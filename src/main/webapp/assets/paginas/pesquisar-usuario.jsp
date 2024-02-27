<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pesquisar Usuário</title>
    <style type="text/css">
        <%@include file="/assets/css/style.css"%>
    </style>
    <script src="seu-arquivo-js.js"></script>
</head>
<body>
	<%@ include file="/assets/barras-navegacao/logado.jsp"%>
    <h1>Pesquisar Usuários</h1>
    
    <form action="/LugarDeFala/resultado-pesquisar-usuario" method="post" onsubmit="return validarFormulario()">
        <input class="input-pesquisa" type="text" placeholder="Pesquisar Usuário" oninput="this.className = ''" name="pesquisar" id="pesquisar">
        <button type="submit">Pesquisar</button>
    </form>
    
     <h2 class="titulo-pesquisa-usuario"> Recomendados </h2>
        <div class="comunidades-populares">
           <div class="comunidade-card">
                <img src="img/usuarios/usuario1.svg" alt="">
                <img src="img/usuarios/usuario2.svg" alt="">
           </div>
           <div class="comunidade-card">
                <img src="img/usuarios/usuario3.svg" alt="">
                <img src="img/usuarios/usuario4.svg" alt="">
           </div>
        </div>
    
    <c:if test="${not empty usuarios}">
        <ul>
            <c:forEach var="usuario" items="${usuarios}">
                <li>
                    <a href="/LugarDeFala/perfil-usuario-externo?id=<c:out value='${usuario.id}'/>">${usuario.nome}</a>
                </li>
            </c:forEach>
        </ul>
    </c:if>
    
    <c:if test="${empty usuarios}">
        <p>Nenhuma usuario encontrado.</p>
    </c:if>
    <%@include file="/assets/rodape/rodape.jsp" %> 
</body>
</html>