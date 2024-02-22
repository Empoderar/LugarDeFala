<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cadastro de Conselho</title>
</head>
<body>
	<div>
		<h1>Bem-vindo, ${usuarioLogado.nome}</h1>
		<c:forEach var="relato" items="${relatos}">
			<p>${relato.conteudo}</p>
		</c:forEach>
		<p>Data atual do relato: ${dataAtual}</p>
		<form action="/LugarDeFala/inserir-conselho" method="post">
			<label for="conselho">Conselho</label> <input type="text"
				id="conselho" name="conteudo" required maxlength="500">
			<button type="submit">Publicar Conselho</button>
		</form>
	</div>
</body>
</html>