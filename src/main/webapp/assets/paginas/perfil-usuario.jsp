<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Perfil Usuário</title>
<style type="text/css"><%@includefile="/assets/css/style.css"%></style>
</head>
<body>
	<c:if test="${usuario == null}">
		<%@ include file="/assets/barras-navegacao/barra-de-navegacao.jsp"%>
	</c:if>

	<c:if test="${usuario != null}">
		<%@ include file="/assets/barras-navegacao/barra-de-navegacao.jsp"%>
	</c:if>
<div><button onclick="#">Editar perfil</button></div>
	<div>
		<form action="/metodo-editar-perfil" method="post">
				<p>Nome:</p>
				<c:out value="${usuario.nome}" />
				<p>Nome de usuário</p>
				<c:out value="${usuario.apelido}" /> 
				<p>Biografia:</p>
				<c:out value="${usuario.descricao}" /> 
				<p>Comunidades:</p>
				<c:forEach var="comunidade" items="${comunidades}">
				<c:out value="${comunidade.nome}" />
				</c:forEach>
				<p>Relatos:</p>
				<c:forEach var="relato" items="${relatos}">
				<c:out value="${usuario.icone}"/>
				<c:out value="${usuario.nome} "/>
				<c:out value="${relato.conteudo}" />
				</c:forEach>
		</form>
	</div>
	<%@include file="/assets/rodape/rodape.jsp" %> 
</body>
</html>