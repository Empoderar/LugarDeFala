<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<title>Comunidades</title>
		<style>
		</style>
	</head>
	<body>
	<c:if test="${usuario == null}">
		<%@ include file="/assets/barras-navegacao/usuario-deslogado.jsp"%>
	</c:if>

	<c:if test="${usuario != null}">
		<%@ include file="/assets/barras-navegacao/usuario-logado.jsp"%>
	</c:if>
	<div>
		<div>
			<div>
				<hr>
				<a href="#">Página inicial</a> 
				<a href="#">Popular</a>
			</div>
			<div>
				<a href="#">Comunidades</a> <a href="#">Violência física</a> <a
					href="#">Violência psicológica</a> <a href="#">Violência moral</a>
				<a href="#">Violência sexual</a> <a href="#">Violência
					patrimonial</a>
			</div>
			<c:forEach var="comunidade" items="${comunidades}">
				<p>
					COMUNIDADES:
					<c:out value="${comunidade.nome}" />
				</p>
			</c:forEach>
			<button onclick="#">Relatar</button>
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
			<p>NOME:</p>
			<c:out value="${comunidade.nome}" />
			<p>DESCRIÇÃO:</p>
			<c:out value="${comunidade.descricao}" />
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
	</div>

	<!-- Comunidade violência física logada-->


	<div>
		<hr>
		<div>
			<nav>
				<div>
					<a href="home">Página inicial</a> <a href="#">Popular</a>
				</div>
				<div>
					<p>Violência física</p>
					<a href="perfil-comunidade">Sair da comunidade</a>
					<!-- adicionar um contador de membros relato e moderadores -->
				</div>
				<div>
					<a href="#">Comunidades</a> <a href="#">Violência física</a>
					<!--tem que mudar a cor-->
					<a href="#">Violência psicológica</a> <a href="#">Violência
						moral</a> <a href="#">Violência sexual</a> <a href="#">Violência
						patrimonial</a>
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
			<p>NOME:</p>
			<c:out value="${comunidade.nome}" />
			<p>DESCRIÇÃO:</p>
			<c:out value="${comunidade.descricao}" />
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
	</div>
	<!-- Comunidade violência psicológica logada-->

	<div>
		<hr>
		<div>
			<nav>
				<div>
					<a href="home">Página inicial</a> <a href="#">Popular</a>
				</div>
				<div>
					<p>Violência psicológica</p>
					<a href="perfil-comunidade">Sair da comunidade</a>
					<!-- adicionar um contador de membros relato e moderadores -->
				</div>
				<div>
					<a href="#">Comunidades</a> <a href="#">Violência física</a> <a
						href="#">Violência psicológica</a>
					<!--tem que mudar a cor-->
					<a href="#">Violência moral</a> <a href="#">Violência sexual</a> <a
						href="#">Violência patrimonial</a>
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
			<p>NOME:</p>
			<c:out value="${comunidade.nome}" />
			<p>DESCRIÇÃO:</p>
			<c:out value="${comunidade.descricao}" />
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
	</div>

	<!-- Comunidade violência moral logada -->

	<div>
		<hr>
		<div>
			<nav>
				<div>
					<a href="home">Página inicial</a> <a href="#">Popular</a>
				</div>
				<div>
					<p>Violência moral</p>
					<a href="perfil-comunidade">Sair da comunidade</a>
					<!-- adicionar um contador de membros relato e moderadores -->
				</div>
				<div>
					<a href="#">Comunidades</a> <a href="#">Violência física</a> <a
						href="#">Violência psicológica</a> <a href="#">Violência moral</a>
					<!--tem que mudar a cor-->
					<a href="#">Violência sexual</a> <a href="#">Violência
						patrimonial</a>
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
			<p>NOME:</p>
			<c:out value="${comunidade.nome}" />
			<p>DESCRIÇÃO:</p>
			<c:out value="${comunidade.descricao}" />
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
	</div>

	<!-- Comunidade violência sexual logada -->

	<div>
		<hr>
		<div>
			<nav>
				<div>
					<a href="home">Página inicial</a> <a href="#">Popular</a>
				</div>
				<div>
					<p>Violência sexual</p>
					<a href="perfil-comunidade">Sair da comunidade</a>
					<!-- adicionar um contador de membros relato e moderadores -->
				</div>
				<div>
					<a href="#">Comunidades</a> <a href="#">Violência física</a> <a
						href="#">Violência psicológica</a> <a href="#">Violência moral</a>
					<a href="#">Violência sexual</a>
					<!--tem que mudar a cor-->
					<a href="#">Violência patrimonial</a>
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
			<p>NOME:</p>
			<c:out value="${comunidade.nome}" />
			<p>DESCRIÇÃO:</p>
			<c:out value="${comunidade.descricao}" />
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
	</div>


	<!-- Comunidade violência patrimonial logada -->

	<div>
		<hr>
		<div>
			<nav>
				<div>
					<a href="home">Página inicial</a> <a href="#">Popular</a>
				</div>
				<div>
					<p>Violência patrimonial</p>
					<a href="perfil-comunidade">Sair da comunidade</a>
					<!-- adicionar um contador de membros relato e moderadores -->
				</div>

				<div>
					<a href="#">Comunidades</a> <a href="#">Violência física</a> <a
						href="#">Violência psicológica</a> <a href="#">Violência moral</a>
					<a href="#">Violência sexual</a> <a href="#">Violência
						patrimonial</a>
					<!--tem que mudar a cor-->
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
			<p>NOME:</p>
			<c:out value="${comunidade.nome}" />
			<p>DESCRIÇÃO:</p>
			<c:out value="${comunidade.descricao}" />
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
	</div>
	<%@include file="../rodape/rodape.jsp" %>
</body>
</html>
