package br.com.bitwiselab.jano.dto;

import br.com.henry.primmeAcesso.server.PanicoState;
import br.com.henry.primmeAcesso.server.PanicoState.Panico;

public class PanicoJson {

	private Panico panico;
	private String tempo;
	private boolean ativo;

	public Panico getPanico() {
		return panico;
	}

	public void setPanico(Panico panico) {
		this.panico = panico;
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

	protected static void popularPanicoJson(PanicoState panico,
			PanicoJson panicoJson) {
		if (panico == null || panicoJson == null) {
			return;
		}

		panicoJson.setPanico(panico.getEstado());
		panicoJson.setTempo(panico.getCronometro().getTime());
		panicoJson.setAtivo(panico.isAtivo());
	}

	public static PanicoJson toJSON(PanicoState panico) {
		if (panico == null) {
			return null;
		}
		PanicoJson panicoJson = new PanicoJson();
		popularPanicoJson(panico, panicoJson);
		return panicoJson;
	}

}
