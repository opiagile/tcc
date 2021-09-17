--- usuario
<%@ page pageEncoding="UTF-8"%>
<%@ include file="../include/taglibs.jsp" %>
<%@ include file="../include/headHelp.jsp" %>
<style type="text/css">
	fieldset{
		padding-bottom: 10px;
	}
</style>
<div class="page-header">	
	<h3><fmt:message key="usuario.help.title" /></h3>
</div>
	<p><fmt:message key="usuario.help.descricao" /></p>
	<fieldset>
		<legend><fmt:message key="usuario.help.listar"/></legend>
		<p><fmt:message key="usuario.help.listar.descricao" /></p>
	</fieldset>
	<fieldset>
		<legend><fmt:message key="usuario.help.cadastro"/></legend>
		<p><fmt:message key="usuario.help.cadastro.descricao" /></p>
		<fieldset>
			<legend><fmt:message key="usuario.help.cadastro.dados"/></legend>
			<p><b><fmt:message key="usuario.help.cadastro.dados.pessoa" /></b>: <fmt:message key="usuario.help.cadastro.dados.pessoa.descricao" /></p>
			<p><b><fmt:message key="usuario.help.cadastro.dados.login" /></b>: <fmt:message key="usuario.help.cadastro.dados.login.descricao" /></p>
			<p><b><fmt:message key="usuario.help.cadastro.dados.alterarSenha" /></b>: <fmt:message key="usuario.help.cadastro.dados.alterarSenha.descricao" /></p>
			<p><b><fmt:message key="usuario.help.cadastro.dados.senha" /></b>: <fmt:message key="usuario.help.cadastro.dados.senha.descricao" /></p>
			<p><b><fmt:message key="usuario.help.cadastro.dados.confirmarsenha" /></b>: <fmt:message key="usuario.help.cadastro.dados.confirmarsenha.descricao" /></p>
			
		<fieldset>
			<legend><fmt:message key="usuario.help.cadastro.permissao"/></legend>
			<p><fmt:message key="usuario.help.cadastro.permissao.descricao"/></p>
		</fieldset>
	</fieldset>
<%@ include file="../include/footHelp.jsp" %>