<%@ include file="../include/taglibs.jsp" %>
<script type="text/javascript">
	$("#tabs a").click(function(){
		$(this).tab('show');
	});
	$('#salvar').bind('click', function(){
		salvarCadastro('<c:url value="/empresa/salvar"/>', 'formSalvar', 'myModal');
	});
</script>

<div class="modal-dialog" id="editarEmpresa" style="width:660px" >
	<div class="modal-content" >
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title"><fmt:message key="empresa.editar.titulo"/></h4>
		</div>
		<div class="modal-body"  >
			<ul class="nav nav-tabs" id="tabs">
				<li class="active"><a href="#dados" data-toggle="tab" ><fmt:message key="empresa.tab.dados" /></a></li>
				<li><a href="#endereco" data-toggle="tab" ><fmt:message key="empresa.tab.endereco" /></a></li>
			</ul>
			<div>&nbsp;</div>
			<form id="formSalvar" >
				<input type="hidden" name="empresa.id" value="${empresa.id}"/>
				<div class="tab-content">
					<div id="dados" class="tab-pane active"><%@ include file="include/dados.jsp" %></div>
					<div id="endereco" class="tab-pane"><%@ include file="include/endereco.jsp" %></div>
				</div>
			</form>
			<%@ include file="../include/botaoCadastro.jsp" %>
		</div>
	</div>
</div>