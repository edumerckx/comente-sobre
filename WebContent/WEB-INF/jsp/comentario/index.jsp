<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>


<div id="conteudo">
	<h1>Sobre o que deseja comentar?</h1>
	<form id="assuntoForm" action="" method="post">
		<input type="text" name="assunto" id="assunto" />
		<input type="submit" name="enviar" id="enviar" value="Enviar" />
		<span id="msg"></span>
	</form> 
</div>

<c:import url="../footer.jsp"/>