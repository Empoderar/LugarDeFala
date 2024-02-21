<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pesquisar Usuario</title>
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
    <h1>Pesquisar Usuarios</h1>
    
    <form action="/LugarDeFala/resultado-pesquisar-usuario" method="post" onsubmit="return validarFormulario()">
        <input type="text" placeholder="Pesquisar Usuario" oninput="this.className = ''" name="pesquisar" id="pesquisar">
        <button href="/LugarDeFala/pesquisar-usuario" type="submit">Pesquisar</button>
    </form>
    
    <c:if test="${not empty usuarios}">
        <ul>
            <c:forEach var="usuario" items="${usuarios}">
                <li>
                    <a href="perfil-usuario?id=${usuario.id}">${usuario.nome}</a>
                </li>
            </c:forEach>
        </ul>
    </c:if>
    
    <c:if test="${empty usuarios}">
        <p>Nenhuma usuario encontrado.</p>
    </c:if>
</body>
</html>
