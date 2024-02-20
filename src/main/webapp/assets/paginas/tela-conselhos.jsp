<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Conselhos</title>
<style>
</style>
</head>	
<body>
	<c:if test="${usuario == null}">
		<%@ include file="../barras-navegacao/deslogada.jsp"%>
	</c:if>

	<c:if test="${usuario != null}">
		<%@ include file="../barras-navegacao/logada.jsp"%>
	</c:if>
	<div>
		<nav>
			<div>

				<div>
					<a href="#">PÃ¡gina inicial</a> <a href="#">Popular</a>
					<hr>
				</div>
				<div>
					<a href="#">Comunidades</a> 
					<a href="#">ViolÃªncia fÃ­sica</a> 
					<a href="#">Violência psicolÃ³gica</a> 
					<a href="#">ViolÃªncia moral</a> 
					<a href="#">ViolÃªncia sexual</a> 
					<a href="#">ViolÃªncia patrimonial</a>
					<hr>
				</div>
			</div>
			<button onclick="#">Relatar</button>
		</nav>
	</div>
	<div>
		<p>Relato</p>
		<form action="publicar-conselho" method="post">
			<button type="submit">Publicar</button>
		</form>
	</div>
	<div>
		<c:forEach var="conselho" items="${conselhos}">
			<p>
				CONSELHOS:
				<c:out value="${usuario.nome} " />
				<c:out value="${Conselho.conteudo}" />
			</p>
		</c:forEach>
	</div>
		<%@include file="../rodape/rodape.jsp" %>
</body>
</html>
