package br.com.lucas.project.notafiscal.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Autorizador implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	@JsonIgnore
	@OneToMany(mappedBy = "autorizador", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<NotaFiscalStatus> notaFiscalStatus; 

	public Autorizador() {
	}

	public Autorizador(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<NotaFiscalStatus> getNotaFiscalStatus() {
		return notaFiscalStatus;
	}

	public void setNotaFiscalStatus(List<NotaFiscalStatus> notaFiscalStatus) {
		this.notaFiscalStatus = notaFiscalStatus;
	}

	
	
	
}
