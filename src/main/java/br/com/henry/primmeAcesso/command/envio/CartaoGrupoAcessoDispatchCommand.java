package br.com.henry.primmeAcesso.command.envio;

import java.util.List;

public class CartaoGrupoAcessoDispatchCommand extends DispatchCommand {

	public CartaoGrupoAcessoDispatchCommand() {
		super("ECGA+00+", "");
	}

	@Override
	public List<String> getCommand() {
		return null;
	}

}
