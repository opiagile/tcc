package br.com.bitwiselab.jano.model;

public class Logradouro extends AbstractModel {
	private static final long serialVersionUID = 1L;

	private Bairro bairro;
	private String nome;
	private String cep;

	public Logradouro(Long id) {
		setId(id);
	}

	public Logradouro() {
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
