<%@ page pageEncoding="UTF-8"%>
<%@ include file="../include/taglibs.jsp" %>
<%@ include file="../include/headHelp.jsp" %>
<style type="text/css">
	fieldset{
		padding-bottom: 10px;
	}
</style>
<div class="page-header">	
	<h3><fmt:message key="equipamento.help.title" /></h3>
</div>
	<p><fmt:message key="equipamento.help.descricao" /></p>
	<fieldset>
		<legend><fmt:message key="equipamento.help.listar"/></legend>
		<p><fmt:message key="equipamento.help.listar.descricao" /></p>
	</fieldset>
	<fieldset>
		<legend><fmt:message key="equipamento.help.cadastro"/></legend>
		<p><fmt:message key="equipamento.help.cadastro.descricao" /></p>
		<fieldset>
			<legend><fmt:message key="equipamento.help.cadastro.geral"/></legend>
			<p><b><fmt:message key="equipamento.help.cadastro.geral.mensagemdodisplay" /></b>: <fmt:message key="equipamento.help.cadastro.geral.mensagemdodisplay.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.geral.idioma" /></b>: <fmt:message key="equipamento.help.cadastro.geral.idioma.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.geral.volume" /></b>: <fmt:message key="equipamento.help.cadastro.geral.volume.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.geral.beepdoteclado" /></b>: <fmt:message key="equipamento.help.cadastro.geral.beepdoteclado.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.geral.layouttecladousb" /></b>: <fmt:message key="equipamento.help.cadastro.geral.layouttecladousb.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.geral.leitorverificadigital" /></b>: <fmt:message key="equipamento.help.cadastro.geral.leitorverificadigital.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.geral.biometriaonline" /></b>: <fmt:message key="equipamento.help.cadastro.geral.biometriaonline.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.geral.gerenciamentointeligente" /></b>: <fmt:message key="equipamento.help.cadastro.geral.gerenciamentointeligente.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.geral.cadastroautomatico" /></b>: <fmt:message key="equipamento.help.cadastro.geral.cadastroautomatico.descricao" /></p>
		</fieldset>
		<fieldset>
			<legend><fmt:message key="equipamento.help.cadastro.acesso"/></legend>
			<p><b><fmt:message key="equipamento.help.cadastro.acesso.tipodeacesso" /></b>: <fmt:message key="equipamento.help.cadastro.acesso.tipodeacesso.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.acesso.taxaderevista" /></b>: <fmt:message key="equipamento.help.cadastro.acesso.taxaderevista.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.acesso.verificarvalidade" /></b>: <fmt:message key="equipamento.help.cadastro.acesso.verificarvalidade.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.acesso.verificarhorario" /></b>: <fmt:message key="equipamento.help.cadastro.acesso.verificarhorario.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.acesso.ativarmaster" /></b>: <fmt:message key="equipamento.help.cadastro.acesso.ativarmaster.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.acesso.mododecomunicacao" /></b>: <fmt:message key="equipamento.help.cadastro.acesso.mododecomunicacao.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.acesso.tipodegravacao" /></b>: <fmt:message key="equipamento.help.cadastro.acesso.tipodegravacao.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.acesso.latenciaoffline" /></b>: <fmt:message key="equipamento.help.cadastro.acesso.latenciaoffline.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.acesso.reportaoffline" /></b>: <fmt:message key="equipamento.help.cadastro.acesso.reportaoffline.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.acesso.passback" /></b>: <fmt:message key="equipamento.help.cadastro.acesso.passback.descricao" /></p>
		</fieldset>
		<fieldset>
			<legend><fmt:message key="equipamento.help.cadastro.comunicacao"/></legend>
			<p><b><fmt:message key="equipamento.help.cadastro.comunicacao.numeroequipamento" /></b>: <fmt:message key="equipamento.help.cadastro.comunicacao.numeroequipamento.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.comunicacao.valocidadecomunicacao" /></b>: <fmt:message key="equipamento.help.cadastro.comunicacao.valocidadecomunicacao.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.comunicacao.dhcp" /></b>: <fmt:message key="equipamento.help.cadastro.comunicacao.dhcp.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.comunicacao.ip" /></b>: <fmt:message key="equipamento.help.cadastro.comunicacao.ip.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.comunicacao.porta" /></b>: <fmt:message key="equipamento.help.cadastro.comunicacao.porta.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.comunicacao.mascaradesubrede" /></b>: <fmt:message key="equipamento.help.cadastro.comunicacao.mascaradesubrede.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.comunicacao.dns" /></b>: <fmt:message key="equipamento.help.cadastro.comunicacao.dns.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.comunicacao.gateway" /></b>: <fmt:message key="equipamento.help.cadastro.comunicacao.gateway.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.comunicacao.nomedarede" /></b>: <fmt:message key="equipamento.help.cadastro.comunicacao.nomedarede.descricao" /></p>
		</fieldset>
		<fieldset>
			<legend><fmt:message key="equipamento.help.cadastro.biometria"/></legend>
			<p><b><fmt:message key="equipamento.help.cadastro.biometria.verificar1n" /></b>: <fmt:message key="equipamento.help.cadastro.biometria.verificar1n.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.biometria.autoon" /></b>: <fmt:message key="equipamento.help.cadastro.biometria.autoon.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.biometria.sensibilidade" /></b>: <fmt:message key="equipamento.help.cadastro.biometria.sensibilidade.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.biometria.qualidadeimagem" /></b>: <fmt:message key="equipamento.help.cadastro.comunicacao.qualidadeimagem.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.biometria.qualidademinima" /></b>: <fmt:message key="equipamento.help.cadastro.biometria.qualidademinima.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.biometria.luminosidade" /></b>: <fmt:message key="equipamento.help.cadastro.biometria.luminosidade.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.biometria.padraodotemplate" /></b>: <fmt:message key="equipamento.help.cadastro.biometria.padraodotemplate.descricao" /></p>
		</fieldset>
		<fieldset>
			<legend><fmt:message key="equipamento.help.cadastro.perifericos"/></legend>
			<p><b><fmt:message key="equipamento.help.cadastro.perifericos.tipo1" /></b>: <fmt:message key="equipamento.help.cadastro.perifericos.tipo1.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.perifericos.direcao1" /></b>: <fmt:message key="equipamento.help.cadastro.perifericos.direcao1.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.perifericos.tipo2" /></b>: <fmt:message key="equipamento.help.cadastro.perifericos.tipo2.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.perifericos.direcao2" /></b>: <fmt:message key="equipamento.help.cadastro.perifericos.direcao2.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.perifericos.tipo3" /></b>: <fmt:message key="equipamento.help.cadastro.perifericos.tipo3.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.perifericos.direcao3" /></b>: <fmt:message key="equipamento.help.cadastro.perifericos.direcao3.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.perifericos.tipo4" /></b>: <fmt:message key="equipamento.help.cadastro.perifericos.tipo4.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.perifericos.direcao4" /></b>: <fmt:message key="equipamento.help.cadastro.perifericos.direcao4.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.perifericos.tipo5" /></b>: <fmt:message key="equipamento.help.cadastro.perifericos.tipo5.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.perifericos.direcao5" /></b>: <fmt:message key="equipamento.help.cadastro.perifericos.direcao5.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.perifericos.tecladotipo" /></b>: <fmt:message key="equipamento.help.cadastro.perifericos.tecladotipo.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.perifericos.tecladodirecao" /></b>: <fmt:message key="equipamento.help.cadastro.perifericos.tecladodirecao.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.perifericos.leitorausbtipo" /></b>: <fmt:message key="equipamento.help.cadastro.perifericos.leitorausbtipo.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.perifericos.leitora2dtipo" /></b>: <fmt:message key="equipamento.help.cadastro.perifericos.leitora2dtipo.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.perifericos.leitora2ddirecao" /></b>: <fmt:message key="equipamento.help.cadastro.perifericos.leitora2ddirecao.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.perifericos.tamper" /></b>: <fmt:message key="equipamento.help.cadastro.perifericos.tamper.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.perifericos.entrada1tipo" /></b>: <fmt:message key="equipamento.help.cadastro.perifericos.entrada1tipo.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.perifericos.entrada2tipo" /></b>: <fmt:message key="equipamento.help.cadastro.perifericos.entrada2tipo.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.perifericos.rele1tipo" /></b>: <fmt:message key="equipamento.help.cadastro.perifericos.rele1tipo.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.perifericos.rele1tempo" /></b>: <fmt:message key="equipamento.help.cadastro.perifericos.rele1tempo.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.perifericos.rele2tipo" /></b>: <fmt:message key="equipamento.help.cadastro.perifericos.rele2tipo.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.perifericos.rele2tempo" /></b>: <fmt:message key="equipamento.help.cadastro.perifericos.rele2tempo.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.perifericos.rele3tipo" /></b>: <fmt:message key="equipamento.help.cadastro.perifericos.rele3tipo.descricao" /></p>
			<p><b><fmt:message key="equipamento.help.cadastro.perifericos.rele3tempo" /></b>: <fmt:message key="equipamento.help.cadastro.perifericos.rele3tempo.descricao" /></p>		
		</fieldset>
		<div class="hidden">
		<fieldset>
			<legend><fmt:message key="equipamento.help.cadastro.expansao"/></legend>
			<p><b><fmt:message key="equipamento.help.cadastro.expansao.habilitar" /></b>: <fmt:message key="equipamento.help.cadastro.expansao.habilitar.descricao" /></p>
		</fieldset>	
		</div>
	</fieldset>
<%@ include file="../include/footHelp.jsp" %>