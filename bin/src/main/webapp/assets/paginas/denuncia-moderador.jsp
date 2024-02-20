<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Denunciar Moderador</title>
</head>
<body>
<div>
	<div>
		<h1>Denunciar Moderador</h1>
		<form action="inserir-denuncia-de-moderador" method="post">
			<input type="submit" value="Abuso "> 
			<input type="submit" value="Violação das diretrizes"> 
			<input type="submit" value="Discurso de ódio">
		</form>
	</div>
	<hr>
	<div>
		<h2>Denunciar</h2>
		<form action="inserir-denuncia-de-moderador" method="post">
			<label for="motivo">Justifique sua denuncia</label> 
			<input type="text" id="motivo" name="motivo" required maxlength="500">
			<p>Usuário Denunciante:</p>
			<c:out value="${usuario.nome}" />
			<p>Moderador Denunciado:</p>
			<c:out value="${moderador.nome}" />
			<p>Data atual da Denúncia: ${dataAtual}</p>
			<p>Status da Denúncia:</p>
			<c:out value="${status}" />
			<input type="submit" value="Salvar">
		</form>
	</div>
</div>
</body>
</html>