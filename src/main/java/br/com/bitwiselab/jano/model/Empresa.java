package br.com.bitwiselab.jano.model;

public class Empresa extends AbstractModel {

	private static final long serialVersionUID = 1L;

	private String cnpj;
	private String nome;
	private Contato contato;
	private Endereco endereco;

	public Empresa() {
	}

	public Empresa(Long id) {
		setId(id);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

}
