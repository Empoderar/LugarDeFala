<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Conselhos</title>
<style type="text/css"><%@include file="/assets/css/style.css"%></style>
</head>	
<body>
	<%@ include file="/assets/barras-navegacao/logado.jsp"%>
	<div>
		<div>
			<nav>
				<div>
					<a href="#">Página Inicial</a> <a href="#">Popular</a>		
				</div>
				<button onclick="#">Relatar</button>
			</nav>
		</div>
		<div>
			<c:out value="${relato.conteudo}"></c:out>
			<form action="publicar-conselho" method="post">
				<button type="submit">Publicar</button>
			</form>
		</div>
		<div>
			<c:forEach var="conselho" items="${conselhos}"> 
					<c:out value="${usuario.nome} " />
					<c:out value="${Conselho.conteudo}" />
			</c:forEach>
		</div>
	</div>
    	<%@include file="/assets/rodape/rodape.jsp" %> 
</body>
</html>
