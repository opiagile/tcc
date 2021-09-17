<%@ page pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<%@ include file="../include/taglibs.jsp" %>
<%@ include file="../include/pageHeader.jsp" %>
<button type="button" class="btn btn-default pull-right" onClick="abrirCadastroModal('<c:url value="/empresa/cadastrar" />', 'myModal');"><fmt:message key="empresa.listar.botaoNovo" /></button>
<div>&nbsp;</div>
<div>&nbsp;</div>
<div class="bs-table-scrollable">
	<table class="table table-striped">
		<thead>
			<tr>
				<th><fmt:message key="empresa.label.nome" /></th>
				<th><fmt:message key="empresa.label.cnpj" /></th>
				<th><fmt:message key="empresa.label.telefone" /></th>
				<th><fmt:message key="empresa.label.endereco" /></th>
				<th><fmt:message key="empresa.label.editar" /></th>
		</tr>
		</thead>
		<tbody>
			<c:forEach var="empresa" items="${empresas}">
				<tr>
					<td>${empresa.nome}</td>
					<td>${empresa.cnpj}</td>
					<td>${empresa.contato.telefone}</td>
					<td>${empresa.endereco.logradouro.nome}</td>
					<td><button type="button" class="btn btn-default btn-xs" onClick="abrirCadastroModal('<c:url value="/empresa/editar/" />' + ${empresa.id}, 'myModal')" ><fmt:message key="empresa.label.editar" /></button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="modal fade" id="myModal"></div>
<%@ include file="../include/footer.jsp" %>
