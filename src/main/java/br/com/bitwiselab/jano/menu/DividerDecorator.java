package br.com.bitwiselab.jano.menu;

import br.com.bitwiselab.jano.model.Usuario;

public class DividerDecorator extends MenuItem {

	public DividerDecorator() {
		this.descricao = "";
		this.classe = "divider";
	}

	@Override
	public boolean isPermitido(Usuario usuario) {
		return true;
	}
}