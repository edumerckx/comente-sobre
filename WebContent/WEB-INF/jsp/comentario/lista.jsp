<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>

<div id="conteudo">	
	<span id="msg"></span>
	<table id="comentarios">
		<thead>
			<tr>
				<th>Assunto</th>
				<th>E-mail</th>
				<th>Coment&aacute;rio</th>
				<th>A&ccedil;&atilde;o</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${comentarioList}" var="c">
			<tr id="linha_${c.id}">
				<td>${c.assunto}</td>
				<td>${c.email}</td>
				<td>${c.comentario}</td>
				<td><input type="button" name="excluir " id="excluir${c.id}" class="excluir" value="Excluir" onclick="excluir(${c.id})" />
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>

<c:import url="../footer.jsp"/>