<%@ page pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jsp" %>
<fieldset>
	<fieldset>
		<legend><fmt:message key="empresa.label.empresa"/></legend>
		<table>
			<tr>
				<td><fmt:message key="empresa.label.nome"/></td>
				<td><fmt:message key="empresa.label.cnpj"/></td>
			</tr>
			<tr>
				<td><input type="text" class="input-sm" id="nome" name="empresa.nome" value="${empresa.nome}" maxlength="50" placeholder="<fmt:message key='empresa.placeHolder.nome'/>" style="width:280px;"/></td>
				<td><input type="text" class="input-sm" id="cnpj" name="empresa.cnpj" value="${empresa.cnpj}" maxlength="50" placeholder="<fmt:message key='empresa.placeHolder.cnpj'/>" style="width:280px;"/></td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
		<legend><fmt:message key="empresa.label.contato"/></legend>
		<table>
			<tr>
				<td><fmt:message key="empresa.label.contato.telefone"/></td>
				<td><fmt:message key="empresa.label.contato.celular"/></td>
			</tr>
			<tr>
				<td><input type="text" class="input-sm" id="telefone" name="empresa.contato.telefone" value="${empresa.contato.telefone}" maxlength="15" placeholder="<fmt:message key='empresa.placeHolder.telefone'/>" style="width:280px;"/></td>
				<td><input type="text" class="input-sm" id="celular" name="empresa.contato.celular" value="${empresa.contato.celular}" maxlength="15" placeholder="<fmt:message key='empresa.placeHolder.celular'/>" style="width:280px;"/></td>
			</tr>
			<tr>
				<td><fmt:message key="empresa.label.contato.email"/></td>
			</tr>
			<tr>
				<td><input type="text" class="input-sm" id="email" name="empresa.contato.email" value="${empresa.contato.email}" maxlength="255" placeholder="<fmt:message key='empresa.placeHolder.email'/>" style="width:280px;"/></td>				
			</tr>
		</table>
	</fieldset>
</fieldset>
