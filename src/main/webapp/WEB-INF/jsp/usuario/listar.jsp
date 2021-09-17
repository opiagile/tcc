<%@ page pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<%@ include file="../include/taglibs.jsp" %>
<%@ include file="../include/pageHeader.jsp" %>
<button type="button" class="btn btn-default btn-new pull-right" onClick="abrirCadastroModal('<c:url value="/usuario/cadastrar" />', 'myModal');"><fmt:message key="usuario.listar.botaoNovo" /></button>
<div>&nbsp;</div>
<div>&nbsp;</div>
<div class="bs-table-scrollable">
	<table class="table table-striped">
		<thead>
			<tr>
				<th><fmt:message key="usuario.label.pessoa" /></th>
				<th><fmt:message key="usuario.label.login" /></th>
				<th><fmt:message key="usuario.label.editar" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="usuario" items="${usuarios}">
				<tr>
					<td>${usuario.pessoa.nome}</td>
					<td>${usuario.login}</td>
					<td><button type="button" class="btn btn-default btn-xs" onClick="abrirCadastroModal('<c:url value="/usuario/editar/" />' + ${usuario.id}, 'myModal')" ><fmt:message key="label.editar" /></button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="modal fade" id="myModal"></div>
<%@ include file="../include/footer.jsp" %>