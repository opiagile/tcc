var validarPeriodo = function(idForm, messageRequired, messageDate){
	$("#" + idForm).validate({
		rules: {
			"filtro.periodo.inicio": {
				required: true,
				dateTime: true
			},
			"filtro.periodo.fim":{
				required: true,
				dateTime: true
			}
		},
		messages: {
			"filtro.periodo.inicio": {
				required: messageRequired,
				dateTime: messageDate
			},
			"filtro.periodo.fim": {
				required: messageRequired,
				dateTime: messageDate
			}
		}
	});
}