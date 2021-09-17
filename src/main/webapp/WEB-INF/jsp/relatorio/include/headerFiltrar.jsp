<%@ page pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jsp" %>
<c:set var="filtros" value="${filtro.toStrings()}"/>
<div class="page-header">
	<h3>${filtro.nomeRelatorio}</h3>
	<table>
		<tbody>	
			<tr>
				<td><strong><fmt:message key="relatorio.label.dataRelatorio"/>:&nbsp;</strong><fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${filtro.dataAtual}" /></td>
			</tr>	
			<tr>
				<td style="text-align:left">
					<strong>Filtros:</strong>
					<c:forEach var="item" items="${filtros.keySet()}" varStatus="status">
						<c:if test="${!status.first}">
						-
						</c:if>
						<strong>${item}:</strong> ${filtros[item]} 			
					</c:forEach>				
				</td>
			</tr>
		</body>
	</table>
</div>
<div>&nbsp;</div>
<c:if test="${empty relatorio}">
	<div>
		<fmt:message key="relatorio.label.nenhumRegistroEncontrado"/>
	</div>
</c:if>