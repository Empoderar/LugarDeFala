<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Perfil Moderador</title>
<style type="text/css"><%@includefile="/assets/css/style.css"%></style>
</head>
<body>
<div>
	<div>
		<form action="/metodo-editar-perfil" method="post">
				<p>nome:</p>
				<c:out value="${moderador.nome}" />
				<p>nome de usuário:</p>
				<c:out value="${moderador.apelido}" />
				<p>descrição:</p>
				<c:out value="${moderador.descricao}" />
				<c:forEach var="comunidade" items="${comunidades}">
					COMUNIDADES:
					<c:out value="${comunidade.nome}" />

				</c:forEach>
				<c:out value="${moderador.descricao}" />
				<c:forEach var="relato" items="${relatos}">
				<p>
					RELATOS :
					<c:out value="${relato.conteudo}" />
				</p>
			</c:forEach>
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
</div>	
	 <%@include file="/assets/rodape/rodape.jsp" %> 
</body>
