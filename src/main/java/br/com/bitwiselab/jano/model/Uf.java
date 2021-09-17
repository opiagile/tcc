package br.com.bitwiselab.jano.model;

public class Uf extends AbstractModel {
	private static final long serialVersionUID = 1L;

	private String sigla;
	private String nome;

	public Uf(Long id) {
		setId(id);
	}

	public Uf() {
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
