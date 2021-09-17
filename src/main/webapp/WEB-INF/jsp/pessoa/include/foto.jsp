<%@ page pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jsp" %>
<style type="text/css">

</style>
<script type="text/javascript">
	var video, context, localMediaStream;

	var alterarVisibilidade = function(isSnapshot){
		if(isSnapshot){
			$(".video").hide();
			$(".foto").show();
		} else {
			$(".video").show();
			$(".foto").hide();
		}
	}
	function snapshot(){
		if (localMediaStream) {
			context.drawImage(video, 0, 0, 400, 300);
			var cnv = canvas.toDataURL("image/webp");
			$('#img-photo').attr('src', cnv);
			$("#fotoFDP").val(encodeURIComponent(cnv));
			alterarVisibilidade(true);
		}
	}
	
	navigator.getMedia = getMedia();
	navigator.getMedia({ video: true, audio: false }, function(stream) {
		video.src = window.URL.createObjectURL(stream);
		localMediaStream = stream;
	}, userMediaError);
	$(document).ready(function(){
		video = document.getElementById('video');
		context = document.getElementById('canvas').getContext('2d');
	})
</script>
<div id="imagem" style="overflow: hidden;">
	<input type="hidden" id="fotoFDP" name="foto" value="${pessoa.foto}" />
	<div id="webcam">
		<video autoplay id="video" width="400" height="300" class="video"/>
		<input type="button" value="Tirar foto" id="takephoto" onClick="snapshot();" class="btn btn-primary pull-right video"/>
	</div>
	<div>
		<img src="" id="img-photo" style="display: none;" class="foto"/>
		<input type="button" value="Tirar outra foto" style="display: none;" class="btn btn-warning pull-right foto" onClick="alterarVisibilidade(false);" />
	</div>
	<canvas id="canvas" width="400" height="300" style="visibility: hidden; position:absolute; top:0;left:0; z-index: 1000;" />
</div>