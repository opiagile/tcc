<%@ page pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jsp" %>
<script type="text/javascript">
	$("#cep").on('keyup',function(){
		var value = $("#cep").val().length;
		if(value == 8){
			var url = '<c:url value="/logradouro/buscarPorCep/" />' + $("#cep").val();
			$.getJSON(url, function(json){
				var logradouro = json.logradouro;
				$("#logradouro_id").val(logradouro.id);
				$("#logradouro").val(logradouro.nome);
				$("#bairro").val(logradouro.bairro.nome);
				$("#cidade").val(logradouro.bairro.cidade.nome);
				$("#uf").val(logradouro.bairro.cidade.uf.id);
			});
		}
	});
</script>
<fieldset>
	<fieldset>
		<input type="hidden" id="logradouro_id" name="pessoa.endereco.logradouro.id" value="${pessoa.endereco.logradouro.id}" />
		<legend><fmt:message key="pessoa.label.endereco"/></legend>
		<table>
			<tr>
				<td colspan="3"><fmt:message key="pessoa.label.endereco.cep"/></td>
			</tr>
			<tr>
				<td colspan="3"><input type="text" class="input-sm" id="cep" name="cep" value="" maxlength="8" placeholder="<fmt:message key='pessoa.placeHolder.cep'/>" style="width:250px;"/></td>
			</tr>
			<tr>
				<td><fmt:message key="pessoa.label.endereco.logradouro"/></td>
				<td><fmt:message key="pessoa.label.endereco.numero"/></td>
				<td><fmt:message key="pessoa.label.endereco.complemento"/></td>
			</tr>
			<tr>
				<td><input type="text" class="input-sm" id="logradouro" name="pessoa.endereco.logradouro.nome" value="${pessoa.endereco.logradouro.nome}" maxlength="500" placeholder="<fmt:message key='pessoa.placeHolder.logradouro'/>" style="width:250px;"/></td>
				<td><input type="text" class="input-sm" id="numeroLogradouro" name="pessoa.endereco.numero" value="${pessoa.endereco.numero}" maxlength="7" placeholder="<fmt:message key='pessoa.placeHolder.numeroLogradouro'/>" style="width:100px;"/></td>
				<td><input type="text" class="input-sm" id="complementoLogradouro" name="pessoa.endereco.complemento" value="${pessoa.endereco.complemento}" maxlength="25" placeholder="<fmt:message key='pessoa.placeHolder.complemento'/>" style="width:100px;"/></td>				
			</tr>
			<tr>
				<td><fmt:message key="pessoa.label.endereco.bairro"/></td>
				<td><fmt:message key="pessoa.label.endereco.cidade"/></td>
				<td><fmt:message key="pessoa.label.endereco.estado"/></td>
			</tr>
			<tr>
				<td><input type="text" class="input-sm" id="bairro" name="pessoa.endereco.logradouro.bairro.nome" value="${pessoa.endereco.logradouro.bairro.nome}" maxlength="500" placeholder="<fmt:message key='pessoa.placeHolder.bairro'/>" style="width:250px;"/></td>
				<td><input type="text" class="input-sm" id="cidade" name="pessoa.endereco.logradouro.bairro.cidade.nome" value="${pessoa.endereco.logradouro.bairro.cidade.nome}" maxlength="7" placeholder="<fmt:message key='pessoa.placeHolder.cidade'/>" style="width:100px;"/></td>
				<td><tg:combo id="uf" name="pessoa.endereco.logradouro.bairro.cidade.estado.id" width="100px;" options="${ufs}" optionValue="id" optionLabel="sigla" selected="${pessoa.endereco.logradouro.bairro.cidade.uf.id}"/></td>
			</tr>
		</table>
	</fieldset>
</fieldset>