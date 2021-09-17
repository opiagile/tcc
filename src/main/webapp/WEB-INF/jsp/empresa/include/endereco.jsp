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
		<input type="hidden" id="logradouro_id" name="empresa.endereco.logradouro.id" value="${empresa.endereco.logradouro.id}" />
		<legend><fmt:message key="empresa.label.endereco"/></legend>
		<table>
			<tr>
				<td colspan="3"><fmt:message key="empresa.label.cep"/></td>
			</tr>
			<tr>
				<td colspan="3"><input type="text" class="input-sm" id="cep" name="empresa.endereco.cep" value="${empresa.endereco.logradouro.cep}" maxlength="8" placeholder="<fmt:message key='empresa.placeHolder.cep'/>" style="width:250px;"/></td>
			</tr>
			<tr>
				<td><fmt:message key="empresa.label.logradouro"/></td>
				<td><fmt:message key="empresa.label.numero"/></td>
				<td><fmt:message key="empresa.label.complemento"/></td>
			</tr>
			<tr>
				<td><input type="text" class="input-sm" id="logradouro" name="empresa.endereco.logradouro.nome" value="${empresa.endereco.logradouro.nome}" maxlength="500" placeholder="<fmt:message key='empresa.placeHolder.logradouro'/>" style="width:250px;"/></td>
				<td><input type="text" class="input-sm" id="numeroLogradouro" name="empresa.endereco.numero" value="${empresa.endereco.numero}" maxlength="7" placeholder="<fmt:message key='empresa.placeHolder.numeroLogradouro'/>" style="width:100px;"/></td>
				<td><input type="text" class="input-sm" id="complementoLogradouro" name="empresa.endereco.complemento" value="${empresa.endereco.complemento}" maxlength="25" placeholder="<fmt:message key='empresa.placeHolder.complemento'/>" style="width:100px;"/></td>				
			</tr>
			<tr>
				<td><fmt:message key="empresa.label.bairro"/></td>
				<td><fmt:message key="empresa.label.cidade"/></td>
				<td><fmt:message key="empresa.label.estado"/></td>
			</tr>
			<tr>
				<td><input type="text" class="input-sm" id="bairro" name="empresa.endereco.logradouro.bairro.nome" value="${empresa.endereco.logradouro.bairro.nome}" maxlength="500" placeholder="<fmt:message key='empresa.placeHolder.bairro'/>" style="width:250px;"/></td>
				<td><input type="text" class="input-sm" id="cidade" name="empresa.endereco.logradouro.bairro.cidade.nome" value="${empresa.endereco.logradouro.bairro.cidade.nome}" maxlength="7" placeholder="<fmt:message key='empresa.placeHolder.cidade'/>" style="width:100px;"/></td>
				<td><tg:combo id="uf" name="empresa.endereco.logradouro.bairro.cidade.estado.id" width="100px;" options="${ufs}" optionValue="id" optionLabel="sigla" selected="${empresa.endereco.logradouro.bairro.cidade.uf.id}"/></td>
			</tr>
		</table>
	</fieldset>
</fieldset>