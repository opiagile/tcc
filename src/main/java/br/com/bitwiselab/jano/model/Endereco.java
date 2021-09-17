package br.com.bitwiselab.jano.model;

public class Endereco extends AbstractModel {
	private static final long serialVersionUID = 1L;

	private Logradouro logradouro;
	private Integer numero;
	private String complemento;

	public Endereco() {
	}

	public Endereco(Long id) {
		setId(id);
	}

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}