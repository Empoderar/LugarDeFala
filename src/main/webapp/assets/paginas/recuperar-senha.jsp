<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Recuperar Senha</title>
</head>
<body>
    <div>
    	<form action="recuperar-email" method="post">
        	<h1>Recuperar senha</h1>
        		<p>Ensira o e-mail e enviaremos um link para você recuperar sua conta</p>
        		
        </form>
    </div>
    <div>
        <h2>Criar nova senha</h2>
        <form action="recuperar-senha" method="post">
            <input type="password" id="novasenha" name="senha" required maxlength="20" placeholder="Nova senha">
            <!-- <input type="password" id="cnovasenha" name="csenha" required maxlength="20" placeholder="Confirmar senha"> -->
            <button type="submit">Confirmar</button>
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
