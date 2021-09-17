package br.com.bitwiselab.jano.model;

public class Cidade extends AbstractModel {
	private static final long serialVersionUID = 1L;

	private Uf uf;
	private String nome;

	public Cidade(Long id) {
		setId(id);
	}

	public Cidade() {
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
