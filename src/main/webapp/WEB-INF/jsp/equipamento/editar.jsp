<%@ include file="../include/taglibs.jsp" %>
<style type="text/css">
#editarEquip{
	width: 80%;
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
		salvarCadastro('<c:url value="/equipamento/salvar"/>', 'formSalvar', 'myModal');
	});
</script>

<div class="modal-dialog" id="editarEquip" style="width:750px" >
	<div class="modal-content" >
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title"><fmt:message key="equipamento.editar.titulo"/></h4>
		</div>
		<div class="modal-body"  >
			<ul class="nav nav-tabs" id="tabs">
				<li class="active"><a href="#geral" data-toggle="tab" ><fmt:message key="equipamento.tab.geral" /></a></li>
				<li><a href="#acesso" data-toggle="tab" ><fmt:message key="equipamento.tab.acesso" /></a></li>
				<li><a href="#comunicacao" data-toggle="tab" ><fmt:message key="equipamento.tab.comunicacao" /></a></li>
				<li><a href="#biometria" data-toggle="tab" ><fmt:message key="equipamento.tab.biometria" /></a></li>
				<li><a href="#perifericos" data-toggle="tab" ><fmt:message key="equipamento.tab.perifericos" /></a></li>
				<li class="hidden" ><a href="#expansao" data-toggle="tab" ><fmt:message key="equipamento.tab.expansao" /></a></li>
			</ul>
			<div>&nbsp;</div>
			<form id="formSalvar" >
				<input type="hidden" name="equipamento.id" value="${equipamento.id}"/>
				<div class="tab-content">
					<div id="geral" class="tab-pane active"><%@ include file="include/geral.jsp" %></div>
					<div id="acesso" class="tab-pane" ><%@ include file="include/acesso.jsp" %></div>
					<div id="comunicacao" class="tab-pane"><%@ include file="include/comunicacao.jsp" %></div>
					<div id="biometria" class="tab-pane"><%@ include file="include/biometria.jsp" %></div>
					<div id="perifericos" class="tab-pane"><%@ include file="include/perifericos.jsp" %></div>
					<div id="expansao" class="tab-pane hidden"><%@ include file="include/expansao.jsp" %></div>
				</div>
			</form>
			<%@ include file="../include/botaoCadastro.jsp" %>
		</div>
	</div>
</div>
