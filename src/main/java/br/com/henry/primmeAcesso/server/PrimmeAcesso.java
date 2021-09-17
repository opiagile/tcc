package br.com.henry.primmeAcesso.server;

import java.net.InetAddress;
import java.util.concurrent.ExecutorService;

import br.com.bitwiselab.jano.model.Equipamento;
import br.com.bitwiselab.jano.model.Pessoa;
import br.com.henry.primmeAcesso.command.envio.ConfiguracaoDispatchCommand;
import br.com.henry.primmeAcesso.command.envio.PessoaDispatchCommand;
import br.com.henry.primmeAcesso.command.recebimento.ReceptionCommand;

public class PrimmeAcesso {

	private Long codigo;
	private PrimmeAcessoServerStreamer streamer;
	private ExecutorService executor;
	private PrimmeAcessoProxy proxy;
	private String ip;

	public PrimmeAcesso(Long codigo, String ip,
			PrimmeAcessoServerStreamer streamer, ExecutorService executor) {
		this.codigo = codigo;
		this.ip = ip;
		this.streamer = streamer;
		this.executor = executor;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void testarConexao() {
		executor.execute(new Runnable() {
			@Override
			public void run() {
				while (true) {
					boolean online = proxy.isOnline();
					try {
						if (InetAddress.getByName(ip).isReachable(1000)) {
							if (!online) {
								proxy.onConectar();
								streamer.connect();
							}
						} else {
							if (online) {
								proxy.onDesconectar();
								streamer.disconnect();
							}
						}
						Thread.sleep(2500);
					} catch (Exception e) {
						proxy.onDesconectar();
						e.printStackTrace();
					}
				}
			}
		});
	}

	public void atualizarConfiguracaoEquipamento(final Equipamento equipamento) {
		executor.execute(new Runnable() {
			@Override
			public void run() {
				ConfiguracaoDispatchCommand dispatcher = new ConfiguracaoDispatchCommand(
						equipamento.getConfiguracao());
				streamer.sendMessage(dispatcher.getCommand());
			}
		});
	}

	public void incluirPessoa(Pessoa pessoa) {
		enviarPessoa(new PessoaDispatchCommand(pessoa, 'I'));
	}

	public void removerPessoa(Pessoa pessoa) {
		enviarPessoa(new PessoaDispatchCommand(pessoa, 'E'));
	}

	private void enviarPessoa(final PessoaDispatchCommand dispatcher) {
		executor.execute(new Runnable() {
			@Override
			public void run() {
				streamer.sendMessage(dispatcher.getCommand());
			}
		});
	}

	public void liberarAcesso(final ReceptionCommand dispatcher) {
		executor.execute(new Runnable() {
			@Override
			public void run() {
				streamer.sendMessage(dispatcher.getCommand());
			}
		});
	}

	public void addProxy(PrimmeAcessoProxy proxy) {
		this.proxy = proxy;
	}

}
