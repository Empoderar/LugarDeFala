<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Denunciar</title>
</head>
<body>
	<c:if test="${usuario == null}">
		<%@ include file="../barras-navegacao/home-deslogada.jsp"%>
	</c:if>

	<c:if test="${usuario != null}">
		<%@ include file="../barras-navegacao/home-logada.jsp"%>
	</c:if>
    <div>
        <h1>Denúncias de relatos</h1>
        	<a href="#">Filtrar denúncias</a>
       			<form action="julgar-denuncia-relato" method="post">
        			<button type="submit">Aprovar</button>
        			<button type="submit">Rejeitar</button>
        			<button type="submit">Arquivar</button>
        		</form>
    </div>
    <div>
    	<h1>Denúncias de usuarios</h1>
        	<form action="julgar-denuncia-usuario" method="post">
        		<button type="submit">Aprovar</button>
        		<button type="submit">Rejeitar</button>
       		 	<button type="submit">Arquivar</button>
        	</form>
    </div>
    <div>
    	<h1>Denúncias de moderadores</h1>
        	<form action="julgar-denuncia-moderador" method="post">
        		<button type="submit">Aprovar</button>
        		<button type="submit">Rejeitar</button>
        		<button type="submit">Arquivar</button>
        	</form>
    </div>
    <div>
    	<h1>Denúncias de conselhos</h1>
        	<form action="julgar-denuncia-conselho" method="post">
        		<button type="submit">Aprovar</button>
        		<button type="submit">Rejeitar</button>
        		<button type="submit">Arquivar</button>
        	</form>
    </div>
    <c:if test="${usuario == null}">
		<%@ include file="../rodape/rodape.jsp"%>
	</c:if>

	<c:if test="${usuario != null}">
		<%@ include file="../rodape/rodape.jsp"%>
	</c:if>
</body>
</html>
