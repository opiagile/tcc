<%@ page pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<%@ include file="../include/taglibs.jsp" %>
<%@ include file="../include/pageHeader.jsp" %>
<button type="button" class="btn btn-default pull-right" onClick="abrirCadastroModal('<c:url value="/equipamento/cadastrar" />', 'myModal');"><fmt:message key="equipamento.listar.botaoNovo" /></button>
<div>&nbsp;</div>
<div>&nbsp;</div>
<div class="bs-table-scrollable">
	<table class="table table-striped">
		<thead>
			<tr>
				<th><fmt:message key="equipamento.label.ip" /></th>
				<th><fmt:message key="equipamento.label.nome" /></th>
				<th><fmt:message key="equipamento.label.mensagemDisplay" /></th>
				<th><fmt:message key="label.editar" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="equipamento" items="${equipamentos}">
				<tr>
					<td>${equipamento.configuracao.comunicacao.tcp.ip}</td>
					<td>${equipamento.configuracao.comunicacao.tcp.nome}</td>
					<td>${equipamento.configuracao.geral.mensagemDisplay}</td>
					<td><button type="button" class="btn btn-default btn-xs" onClick="abrirCadastroModal('<c:url value="/equipamento/editar/" />' + ${equipamento.id}, 'myModal')" ><fmt:message key="label.editar" /></button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="modal fade" id="myModal"></div>
<%@ include file="../include/footer.jsp" %>
