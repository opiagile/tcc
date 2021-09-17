var abrirCadastroModal = function(url, idModal) {
	$.ajax(url) //
	.done(function(data) {
		$('#' + idModal).html(data);
		$('#' + idModal).modal('show');
	}).fail(function() {
		alert('Problemas Aconteceram!');
	});
};
var salvarCadastro = function(url, idFormulario, idModal) {
	$.ajax({
		url : url,
		method : 'POST',
		data : $('#' + idFormulario).serialize(),
		dataType : 'json'
	}).done(function(data) {
		$('#' + idModal).modal('hide');
		alert(data);
		window.location.reload();
	}).fail(function(data) {
		var response = jQuery.parseJSON(data.responseText);
		var message = "";
		for ( var i in response.errors) {
			message += " - " + response.errors[i].message + "\n";
		}
		alert(message);
	});
};
var openPopupHelp = function(url) {
	window.open(url, 'Help', 'scrollbars=1, menubar=0, resizable=1, width=800, height=500', true);
}
var ajaxSemRetorno = function(url) {
	$.ajax(url);
};
var dataHora = function(evento, objeto){
	var keypress=(window.event)?event.keyCode:evento.which;
	campo = eval (objeto);
	if (campo.value == '00/00/0000 00:00:00') {
		campo.value=""
	}
 
	caracteres = '0123456789';
	separacao1 = '/';
	separacao2 = ' ';
	separacao3 = ':';
	conjunto1 = 2;
	conjunto2 = 5;
	conjunto3 = 10;
	conjunto4 = 13;
	conjunto5 = 16;
	if ((caracteres.search(String.fromCharCode (keypress))!=-1) && campo.value.length < (19)) {
		if (campo.value.length == conjunto1 )
		campo.value = campo.value + separacao1;
		else if (campo.value.length == conjunto2)
		campo.value = campo.value + separacao1;
		else if (campo.value.length == conjunto3)
		campo.value = campo.value + separacao2;
		else if (campo.value.length == conjunto4)
		campo.value = campo.value + separacao3;
		else if (campo.value.length == conjunto5)
		campo.value = campo.value + separacao3;
	} else {
		event.returnValue = false;
	}
}
// Necessário para integrar webcam
var getMedia = function() {
	return (navigator.webkitGetUserMedia || navigator.mozGetUserMedia);
}
var userMediaError = function(){
}