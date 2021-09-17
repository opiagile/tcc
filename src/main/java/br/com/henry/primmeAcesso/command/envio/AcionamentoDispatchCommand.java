package br.com.henry.primmeAcesso.command.envio;

import java.util.List;

public class AcionamentoDispatchCommand extends DispatchCommand {

	public AcionamentoDispatchCommand() {
		super("EACI+00+", "");
	}

	@Override
	public List<String> getCommand() {
		return null;
	}

}
