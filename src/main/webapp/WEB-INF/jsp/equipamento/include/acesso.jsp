<%@ page pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jsp" %>
<fieldset>
	<fieldset>
		<legend><fmt:message key="equipamento.label.acesso"/></legend>
		<table>
			<tr>
				<td><fmt:message key="equipamento.label.acesso.tipoAcesso"/>:</td>
				<td><fmt:message key="equipamento.label.acesso.taxaRevista"/>:</td>
				<td></td>
			</tr>
			<tr>
				<td><tg:combo id="tipoAcesso" name="equipamento.configuracao.acesso.tipoAcesso" width="250px;" options="${tiposAcesso}" optionValue="id" optionLabel="descricao" selected="${equipamento.configuracao.acesso.tipoAcesso}"/></td>
				<td><tl:spinner id="taxaRevista" name="equipamento.configuracao.acesso.taxaRevista" width="180px" value="${equipamento.configuracao.acesso.taxaRevista}" /></td>
				<td></td>
			</tr>
			<tr>
				<td><tl:checkbox id="verificarValidade" name="equipamento.configuracao.acesso.verificarValidade" value="${equipamento.configuracao.acesso.verificarValidade}" />&nbsp;<fmt:message key="equipamento.label.acesso.verificarValidade"/></td>
				<td><tl:checkbox id="verificarHorario" name="equipamento.configuracao.acesso.verificarHorario" value="${equipamento.configuracao.acesso.verificarHorario}" />&nbsp;<fmt:message key="equipamento.label.geral.verificarHorario"/></td>
				<td><tl:checkbox id="ativarMaster" name="equipamento.configuracao.acesso.ativarMaster" value="${equipamento.configuracao.acesso.ativarMaster}" />&nbsp;<fmt:message key="equipamento.label.acesso.ativarMaster"/></td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
		<legend><fmt:message key="equipamento.label.acesso.comunicacao"/></legend>
		<table>
			<tr>
				<td><fmt:message key="equipamento.label.acesso.comunicacao.modoComunicacao"/>:</td>
				<td><fmt:message key="equipamento.label.acesso.comunicacao.tipoGravacao"/>:</td>
				<td><fmt:message key="equipamento.label.acesso.comunicacao.timeoutOnline"/>:</td>
			</tr>
			<tr>
				<td><tg:combo id="tipoComunicacao" name="equipamento.configuracao.comunicacao.tipoComunicacao" width="250px;" options="${tiposComunicacao}" optionValue="id" optionLabel="descricao" selected="${equipamento.configuracao.comunicacao.tipoComunicacao}"/></td>
				<td><tg:combo id="tipoArmazenamento" name="equipamento.configuracao.acesso.tipoArmazenamento" width="210px;" options="${tiposArmazenamento}" optionValue="id" optionLabel="descricao" selected="${equipamento.configuracao.acesso.tipoArmazenamento}"/></td>
				<td><tl:spinner id="timeout" name="equipamento.configuracao.acesso.timeout" width="100px" value="${equipamento.configuracao.acesso.timeout}" /></td>
			</tr>
			<tr>
				<td><fmt:message key="equipamento.label.acesso.comunicacao.latenciaOffline"/>:</td>
				<td></td>
			</tr>
				<td><tl:spinner id="tempoEsperaOffline" name="equipamento.configuracao.acesso.tempoEsperaOffline" width="220px" value="${equipamento.configuracao.acesso.tempoEsperaOffline}" /></td>
				<td><tl:checkbox id="validacaoOffline" name="equipamento.configuracao.acesso.validacaoOffline" value="${equipamento.configuracao.acesso.validacaoOffline}" />&nbsp;<fmt:message key="equipamento.label.acesso.validacaoOffline"/></td>
			<tr>
			</tr>
		</table>
	</fieldset>
	<fieldset>
		<legend><fmt:message key="equipamento.label.acesso.reentrada"/></legend>
		<table>
			<tr>
				<td><tl:checkbox id="direcaoPassback" name="equipamento.configuracao.acesso.direcaoPassback" value="${equipamento.configuracao.acesso.direcaoPassback}" />&nbsp;<fmt:message key="equipamento.label.acesso.direcaoPassback"/></td>
			</tr>
		</table>
	</fieldset>
	<div class="hidden">
	<fieldset>
		<legend><fmt:message key="equipamento.label.acesso.mensagemEntrada"/></legend>
		<table>
			<tr>
				<td></td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
		<legend><fmt:message key="equipamento.label.acesso.mensagemSaida"/></legend>
		<table>
			<tr>
				<td></td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
		<legend><fmt:message key="equipamento.label.acesso.filtroDigitos"/></legend>
		<table>
			<tr>
				<td></td>
			</tr>
		</table>
	</fieldset>
	</div>
</fieldset>