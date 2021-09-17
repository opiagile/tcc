<%@ page pageEncoding="UTF-8"%>
<%@ include file="../include/taglibs.jsp" %>
<%@ include file="../include/header.jsp" %>
<%@ include file="required.jsp" %>
<script type="text/javascript">
	var equipamentos = new ListaEquipamento(); 
	<c:forEach var="equipamento" items="${equipamentos}">	
		var equipamento = new Equipamento('${equipamento.id}', '${equipamento.estado}');
		equipamentos.add(equipamento);
	</c:forEach>
	$("#tabs a").click(function(){
		$(this).tab('show');
	});
	processador['EquipamentoIncluir_Atualizar'] = function (payload) {
		var equipamento = equipamentos.get(payload[0].id)
		equipamento.atualizarIcone(payload[0].estado);
	};
	var atualizacaoPeriodica = function() {
		var url = '<c:url value="/websocket/equipamento"/>';
		processador.desativarWebSocket(url);
		processador.ativarWebSocket(url);
	}
	$(document).ready(function() {
		atualizacaoPeriodica();
		window.setInterval('atualizacaoPeriodica()', 300000);
	});
</script>
<div class="page-header">
	<c:if test="${temHelp}">
		<div class="pull-right" id="help">
			<a href="#" onclick="openPopupHelp('${urlHelp}')"><img src="<c:url value="/static/images/help.png" />" title="<fmt:message key="label.help" />" /></a>
		</div>
	</c:if>
  <button type="button" class="btn btn-danger pull-right" style="margin-right: 15px;" onClick="ajaxSemRetorno('<c:url value="/equipamento/panico" />')"><fmt:message key="index.equipamento.panico"/></button>
  <h3>${usuario.pessoa.nome}
  </h3>&nbsp;
  <c:if test="${empty ultimoAcesso}" >
  	<fmt:message key="index.label.primeiroAcesso" />
  </c:if>
  <c:if test="${not empty ultimoAcesso}" >
  	<fmt:message key="index.label.ultimoAcesso" />: <fmt:formatDate pattern="dd/MM/yyyy hh:mm:ss" value="${ultimoAcesso.dataHora}" />
  </c:if>
</div>
<ul class="nav nav-tabs" id="tabs">
	<li class="active"><a href="#equipamentos" data-toggle="tab"><fmt:message key="index.equipamentos.title" /></a></li>
	<li class="hidden"><a href="#dadosPessoais" data-toggle="tab"><fmt:message key="index.dadosPessoais.title" /></a></li>
</ul>
<div class="tab-content">
	<div id="equipamentos" class="tab-pane active well">
		<table>
			<tr>
				<c:forEach var="equipamento" items="${equipamentos}" varStatus="status">
					<td style="width: 220px;">
						<table>
							<tr>
								<td><img id="icone_${equipamento.id}" src="<c:url value="/static/images/${equipamento.estado}.png" />" /></td>
								<td>
									<fmt:message key="index.equipamento.nome" />: ${equipamento.configuracao.comunicacao.tcp.nome}<br>
									<fmt:message key="index.equipamento.ip" />: ${equipamento.configuracao.comunicacao.tcp.ip}<br>
									<button type="button" class="btn btn-success" onClick="ajaxSemRetorno('<c:url value="/equipamento/liberarAcesso/${equipamento.id}" />')"><fmt:message key="index.equipamento.liberarAcesso"/>
								</td>
							</tr>
						</table>
					</td>
					<c:if test="${status.index == 4}">
						</tr><tr>
					</c:if>
				</c:forEach>
			</tr>
		</table>
	</div>
	<div id="dadosPessoais" class="tab-pane well"><fmt:message key="index.dadosPessoais.labelTemporária" /></div>
</div>
<%@ include file="../include/footer.jsp" %>