package br.com.henry.primmeAcesso.server;

import br.com.bitwiselab.jano.model.Cronometro;
import br.com.bitwiselab.jano.service.EquipamentoService;

public class PanicoState {
	public enum Panico {
		ATIVO, INATIVO;
	}

	public PanicoState(Panico panico) {
		this.estado = panico;
	}

	private Cronometro cronometro;
	private Panico estado;

	public Cronometro getCronometro() {
		return cronometro;
	}

	public void setCronometro(Cronometro cronometro) {
		this.cronometro = cronometro;
	}

	public Panico getEstado() {
		return estado;
	}

	public void setEstado(Panico estado) {
		this.estado = estado;
	}

	public boolean isAtivo() {
		return estado == Panico.ATIVO;
	}

	public void ativarCronometroRegressivo(EquipamentoService equipamentoService) {
		cronometro.setEquipamentoService(equipamentoService);
		cronometro.cronometro();
	}

}
