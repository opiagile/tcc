package br.com.henry.primmeAcesso.server;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import br.com.bitwiselab.jano.model.Cronometro;
import br.com.bitwiselab.jano.service.EquipamentoService;
import br.com.henry.primmeAcesso.server.PanicoState.Panico;

public class PrimmeAcessoManager {
	private static PrimmeAcessoManager INSTANCE;
	private final ConcurrentMap<Long, PrimmeAcessoProxy> proxies;
	private PanicoState panico;

	private PrimmeAcessoManager() {
		this.proxies = new ConcurrentHashMap<Long, PrimmeAcessoProxy>();
		this.panico = new PanicoState(Panico.INATIVO);
	}

	public static PrimmeAcessoManager getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PrimmeAcessoManager();
		}
		return INSTANCE;
	}

	public PrimmeAcessoProxy getProxy(Long codigo) {
		return proxies.get(codigo);
	}

	public void add(PrimmeAcessoProxy proxy) {
		proxies.put(proxy.getCodigo(), proxy);
	}

	public boolean isConectado(Long codigo) {
		return proxies.get(codigo).isOnline();
	}

	public boolean emPanico() {
		return panico.getEstado() == Panico.ATIVO;
	}

	public PanicoState getPanico() {
		return panico;
	}

	public void ativarPanico(EquipamentoService equipamentoService) {
		panico.setCronometro(new Cronometro());
		panico.setEstado(Panico.ATIVO);
		panico.ativarCronometroRegressivo(equipamentoService);
	}

	public void desativarPanico() {
		panico.setEstado(Panico.INATIVO);
		panico.getCronometro().desativarPanico();
	}
}
