<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Perfil Moderador</title>
</head>
<body>
	<div>
		<form action="inserir-moderador" method="post">
			<p>
				<strong>nome:</strong>
				<c:out value="${moderador.nome}" />
				<strong>nome de usuário:</strong>
				<c:out value="${moderador.apelido}" />
				<strong>descrição:</strong>
				<c:out value="${moderador.descricao}" />
				<c:forEach var="comunidade" items="${comunidades}">
				<p>
					COMUNIDADES:
					<c:out value="${comunidade.nome}" />
				</p>
				</c:forEach>
				<c:out value="${moderador.descricao}" />
				<c:forEach var="relato" items="${relatos}">
				<p>
					RELATOS :
					<c:out value="${relato.conteudo}" />
				</p>
			</c:forEach>
			</p>
		</form>
	</div>
	<div>
		<form action="perfil-moderador" method="post">
			<c:forEach var="comunidade" items="${comunidades}">
				<p>
					COMUNIDADES:
					<c:out value="${comunidade.nome}" />
				</p>
			</c:forEach>
		</form>
	</div>

	<div>
		<a href="#">Relatos</a>
	</div>
	<div>
		<a href="#">Comunidades</a>
		<p>Ingressar em mais comunidades</p>
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