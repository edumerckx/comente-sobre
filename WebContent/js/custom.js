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
						alert('url ' + data.url);
					}
				},
				'json'
		);
		return false;
	});
	
});