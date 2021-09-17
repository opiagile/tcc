package br.com.henry.primmeAcesso.command.recebimento;

import java.util.List;

public class DigitalReceptionCommand extends ReceptionCommand {

	public DigitalReceptionCommand() {
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
