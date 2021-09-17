package br.com.henry.primmeAcesso.command.envio;

import java.util.List;

public class FeriadoDispatchCommand extends DispatchCommand {

	public FeriadoDispatchCommand() {
		super("EFER+00+", "");
	}

	@Override
	public List<String> getCommand() {
		return null;
	}

}
