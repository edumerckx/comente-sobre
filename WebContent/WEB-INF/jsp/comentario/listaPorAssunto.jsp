<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:import url="../header.jsp"/>

<div id="conteudo">
	<h1>Coment&aacute;rios para <i>${assunto}</i></h1><br/>
		
	<span id="msg"></span>
	<table id="comentarios">
		<thead>
			<tr>
				<th>E-mail</th>
				<th>Coment&aacute;rio</th>
				<th>A&ccedil;&atilde;o</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${comentarioList}" var="c">
			<tr id="linha_${c.id}">
				<td width="25%">${c.email}</td>
				<td width="65%">${fn:substring(c.comentario, 0, 40)}...</td>
				<td width="10%"><input type="button" name="excluir " id="excluir${c.id}" class="excluir" value="Excluir" onclick="excluir(${c.id})"/>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>

<c:import url="../footer.jsp"/>