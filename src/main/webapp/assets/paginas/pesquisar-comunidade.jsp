<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pesquisar Comunidades</title>
</head>
<body>
	<%@ include file="../barras-navegacao/logada.jsp"%>
    <h1>Pesquisar Comunidades</h1>
    <form action="resultado-pesquisar-comunidade" method="get">
        <input type="text" placeholder="Pesquisar Comunidade" oninput="this.className = ''" name="pesquisar" id="pesquisar">
        <button type="submit">Pesquisar</button>
    </form>
    
    <c:if test="${not empty comunidades}">
        <ul>
            <c:forEach var="comunidade" items="${comunidades}">
                <li>
                    <a href="perfil-comunidade?id=${comunidade.id}">${comunidade.nome}</a>
                </li>
            </c:forEach>
        </ul>
    </c:if>
    
    <c:if test="${empty comunidades}">
        <p>Nenhuma comunidade encontrada.</p>
    </c:if>
    <%@include file="../rodape/rodape.jsp" %>
</body>
</html>
