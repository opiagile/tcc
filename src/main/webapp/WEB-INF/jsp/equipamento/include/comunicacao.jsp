<%@ page pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jsp" %>
<fieldset>
	<fieldset>
		<legend><fmt:message key="equipamento.label.comunicacao.serial"/></legend>
		<table>
			<tr>
				<td><fmt:message key="equipamento.label.comunicacao.numeroEquipamento"/>:</td>
				<td><fmt:message key="equipamento.label.comunicacao.velocidadeComunicacao"/>:</td>
			</tr>
			<tr>
				<td><tl:spinner id="numeroEquipamento" name="equipamento.configuracao.geral.numeroEquipamento" width="250px" value="${equipamento.configuracao.geral.numeroEquipamento}" /></td>
				<td><tg:combo id="velocidadeSerial" name="equipamento.configuracao.comunicacao.velocidadeSerial" width="280px;" options="${velocidadesComunicacao}" optionValue="id" optionLabel="descricao" selected="${equipamento.configuracao.comunicacao.velocidadeSerial}"/></td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
		<legend><fmt:message key="equipamento.label.comunicacao.tcp"/></legend>
		<table>
			<tr>
				<td colspan="3"><tl:checkbox id="dhcp" name="equipamento.configuracao.comunicacao.tcp.dhcp" value="${equipamento.configuracao.comunicacao.tcp.dhcp}" />&nbsp;<fmt:message key="equipamento.label.comunicacao.dhcp"/></td>
			</tr>
			<tr>
				<td><fmt:message key="equipamento.label.acesso.comunicacao.ip"/>:</td>
				<td><fmt:message key="equipamento.label.acesso.comunicacao.porta"/>:</td>
				<td><fmt:message key="equipamento.label.acesso.comunicacao.mascara"/>:</td>
			</tr>
			<tr>
				<td><input type="text" id="ip" name="equipamento.configuracao.comunicacao.tcp.ip" width="280px;" value="${equipamento.configuracao.comunicacao.tcp.ip}" /></td>
				<td><input type="text" id="porta" name="equipamento.configuracao.comunicacao.tcp.porta" width="280px;" value="${equipamento.configuracao.comunicacao.tcp.porta}" /></td>
				<td><input type="text" id="mascara" name="equipamento.configuracao.comunicacao.tcp.mascara" width="280px;" value="${equipamento.configuracao.comunicacao.tcp.mascara}" /></td>
			</tr>
			<tr>
				<td><fmt:message key="equipamento.label.acesso.comunicacao.dns"/>:</td>
				<td><fmt:message key="equipamento.label.acesso.comunicacao.gateway"/>:</td>
				<td><fmt:message key="equipamento.label.acesso.comunicacao.nomeRede"/>:</td>
			</tr>
			<tr>
				<td><input type="text" id="dns" name="equipamento.configuracao.comunicacao.tcp.dns" width="280px;" value="${equipamento.configuracao.comunicacao.tcp.dns}" /></td>
				<td><input type="text" id="gateway" name="equipamento.configuracao.comunicacao.tcp.gateway" width="280px;" value="${equipamento.configuracao.comunicacao.tcp.gateway}" /></td>
				<td><input type="text" id="nomeRede" name="equipamento.configuracao.comunicacao.tcp.nome" width="280px;" value="${equipamento.configuracao.comunicacao.tcp.nome}" /></td>
			</tr>
			<tr>
			</tr>
		</table>
	</fieldset>
</fieldset>
