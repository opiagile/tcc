package br.com.henry.primmeAcesso.model.configuracao;

import br.com.henry.primmeAcesso.model.TipoComunicacao;
import br.com.henry.primmeAcesso.model.VelocidadeSerial;

public class Comunicacao {

	private ComunicacaoTCP tcp;
	private VelocidadeSerial velocidadeSerial;
	private TipoComunicacao tipoComunicacao;
	private boolean conexaoSegura;
	private String ipComunicacaoSegura;
	private boolean criptografar;
	private String chaveCriptografia;

	public Comunicacao() {
		this.tcp = new ComunicacaoTCP();
		this.velocidadeSerial = VelocidadeSerial.V115600;
		this.tipoComunicacao = TipoComunicacao.TCP;
		this.conexaoSegura = false;
		this.criptografar = false;
	}

	public ComunicacaoTCP getTcp() {
		return tcp;
	}

	public void setTcp(ComunicacaoTCP tcp) {
		this.tcp = tcp;
	}

	public VelocidadeSerial getVelocidadeSerial() {
		return velocidadeSerial;
	}

	public void setVelocidadeSerial(VelocidadeSerial velocidadeSerial) {
		this.velocidadeSerial = velocidadeSerial;
	}

	public TipoComunicacao getTipoComunicacao() {
		return tipoComunicacao;
	}

	public void setTipoComunicacao(TipoComunicacao tipoComunicacao) {
		this.tipoComunicacao = tipoComunicacao;
	}

	public boolean isConexaoSegura() {
		return conexaoSegura;
	}

	public void setConexaoSegura(boolean conexaoSegura) {
		this.conexaoSegura = conexaoSegura;
	}

	public String getIpComunicacaoSegura() {
		return ipComunicacaoSegura;
	}

	public void setIpComunicacaoSegura(String ipComunicacaoSegura) {
		this.ipComunicacaoSegura = ipComunicacaoSegura;
	}

	public boolean isCriptografar() {
		return criptografar;
	}

	public void setCriptografar(boolean criptografar) {
		this.criptografar = criptografar;
	}

	public String getChaveCriptografia() {
		return chaveCriptografia;
	}

	public void setChaveCriptografia(String chaveCriptografia) {
		this.chaveCriptografia = chaveCriptografia;
	}

}
