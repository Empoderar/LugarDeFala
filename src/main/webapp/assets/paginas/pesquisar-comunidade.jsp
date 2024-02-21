<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pesquisar Comunidades</title>
    <style type="text/css"><%@includefile="/assets/css/style.css"%></style>
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
    <h1>Pesquisar Comunidades</h1>
    <form action="/LugarDeFala/resultado-pesquisar-comunidade" method="post" onsubmit="return validarFormulario()">
        <input type="text" placeholder="Pesquisar Comunidade" oninput="this.className = ''" name="pesquisar" id="pesquisar">
        <button href="/LugarDeFala/pesquisar-comunidade" type="submit">Pesquisar</button>
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
</body>
</html>
