package br.com.henry.primmeAcesso.model.configuracao;

import br.com.henry.primmeAcesso.model.Digitos;
import br.com.henry.primmeAcesso.model.TipoAcesso;
import br.com.henry.primmeAcesso.model.TipoArmazenamento;
import br.com.henry.primmeAcesso.model.TipoValidacao;

public class Acesso {
	private TipoValidacao tipoValidacao;
	private TipoArmazenamento tipoArmazenamento;
	private boolean validacaoOffline;
	private Integer timeout;
	private Integer tempoEsperaOffline;
	private Integer tempoPassback;
	private boolean direcaoPassback;
	private boolean verificarValidade;
	private TipoAcesso tipoAcesso;
	private boolean ativarMaster;
	private boolean verificarHorario;
	private boolean gravacaoCiclica;
	private Integer taxaRevista;
	private boolean biometriaOnline;
	private boolean enviarMatricula;
	private Digitos numeroDigitosMatrícula;
	private Digitos cortaDigitos;

	public Acesso() {
		this.tipoValidacao = TipoValidacao.ONLINE;
		this.tipoArmazenamento = TipoArmazenamento.TODOS;
		this.validacaoOffline = false;
		this.timeout = 3000;
		this.tempoEsperaOffline = 60;
		this.tempoPassback = 0;
		this.direcaoPassback = false;
		this.verificarValidade = false;
		this.ativarMaster = false;
		this.verificarHorario = false;
		this.gravacaoCiclica = false;
		this.taxaRevista = 0;
		this.biometriaOnline = false;
		this.enviarMatricula = false;
		this.numeroDigitosMatrícula = new Digitos();
	}

	public TipoValidacao getTipoValidacao() {
		return tipoValidacao;
	}

	public void setTipoValidacao(TipoValidacao tipoValidacao) {
		this.tipoValidacao = tipoValidacao;
	}

	public TipoArmazenamento getTipoArmazenamento() {
		return tipoArmazenamento;
	}

	public void setTipoArmazenamento(TipoArmazenamento tipoArmazenamento) {
		this.tipoArmazenamento = tipoArmazenamento;
	}

	public boolean isValidacaoOffline() {
		return validacaoOffline;
	}

	public void setValidacaoOffline(boolean validacaoOffline) {
		this.validacaoOffline = validacaoOffline;
	}

	public Integer getTimeout() {
		return timeout;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}

	public Integer getTempoEsperaOffline() {
		return tempoEsperaOffline;
	}

	public void setTempoEsperaOffline(Integer tempoEsperaOffline) {
		this.tempoEsperaOffline = tempoEsperaOffline;
	}

	public Integer getTempoPassback() {
		return tempoPassback;
	}

	public void setTempoPassback(Integer tempoPassback) {
		this.tempoPassback = tempoPassback;
	}

	public boolean isDirecaoPassback() {
		return direcaoPassback;
	}

	public void setDirecaoPassback(boolean direcaoPassback) {
		this.direcaoPassback = direcaoPassback;
	}

	public boolean isVerificarValidade() {
		return verificarValidade;
	}

	public void setVerificarValidade(boolean verificarValidade) {
		this.verificarValidade = verificarValidade;
	}

	public TipoAcesso getTipoAcesso() {
		return tipoAcesso;
	}

	public void setTipoAcesso(TipoAcesso tipoAcesso) {
		this.tipoAcesso = tipoAcesso;
	}

	public boolean isAtivarMaster() {
		return ativarMaster;
	}

	public void setAtivarMaster(boolean ativarMaster) {
		this.ativarMaster = ativarMaster;
	}

	public boolean isVerificarHorario() {
		return verificarHorario;
	}

	public void setVerificarHorario(boolean verificarHorario) {
		this.verificarHorario = verificarHorario;
	}

	public boolean isGravacaoCiclica() {
		return gravacaoCiclica;
	}

	public void setGravacaoCiclica(boolean gravacaoCiclica) {
		this.gravacaoCiclica = gravacaoCiclica;
	}

	public Integer getTaxaRevista() {
		return taxaRevista;
	}

	public void setTaxaRevista(Integer taxaRevista) {
		this.taxaRevista = taxaRevista;
	}

	public boolean isBiometriaOnline() {
		return biometriaOnline;
	}

	public void setBiometriaOnline(boolean biometriaOnline) {
		this.biometriaOnline = biometriaOnline;
	}

	public boolean isEnviarMatricula() {
		return enviarMatricula;
	}

	public void setEnviarMatricula(boolean enviarMatricula) {
		this.enviarMatricula = enviarMatricula;
	}

	public Digitos getNumeroDigitosMatrícula() {
		return numeroDigitosMatrícula;
	}

	public void setNumeroDigitosMatrícula(Digitos numeroDigitosMatrícula) {
		this.numeroDigitosMatrícula = numeroDigitosMatrícula;
	}

	public Digitos getCortaDigitos() {
		return cortaDigitos;
	}

	public void setCortaDigitos(Digitos cortaDigitos) {
		this.cortaDigitos = cortaDigitos;
	}

}
