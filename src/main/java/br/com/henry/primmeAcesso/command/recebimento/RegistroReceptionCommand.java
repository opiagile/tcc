package br.com.henry.primmeAcesso.command.recebimento;

import java.util.List;

import br.com.bitwiselab.jano.model.Acesso;
import br.com.bitwiselab.jano.model.Equipamento;
import br.com.bitwiselab.jano.model.Pessoa;
import br.com.bitwiselab.jano.model.TipoLiberacaoAcesso;
import br.com.henry.primmeAcesso.server.PrimmeAcessoManager;
import br.com.henry.primmeAcesso.server.PrimmeAcessoProxy;

public class RegistroReceptionCommand extends ReceptionCommand {

	private List<String> comando;

	public RegistroReceptionCommand() {
		super("REON+00+", "%d]%d]%s %s]%d]");
	}

	public List<String> getCommand() {
		return comando;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private void gravarAcesso(Pessoa pessoa) {
		Acesso acesso = new Acesso(pessoa, new Equipamento(id),
				TipoLiberacaoAcesso.PERMISSAO);
		PrimmeAcessoManager.getInstance().getProxy(id).gravarAcesso(acesso);
	}

	@Override
	public boolean consultaBanco(String[] reception) {
		String[] split = reception[3].split("]");
		PrimmeAcessoProxy proxy = PrimmeAcessoManager.getInstance()
				.getProxy(id);
		if (split[0].equals("0")) {
			// aguardandoLiberacao
			Pessoa pessoa = proxy.buscarPessoaPorIdentificador(split[1]);
			if (pessoa != null) {
				String message = String.format(formato, 1, 3, "Seja bem vindo",
						pessoa.getNome(), 1);
				comando = normalize(reception[0], message);
				proxy.getDevice().liberarAcesso(this);
				gravarAcesso(pessoa);
			} else {
				String message = String.format(formato, 30, 3,
						"Sem permissão!", "", 1);
				comando = normalize(reception[0], message);
				proxy.getDevice().liberarAcesso(this);
			}
		} else if (split[0].equals("1")) {
			// liberado
		} else if (split[0].equals("2")) {
			// giro catraca.. obsoleto???
		} else if (split[0].equals("3")) {
			// liberado por master
		} else if (split[0].equals("4")) {
			// Liberação Online
		} else if (split[0].equals("5")) {
			// Liberada entrada
		} else if (split[0].equals("6")) {
			// Liberada saída
		}
		return false;
	}

	public void teste(String message) {
		comando = normalize("11", message);
	}
}
