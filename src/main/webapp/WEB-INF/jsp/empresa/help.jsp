<%@ page pageEncoding="UTF-8"%>
<%@ include file="../include/taglibs.jsp" %>
<%@ include file="../include/headHelp.jsp" %>
<style type="text/css">
	fieldset{
		padding-bottom: 10px;
	}
</style>
<div class="page-header">	
	<h3><fmt:message key="empresa.help.title" /></h3>
</div>
	<p><fmt:message key="empresa.help.descricao" /></p>
	<fieldset>
		<legend><fmt:message key="empresa.help.listar"/></legend>
		<p><fmt:message key="empresa.help.listar.descricao" /></p>
	</fieldset>
	<fieldset>
		<legend><fmt:message key="empresa.help.cadastro"/></legend>
		<p><fmt:message key="empresa.help.cadastro.descricao" /></p>
		<fieldset>
			<legend><fmt:message key="empresa.help.cadastro.dados"/></legend>
			<p><b><fmt:message key="empresa.help.cadastro.dados.nome" /></b>: <fmt:message key="empresa.help.cadastro.dados.nome.descricao" /></p>
			<p><b><fmt:message key="empresa.help.cadastro.dados.cnpj" /></b>: <fmt:message key="empresa.help.cadastro.dados.cnpj.descricao" /></p>
			<p><b><fmt:message key="empresa.help.cadastro.dados.telefone" /></b>: <fmt:message key="empresa.help.cadastro.dados.telefone.descricao" /></p>
			<p><b><fmt:message key="empresa.help.cadastro.dados.celular" /></b>: <fmt:message key="empresa.help.cadastro.dados.celular.descricao" /></p>
			<p><b><fmt:message key="empresa.help.cadastro.dados.email" /></b>: <fmt:message key="empresa.help.cadastro.dados.email.descricao" /></p>
		</fieldset>
		<fieldset>
			<legend><fmt:message key="empresa.help.cadastro.endereco"/></legend>
			<p><b><fmt:message key="empresa.help.cadastro.endereco.cep" /></b>: <fmt:message key="empresa.help.cadastro.endereco.cep.descricao" /></p>
			<p><b><fmt:message key="empresa.help.cadastro.endereco.logradouro" /></b>: <fmt:message key="empresa.help.cadastro.endereco.logradouro.descricao" /></p>
			<p><b><fmt:message key="empresa.help.cadastro.endereco.numero" /></b>: <fmt:message key="empresa.help.cadastro.endereco.numero" /></p>
			<p><b><fmt:message key="empresa.help.cadastro.endereco.complemento" /></b>: <fmt:message key="empresa.help.cadastro.endereco.complemento.descricao" /></p>
			<p><b><fmt:message key="empresa.help.cadastro.endereco.bairro" /></b>: <fmt:message key="empresa.help.cadastro.endereco.bairro.descricao" /></p>
			<p><b><fmt:message key="empresa.help.cadastro.endereco.cidade" /></b>: <fmt:message key="empresa.help.cadastro.endereco.cidade.descricao" /></p>
			<p><b><fmt:message key="empresa.help.cadastro.endereco.estado" /></b>: <fmt:message key="empresa.help.cadastro.endereco.estado.descricao" /></p>
		</fieldset>
	</fieldset>
<%@ include file="../include/footHelp.jsp" %>