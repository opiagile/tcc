package br.com.henry.primmeAcesso.model.configuracao;

public class Configuracao {

	private Geral geral;
	private Acesso acesso;
	private Comunicacao comunicacao;
	private Biometria biometria;
	private Perifericos perifericos;
	private Expansao expansao;

	public Configuracao() {
		this.geral = new Geral();
		this.acesso = new Acesso();
		this.comunicacao = new Comunicacao();
		this.biometria = new Biometria();
		this.perifericos = new Perifericos();
		this.expansao = new Expansao();
	}

	public Geral getGeral() {
		return geral;
	}

	public void setGeral(Geral geral) {
		this.geral = geral;
	}

	public Acesso getAcesso() {
		return acesso;
	}

	public void setAcesso(Acesso acesso) {
		this.acesso = acesso;
	}

	public Comunicacao getComunicacao() {
		return comunicacao;
	}

	public void setComunicacao(Comunicacao comunicacao) {
		this.comunicacao = comunicacao;
	}

	public Biometria getBiometria() {
		return biometria;
	}

	public void setBiometria(Biometria biometria) {
		this.biometria = biometria;
	}

	public Perifericos getPerifericos() {
		return perifericos;
	}

	public void setPerifericos(Perifericos perifericos) {
		this.perifericos = perifericos;
	}

	public Expansao getExpansao() {
		return expansao;
	}

	public void setExpansao(Expansao expansao) {
		this.expansao = expansao;
	}

}
