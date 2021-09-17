<%@ page pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jsp" %>
<fieldset>
	<fieldset>
		<legend><fmt:message key="pessoa.label.equipamento"/></legend>
		<table>
			<tr>
				<c:forEach var="item" items="${equipamentos}" varStatus="status">
					<c:set var="checado" value=""/>
						<c:if test="${tgfn:contains(pessoa.equipamentos, item)}">
							<c:set var="checado" value="checked"/>
						</c:if>
					<td style="width: 200px; text-align: center;"><input type="checkbox" name="equipamentos[].id" value="${item.id}" ${checado} >&nbsp;${item.configuracao.comunicacao.tcp.nome}</td>
					<c:if test="${status.index == 2}">
						</tr>
						<tr>
					</c:if>
				</c:forEach>
			</tr>
		</table>
	</fieldset>
</fieldset>