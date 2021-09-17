package br.com.bitwiselab.jano.model;

import java.util.Set;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.bitwiselab.jano.util.Digests;

public class Usuario extends AbstractModel {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "{usuario.validator.loginObrigatorio}")
	@Length(min = 3, max = 50, message = "{usuario.validator.tamanhoLogin}")
	private String login;
	private String senha;
	private Set<Permissao> permissoes;
	private Pessoa pessoa;

	public Usuario() {
	}

	public Usuario(Long id) {
		setId(id);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void gerarSenhaCriptografada() {
		senha = Digests.digest(senha);
	}

	public Set<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(Set<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	public boolean temPermissao(Permissao permissao) {
		return permissoes.contains(permissao);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
