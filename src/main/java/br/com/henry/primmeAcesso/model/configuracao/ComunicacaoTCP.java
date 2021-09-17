package br.com.henry.primmeAcesso.model.configuracao;

public class ComunicacaoTCP {

	public ComunicacaoTCP() {
		this.ip = "192.168.0.200";
		this.mascara = "255.255.255.0";
		this.dns = "192.168.0.1";
		this.gateway = "192.168.0.1";
		this.porta = 3000;
		this.versaoIP = 4;
		this.dhcp = false;
		this.nome = "PRIMEACESSO";
	}

	private String ip;
	private String mascara;
	private String dns;
	private String gateway;
	private String macAddres;
	private Integer porta;
	private Integer versaoIP;
	private boolean dhcp;
	private String nome;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMascara() {
		return mascara;
	}

	public void setMascara(String mascara) {
		this.mascara = mascara;
	}

	public String getDns() {
		return dns;
	}

	public void setDns(String dns) {
		this.dns = dns;
	}

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	public String getMacAddres() {
		return macAddres;
	}

	public void setMacAddres(String macAddres) {
		this.macAddres = macAddres;
	}

	public Integer getPorta() {
		return porta;
	}

	public void setPorta(Integer porta) {
		this.porta = porta;
	}

	public Integer getVersaoIP() {
		return versaoIP;
	}

	public void setVersaoIP(Integer versaoIP) {
		this.versaoIP = versaoIP;
	}

	public boolean isDhcp() {
		return dhcp;
	}

	public void setDhcp(boolean dhcp) {
		this.dhcp = dhcp;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
