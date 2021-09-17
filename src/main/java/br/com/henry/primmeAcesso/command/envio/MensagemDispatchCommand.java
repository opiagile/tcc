package br.com.henry.primmeAcesso.command.envio;

import java.util.List;

public class MensagemDispatchCommand extends DispatchCommand {

	public MensagemDispatchCommand() {
		super("EMSG+00+", "");
	}

	@Override
	public List<String> getCommand() {
		return null;
	}

}
