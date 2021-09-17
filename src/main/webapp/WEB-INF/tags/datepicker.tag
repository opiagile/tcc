<%@ attribute name="id" required="true" %>
<%@ attribute name="name" required="true" %>
<%@ attribute name="width" required="false" %>
<%@ attribute name="value" required="false" %>
<input type="text" id="${id}" name="${name}" style="width:${width};" maxlength="10" size="10" value="${value}" onKeyUp="dataHora(event, this)" class="input-small" />