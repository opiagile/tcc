<%@ page pageEncoding="UTF-8"%>
<%@ include file="../include/taglibs.jsp" %>
<script type="text/javascript">
Equipamento = function(id, estado){
	this.id = id
	this.estado = estado;
	this.icone = '<c:url value="/static/images/" />';
};
Equipamento.prototype.atualizarIcone = function(estado){
	var self = this;
	this.estado = estado;
	$("#icone_" + self.id).attr('src', self.icone + estado + '.png');
};
ListaEquipamento = function(){
	this.equipamentos = {};
};
ListaEquipamento.prototype.add = function(equipamento){
	this.equipamentos[equipamento.id] = equipamento;
};
ListaEquipamento.prototype.get = function(id){
	return this.equipamentos[id];
};
processador = new ProcessadorJson();
</script>