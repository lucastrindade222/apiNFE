package br.com.lucas.project.notafiscal.domain;

public class Aux implements Comparable<Aux> {

	private String nome;
	private Integer quantidade;

	public Aux() {
		
	}
	
	public Aux(String nome, Integer quantidade) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int compareTo(Aux obj) {
		if (this.quantidade > obj.getQuantidade()) {
			return -1;
		}
		if (this.quantidade < obj.getQuantidade()) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Aux [nome=" + nome + ", quantidade=" + quantidade + "]";
	}

}
