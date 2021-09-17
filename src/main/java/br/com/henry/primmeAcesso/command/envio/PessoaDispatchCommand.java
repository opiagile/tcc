package br.com.henry.primmeAcesso.command.envio;

import java.util.List;

import br.com.bitwiselab.jano.model.Pessoa;

public class PessoaDispatchCommand extends DispatchCommand {

	private Pessoa pessoa;
	private char acao;

	public PessoaDispatchCommand(Pessoa pessoa, char acao) {
		super("EU+00+1+", "%S[%s[%s[[%d[%s]");
		this.pessoa = pessoa;
		this.acao = acao;
	}

	@Override
	public List<String> getCommand() {
		// TODO: Pessoa está fixo com 1 cartão.
		return normalize(String.format(formato, acao, pessoa.getId(),
				pessoa.getNome(), 1, pessoa.getIdentificador()));
	}
}
