<%@ page pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jsp" %>
<fieldset>
		<fieldset>
		<legend><fmt:message key="pessoa.label.empresa"/></legend>
		<table>
			<tr>
				<td><fmt:message key="pessoa.label.empresa"/></td>
			</tr>
			<tr>
				<td><tg:combo id="empresa" name="pessoa.empresa.id" width="280px;" options="${empresas}" optionValue="id" optionLabel="nome" selected="${pessoa.empresa.id}"/></td>
			</tr>
			<tr>
				<td><button type="button" class="btn btn-default btn-new" id="cadastrarNovaEmpresa" onClick="abrirCadastroModal('<c:url value="/empresa/cadastrar" />', 'myModal');"><fmt:message key="empresa.listar.botaoNovo"/></button></td>
			</tr>
		</table>
	</fieldset>
</fieldset>
