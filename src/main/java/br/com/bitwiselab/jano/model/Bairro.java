package br.com.bitwiselab.jano.model;

public class Bairro extends AbstractModel {
	private static final long serialVersionUID = 1L;

	private Cidade cidade;
	private String nome;

	public Bairro(Long id) {
		setId(id);
	}

	public Bairro() {
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
