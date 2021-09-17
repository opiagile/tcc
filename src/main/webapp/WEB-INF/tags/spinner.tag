<%@ attribute name="id" required="true" %>
<%@ attribute name="name" required="true" %>
<%@ attribute name="width" required="false" %>
<%@ attribute name="value" required="false" %>
<%@ attribute name="min" required="false" %>
<%@ attribute name="max" required="false" %>
<input type="text" id="${id}" name="${name}" style="width: ${width};" value="${value}" class="input-small" />
<script type="text/javascript">
	$("#${id}").spinner({
		numberFormat: "n",
		 culture: "br"
	});
	var min = '${min}';
	var max = '${max}';
	if(min != ''){
		$("#${id}").spinner( "option", "min", "${min}" );
	}
	if(max != ''){
		$("#${id}").spinner( "option", "max", "${max}" );
	}
</script>