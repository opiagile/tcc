package br.com.henry.primmeAcesso.model.configuracao;

import java.util.ArrayList;
import java.util.List;

import br.com.henry.primmeAcesso.model.Direcao;
import br.com.henry.primmeAcesso.model.EntradaDigital;
import br.com.henry.primmeAcesso.model.Leitor;
import br.com.henry.primmeAcesso.model.Padrao2D;
import br.com.henry.primmeAcesso.model.Rele;
import br.com.henry.primmeAcesso.model.TamperExterno;
import br.com.henry.primmeAcesso.model.TipoLeitora;

public class Perifericos {
	private Leitor leitor1;
	private Leitor leitor2;
	private Leitor leitor3;
	private Leitor leitor4;
	private Leitor leitor5;
	private Leitor teclado;
	private Leitor leitoraUsb;
	private Leitor leitorExpansao1;
	private Leitor leitorExpansao2;
	private Leitor leitorExpansaoBiometrico;
	private Leitor leitor2D;
	private List<Padrao2D> padroes2D;
	private EntradaDigital entradaDigital1;
	private EntradaDigital entradaDigital2;
	private Rele rele1;
	private Rele rele2;
	private Rele rele3;
	private TamperExterno tamper;

	public Perifericos() {
		this.leitor1 = new Leitor(TipoLeitora.NENHUM);
		this.leitor2 = new Leitor(TipoLeitora.NENHUM);
		this.leitor3 = new Leitor(TipoLeitora.NENHUM);
		this.leitor4 = new Leitor(TipoLeitora.NENHUM);
		this.leitor5 = new Leitor(TipoLeitora.NENHUM);
		this.teclado = new Leitor(TipoLeitora.TECLADO, Direcao.SAIDA);
		this.leitorExpansao1 = new Leitor(TipoLeitora.NENHUM);
		this.leitorExpansao2 = new Leitor(TipoLeitora.NENHUM);
		this.leitorExpansaoBiometrico = new Leitor(TipoLeitora.NENHUM);
		this.leitor2D = new Leitor(TipoLeitora.NENHUM);
		this.entradaDigital1 = EntradaDigital.DESABILITADO;
		this.entradaDigital2 = EntradaDigital.DESABILITADO;
		this.rele1 = new Rele();
		this.rele2 = new Rele();
		this.rele3 = new Rele();
		this.tamper = TamperExterno.DESABILITADO;
		this.padroes2D = new ArrayList<Padrao2D>();
	}

	public Leitor getLeitor1() {
		return leitor1;
	}

	public void setLeitor1(Leitor leitor1) {
		this.leitor1 = leitor1;
	}

	public Leitor getLeitor2() {
		return leitor2;
	}

	public void setLeitor2(Leitor leitor2) {
		this.leitor2 = leitor2;
	}

	public Leitor getLeitor3() {
		return leitor3;
	}

	public void setLeitor3(Leitor leitor3) {
		this.leitor3 = leitor3;
	}

	public Leitor getLeitor4() {
		return leitor4;
	}

	public void setLeitor4(Leitor leitor4) {
		this.leitor4 = leitor4;
	}

	public Leitor getLeitor5() {
		return leitor5;
	}

	public void setLeitor5(Leitor leitor5) {
		this.leitor5 = leitor5;
	}

	public Leitor getTeclado() {
		return teclado;
	}

	public void setTeclado(Leitor teclado) {
		this.teclado = teclado;
	}

	public Leitor getLeitoraUsb() {
		return leitoraUsb;
	}

	public void setLeitoraUsb(Leitor leitoraUsb) {
		this.leitoraUsb = leitoraUsb;
	}

	public Leitor getLeitorExpansao1() {
		return leitorExpansao1;
	}

	public void setLeitorExpansao1(Leitor leitorExpansao1) {
		this.leitorExpansao1 = leitorExpansao1;
	}

	public Leitor getLeitorExpansao2() {
		return leitorExpansao2;
	}

	public void setLeitorExpansao2(Leitor leitorExpansao2) {
		this.leitorExpansao2 = leitorExpansao2;
	}

	public Leitor getLeitorExpansaoBiometrico() {
		return leitorExpansaoBiometrico;
	}

	public void setLeitorExpansaoBiometrico(Leitor leitorExpansaoBiometrico) {
		this.leitorExpansaoBiometrico = leitorExpansaoBiometrico;
	}

	public Leitor getLeitor2D() {
		return leitor2D;
	}

	public void setLeitor2D(Leitor leitor2D) {
		this.leitor2D = leitor2D;
	}

	public List<Padrao2D> getPadroes2D() {
		return padroes2D;
	}

	public void setPadroes2D(List<Padrao2D> padroes2D) {
		this.padroes2D = padroes2D;
	}

	public String formatarPadroes() {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (Padrao2D padrao : padroes2D) {
			if (count != 0) {
				sb.append("}");
			}
			sb.append(padrao.getId());
			count++;
		}
		return sb.toString();
	}

	public EntradaDigital getEntradaDigital1() {
		return entradaDigital1;
	}

	public void setEntradaDigital1(EntradaDigital entradaDigital1) {
		this.entradaDigital1 = entradaDigital1;
	}

	public EntradaDigital getEntradaDigital2() {
		return entradaDigital2;
	}

	public void setEntradaDigital2(EntradaDigital entradaDigital2) {
		this.entradaDigital2 = entradaDigital2;
	}

	public Rele getRele1() {
		return rele1;
	}

	public void setRele1(Rele rele1) {
		this.rele1 = rele1;
	}

	public Rele getRele2() {
		return rele2;
	}

	public void setRele2(Rele rele2) {
		this.rele2 = rele2;
	}

	public Rele getRele3() {
		return rele3;
	}

	public void setRele3(Rele rele3) {
		this.rele3 = rele3;
	}

	public TamperExterno getTamper() {
		return tamper;
	}

	public void setTamper(TamperExterno tamper) {
		this.tamper = tamper;
	}

}
