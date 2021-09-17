package br.com.henry.primmeAcesso.command.envio;

import java.util.List;

public class GrupoAcessoDispatchCommand extends DispatchCommand {

	public GrupoAcessoDispatchCommand() {
		super("EGA+00+", "");
	}

	@Override
	public List<String> getCommand() {
		return null;
	}

}
