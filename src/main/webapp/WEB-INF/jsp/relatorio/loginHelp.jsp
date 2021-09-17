<%@ page pageEncoding="UTF-8"%>
<%@ include file="../include/taglibs.jsp" %>
<%@ include file="../include/headHelp.jsp" %>
<style type="text/css">
	fieldset{
		padding-bottom: 10px;
	}
</style>
<div class="page-header">	
	<h3><fmt:message key="relatorio.login.title" /></h3>
</div>
	<p><fmt:message key="relatorio.help.login.descricao" /></p>
	<fieldset>
		<legend><fmt:message key="relatorio.help.login.filtros"/></legend>
		<fieldset>
			<p><b><fmt:message key="relatorio.help.login.usuario" /></b>: <fmt:message key="relatorio.help.login.usuario.descricao" /></p>
			<p><b><fmt:message key="relatorio.help.login.tipoLogin" /></b>: <fmt:message key="relatorio.help.login.tipoLogin.descricao" /></p>
			<p><b><fmt:message key="relatorio.help.login.dataInicio" /></b>: <fmt:message key="relatorio.help.login.dataInicio.descricao" /></p>
			<p><b><fmt:message key="relatorio.help.login.dataFim" /></b>: <fmt:message key="relatorio.help.login.dataFim.descricao" /></p>
		</fieldset>
	</fieldset>
<%@ include file="../include/footHelp.jsp" %>