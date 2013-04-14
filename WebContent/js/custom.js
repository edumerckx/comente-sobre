$(document).ready(function() {

	/**
	 * Envia os dados do formulário inicial (assunto) e recebe
	 * json com a url a ser redirecionada
	 */
	$('#assuntoForm').submit(function() {

		// verifica se o usuário digitou o
		// assunto
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
					location.href = '/comente-sobre/' + data.url;
				} else {
					$('#msg').html("Erro ao enviar dados! Tente novamente...");
				}
			},
			'json'
		);
		return false;
	});

	/**
	 * Envia os dados do comentário e redireciona para lista do
	 * mesmo assunto
	 * 
	 */
	$('#comentarioForm').submit(function() {
		// validar...
		if (!validateEmail($('#email').val())) {
			$('#msg').html("Digite um email válido...");
			$('#email').focus();
			return false;
		}

		if ($('#comentario').val() == '') {
			$('#msg').html("Digite o comentário...");
			$('#comentario').focus();
			return false;
		}

		$.post(
			'/comente-sobre/adiciona',
			$('#comentarioForm').serialize(),
			function(data) {
				if (data.retorno == 'ok') {
					location.href = '/comente-sobre/comentarios/' + $('#assunto').val();
				}
			},
			'json'
		);
		return false;
	});

	/**
	 * Estilo para listagem de comentários Tabela 'zebrada'
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
		$.post('/comente-sobre/exclui', {
			'id' : id
		}, function(data) {
			if (data.retorno == 'ok') {
				$('#linha_' + id).remove();
			} else {
				$('#msg').html('Erro ao excluir comentário');
			}
		}, 'json'

		);
		return false;
	}
}

/**
 * Exibe os dados do comentário informado
 * Redireciona para url do comentário
 * 
 * @param id
 */
function exibeComentario(id) {
	location.href='/comente-sobre/comentario/' + id;
}

/**
 * Valida email
 * 
 * @param email
 * @returns {Boolean}
 * @see http://thejimgaudet.com/articles/support/web/jquery-e-mail-validation-without-a-plugin/
 */
function validateEmail(email) {
	var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
	if (!emailReg.test(email)) {
		return false;
	} else {
		return true;
	}
}