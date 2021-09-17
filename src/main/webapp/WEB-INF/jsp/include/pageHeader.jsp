<%@ page pageEncoding="UTF-8"%>
<%@ include file="taglibs.jsp" %>
<div class="page-header">	
	<h2>${title}
	<c:if test="${temHelp}">
		<div class="pull-right" id="help">
			<a href="#" onclick="openPopupHelp('${urlHelp}')"><img src="<c:url value="/static/images/help.png" />" title="<fmt:message key="label.help" />" /></a>
		</div>
	</c:if>
	</h2>
</div>