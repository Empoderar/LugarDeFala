<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Comunidade</title>
<style>
</style>
</head>
<body>
	<div>
		<header>
			<form action="#">
				<input type="text" name="pesquisa" id="pesquisa">
			</form>
		</header>
	</div>
	<div>
		<nav>
			<div>
				<a href="#">Página inicial</a> <a href="#">Popular</a>
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
			<c:forEach var="comunidade" items="${comunidades}">
				<p>
					COMUNIDADES:
					<c:out value="${comunidade.nome}" />
				</p>
			</c:forEach>
			<button onclick="#">Relatar</button>
		</nav>
	</div>
			<c:forEach var="relato" items="${relatos}">
				<p>
					RELATOS:
					<c:out value="${usuario.nome}"></c:out>
					<c:out value="${relato.conteudo}"></c:out>
				</p>
			</c:forEach>
	<div>
		<p>
			<strong>NOME:</strong>
			<c:out value="${comunidade.nome}" />
		</p>
		<p>
			<strong>DESCRIÇÃO:</strong>
			<c:out value="${comunidade.descricao}" />
		</p>
	</div>
	<div>
		<form action="perfil-comunidade" method="post">
			<c:forEach var="moderadores" items="${moderadores}">
				<p>
					MODERADORES:
					<c:out value="${moderadores.nome}" />
				</p>
			</c:forEach>
		</form>
				<form action="perfil-comunidade" method="post">
			<c:forEach var="relatos" items="${relatos}">
				<p>
					RELATOS:
					<c:out value="${relatos.conteudo}" />
					<c:out value="${relatos.data}" />
					<c:out value="${relatos.avaliacao}" />
					<c:out value="${relatos.status}" />
				</p>
			</c:forEach>
		</form>
	</div>

	<div>
		<footer>
			<div>
				<p>Lugar de Fala</p>
				<a href="#">Sobre nós</a> <a href="#">Página inicial</a>
			</div>
			<div>
				<p>Atendimento</p>
				<a href="#">Contato</a> <a href="#">Termos de uso</a>
			</div>
			<div>
				<p>Redes Sociais</p>
				<a href="#">Whatsapp</a> <a href="#">Instagram</a>
			</div>
			<div>
				<p>Lugar de Fala</p>
			</div>
			<div>
				<p>2023 Todos os direitos reservados</p>
			</div>
		</footer>
	</div>
</body>
</html>
