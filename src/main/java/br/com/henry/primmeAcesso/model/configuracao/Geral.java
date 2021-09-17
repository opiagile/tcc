package br.com.henry.primmeAcesso.model.configuracao;

import br.com.henry.primmeAcesso.model.Automatico;
import br.com.henry.primmeAcesso.model.Idioma;
import br.com.henry.primmeAcesso.model.LayoutTeclado;
import br.com.henry.primmeAcesso.model.TipoDisplay;

public class Geral {
	private Integer numeroEquipamento;
	private Integer numeroFabrica;
	private TipoDisplay tipoDisplay;
	private Integer volume;
	private String mensagemDisplay;
	private boolean beepTeclado;
	private boolean gerenciadorInteligente;
	private String senhaMenu;
	private String login;
	private LayoutTeclado layoutTeclado;
	private Idioma idioma;
	private boolean leitorVericaDigital;
	private Automatico modoCadastro;
	private String tipoEquipamento;
	private String versaoProduto;
	private String versaoProtocolo;
	private String formatoRegistro;

	public Geral() {
		this.numeroEquipamento = 1;
		this.volume = 9;
		this.beepTeclado = false;
		this.gerenciadorInteligente = false;
		this.login = "primmeAcesso";
		this.idioma = Idioma.PORTUGUES;
		this.leitorVericaDigital = false;
		this.modoCadastro = Automatico.NORMAL;
	}

	public Integer getNumeroEquipamento() {
		return numeroEquipamento;
	}

	public void setNumeroEquipamento(Integer numeroEquipamento) {
		this.numeroEquipamento = numeroEquipamento;
	}

	public Integer getNumeroFabrica() {
		return numeroFabrica;
	}

	public void setNumeroFabrica(Integer numeroFabrica) {
		this.numeroFabrica = numeroFabrica;
	}

	public TipoDisplay getTipoDisplay() {
		return tipoDisplay;
	}

	public void setTipoDisplay(TipoDisplay tipoDisplay) {
		this.tipoDisplay = tipoDisplay;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public String getMensagemDisplay() {
		return mensagemDisplay;
	}

	public void setMensagemDisplay(String mensagemDisplay) {
		this.mensagemDisplay = mensagemDisplay;
	}

	public boolean isBeepTeclado() {
		return beepTeclado;
	}

	public void setBeepTeclado(boolean beepTeclado) {
		this.beepTeclado = beepTeclado;
	}

	public boolean isGerenciadorInteligente() {
		return gerenciadorInteligente;
	}

	public void setGerenciadorInteligente(boolean gerenciadorInteligente) {
		this.gerenciadorInteligente = gerenciadorInteligente;
	}

	public String getSenhaMenu() {
		return senhaMenu;
	}

	public void setSenhaMenu(String senhaMenu) {
		this.senhaMenu = senhaMenu;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public LayoutTeclado getLayoutTeclado() {
		return layoutTeclado;
	}

	public void setLayoutTeclado(LayoutTeclado layoutTeclado) {
		this.layoutTeclado = layoutTeclado;
	}

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

	public boolean isLeitorVericaDigital() {
		return leitorVericaDigital;
	}

	public void setLeitorVericaDigital(boolean leitorVericaDigital) {
		this.leitorVericaDigital = leitorVericaDigital;
	}

	public Automatico getModoCadastro() {
		return modoCadastro;
	}

	public void setModoCadastro(Automatico modoCadastro) {
		this.modoCadastro = modoCadastro;
	}

	public String getTipoEquipamento() {
		return tipoEquipamento;
	}

	public void setTipoEquipamento(String tipoEquipamento) {
		this.tipoEquipamento = tipoEquipamento;
	}

	public String getVersaoProduto() {
		return versaoProduto;
	}

	public void setVersaoProduto(String versaoProduto) {
		this.versaoProduto = versaoProduto;
	}

	public String getVersaoProtocolo() {
		return versaoProtocolo;
	}

	public void setVersaoProtocolo(String versaoProtocolo) {
		this.versaoProtocolo = versaoProtocolo;
	}

	public String getFormatoRegistro() {
		return formatoRegistro;
	}

	public void setFormatoRegistro(String formatoRegistro) {
		this.formatoRegistro = formatoRegistro;
	}

}
