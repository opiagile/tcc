package br.com.henry.primmeAcesso.command.envio;

import java.util.List;

public class DigitalDispatchCommand extends DispatchCommand {

	public DigitalDispatchCommand() {
		super("ED+00+", "");
	}

	@Override
	public List<String> getCommand() {
		return null;
	}

}
