<%@ attribute name="id" required="true" %>
<%@ attribute name="name" required="true" %>
<%@ attribute name="width" required="false" %>
<%@ attribute name="value" required="false" %>
<input type="text" id="${id}" name="${name}" style="width:${width};" maxlength="19" size="19" value="${value}" onKeyUp="dataHora(event, this)" class="input-small" />