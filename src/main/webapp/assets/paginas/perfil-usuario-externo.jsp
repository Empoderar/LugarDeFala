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
		<%@ include file="/assets/barras-navegacao/barra-de-navegacao.jsp"%>

	<div>
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
				</c:forEach>
	</div>
	<%@include file="/assets/rodape/rodape.jsp" %> 
</body>
</html>