<%@ attribute name="id" required="true" %>
<%@ attribute name="name" required="true" %>
<%@ attribute name="value" required="true" %>
<input type="hidden" id="hidden_${id}" name="${name}" value="${value}" class="input-small" />
<input type="checkbox" id="${id}" value="${value}" class="input-small" />
<script type="text/javascript">
	$("#hidden_${id}").val('${value}');
	$("#${id}").bind('change', function(){
		$("#hidden_${id}").val($("#${id}").is(':checked'));
		$("#${id}").attr('checked', $("#${id}").is(':checked'));
	});
	$(document).ready(function(){
		if(${value}){
			$("#${id}").attr('checked', 'checked');
		}
	});
</script>