package br.com.henry.primmeAcesso.command.recebimento;

import java.util.ArrayList;
import java.util.List;

import br.com.henry.primmeAcesso.command.Command;

public abstract class ReceptionCommand implements Command {

	private String codigo;
	protected String formato;
	protected Long id;

	protected ReceptionCommand(String codigo, String formato) {
		this.codigo = codigo;
		this.formato = formato;
	}

	public void setId(Long id) {
		this.id = id;
	}

	protected String format(String propriedade, Object valor) {
		if (valor != null) {
			return String.format(formato, propriedade, valor);
		} else {
			return "";
		}
	}

	protected List<String> normalize(String indiceMessage, String message) {
		List<String> messages = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		int indice = 1;
		sb.append(indiceMessage);
		sb.append("+");
		sb.append(codigo);
		String[] comandos = message.split("(?=])");
		for (String comando : comandos) {
			if (sb.length() + comando.length() >= 245) {
				messages.add(sb.toString());
				sb = new StringBuilder();
				++indice;
				sb.append("0" + String.valueOf(indice) + "+");
				sb.append(codigo);
			}
			sb.append(comando);
		}
		messages.add(sb.toString());
		return messages;
	}

	public abstract boolean consultaBanco(String[] reception);

}
