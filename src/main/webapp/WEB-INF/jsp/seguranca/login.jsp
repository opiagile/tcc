<%@ page pageEncoding="UTF-8"%>
<%@ include file="../include/taglibs.jsp" %>
<%@ include file="../include/header.jsp" %>
<div style="padding: 40px;">&nbsp;</div>
<div class="panel panel-default" style="width: 300px; margin: auto;" >
	<div class="panel-heading"><fmt:message key="login.label.titulo"/></div>
	<div class="panel-body">
		<form method="post" action="<c:url value="/seguranca/login" />" >
			<fieldset>			
				<dl>
					<dt><label for="login"><fmt:message key="login.label.login"/>:</label></dt>
					<dd><input type="text" class="input-sm" id="login" name="login" value="" maxlength="50" placeholder="<fmt:message key="login.placeholder.login"/>" style="width:250px;" required /></dd>
				</dl>
				<dl>
					<dt><label for="login"><fmt:message key="login.label.senha"/>:</label></dt>
					<dd><input type="password" class="input-sm" id="login" name="senha" maxlength="50" placeholder="<fmt:message key="login.placeholder.senha"/>" style="width:250px;" required /></dd>
				</dl>
				 <button type="submit" class="btn btn-primary pull-right"><fmt:message key="login.label.entrar" /></button>
			</fieldset>
		</form>
	</div>
</div>
<%@ include file="../include/footer.jsp" %>