<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Virar Moderador</title>
</head>
<body>
	<c:if test="${usuario == null}">
		<%@ include file="../barras-navegacao/barra-de-navegacao.jsp"%>
	</c:if>

	<c:if test="${usuario != null}">
		<%@ include file="../barras-navegacao/barra-de-navegacao.jsp"%>
	</c:if>
<div>
	<div>
		<h1>Virar Moderador</h1>
		<p>Leia as informações no PDF para responder ao formulário</p>
		<!-- pdf para levar ao formulario de moderador  -->
		<p>Clique no icone para baixar o arquivo</p>
		 <button type="submit">Próximo</button>
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