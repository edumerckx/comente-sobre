<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>


<div id="detalhe">
	<label>ID: </label><span>${comentario.id}</span><br/>		
	<label>Assunto: </label><span>${comentario.assunto}</span><br/>
	<label>E-mail: </label><span>${comentario.email}</span><br/>
	<label>Coment&aacute;rio: </label><span>${comentario.comentario}</span><br/>		
</div>

<c:import url="../footer.jsp"/>