package br.com.bitwiselab.jano.model;

import br.com.henry.primmeAcesso.server.PanicoState;

public class Panico {

	public Panico(PanicoState.Panico estado) {
		this.estado = estado;
		this.ativo = (estado == PanicoState.Panico.ATIVO);
	}

	private PanicoState.Panico estado;
	private String tempo;
	private boolean ativo;

	public PanicoState.Panico getEstado() {
		return estado;
	}

	public void setPanico(PanicoState.Panico estado) {
		this.estado = estado;
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
