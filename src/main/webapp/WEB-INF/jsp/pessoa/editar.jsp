<%@ include file="../include/taglibs.jsp" %>
<style type="text/css">
#editarPessoa{
	overflow: auto;
}
#formSalvar{
	height: 400px;
	overflow: auto;
}
table td {
	padding: 8px;
}
</style>
<script type="text/javascript">
	$("#tabs a").click(function(){
		$(this).tab('show');
	});
	$('#salvar').bind('click', function(){
		salvarCadastro('<c:url value="/pessoa/salvar"/>', 'formSalvar', 'myModal');
	});
</script>

<div class="modal-dialog" id="editarPessoa" style="width:750px" >
	<div class="modal-content" >
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title"><fmt:message key="pessoa.editar.titulo"/></h4>
		</div>
		<div class="modal-body"  >
			<ul class="nav nav-tabs" id="tabs">
				<li class="active"><a href="#dados" data-toggle="tab" ><fmt:message key="pessoa.tab.dados" /></a></li>
				<li><a href="#contato" data-toggle="tab" ><fmt:message key="pessoa.tab.contato" /></a></li>
				<li><a href="#endereco" data-toggle="tab" ><fmt:message key="pessoa.tab.endereco" /></a></li>
				<li><a href="#empresa" data-toggle="tab" ><fmt:message key="pessoa.tab.empresa" /></a></li>
				<li><a href="#equipamento" data-toggle="tab" ><fmt:message key="pessoa.tab.equipamento" /></a></li>
			    <li><a href="#foto" data-toggle="tab" ><fmt:message key="pessoa.tab.foto" /></a></li>
			</ul>
			<div>&nbsp;</div>
			<form id="formSalvar" enctype="multipart/form-data" >
				<input type="hidden" name="pessoa.id" value="${pessoa.id}"/>
				<div class="tab-content">
					<div id="dados" class="tab-pane active"><%@ include file="include/dados.jsp" %></div>
					<div id="contato" class="tab-pane" ><%@ include file="include/contato.jsp" %></div>
					<div id="endereco" class="tab-pane"><%@ include file="include/endereco.jsp" %></div>
					<div id="empresa" class="tab-pane"><%@ include file="include/empresa.jsp" %></div>
					<div id="equipamento" class="tab-pane"><%@ include file="include/equipamento.jsp" %></div>
				    <div id="foto" class="tab-pane"><%@ include file="include/foto.jsp" %></div>
				</div>
			</form>
			<%@ include file="../include/botaoCadastro.jsp" %>
		</div>
	</div>
</div>
