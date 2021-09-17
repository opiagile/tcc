<%@ page pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jsp" %>
<fieldset>
	<fieldset>
		<legend><fmt:message key="equipamento.label.perifericos.leitoras"/></legend>
		<table>
			<tr>
				<td><input type="checkbox" name="equipamento.configuracao.expansao.habilitado" value="${equipamento.configuracao.expansao.habilitado}">&nbsp;<fmt:message key="equipamento.label.expansao.habilitar"/></td>
			</tr>
		</table>
	</fieldset>
</fieldset>