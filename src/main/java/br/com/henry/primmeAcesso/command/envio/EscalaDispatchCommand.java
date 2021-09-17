package br.com.henry.primmeAcesso.command.envio;

import java.util.List;

public class EscalaDispatchCommand extends DispatchCommand {

	public EscalaDispatchCommand() {
		super("EESC+00+", "");
	}

	@Override
	public List<String> getCommand() {
		return null;
	}

}
