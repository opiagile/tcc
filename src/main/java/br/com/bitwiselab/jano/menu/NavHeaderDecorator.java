package br.com.bitwiselab.jano.menu;

import br.com.bitwiselab.jano.model.Usuario;

public class NavHeaderDecorator extends MenuItem {

	public NavHeaderDecorator() {
		this.descricao = "";
		this.classe = "nav-header";
	}

	@Override
	public boolean isPermitido(Usuario usuario) {
		return true;
	}
}