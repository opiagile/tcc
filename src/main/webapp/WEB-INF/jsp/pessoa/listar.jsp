<%@ page pageEncoding="UTF-8"%>
<%@ include file="../include/taglibs.jsp" %>
<%@ include file="../include/header.jsp" %>
<%@ include file="../include/pageHeader.jsp" %>
<button type="button" class="btn btn-default btn-new pull-right" onClick="abrirCadastroModal('<c:url value="/pessoa/cadastrar" />', 'myModal');"><fmt:message key="pessoa.listar.botaoNovo" /></button>
<div>&nbsp;</div>
<div>&nbsp;</div>
<div class="bs-table-scrollable">
	<table class="table table-striped">
		<thead>
			<tr>
				<th><fmt:message key="pessoa.label.nome" /></th>
				<th><fmt:message key="pessoa.label.identificador" /></th>
			    <th><fmt:message key="pessoa.label.empresa" /></th>
			    <th><fmt:message key="pessoa.label.documento" /></th>
			    <th><fmt:message key="pessoa.label.orgaoExpedidor" /></th>
			    <th><fmt:message key="pessoa.label.editar" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="pessoa" items="${pessoas}">
				<tr>
					<td>${pessoa.nome}</td>
					<td>${pessoa.identificador}</td>
					<td>${pessoa.empresa.nome}</td>
					<td>${pessoa.documento.numero}</td>
					<td>${pessoa.documento.orgaoExpedidor}</td>
					<td><button type="button" class="btn btn-default btn-xs" onClick="abrirCadastroModal('<c:url value="/pessoa/editar/" />' + ${pessoa.id}, 'myModal')" ><fmt:message key="label.editar" /></button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="modal fade" id="myModal"></div>
<%@ include file="../include/footer.jsp" %>