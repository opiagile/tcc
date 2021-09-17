<%@ page pageEncoding="UTF-8"%>
<%@ include file="../include/taglibs.jsp" %>
<%@ include file="../include/headHelp.jsp" %>
<style type="text/css">
	fieldset{
		padding-bottom: 10px;
	}
</style>
<div class="page-header">	
	<h3><fmt:message key="relatorio.acessos.title" /></h3>
</div>
	<p><fmt:message key="relatorio.help.acessos.descricao" /></p>
	<fieldset>
		<legend><fmt:message key="relatorio.help.acessos.filtros"/></legend>
		<fieldset>
			<p><b><fmt:message key="relatorio.help.acessos.pessoa" /></b>: <fmt:message key="relatorio.help.acessos.pessoa.descricao" /></p>
			<p><b><fmt:message key="relatorio.help.acessos.equipamento" /></b>: <fmt:message key="relatorio.help.acessos.equipamento.descricao" /></p>
			<p><b><fmt:message key="relatorio.help.acessos.tipoLiberacao" /></b>: <fmt:message key="relatorio.help.acessos.tipoLiberacao.descricao" /></p>
			<p><b><fmt:message key="relatorio.help.acessos.dataInicio" /></b>: <fmt:message key="relatorio.help.acessos.dataInicio.descricao" /></p>
			<p><b><fmt:message key="relatorio.help.acessos.dataFim" /></b>: <fmt:message key="relatorio.help.acessos.dataFim.descricao" /></p>
		</fieldset>
	</fieldset>
<%@ include file="../include/footHelp.jsp" %>