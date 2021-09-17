<%@ page pageEncoding="UTF-8"%>
<%@ include file="../include/taglibs.jsp" %>
<%@ include file="../include/headHelp.jsp" %>
<style type="text/css">
	fieldset{
		padding-bottom: 10px;
	}
</style>
<div class="page-header">	
	<h3><fmt:message key="pessoa.help.title" /></h3>
</div>
	<p><fmt:message key="pessoa.help.descricao" /></p>
	<fieldset>
		<legend><fmt:message key="pessoa.help.listar"/></legend>
		<p><fmt:message key="pessoa.help.listar.descricao" /></p>
	</fieldset>
	<fieldset>
		<legend><fmt:message key="pessoa.help.cadastro"/></legend>
		<p><fmt:message key="pessoa.help.cadastro.descricao" /></p>
		<fieldset>
			<legend><fmt:message key="pessoa.help.cadastro.dados"/></legend>
			<p><b><fmt:message key="pessoa.help.cadastro.dados.identificador" /></b>: <fmt:message key="pessoa.help.cadastro.dados.identificador.descricao" /></p>
			<p><b><fmt:message key="pessoa.help.cadastro.dados.nome" /></b>: <fmt:message key="pessoa.help.cadastro.dados.nome.descricao" /></p>
			<p><b><fmt:message key="pessoa.help.cadastro.dados.dataNascimento" /></b>: <fmt:message key="pessoa.help.cadastro.dados.dataNascimento.descricao" /></p>
			<p><b><fmt:message key="pessoa.help.cadastro.dados.numeroDocumento" /></b>: <fmt:message key="pessoa.help.cadastro.dados.numeroDocumento.descricao" /></p>
			<p><b><fmt:message key="pessoa.help.cadastro.dados.orgaoEmissor" /></b>: <fmt:message key="pessoa.help.cadastro.dados.orgaoEmissor.descricao" /></p>
			<p><b><fmt:message key="pessoa.help.cadastro.dados.dataEmissao" /></b>: <fmt:message key="pessoa.help.cadastro.dados.dataEmissao.descricao" /></p>
			<p><b><fmt:message key="pessoa.help.cadastro.dados.periodoPermanencia" /></b>: <fmt:message key="pessoa.help.cadastro.dados.periodoPermanencia.descricao" /></p>
		</fieldset>
		<fieldset>
			<legend><fmt:message key="pessoa.help.cadastro.contato"/></legend>
			<p><b><fmt:message key="pessoa.help.cadastro.contato.telefone" /></b>: <fmt:message key="pessoa.help.cadastro.contato.telefone.descricao" /></p>
			<p><b><fmt:message key="pessoa.help.cadastro.contato.celular" /></b>: <fmt:message key="pessoa.help.cadastro.contato.celular" /></p>
			<p><b><fmt:message key="pessoa.help.cadastro.contato.email" /></b>: <fmt:message key="pessoa.help.cadastro.contato.email.descricao" /></p>
		</fieldset>
		<fieldset>
			<legend><fmt:message key="pessoa.help.cadastro.endereco"/></legend>
			<p><b><fmt:message key="pessoa.help.cadastro.endereco.cep" /></b>: <fmt:message key="pessoa.help.cadastro.endereco.cep.descricao" /></p>
		</fieldset>
		<fieldset>
			<legend><fmt:message key="pessoa.help.cadastro.empresa"/></legend>
			<p><fmt:message key="pessoa.help.cadastro.empresa.descricao" /></p>
		</fieldset>
		<fieldset>
			<legend><fmt:message key="pessoa.help.cadastro.equipamento"/></legend>
			<p><fmt:message key="pessoa.help.cadastro.equipamento.descricao" /></p>
		</fieldset>
	</fieldset>
<%@ include file="../include/footHelp.jsp" %>