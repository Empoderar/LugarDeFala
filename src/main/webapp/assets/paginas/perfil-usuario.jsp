<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Perfil Usuário</title>
    <style type="text/css">
        <%@include file="/assets/css/style.css"%>
    </style>
</head>
<body>

<%@ include file="/assets/barras-navegacao/barra-de-navegacao.jsp"%>

<div class="secao-editar-perfil">
    <a href="<%=request.getContextPath()%>/editar-perfil">Editar perfil</a>
    <button onclick="/editar-perfil"></button>
</div>

<div class="secao-nome">
    <p>Nome:</p>
    <c:out value="${usuarioLogado.nome}" />
</div>

<div class="secao-apelido">
    <p>Nome de usário:</p>
    <c:out value="${usuarioLogado.apelido}" />
</div>

<div class="secao-biografia">
    <p>Biografia:</p>
    <c:out value="${usuarioLogado.descricao}" />
</div>

<div class="secao-comunidades">
    <p>Comunidades:</p>
    <c:forEach var="comunidade" items="${comunidades}">
        <c:out value="${comunidade.nome}" />
    </c:forEach>
</div>

<div class="secao-relatos">
    <p>Relatos:</p>
    <c:forEach var="relato" items="${relatos}">
        <!-- Adicione o conteúdo do relato aqui -->
    </c:forEach>
</div>

<%@include file="/assets/rodape/rodape.jsp" %>

</body>
</html>
