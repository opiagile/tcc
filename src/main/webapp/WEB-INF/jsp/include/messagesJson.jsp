<%@ page pageEncoding="UTF-8"%>
<%@ include file="../include/taglibs.jsp" %>
<script type=text/javascript>	
	$(document).ready(function() {
		var messagesJsonErros = new Array();
		<c:if test="${!empty errors}">
			<c:forEach var="error" items="${errors}">
				messagesJsonErros.push('${error.message}');
			</c:forEach>
		</c:if>
		if (messagesJsonErros.length > 0) {
			alert(messagesJsonErros);
		}
	});
</script>