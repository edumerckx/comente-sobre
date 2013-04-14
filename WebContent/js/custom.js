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
		$.post(
			'/comente-sobre/adiciona',
			$('#comentarioForm').serialize(),
			function(data) {
				if (data.retorno == 'ok') {
					location.href='/comente-sobre/comentarios/';
				}
			},
			'json'
		);
		return false;
	});
	
	
	/**
	 * Estilo para listagem de comentários
	 * Tabela 'zebrada'
	 * 
	 */
	$('table#comentarios tbody tr:odd').addClass('lista_zebrada');
});

/**
 * Excluir o comentário informado
 * 
 * @param id
 */
function excluir(id) {
	
	if (id > 0) {
		$.post(
			'/comente-sobre/exclui',
			{'id':id},
			function(data) {
				if (data.retorno == 'ok') {
					$('#linha_' + id).remove();
				} else {
					$('#msg').html('Erro ao excluir comentário');
				}
			}, 
			'json'
			
		);
		return false;
	}
}