package com.flexpag.paymentscheduler.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import com.flexpag.paymentscheduler.entity.Agendamento;

public class AgendamentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private LocalDateTime data_hora;
	private String status;

	public AgendamentoDTO(Agendamento agendamento) {
		this.id = agendamento.getId();
		this.data_hora = agendamento.getData_hora();
		this.status = agendamento.getStatus();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getData_hora() {
		return data_hora;
	}

	public void setData_hora(LocalDateTime data_hora) {
		this.data_hora = data_hora;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data_hora, id, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgendamentoDTO other = (AgendamentoDTO) obj;
		return Objects.equals(data_hora, other.data_hora) && Objects.equals(id, other.id)
				&& Objects.equals(status, other.status);
	}

}
