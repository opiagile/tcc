package br.com.henry.primmeAcesso.command.envio;

import java.util.List;

public class CartaoDispatchCommand extends DispatchCommand {

	public CartaoDispatchCommand() {
		super("ECAR+00+", "");
	}

	@Override
	public List<String> getCommand() {
		return null;
	}

}
