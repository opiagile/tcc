package br.com.henry.primmeAcesso.model.configuracao;

import br.com.henry.primmeAcesso.model.LeitoraCofre;
import br.com.henry.primmeAcesso.model.TipoLiberacao;

public class Expansao {

	private boolean habilitado;
	private Integer tempoLiberacao;
	private boolean catracaInvertida;
	private TipoLiberacao tipoLiberacao;
	private boolean habilitarCofre;
	private LeitoraCofre leitoraCofre;
	private boolean habilitarPictograma;

	public Expansao() {
		this.habilitado = false;
		this.tempoLiberacao = 10;
		this.catracaInvertida = false;
		this.tipoLiberacao = TipoLiberacao.BLOQUEADO;
		this.habilitarCofre = false;
		this.leitoraCofre = LeitoraCofre.LEITOR1;
		this.habilitarPictograma = true;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public Integer getTempoLiberacao() {
		return tempoLiberacao;
	}

	public void setTempoLiberacao(Integer tempoLiberacao) {
		this.tempoLiberacao = tempoLiberacao;
	}

	public boolean isCatracaInvertida() {
		return catracaInvertida;
	}

	public void setCatracaInvertida(boolean catracaInvertida) {
		this.catracaInvertida = catracaInvertida;
	}

	public TipoLiberacao getTipoLiberacao() {
		return tipoLiberacao;
	}

	public void setTipoLiberacao(TipoLiberacao tipoLiberacao) {
		this.tipoLiberacao = tipoLiberacao;
	}

	public boolean isHabilitarCofre() {
		return habilitarCofre;
	}

	public void setHabilitarCofre(boolean habilitarCofre) {
		this.habilitarCofre = habilitarCofre;
	}

	public LeitoraCofre getLeitoraCofre() {
		return leitoraCofre;
	}

	public void setLeitoraCofre(LeitoraCofre leitoraCofre) {
		this.leitoraCofre = leitoraCofre;
	}

	public boolean isHabilitarPictograma() {
		return habilitarPictograma;
	}

	public void setHabilitarPictograma(boolean habilitarPictograma) {
		this.habilitarPictograma = habilitarPictograma;
	}

}
