<%@ page pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jsp" %>
<script type="text/javascript">

</script>
<fieldset>
	<fieldset>
		<legend><fmt:message key="pessoa.label.pessoa"/></legend>
		<table>
			<tr>
				<td><fmt:message key="pessoa.label.identificador"/>:</td>
				<td><fmt:message key="pessoa.label.nome"/>:</td>
			</tr>
			<tr>
				<td><input type="text" class="input-sm" id="identificador" name="pessoa.identificador" value="${pessoa.identificador}" maxlength="255" placeholder="<fmt:message key='pessoa.placeHolder.identificador'/>" style="width:280px;" data-required="true" data-error-message="Please enter your firstname" /></td>
				<td><input type="text" class="input-sm" id="nome" name="pessoa.nome" value="${pessoa.nome}" maxlength="500" placeholder="<fmt:message key='pessoa.placeHolder.nome'/>" style="width:280px;"/></td>
			</tr>
			<tr>
				<td colspan="2"><fmt:message key="pessoa.label.nascimento"/>:</td>
			</tr>
			<tr>
				<td><tl:datepicker name="pessoa.nascimento" id="nascimento" width="280px;" value="${pessoa.nascimentoString}"/></td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
		<legend><fmt:message key="pessoa.label.documento"/></legend>
		<table>
			<tr>
				<td><fmt:message key="pessoa.label.numeroDocumento"/>:</td>
				<td><fmt:message key="pessoa.label.orgaoExpedidor"/>:</td>
			</tr>
			<tr>
				<td><input type="text" class="input-sm" id="numeroDocumento" name="pessoa.documento.numero" value="${pessoa.documento.numero}" maxlength="50" placeholder="<fmt:message key='pessoa.placeHolder.numeroDocumento'/>" style="width:280px;" /></td>
				<td><input type="text" class="input-sm" id="orgaoEmissor" name="pessoa.documento.orgaoExpedidor" value="${pessoa.documento.orgaoExpedidor}" maxlength="50" placeholder="<fmt:message key='pessoa.placeHolder.orgaoEmissor'/>" style="width:280px;"/></td>
			</tr>
				<td><fmt:message key="pessoa.label.dataExpedicao"/>:</td>
			</tr>
			<tr>
				<td><tl:datepicker name="pessoa.documento.dataExpedicao" id="dataEmissao" width="280px;" value="${pessoa.documento.dataExpedicaoFormatada}"/></td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
		<legend><fmt:message key="pessoa.label.periodoPermanencia"/></legend>
		<table>
			<tr>
				<td><fmt:message key="pessoa.label.periodoInicial"/>:</td>
				<td><fmt:message key="pessoa.label.periodoFinal"/>:</td>
			</tr>
			<tr>
				<td><tl:datetimepicker name="pessoa.periodoPermanencia.inicio" id="periodoPermanenciaInicio" width="280px;" value="${pessoa.periodoPermanencia.inicioString}"/></td>
				<td><tl:datetimepicker name="pessoa.periodoPermanencia.fim" id="periodoPermanenciaFim" width="280px;" value="${pessoa.periodoPermanencia.fimString}"/></td>
			</tr>
		</table>
	</fieldset>
</fieldset>
