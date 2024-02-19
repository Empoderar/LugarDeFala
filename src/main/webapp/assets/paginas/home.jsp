<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Home</title>
		<style>
		</style>
	</head>
	<c:if test="${usuario == null}">
		<%@ include file="../barras-navegacao/home-deslogada.jsp"%>
	</c:if>

	<c:if test="${usuario != null}">
		<%@ include file="../barras-navegacao/home-logada.jsp"%>
	</c:if>
	<body>
		<div>
			<div>
				<h1>Lugar de fala</h1>
				<h3>JUNTE-SE A NÓS COMO VOLUNTÁRIA NESTA REDE DE APOIO PRÓ-MULHER!</h3>
				<p>Somos uma rede de apoio dedicada a oferecer assistência para
				mulheres cisgêneras, transgêneras e travestis que foram vítimas de
				violência. Nosso compromisso é criar um espaço seguro onde essas
				mulheres possam encontrar conforto</p>
			</div>
			<div>
				<a href="cadastro-relato">Faça seu relato</a>
			</div>
			<div>
				<a href="perfil-comunidade">Comunidades</a>
			</div>
			<div>
				<a href="#">Seja Voluntario</a>
			</div>
			<div>
				<a href="#">Sobre Nós</a>
			</div>
			<div>
<%-- 				<c:forEach var="comunidade" items="${comunidades}"> --%>
<!-- 					USUARIOS:  -->
<%-- 			 	<c:out value="${comunidade.icone}"></c:out> --%>
<%-- 				<c:out value="${comunidade.nome}"></c:out> --%> 
<%-- 				</c:forEach> --%>
			</div>
			<div>
				<h1>VENHA FAZER PARTE</h1>
				<p>Durante a pandemia, 8 mulheres apanharam por minuto no Brasil.
					A violência psicológica, que não deixa marcas físicas, feriu também
					a dignidade de muitas. Mostre seu apoio à outras mulheres fazendo
					seu relato, pois nõo estamos sozinhas nessa luta!</p>
			</div>
			<div>
				<div>
					<p>Como me tornar um voluntário?</p>
					<p>Para se tornar um voluntário é necessário fazer o cadastro de
						voluntário, que apresenta um PDF com as informações que um
						voluntário deve saber e um breve teste sobre os conhecimentos
						adquiridos.</p>
				</div>
				<div>
					<p>Como fazer um relato?</p>
					<p>Para fazer seu relato é necessário criar uma conta, fazer
						login no site e escolher uma comunidade, então clicar no botão
						relatar e se abrir com pessoas que passam ou já passaram pelo
						mesmo.</p>
				</div>
				<div>
					<p>O que são as comunidades?</p>
					<p>As comunidades são grandes grupos, cada comunidade representa
						um tipo de violência onde você pode buscar acolhimento.</p>
				</div>
				<div>
					<p>O que é um voluntário?</p>
					<p>Voluntários são usuários comuns que moderam as comunidades e
						gerenciam possíveis problemas.</p>
				</div>
			</div>
		</div>
	<div>

		<div>
			<h1>Comunidades em destaque</h1>
		</div>
		<div>
			<c:forEach var="comunidade" items="${comunidades}">
				<c:out value="${comunidade.icone}"></c:out>
				<c:out value="${comunidade.nome}"></c:out>
			</c:forEach>
		</div>
		<div>
			<c:forEach var="relato" items="${relatos}">
				<c:out value="${relato.conteudo}"></c:out>
				<c:out value="${usuario.nome}"></c:out>
				<c:out value="${usuario.icone}"></c:out>
				<c:out value="${relato.categoria}"></c:out>
			</c:forEach>
			</div>
		</div>
	<c:if test="${usuario == null}">
		<%@ include file="../rodape/rodape.jsp"%>
	</c:if>

	<c:if test="${usuario != null}">
		<%@ include file="../rodape/rodape.jsp"%>
	</c:if>
</body>	
</html>