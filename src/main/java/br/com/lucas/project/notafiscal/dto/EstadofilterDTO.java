package br.com.lucas.project.notafiscal.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EstadofilterDTO {

	private String estado;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy  HH:mm", timezone = "GMT-3")
	private String date;

	public EstadofilterDTO() {
		super();
	}

	public EstadofilterDTO(String estado, String date) {
		super();
		this.estado = estado;
		this.date = date;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

 

}
