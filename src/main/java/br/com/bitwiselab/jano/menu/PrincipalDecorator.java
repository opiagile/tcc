package br.com.bitwiselab.jano.menu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.bitwiselab.jano.model.Usuario;

public class PrincipalDecorator extends MenuItem {
	private final List<MenuItem> itens = new ArrayList<MenuItem>();

	public PrincipalDecorator() {
	}

	public List<MenuItem> getItens() {
		return itens;
	}

	public void addItem(MenuItem item) {
		itens.add(item);
	}

	private void removerItem(MenuItem item) {
		itens.remove(item);
	}

	public boolean isPermitido(Usuario usuario) {
		Set<MenuItem> naoPermitidos = new HashSet<MenuItem>();
		for (MenuItem item : itens) {
			if (!item.isPermitido(usuario)) {
				naoPermitidos.add(item);
			}
		}
		for (MenuItem naoPermitido : naoPermitidos) {
			removerItem(naoPermitido);
		}
		return !itens.isEmpty();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(descricao);
		sb.append('\n');
		for (MenuItem item : itens) {
			sb.append(item);
			sb.append('\n');
		}
		return sb.toString();
	}

}