package br.com.lucas.project.notafiscal.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class NotaFiscalStatus implements Serializable, Comparable<NotaFiscalStatus> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    
	
	@ManyToOne
	@JoinColumn(name = "autorizador_id")
	private Autorizador autorizador;
	private String autorizacao4;
	private String retornoAutorizacao4;
	private String inutilizacao4;
	private String consultaProtocolo4;
	private String statusServico4;
	private String tempoMedio;
	private String consultaCadastro4;
	private String recepcaoEvento4;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy  HH:mm", timezone = "GMT-3")
	private Date criacao;

	public NotaFiscalStatus() {

	}

	public NotaFiscalStatus(Integer id, Autorizador autorizador, String autorizacao4, String retornoAutorizacao4,
			String inutilizacao4, String consultaProtocolo4, String statusServico4, String tempoMedio,
			String consultaCadastro4, String recepcaoEvento4, Date criacao) {
		super();
		this.id = id;
		this.autorizador = autorizador;
		this.autorizacao4 = autorizacao4;
		this.retornoAutorizacao4 = retornoAutorizacao4;
		this.inutilizacao4 = inutilizacao4;
		this.consultaProtocolo4 = consultaProtocolo4;
		this.statusServico4 = statusServico4;
		this.tempoMedio = tempoMedio;
		this.consultaCadastro4 = consultaCadastro4;
		this.recepcaoEvento4 = recepcaoEvento4;
		this.criacao = criacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Autorizador getAutorizador() {
		return autorizador;
	}

	public void setAutorizador(Autorizador autorizador) {
		this.autorizador = autorizador;
	}

	public String getAutorizacao4() {
		return autorizacao4;
	}

	public void setAutorizacao4(String autorizacao4) {
		this.autorizacao4 = autorizacao4;
	}

	public String getRetornoAutorizacao4() {
		return retornoAutorizacao4;
	}

	public void setRetornoAutorizacao4(String retornoAutorizacao4) {
		this.retornoAutorizacao4 = retornoAutorizacao4;
	}

	public String getInutilizacao4() {
		return inutilizacao4;
	}

	public void setInutilizacao4(String inutilizacao4) {
		this.inutilizacao4 = inutilizacao4;
	}

	public String getConsultaProtocolo4() {
		return consultaProtocolo4;
	}

	public void setConsultaProtocolo4(String consultaProtocolo4) {
		this.consultaProtocolo4 = consultaProtocolo4;
	}

	public String getStatusServico4() {
		return statusServico4;
	}

	public void setStatusServico4(String statusServico4) {
		this.statusServico4 = statusServico4;
	}

	public String getTempoMedio() {
		return tempoMedio;
	}

	public void setTempoMedio(String tempoMedio) {
		this.tempoMedio = tempoMedio;
	}

	public String getConsultaCadastro4() {
		return consultaCadastro4;
	}

	public void setConsultaCadastro4(String consultaCadastro4) {
		this.consultaCadastro4 = consultaCadastro4;
	}

	public String getRecepcaoEvento4() {
		return recepcaoEvento4;
	}

	public void setRecepcaoEvento4(String recepcaoEvento4) {
		this.recepcaoEvento4 = recepcaoEvento4;
	}

	public Date getCriacao() {
		return criacao;
	}

	public void setCriacao(Date criacao) {
		this.criacao = criacao;
	}

	@Override
	public String toString() {
		return "Status [id=" + id + ", autorizador=" + autorizador + ", autorizacao4=" + autorizacao4
				+ ", retornoAutorizacao4=" + retornoAutorizacao4 + ", inutilizacao4=" + inutilizacao4
				+ ", consultaProtocolo4=" + consultaProtocolo4 + ", statusServico4=" + statusServico4 + ", tempoMedio="
				+ tempoMedio + ", consultaCadastro4=" + consultaCadastro4 + ", recepcaoEvento4=" + recepcaoEvento4
				+ ", criacao=" + criacao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotaFiscalStatus other = (NotaFiscalStatus) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int compareTo(NotaFiscalStatus obj) {
		if (this.getId() > obj.getId()) {
			return -1;
		}
		if (this.getId() < obj.getId()) {
			return 1;
		}
		return 0;
	}

}
