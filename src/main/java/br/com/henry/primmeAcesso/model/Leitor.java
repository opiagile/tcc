package br.com.henry.primmeAcesso.model;

public class Leitor {
	private TipoLeitora tipo;
	private Direcao direcao;

	public Leitor() {
	}

	public Leitor(TipoLeitora tipo, Direcao direcao) {
		this.tipo = tipo;
		this.direcao = direcao;
	}

	public Leitor(TipoLeitora tipo) {
		this.tipo = tipo;
	}

	public TipoLeitora getTipo() {
		return tipo;
	}

	public void setTipo(TipoLeitora tipo) {
		this.tipo = tipo;
	}

	public Direcao getDirecao() {
		return direcao;
	}

	public void setDirecao(Direcao direcao) {
		this.direcao = direcao;
	}

	public String format() {
		if (TipoLeitora.isNenhum(tipo)) {
			return String.valueOf(tipo.getValor());
		} else {
			return String.format("%s}%s", tipo.getValor(), direcao.getValor());
		}
	}
}
