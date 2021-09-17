package br.com.henry.primmeAcesso.command.envio;

import java.util.List;

import br.com.henry.primmeAcesso.model.configuracao.Acesso;
import br.com.henry.primmeAcesso.model.configuracao.Biometria;
import br.com.henry.primmeAcesso.model.configuracao.Comunicacao;
import br.com.henry.primmeAcesso.model.configuracao.ComunicacaoTCP;
import br.com.henry.primmeAcesso.model.configuracao.Configuracao;
import br.com.henry.primmeAcesso.model.configuracao.Expansao;
import br.com.henry.primmeAcesso.model.configuracao.Geral;
import br.com.henry.primmeAcesso.model.configuracao.Perifericos;

public class ConfiguracaoDispatchCommand extends DispatchCommand {

	private Configuracao configuracao;

	public ConfiguracaoDispatchCommand(Configuracao configuracao) {
		super("EC+00+", "%s[%s]");
		this.configuracao = configuracao;
	}

	@Override
	public List<String> getCommand() {
		StringBuilder sb = new StringBuilder();
		sb.append(getConfiguracaoGeral());
		sb.append(getConfiguracaoAcesso());
		sb.append(getConfiguracaoComunicacao());
		sb.append(getConfiguracaoBiometria());
		sb.append(getConfiguracaoPerifericos());
		sb.append(getConfiguracaoExpansao());
		return normalize(sb.toString());
	}

	private String getConfiguracaoGeral() {
		StringBuilder sb = new StringBuilder();
		Geral geral = configuracao.getGeral();
		if (geral != null) {
			sb.append(format("NR_EQUIP", geral.getNumeroEquipamento()));
			sb.append(format("VOLUME", geral.getVolume()));
			sb.append(format("MSG_DISPLAY", geral.getMensagemDisplay()));
			sb.append(format("BEEP_TECLADO",
					converterBoolean(geral.isBeepTeclado())));
			sb.append(format("GER_INTELIGENTE",
					converterBoolean(geral.isGerenciadorInteligente())));
			sb.append(format("SENHA_MENU", geral.getSenhaMenu()));
			sb.append(format("LOGIN", geral.getLogin()));
			sb.append(format("LAYOUT_TECLADO_USB", geral.getLayoutTeclado()));
			if (geral.getIdioma() != null) {
				sb.append(format("IDIOMA", geral.getIdioma().getValor()));
			}
			sb.append(format("LEITOR_VER_DIG",
					converterBoolean(geral.isLeitorVericaDigital())));
			if (geral.getModoCadastro() != null) {
				sb.append(format("MODO_CADASTRO", geral.getModoCadastro()
						.getValor()));
			}
			sb.append(format("FORMATO_REGISTRO", geral.getFormatoRegistro()));
		}
		return sb.toString();
	}

	private String getConfiguracaoAcesso() {
		StringBuilder sb = new StringBuilder();
		Acesso acesso = configuracao.getAcesso();
		if (acesso != null) {
			if (acesso.getTipoValidacao() != null) {
				sb.append(format("TIPO_VALIDA", acesso.getTipoValidacao()
						.getValor()));
			}
			if (acesso.getTipoArmazenamento() != null) {
				sb.append(format("ARMAZENA_REGISTRO", acesso
						.getTipoArmazenamento().getValor()));
			}
			sb.append(format("VALIDACAO_OFF",
					converterBoolean(acesso.isValidacaoOffline())));
			sb.append(format("TIMEOUT_ON", acesso.getTimeout()));
			sb.append(format("ESPERA_OFF", acesso.getTempoEsperaOffline()));
			sb.append(format("TEMPO_PASSBACK", acesso.getTempoPassback()));
			sb.append(format("DIRECAO_PASSBACK",
					converterBoolean(acesso.isDirecaoPassback())));
			sb.append(format("VERIF_VALIDADE",
					converterBoolean(acesso.isVerificarValidade())));
			if (acesso.getTipoAcesso() != null) {
				sb.append(format("ACESSO_USUARIO", acesso.getTipoAcesso()
						.getValor()));
			}
			sb.append(format("ATIVA_MASTER",
					converterBoolean(acesso.isAtivarMaster())));
			sb.append(format("VERIF_HORARIO",
					converterBoolean(acesso.isVerificarHorario())));
			sb.append(format("GRAVACAO_CICLICA",
					converterBoolean(acesso.isGravacaoCiclica())));
			sb.append(format("TAXA_REVISTA", acesso.getTaxaRevista()));
			sb.append(format("BIOMETRIA_ONLINE",
					converterBoolean(acesso.isBiometriaOnline())));
			sb.append(format("ENVIAR_MATRICULA",
					converterBoolean(acesso.isEnviarMatricula())));
			if (acesso.getNumeroDigitosMatrícula() != null) {
				sb.append(format("NUMERO_DIGITOS", acesso
						.getNumeroDigitosMatrícula().format()));
			}
			if (acesso.getCortaDigitos() != null) {
				sb.append(format("CORTAR_DIGITOS", acesso.getCortaDigitos()
						.format()));
			}
		}
		return sb.toString();
	}

	private String getConfiguracaoComunicacao() {
		StringBuilder sb = new StringBuilder();
		Comunicacao comunicacao = configuracao.getComunicacao();
		ComunicacaoTCP tcp = comunicacao.getTcp();
		if (comunicacao != null) {
			if (tcp != null) {
				sb.append(format("IP", tcp.getIp()));
				sb.append(format("MASC_SUBREDE", tcp.getMascara()));
				sb.append(format("DNS", tcp.getDns()));
				sb.append(format("GATEWAY", tcp.getGateway()));
				sb.append(format("MAC", tcp.getMacAddres()));
				sb.append(format("PORTA_TCP", tcp.getPorta()));
				sb.append(format("NOME_REDE", tcp.getNome()));
				sb.append(format("IP_VERSAO", tcp.getVersaoIP()));
				sb.append(format("DHCP", converterBoolean(tcp.isDhcp())));
			}
			sb.append(format("CRIPTO_CHAVE", comunicacao.getChaveCriptografia()));
			sb.append(format("IP_CON_SEGURA",
					comunicacao.getIpComunicacaoSegura()));
			if (comunicacao.getTipoComunicacao() != null) {
				sb.append(format("TIPO_COM", comunicacao.getTipoComunicacao()
						.getValor()));
			}
			if (comunicacao.getVelocidadeSerial() != null) {
				sb.append(format("VEL_SERIAL", comunicacao
						.getVelocidadeSerial().getValor()));
			}
			sb.append(format("CON_SEGURA",
					converterBoolean(comunicacao.isConexaoSegura())));
			sb.append(format("CRIPTO_HAB",
					converterBoolean(comunicacao.isCriptografar())));
		}
		return sb.toString();
	}

	private String getConfiguracaoBiometria() {
		StringBuilder sb = new StringBuilder();
		Biometria biometria = configuracao.getBiometria();
		if (biometria != null) {
			sb.append(format("DSP_SENSIBILIDADE",
					biometria.getSensibilidadeDSP()));
			sb.append(format("DSP_SEGURANCA", biometria.getSegurancaDSP()));
			sb.append(format("DSP_QLDE_IMG", biometria.getQualidadeImagemDSP()));
			sb.append(format("DSP_MODO_RAPIDO", biometria.getModoRapidoDSP()));
			sb.append(format("MIN_BIO_QUALITY", biometria.getQualidadeMinima()));
			sb.append(format("AUTO_ON", converterBoolean(biometria.isAutoOn())));
			sb.append(format("1:N",
					converterBoolean(biometria.isVerificacao1n())));
			if (biometria.getLuminosidade() != null) {
				sb.append(format("LUMINOSIDADE", biometria.getLuminosidade()
						.getValor()));
			}
			if (biometria.getPadraoTemplate() != null) {
				sb.append(format("PADRAO_TEMPLATE", biometria
						.getPadraoTemplate().getValor()));
			}
		}
		return sb.toString();
	}

	private String getConfiguracaoPerifericos() {
		StringBuilder sb = new StringBuilder();
		Perifericos periferico = configuracao.getPerifericos();
		if (periferico != null) {
			sb.append(format("LEITOR_1", periferico.getLeitor1().format()));
			sb.append(format("LEITOR_2", periferico.getLeitor2().format()));
			sb.append(format("LEITOR_3", periferico.getLeitor3().format()));
			sb.append(format("LEITOR_4", periferico.getLeitor4().format()));
			sb.append(format("LEITOR_5", periferico.getLeitor5().format()));
			sb.append(format("TECLADO", periferico.getTeclado().format()));
			if (periferico.getLeitoraUsb() != null) {
				sb.append(format("LEITORA_USB2", periferico.getLeitoraUsb()
						.format()));
			}
			sb.append(format("LEITOR_EXPANSAO_1", periferico
					.getLeitorExpansao1().format()));
			sb.append(format("LEITOR_EXPANSAO_2", periferico
					.getLeitorExpansao2().format()));
			sb.append(format("LEITOR_EXPANSAO_BIO", periferico
					.getLeitorExpansaoBiometrico().format()));
			sb.append(format("LEITOR_CAM", periferico.getLeitor2D().format()));
			if (!periferico.getPadroes2D().isEmpty()) {
				sb.append(format("CAM_PADRAO_LEITURA",
						periferico.formatarPadroes()));
			}
			if (periferico.getEntradaDigital1() != null) {
				sb.append(format("ENTRADA_DIGITAL1", periferico
						.getEntradaDigital1().getValor()));
			}
			if (periferico.getEntradaDigital2() != null) {
				sb.append(format("ENTRADA_DIGITAL2", periferico
						.getEntradaDigital2().getValor()));
			}
			if (periferico.getRele1() != null) {
				sb.append(format("RELE1", periferico.getRele1().format()));
			}
			if (periferico.getRele2() != null) {
				sb.append(format("RELE2", periferico.getRele2().format()));
			}
			if (periferico.getRele3() != null) {
				sb.append(format("RELE3", periferico.getRele3().format()));
			}
			if (periferico.getTamper() != null) {
				sb.append(format("TAMPER_EXTERNO", periferico.getTamper()
						.getValor()));
			}
		}
		return sb.toString();
	}

	private String getConfiguracaoExpansao() {
		StringBuilder sb = new StringBuilder();
		Expansao expansao = configuracao.getExpansao();
		if (expansao != null) {
			sb.append(format("EXP_HABILITADO",
					converterBoolean(expansao.isHabilitado())));
			sb.append(format("EXP_TEMPO_LIBERACAO",
					expansao.getTempoLiberacao()));
			sb.append(format("EXP_CATRACA_INVERTIDA",
					converterBoolean(expansao.isCatracaInvertida())));
			if (expansao.getTipoLiberacao() != null) {
				sb.append(format("EXP_TIPO_LIBERACAO", expansao
						.getTipoLiberacao().getValor()));
			}
			sb.append(format("EXP_COFRE_HABILITADO",
					converterBoolean(expansao.isHabilitarCofre())));
			if (expansao.getLeitoraCofre() != null) {
				sb.append(format("EXP_COFRE_LEITORA", expansao
						.getLeitoraCofre().getId()));
			}
			sb.append(format("EXP_PICTOGRAMA",
					converterBoolean(expansao.isHabilitarPictograma())));
		}
		return sb.toString();
	}
}
