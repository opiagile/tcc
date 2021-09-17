package br.com.henry.primmeAcesso.command.envio;

import java.util.ArrayList;
import java.util.List;

import br.com.henry.primmeAcesso.command.Command;

public abstract class DispatchCommand implements Command {
	private String codigo;
	protected String formato;

	protected DispatchCommand(String codigo, String formato) {
		this.codigo = codigo;
		this.formato = formato;
	}

	protected String converterBoolean(boolean propriedade) {
		if (propriedade) {
			return "H";
		} else {
			return "D";
		}

	}

	protected String format(String propriedade, Object valor) {
		if (valor != null) {
			return String.format(formato, propriedade, valor);
		} else {
			return "";
		}
	}

	protected List<String> normalize(String message) {
		List<String> messages = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		int indice = 1;
		sb.append("01+");
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

}
