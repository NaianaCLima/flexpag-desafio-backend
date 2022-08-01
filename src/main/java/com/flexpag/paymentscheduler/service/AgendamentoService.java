package com.flexpag.paymentscheduler.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flexpag.paymentscheduler.dto.AgendamentoDTO;
import com.flexpag.paymentscheduler.entity.Agendamento;
import com.flexpag.paymentscheduler.exception.ResourceNotFoundException;
import com.flexpag.paymentscheduler.repository.AgendamentoRepository;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository repository;

	@Transactional(readOnly = true)
	public Page<AgendamentoDTO> findAll(PageRequest pageRequest) {
		Page<Agendamento> list = repository.findAll(pageRequest);
		return list.map(x -> new AgendamentoDTO(x));
	}

	@Transactional(readOnly = true)
	public AgendamentoDTO findById(Long id) {
		Optional<Agendamento> obj = repository.findById(id);
		Agendamento entity = obj.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado! "));
		return new AgendamentoDTO(entity);
	}

	@Transactional
	public AgendamentoDTO insert(AgendamentoDTO dto) {
		Agendamento entity = new Agendamento();
		entity.setData_hora(dto.getData_hora());
		entity.setStatus(dto.getStatus());
		repository.save(entity);
		return new AgendamentoDTO(entity);
	}

	@Transactional
	public AgendamentoDTO update(Long id, AgendamentoDTO dto) {
		Agendamento entity = repository.getOne(id);// para pegar apenas 1x do BD
		try {
			entity.setData_hora(dto.getData_hora());
			entity.setStatus(dto.getStatus());
			entity = repository.save(entity);
			return new AgendamentoDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id não encontrado! " + id);
		}

	}

	public void delete(Long id) {
		Agendamento entity = new Agendamento();
		if (entity.getStatus() != "paid") {
			repository.deleteById(id);

		} else {
			throw new ResourceNotFoundException("Pagamento efetuado, não pode ser excluído!");
		}

	}
}
