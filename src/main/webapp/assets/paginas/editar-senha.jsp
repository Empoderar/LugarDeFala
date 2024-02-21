<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Senha</title>
    <style type="text/css"><%@includefile="/assets/css/style.css"%></style>
</head>
<body>
<div>
    <h2>Criar nova senha</h2>
    <form action="/metodo-editar-senha" method="post">
        <input type="password" id="novasenha" name="senha" required maxlength="20" placeholder="Nova senha">
        <button type="submit">Confirmar</button>
    </form>
<%@include file="/assets/rodape/rodape.jsp" %>
    </div>
</body>
</html>