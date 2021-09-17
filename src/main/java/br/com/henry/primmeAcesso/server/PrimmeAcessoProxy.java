package br.com.henry.primmeAcesso.server;

import br.com.bitwiselab.jano.model.Acesso;
import br.com.bitwiselab.jano.model.Equipamento;
import br.com.bitwiselab.jano.model.Pessoa;
import br.com.bitwiselab.jano.service.EquipamentoService;
import br.com.henry.primmeAcesso.command.recebimento.RegistroReceptionCommand;

public class PrimmeAcessoProxy {
	private final Long codigo;
	private boolean online;
	private final PrimmeAcesso primmeAcesso;
	private final EquipamentoService equipamentoService;

	public PrimmeAcessoProxy(Long codigo, PrimmeAcesso primmeAcesso,
			EquipamentoService equipamentoService) {
		this.codigo = codigo;
		this.online = false;
		this.primmeAcesso = primmeAcesso;
		this.equipamentoService = equipamentoService;
	}

	public Long getCodigo() {
		return codigo;
	}

	public PrimmeAcesso getDevice() {
		return primmeAcesso;
	}

	public boolean isOnline() {
		return online;
	}

	private void onEstadoConexaoAlterado(final boolean conectado) {
		boolean estadoAnterior = online;
		if (estadoAnterior != conectado) {
			equipamentoService.alterarEstadoConexao(codigo, conectado);
			online = conectado;
		}
	}

	public void onConectar() {
		onEstadoConexaoAlterado(true);
	}

	public void onDesconectar() {
		onEstadoConexaoAlterado(false);
	}

	public void atualizarConfiguracaoEquipamento(final Equipamento equipamento) {
		if (online) {
			primmeAcesso.atualizarConfiguracaoEquipamento(equipamento);
		}
	}

	public void incluirPessoa(Pessoa pessoa) throws InterruptedException {
		if (online) {
			primmeAcesso.incluirPessoa(pessoa);
		}
	}

	public void removerPessoa(Pessoa pessoa) {
		if (online) {
			primmeAcesso.removerPessoa(pessoa);
		}
	}

	public Pessoa buscarPessoaPorIdentificador(String identificador) {
		return equipamentoService.buscarPessoaPorIdentificador(identificador);
	}

	public void gravarAcesso(Acesso acesso) {
		equipamentoService.gravarAcesso(acesso);
	}

	public void enviarLiberacaoPorClickParaEquipamento(int tempoLiberacao) {
		if (online) {
			RegistroReceptionCommand comando = new RegistroReceptionCommand();
			String message = String.format("%d]%d]%s %s]%d]", 4,
					tempoLiberacao, "Acesso Liberado", "", 1);
			comando.teste(message);
			this.getDevice().liberarAcesso(comando);
		}
	}

}
