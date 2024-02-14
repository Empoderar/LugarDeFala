<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

				<div>
					<a href="#">PÃ¡gina inicial</a> <a href="#">Popular</a>
					<hr>
				</div>
				<div>
					<a href="#">Comunidades</a> <a href="#">ViolÃªncia fÃ­sica</a> <a
						href="#">Violência psicolÃ³gica</a> <a href="#">ViolÃªncia
						moral</a> <a href="#">ViolÃªncia sexual</a> <a href="#">ViolÃªncia
						patrimonial</a>
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
	<div>
		<footer>
			<div>
				<p>Lugar de Fala</p>
				<a href="#">Sobre nos</a> <a href="#">Pagina inicial</a>
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
