package br.com.henry.primmeAcesso.command.recebimento;

import java.util.List;

public class CartaoGrupoAcessoReceptionCommand extends ReceptionCommand {

	public CartaoGrupoAcessoReceptionCommand() {
		super("", "");
	}

	@Override
	public List<String> getCommand() {
		return null;
	}

	@Override
	public boolean consultaBanco(String[] reception) {
		// TODO Auto-generated method stub
		return false;
	}

}
