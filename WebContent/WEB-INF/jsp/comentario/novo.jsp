<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>

<div id="conteudo">
	<form id="comentarioForm" action="" method="post">
		<h1 class="titulo">Novo coment&aacute;rio para <i>${assunto}</i></h1>
		<fieldset>			
			<label for="email">E-mail</label>
			<input type="text" name="comentario.email" id="email" />
			<label for="comentario">Coment&aacute;rio</label>
			<textarea rows="5" cols="50" name="comentario.comentario" id="comentario"></textarea>
			<input type="hidden" name="comentario.assunto" id="assunto" value="${assunto}"> 
			<input type="submit" name="enviar" id="enviar" value="Enviar" />
			<span id="msg"></span>			
		</fieldset>	
	</form>
</div>

<c:import url="../footer.jsp"/>