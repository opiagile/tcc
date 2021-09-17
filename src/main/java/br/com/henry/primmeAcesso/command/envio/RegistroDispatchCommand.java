package br.com.henry.primmeAcesso.command.envio;

import java.util.List;

public class RegistroDispatchCommand extends DispatchCommand {

	public RegistroDispatchCommand() {
		super("ER+00+", "");
	}

	@Override
	public List<String> getCommand() {
		return null;
	}

}
