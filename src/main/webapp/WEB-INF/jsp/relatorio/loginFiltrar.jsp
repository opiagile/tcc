<%@ page pageEncoding="UTF-8"%>
<%@ include file="../include/taglibs.jsp" %>
<%@ include file="../include/header.jsp" %>
<%@ include file="../include/messagesJson.jsp" %>
<script type="text/javascript">
	$(document).ready(function(){
		validarPeriodo('formFiltrar','<fmt:message key="relatorio.filtrar.validar.required" />', '<fmt:message key="relatorio.filtrar.validar.date" />');
	});
</script>
<div class="page-header">	
	<h3><fmt:message key="relatorio.login.title" />
	<c:if test="${temHelp}">
		<div class="pull-right" id="help">
			<a href="#" onclick="openPopupHelp('${urlHelp}')"><img src="<c:url value="/static/images/help.png" />" title="<fmt:message key="label.help" />" /></a>
		</div>
	</c:if>
	</h3>
</div>
<div class="panel panel-default" style="width: 410px; margin: auto;" >
	<div class="panel-heading"><fmt:message key="label.filtros"/></div>
	<div class="panel-body">
		<form method="get" action="<c:url value="/relatorio/loginProcessar" />" id="formFiltrar" >
			<fieldset>
				<table>
					<tr>
						<td class="labelFiltro"><label for="tipo"><fmt:message key="login.filtrar.tipo"/>:</label></td>
						<td><tg:combo name="filtro.tipo" id="tipo" width="280px;" options="${tipos}" optionLabel="descricao" optionValue="id" selected="${filtro.tipo.id}" primeira="Todos"/></td>
					</tr>
					<tr>
						<td class="labelFiltro"><label for="usuario"><fmt:message key="login.filtrar.usuario"/>:</label></td>
						<td><tg:combo name="filtro.usuario" id="usuario" width="280px;" options="${usuarios}" optionLabel="login" optionValue="id" selected="${filtro.usuario.id}" primeira="Todos"/></td>
					</tr>
					<tr>
						<td class="labelFiltro"><label for="dataInicio"><fmt:message key="login.filtrar.dataInicio"/>:</label></td>
						<td><tl:datetimepicker name="filtro.periodo.inicio" id="dataInicio" width="280px;" value="${filtro.periodo.inicioString}" /></td>
					</tr>
					<tr>
						<td class="labelFiltro"><label for="dataFim"><fmt:message key="login.filtrar.dataFim"/>:</label></td>
						<td><tl:datetimepicker name="filtro.periodo.fim" id="dataFim" width="280px;" value="${filtro.periodo.fimString}"/></td>
					</tr>
					<tr>
						<td colspan=2  style="padding-top: 25px;">
					 		<button type="submit" class="btn btn-default pull-right"><fmt:message key="label.button.pesquisar"/></button>
					 	</td>
					 </tr>
				</table>
			</fieldset>
		</form>
	</div>
</div>
<%@ include file="../include/footer.jsp" %>