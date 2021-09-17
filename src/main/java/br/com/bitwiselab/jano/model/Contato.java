package br.com.bitwiselab.jano.model;

public class Contato extends AbstractModel {
	private static final long serialVersionUID = -6009907054527032452L;
	private String telefone;
	private String celular;
	private String email;

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
