package com.flexpag.paymentscheduler.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_agendamento")
public class Agendamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_agendamento")
	private Long id;

	private LocalDateTime data_hora;

	private String status;

	public Agendamento() {

	}

	public Agendamento(Long id, LocalDateTime data_hora, String status) {
		this.id = id;
		this.data_hora = data_hora;
		this.status = "pending";
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

}
