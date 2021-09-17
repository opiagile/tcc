function ProcessadorJson() {
}
ProcessadorJson.prototype.processar = function(message) {		
	if (message != null && message != undefined) {
		var processador = this[message.type];
		if (processador) {				
			processador(message.payload);
		} else {
			console.log('Sem processador definido para o tipo: ' + message.type);
		}
	}
}
ProcessadorJson.prototype.processarUrl = function(url) {
	var self = this;
	$.ajax({ url: url,
		contentType: 'application/json',
		type: 'POST',
		async: true,
  		data: {
			dataType: "json"
  		},
  		success: function(data, textStatus, XMLHttpRequest) {
  			self.processar(data);
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			alert('Houve um erro ao tentar atualizar as informações!');
		}
	});
}
ProcessadorJson.prototype.ativarWebSocket = function(urlWebSocket) {
	//this.desativarWebSocket(urlWebSocket);
    var request = { url : urlWebSocket, transport: 'websocket' };
    var self = this;
    request.onMessage = function (response) {	    	
        if (response.transport != 'polling' && response.state != 'connected' && response.state != 'closed') {
            if (response.status == 200) {
                var data = response.responseBody;
                if (data.length > 0) {
					var json = JSON.parse(data);
					self.processar(json);
                }
            }
        }
    };
    $.atmosphere.subscribe(request);
}
ProcessadorJson.prototype.desativarWebSocket = function(urlWebSocket) {
	$.atmosphere.unsubscribeUrl(urlWebSocket);
}