<%@ page pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jsp" %>
<fieldset>
	<fieldset>
		<legend><fmt:message key="pessoa.label.contato"/></legend>
		<table>
			<tr>
				<td><fmt:message key="pessoa.label.contato.telefone"/></td>
				<td><fmt:message key="pessoa.label.contato.celular"/></td>
			</tr>
			<tr>
				<td><input type="text" class="input-sm" id="telefone" name="pessoa.contato.telefone" value="${pessoa.contato.telefone}" maxlength="15" placeholder="<fmt:message key='pessoa.placeHolder.telefone'/>" style="width:280px;"/></td>
				<td><input type="text" class="input-sm" id="celular" name="pessoa.contato.celular" value="${pessoa.contato.celular}" maxlength="15" placeholder="<fmt:message key='pessoa.placeHolder.celular'/>" style="width:280px;"/></td>
			</tr>
			<tr>
				<td><fmt:message key="pessoa.label.contato.email"/></td>
			</tr>
			<tr>
				<td><input type="text" class="input-sm" id="email" name="pessoa.contato.email" value="${pessoa.contato.email}" maxlength="255" placeholder="<fmt:message key='pessoa.placeHolder.email'/>" style="width:280px;"/></td>				
			</tr>
		</table>
	</fieldset>
</fieldset>
