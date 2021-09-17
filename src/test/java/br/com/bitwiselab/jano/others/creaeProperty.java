package br.com.bitwiselab.jano.others;

import java.util.ArrayList;
import java.util.List;

public class creaeProperty {

	public static void main(String args[]) {
		List<String> propertys = new ArrayList<String>();
		addPropertys(propertys);
		for (String string : propertys) {
			System.out.println("<property name=\"" + string + "\" column=\""
					+ string.toUpperCase() + "\" />");
		}
	}

	public static void addPropertys(List<String> propertys) {
		propertys.add("numeroEquipamento");
		propertys.add("numeroFabrica");
		propertys.add("idtipoDisplay");
		propertys.add("volume");
		propertys.add("mensagemDisplay");
		propertys.add("beepTeclado");
		propertys.add("gerenciadorInteligente");
		propertys.add("senhaMenu");
		propertys.add("login");
		propertys.add("idlayoutTeclado");
		propertys.add("ididioma");
		propertys.add("leitorVericaDigital");
		propertys.add("idmodocadastro");
		propertys.add("idtipoequipamento");
		propertys.add("versaoProduto");
		propertys.add("versaoProtocolo");
		propertys.add("formatoRegistro");
		propertys.add("idtipoValidacao");
		propertys.add("idtipoarmazenamento");
		propertys.add("validacaoOffline");
		propertys.add("timeout");
		propertys.add("tempoEsperaOffline");
		propertys.add("tempoPassback");
		propertys.add("direcaoPassback");
		propertys.add("verificarValidade");
		propertys.add("idtipoacesso");
		propertys.add("ativarMaster");
		propertys.add("verificarHorario");
		propertys.add("gravacaoCiclica");
		propertys.add("taxaRevista");
		propertys.add("biometriaOnline");
		propertys.add("enviarMatricula");
		propertys.add("ip");
		propertys.add("mascara");
		propertys.add("dns");
		propertys.add("gateway");
		propertys.add("macAddres");
		propertys.add("porta");
		propertys.add("versaoIP");
		propertys.add("dhcp");
		propertys.add("nome");
		propertys.add("velocidadeSerial");
		propertys.add("idtipocomunicacao");
		propertys.add("conexaoSegura");
		propertys.add("ipComunicacaoSegura");
		propertys.add("criptografar");
		propertys.add("chaveCriptografiaString");
		propertys.add("sensibilidadeDSP");
		propertys.add("segurancaDSP");
		propertys.add("qualidadeImagemDSP");
		propertys.add("modoRapidoDSP");
		propertys.add("qualidadeMinima");
		propertys.add("autoOn");
		propertys.add("verificacao1n");
		propertys.add("idluminosidade");
		propertys.add("idpadraotemplate");
		propertys.add("idtipoleitora1");
		propertys.add("iddirecaoleitora1");
		propertys.add("idtipoleitora2");
		propertys.add("iddirecaoleitora2");
		propertys.add("idtipoleitora3");
		propertys.add("iddirecaoleitora3");
		propertys.add("idtipoleitora4");
		propertys.add("iddirecaoleitora4");
		propertys.add("idtipoleitora5");
		propertys.add("iddirecaoleitora5");
		propertys.add("idleitorateclado");
		propertys.add("iddirecaoteclado");
		propertys.add("idtipoleitorausb");
		propertys.add("iddirecaoleitorausb");
		propertys.add("idtipoexpansao1");
		propertys.add("iddirecaoexpansao1");
		propertys.add("idtipoexpansao2");
		propertys.add("iddirecaoexpansao2");
		propertys.add("idtipoexpansaobiometrico");
		propertys.add("iddirecaoexpansaobiometrico");
		propertys.add("idtipoleitor2D");
		propertys.add("iddirecaoleitor2D");
		propertys.add("identradadigital1");
		propertys.add("identradadigital2");
		propertys.add("idconfiguracaorele1");
		propertys.add("temporele1");
		propertys.add("idconfiguracaorele2");
		propertys.add("temporele2");
		propertys.add("idconfiguracaorele3");
		propertys.add("temporele3");
		propertys.add("idtamper");
	}
}
