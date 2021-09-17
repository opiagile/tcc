<%@ page pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jsp" %>
<fieldset>
	<fieldset>
		<legend><fmt:message key="equipamento.label.geral.exibicao"/></legend>
		<table>
			<tr>
				<td><fmt:message key="equipamento.label.geral.exibicao.mensagemDisplay"/>:</td>
				<td><fmt:message key="equipamento.label.geral.exibicao.idioma"/>:</td>
			</tr>
			<tr>
				<td><input type="text" class="input-sm" id="mensagemDisplay" name="equipamento.configuracao.geral.mensagemDisplay" value="${equipamento.configuracao.geral.mensagemDisplay}" maxlength="50" placeholder="<fmt:message key='equipamento.placeHolder.mensagemDisplay'/>" style="width:280px;"/></td>
				<td><tg:combo id="idioma" name="equipamento.configuracao.geral.idioma" width="280px;" options="${idiomas}" optionValue="id" optionLabel="descricao" selected="${equipamento.configuracao.geral.idioma}"/></td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
		<legend><fmt:message key="equipamento.label.geral.audio"/></legend>
		<table>
			<tr>
				<td><fmt:message key="equipamento.label.geral.audio.volume"/>:</td>
				<td></td>
			</tr>
			<tr>
				<td><input type="text" class="input-sm" id="volume" name="equipamento.configuracao.geral.volume" value="${equipamento.configuracao.geral.volume}" maxlength="1" placeholder="<fmt:message key='equipamento.placeHolder.volume'/>" style="width:280px;"/></td>
				<td><tl:checkbox id="beepTeclado" name="equipamento.configuracao.geral.beepTeclado" value="${equipamento.configuracao.geral.beepTeclado}" />&nbsp;<fmt:message key="equipamento.label.geral.audio.beepTeclado"/></td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
		<legend><fmt:message key="equipamento.label.geral.operacao"/></legend>
		<table>
			<tr>
				<td><fmt:message key="equipamento.label.geral.layoutTecladoUSB"/></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td><tg:combo id="layoutTeclado" name="equipamento.configuracao.geral.layoutTeclado" width="280px;" options="${layoutsTeclado}" optionValue="id" optionLabel="descricao" selected="${equipamento.configuracao.geral.layoutTeclado}"/></td>
				<td><tl:checkbox id="leitorVericaDigital" name="equipamento.configuracao.geral.leitorVericaDigital" value="${equipamento.configuracao.geral.leitorVericaDigital}" />&nbsp;<fmt:message key="equipamento.label.geral.leitorVerificaDigital"/></td>
				<td><tl:checkbox id="biometriaOnline" name="equipamento.configuracao.acesso.biometriaOnline" value="${equipamento.configuracao.acesso.biometriaOnline}" />&nbsp;<fmt:message key="equipamento.label.geral.biometriaOnline"/></td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
		<legend><fmt:message key="equipamento.label.geral.modoInteligente"/></legend>
		<table>
			<tr>
				<td><fmt:message key="equipamento.label.geral.modoAutomatico"/></td>
				<td></td>
			</tr>
			<tr>
				<td><tg:combo id="cadastroAutomatico" name="equipamento.configuracao.geral.modoCadastro" width="280px;" options="${modosAutomatico}" optionValue="id" optionLabel="descricao" selected="${equipamento.configuracao.geral.modoCadastro}"/>
				<td><tl:checkbox id="gerenciadorInteligente" name="equipamento.configuracao.geral.gerenciadorInteligente" value="${equipamento.configuracao.geral.gerenciadorInteligente}" />&nbsp;<fmt:message key="equipamento.label.geral.gerenciadorInteligente"/></td>
			</tr>
		</table>
	</fieldset>
</fieldset>