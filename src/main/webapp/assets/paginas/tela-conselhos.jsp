<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Conselhos</title>
 <style type="text/css"><%@includefile="/assets/css/style.css"%></style>
</head>	
<body>
		<%@ include file="/assets/barras-navegacao/logado.jsp"%>
	<div>
		<nav>
			<div>

				<div>
					<a href="#">Página Inicial</a> <a href="#">Popular</a>
					<hr>
				</div>
				<div>
					<a href="#">Comunidades</a> 
					<a href="#">Violência física</a> 
					<a href="#">Violência psicológica</a> 
					<a href="#">Violência moral</a> 
					<a href="#">Violência sexual</a> 
					<a href="#">Violência patrimonial</a>
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
    	<%@include file="/assets/rodape/rodape.jsp" %> 
</body>
</html>
