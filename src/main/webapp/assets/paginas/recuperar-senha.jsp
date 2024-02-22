<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Recuperar Senha</title>
    <style type="text/css"><%@includefile="/assets/css/style.css"%></style>
</head>
<body>
<div>
    <div>
    	<form action="" method="post">
        	<h1>Recuperar senha</h1>
        		<p>Ensira o e-mail e enviaremos um link para você recuperar sua conta</p>
        		
        </form>
    </div>
    <div>
        <h2>Criar nova senha</h2>
        <form action="" method="post">
            <input type="password" id="novasenha" name="senha" required maxlength="20" placeholder="Nova senha">
            <input type="password" id="cnovasenha" name="senha" required maxlength="20" placeholder="Confirmar senha">
            <button type="submit">Confirmar</button>
        </form>
    </div>
</div>
    	<%@include file="/assets/rodape/rodape.jsp" %>
</body>
</html>