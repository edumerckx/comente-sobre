$(document).ready(function() {
	
	/**
	 * Envia os dados do formulário inicial (assunto)
	 * e recebe json com a url a ser redirecionada
	 */
	$('#assuntoForm').submit(function(){
		
		// verifica se o usuário digitou o assunto
		if ($('#assunto').val() == '') {
			$('#msg').html("Digite sobre o que quer comentar...");
			$('#assunto').focus();
			return false;
		}
		
		$.post(
				'/comente-sobre/',
				$('#assuntoForm').serialize(),
				function(data) {
					if (data.retorno == 'ok') {
						// alert('url ' + data.url);
						location.href='/comente-sobre/' + data.url;
					} else {
						$('#msg').html("Erro ao enviar dados! Tente novamente...");
					}
				},
				'json'
		);
		return false;
	});
	
	/**
	 * Envia os dados do comentário e redireciona
	 * para lista do mesmo assunto
	 * 
	 */
	$('#comentarioForm').submit(function(){
		// validar...
		if ($('#email').val() == '') {
			$('#msg').html("Digite seu email...");
			$('#email').focus();
			return false;			
		}
		
		if ($('#comentario').val() == '') {
			$('#msg').html("Digite o comentário...");
			$('#comentario').focus();
			return false;			
		}
		
		// enviar dados via post para /comente-sobre/novo...
	});	
});