<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Senha</title>
</head>
<body>
    <h2>Criar nova senha</h2>
    <form action="metodo-editar-senha" method="post">
        <input type="password" id="novasenha" name="senha" required maxlength="20" placeholder="Nova senha">
        <button type="submit">Confirmar</button>
    </form>
    <c:if test="${usuario == null}">
		<%@ include file="../rodape/rodape.jsp"%>
	</c:if>

	<c:if test="${usuario != null}">
		<%@ include file="../rodape/rodape.jsp"%>
	</c:if>
</body>
</html>