<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Perfil Usuário</title>
</head>
<body>
<div><button onclick="#">Editar perfil</button></div>
	<div>
		<form action="inserir-usuario" method="post">
			<p>
				<strong>Nome:</strong>
				<c:out value="${usuario.nome}" />
				<br>
				 <strong>Nome de Usuário:</strong>
				<c:out value="${usuario.apelido}" />
				<br> 
				<strong>Biografia:</strong>
				<c:out value="${usuario.descricao}" />
				<br> 
				<strong>Relatos:</strong>
				<c:forEach var="relato" items="${relatos}">
				<c:out value="${relato.conteudo}" />
				<br>
				</c:forEach>
				<br> <strong>Comunidades:</strong>
				<c:forEach var="comunidade" items="${comunidades}">
					<c:out value="${comunidade.nome}" />
					<br>
				</c:forEach>
			</p>
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
				S <a href="#">Contato</a> <a href="#">Termos de uso</a>
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