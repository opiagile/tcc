<%@ page pageEncoding="UTF-8"%>
<%@ include file="taglibs.jsp" %>
<style type="text/css">
#tempoPanico {
	background:#fff;
	width:200px;
	height:100px;
	line-height:100px;
	font-size:50px;
	border:none;
}
</style>
<script type="text/javascript">
var panico = null;
Panico = function(estado, tempo, ativo){
	this.estado = estado;
	this.tempo = tempo;
	this.ativo = ativo;
	$("#tempoPanico").val(this.tempo);
};
Panico.prototype.alterarEstado = function(payload){
	console.log(payload.ativo);
	if(payload.ativo){
		$('#telaPanico').modal('show');
	} else {
		$('#telaPanico').modal('hide');
	}
	this.estado = payload.estado;
	this.tempo = payload.tempo;
	this.ativo = payload.ativo;
	$("#tempoPanico").val(payload.tempo);
};
panico = new Panico("${panico.estado}", "${panico.tempo}", ${panico.ativo});
processadorPanico = new ProcessadorJson();
processadorPanico['PanicoIncluir_Atualizar'] = function (payload) {
	panico.alterarEstado(payload);
};
var atualizacaoPeriodicaPanico = function() {
	var url = '<c:url value="/websocket/panico"/>';
	processadorPanico.desativarWebSocket(url);
	processadorPanico.ativarWebSocket(url);
}
var togglePanicoModal = function(ativo){
	$('#telaPanico').modal({ show: ativo });
}
$(document).ready(function() {
	atualizacaoPeriodicaPanico();
	window.setInterval('atualizacaoPeriodicaPanico()', 300000);
	togglePanicoModal(panico.ativo);
});
</script>
<div class="modal" id="telaPanico" data-backdrop="static">
	<div class="modal-dialog" style="width:40%" >
		<div class="modal-content" >
			<div class="modal-header" style="text-align: center">
				<h4 class="modal-title"><fmt:message key="panico.modal.titulo"/></h4>
			</div>
			<div class="modal-body" style="text-align: center">
				<img src="<c:url value="/static/images/panico.png" />" />
				<input type="text" id="tempoPanico" value="" disabled />
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-warning" data-dismiss="modal" onClick="ajaxSemRetorno('<c:url value="/equipamento/panico/cancelar" />');"><fmt:message key="label.button.cancelarPanico"/>
			</div>
		</div>
	</div>
</div>