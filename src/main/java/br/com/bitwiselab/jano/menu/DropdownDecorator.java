package br.com.bitwiselab.jano.menu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.bitwiselab.jano.model.Usuario;

public class DropdownDecorator extends MenuItem {
	private final String dataToggle;
	private final List<MenuItem> itens = new ArrayList<MenuItem>();

	public DropdownDecorator(String descricao) {
		this.descricao = descricao;
		this.url = "#";
		this.classe = "dropdown";
		this.dataToggle = "data-toggle=\"dropdown\"";
	}

	public String getDataToggle() {
		return dataToggle;
	}

	public List<MenuItem> getItens() {
		return itens;
	}

	public void addItem(MenuItem item) {
		itens.add(item);
	}

	private void removeItem(MenuItem item) {
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
			removeItem(naoPermitido);
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

	@Override
	public boolean isDropdown() {
		return true;
	}

}