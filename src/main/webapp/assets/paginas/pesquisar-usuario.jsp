<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pesquisar Usuario</title>

    <script>
        function validarFormulario() {
            var pesquisa = document.getElementById("pesquisar").value;
            if (pesquisa.trim() === "") {
                alert("Digite algo para pesquisar.");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
	<c:if test="${usuario == null}">
		<%@ include file="../barras-navegacao/home-deslogada.jsp"%>
	</c:if>

	<c:if test="${usuario != null}">
		<%@ include file="../barras-navegacao/home-logada.jsp"%>
	</c:if>
    <h1>Pesquisar Comunidades</h1>
    
    <form action="resultado-pesquisar-comunidade" method="get" onsubmit="return validarFormulario()">
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
       <c:if test="${usuario == null}">
		<%@ include file="../rodape/rodape.jsp"%>
	</c:if>

	<c:if test="${usuario != null}">
		<%@ include file="../rodape/rodape.jsp"%>
	</c:if>
</body>
</html>
