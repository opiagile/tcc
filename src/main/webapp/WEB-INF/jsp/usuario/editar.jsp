<%@ include file="../include/taglibs.jsp" %>
<script type="text/javascript">
	var changeAlterarSenha = function(){
		if($("#alterarSenha").is(':checked')){
			$("#senhas").show();
		} else {
			$("#senhas").hide();
		}
	}
	$("#tabs a").click(function(){
		$(this).tab('show');
	});
	$('#salvar').bind('click', function(){
		salvarCadastro('<c:url value="/usuario/salvar" />', 'formSalvar', 'myModal');
	});
	$(document).ready(function(){
		if(${editar}){
			$("#senhas").hide();
		}
	});
</script>
<div class="modal-dialog" id="editar">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title"><fmt:message key="usuario.editar.titulo"/></h4>
		</div>
		<div class="modal-body">
			<ul class="nav nav-tabs" id="tabs">
				<li class="active"><a href="#dados" data-toggle="tab" ><fmt:message key="usuario.tab.dados" /></a></li>
				<li><a href="#permissao" data-toggle="tab" ><fmt:message key="usuario.tab.permissao" /></a></li>
			</ul>
			<form id="formSalvar">
				<div class="tab-content">
					<div id="dados" class="tab-pane active">
						<input type="hidden" name="usuario.id" value="${usuario.id}"/>
						<dl>
							<dt><label for="pessoa"><fmt:message key="usuario.label.pessoa"/>:</label></dt>
							<dd><tg:combo id="pessoa" name="usuario.pessoa.id" width="280px;" options="${pessoas}" optionValue="id" optionLabel="nome" selected="${usuario.pessoa.id}" primeira="Selecione..."/></dd>
						</dl>
						<dl>
							<dt><label for="login"><fmt:message key="usuario.label.login"/>:</label></dt>
							<dd><input type="text" class="form-control" id="login" name="usuario.login" value="${usuario.login}" maxlength="20" placeholder="<fmt:message key='usuario.placeHolder.login'/>" style="width:280px;"/></dd>
						</dl>
						<c:if test="${editar}">
							<input type="checkbox" id="alterarSenha" name="alterarSenha" value="${!editar}" onClick="changeAlterarSenha();">&nbsp;<fmt:message key="usuario.label.alterarSenha"/>
						</c:if>
						<div id="senhas">
							<dl>
								<dt><label for="senha"><fmt:message key="usuario.label.senha"/>:</label></dt>
								<dd><input type="password" class="form-control" id="senha" name="senha" value="" maxlength="20" placeholder="<fmt:message key='usuario.placeHolder.senha'/>" style="width:280px;"/></dd>
							</dl>
							<dl>
								<dt><label for="confirmarSenha"><fmt:message key="usuario.label.confirmarSenha"/>:</label></dt>
								<dd><input type="password" class="form-control" id="confirmarSenha" name="confirmarSenha" value="" maxlength="20" placeholder="<fmt:message key='usuario.placeHolder.senha'/>" style="width:280px;"/></dd>
							</dl>
						</div>
					</div>
					<div id="permissao" class="tab-pane">
						<fieldset>
							<legend><fmt:message key="usuario.label.permissao"/></legend>
							<table>
								<tr>
									<c:forEach var="item" items="${permissoes}" varStatus="status">
										<c:set var="checado" value=""/>
											<c:if test="${tgfn:contains(usuario.permissoes, item)}">
												<c:set var="checado" value="checked"/>
											</c:if>
										<td style="width: 200px; text-align: left;"><input type="checkbox" name="permissoes[].id" value="${item.id}" ${checado} >&nbsp;${item.descricao}</td>
										<c:if test="${status.index == 2}">
											</tr>
											<tr>
										</c:if>
									</c:forEach>
								</tr>
							</table>
						</fieldset>
					</div>
				</div>
			</form>
			<%@ include file="../include/botaoCadastro.jsp" %>
		</div>
	</div>
</div>