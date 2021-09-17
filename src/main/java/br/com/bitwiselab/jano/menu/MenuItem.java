package br.com.bitwiselab.jano.menu;

import br.com.bitwiselab.jano.model.Usuario;

public abstract class MenuItem {

	protected String descricao;
	protected String url;
	protected String classe;
	protected boolean dropdown;

	public String getDescricao() {
		return descricao;
	}

	public String getUrl() {
		return url;
	}

	public String getClasse() {
		return classe;
	}

	public boolean isDropdown() {
		return false;
	}

	public abstract boolean isPermitido(Usuario usuario);
}
