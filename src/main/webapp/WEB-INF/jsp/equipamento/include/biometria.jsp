<%@ page pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jsp" %>
<fieldset>
	<fieldset>
		<legend><fmt:message key="equipamento.label.biometria"/></legend>
		<table>
			<tr>
				<td><tl:checkbox id="verificacao1n" name="equipamento.configuracao.biometria.verificacao1n" value="${equipamento.configuracao.biometria.verificacao1n}" />&nbsp;<fmt:message key="equipamento.label.biometria.verificacao1n"/></td>
				<td colspan="2"><tl:checkbox id="autoOn" name="equipamento.configuracao.biometria.autoOn" value="${equipamento.configuracao.biometria.autoOn}" />&nbsp;<fmt:message key="equipamento.label.biometria.autoOn"/></td>
			</tr>
			<tr>
				<td><fmt:message key="equipamento.label.biometria.sensibilidade"/>:</td>
				<td><fmt:message key="equipamento.label.biometria.nivelSeguranca"/>:</td>
				<td><fmt:message key="equipamento.label.biometria.qualidadeImagem"/>:</td>
			</tr>
			<tr>
				<td><tl:spinner id="sensibilidadeDSP" name="equipamento.configuracao.biometria.sensibilidadeDSP" width="180px" value="${equipamento.configuracao.biometria.sensibilidadeDSP}" min="48" max="55"/></td>
				<td><tl:spinner id="segurancaDSP" name="equipamento.configuracao.biometria.segurancaDSP" width="180px" value="${equipamento.configuracao.biometria.segurancaDSP}" min="48" max="55"/></td>
				<td><tl:spinner id="qualidadeImagemDSP" name="equipamento.configuracao.biometria.qualidadeImagemDSP" width="180px" value="${equipamento.configuracao.biometria.qualidadeImagemDSP}" min="48" max="51"/></td>
			</tr>
			<tr>
				<td><fmt:message key="equipamento.label.biometria.qualidadeMinima"/>:</td>
				<td><fmt:message key="equipamento.label.biometria.modoRapido"/>:</td>
				<td><fmt:message key="equipamento.label.biometria.luminosidade"/>:</td>
			</tr>
			<tr>
				<td><tl:spinner id="qualidadeMinima" name="equipamento.configuracao.biometria.qualidadeMinima" width="180px" value="${equipamento.configuracao.biometria.qualidadeMinima}" min="20" max="100"/></td>
				<td><tl:spinner id="modoRapidoDSP" name="equipamento.configuracao.biometria.modoRapidoDSP" width="180px" value="${equipamento.configuracao.biometria.modoRapidoDSP}" min="48" max="53"/></td>
				<td><tg:combo id="luminosidade" name="equipamento.configuracao.biometria.luminosidade" width="200px;" options="${tiposLuminosidade}" optionValue="id" optionLabel="descricao" selected="${equipamento.configuracao.biometria.luminosidade}"/></td>
			</tr>
			<tr>
				<td><fmt:message key="equipamento.label.biometria.padraoTemplate"/>:</td>
			</tr>
			<tr>
				<td><tg:combo id="padraoTemplate" name="equipamento.configuracao.biometria.padraoTemplate" width="205px;" options="${tiposTemplate}" optionValue="id" optionLabel="descricao" selected="${equipamento.configuracao.biometria.padraoTemplate}"/></td>
			</tr>
		</table>
	</fieldset>
</fieldset>
