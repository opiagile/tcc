package br.com.henry.primmeAcesso.model.configuracao;

import br.com.henry.primmeAcesso.model.Luminosidade;
import br.com.henry.primmeAcesso.model.PadraoTemplate;

public class Biometria {

	private Integer sensibilidadeDSP;
	private Integer segurancaDSP;
	private Integer qualidadeImagemDSP;
	private Integer modoRapidoDSP;
	private Integer qualidadeMinima;
	private boolean autoOn;
	private boolean verificacao1n;
	private Luminosidade luminosidade;
	private PadraoTemplate padraoTemplate;

	public Biometria() {
		this.sensibilidadeDSP = 55;
		this.segurancaDSP = 54;
		this.qualidadeImagemDSP = 49;
		this.modoRapidoDSP = 51;
		this.qualidadeMinima = 70;
		this.autoOn = false;
		this.verificacao1n = true;
		this.luminosidade = Luminosidade.EXTERNO;
		this.padraoTemplate = PadraoTemplate.SUPREMA;
	}

	public Integer getSensibilidadeDSP() {
		return sensibilidadeDSP;
	}

	public void setSensibilidadeDSP(Integer sensibilidadeDSP) {
		this.sensibilidadeDSP = sensibilidadeDSP;
	}

	public Integer getSegurancaDSP() {
		return segurancaDSP;
	}

	public void setSegurancaDSP(Integer segurancaDSP) {
		this.segurancaDSP = segurancaDSP;
	}

	public Integer getQualidadeImagemDSP() {
		return qualidadeImagemDSP;
	}

	public void setQualidadeImagemDSP(Integer qualidadeImagemDSP) {
		this.qualidadeImagemDSP = qualidadeImagemDSP;
	}

	public Integer getModoRapidoDSP() {
		return modoRapidoDSP;
	}

	public void setModoRapidoDSP(Integer modoRapidoDSP) {
		this.modoRapidoDSP = modoRapidoDSP;
	}

	public Integer getQualidadeMinima() {
		return qualidadeMinima;
	}

	public void setQualidadeMinima(Integer qualidadeMinima) {
		this.qualidadeMinima = qualidadeMinima;
	}

	public boolean isAutoOn() {
		return autoOn;
	}

	public void setAutoOn(boolean autoOn) {
		this.autoOn = autoOn;
	}

	public boolean isVerificacao1n() {
		return verificacao1n;
	}

	public void setVerificacao1n(boolean verificacao1n) {
		this.verificacao1n = verificacao1n;
	}

	public Luminosidade getLuminosidade() {
		return luminosidade;
	}

	public void setLuminosidade(Luminosidade luminosidade) {
		this.luminosidade = luminosidade;
	}

	public PadraoTemplate getPadraoTemplate() {
		return padraoTemplate;
	}

	public void setPadraoTemplate(PadraoTemplate padraoTemplate) {
		this.padraoTemplate = padraoTemplate;
	}

}
