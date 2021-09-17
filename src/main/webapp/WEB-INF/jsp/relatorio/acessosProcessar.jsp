<%@ page pageEncoding="UTF-8"%>
<%@ include file="../include/taglibs.jsp" %>
<%@ include file="../include/header.jsp" %>
<%@ include file="include/headerProcessar.jsp" %>
<div class="bs-table-scrollable">
	<c:forEach var="item" items="${relatorio.dados}">
		<table class="table table-striped">
			<thead>
				<tr>
					<th colspan="2"><fmt:message key="acessos.processar.pessoa" />:${item.Pessoa}</th>
				</tr>
				<tr>	
					<th><fmt:message key="acessos.processar.equipamento" /></th>
					<th><fmt:message key="acessos.processar.tipo" /></th>
					<th><fmt:message key="acessos.processar.dataHora" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dado" items="${item.outros}">
					<tr>
						<td>${dado.Equipamento}</td>
						<td>${dado.tipo}</td>
						<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${dado.dataacesso}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:forEach>
</div>
<%@ include file="../include/footer.jsp" %>