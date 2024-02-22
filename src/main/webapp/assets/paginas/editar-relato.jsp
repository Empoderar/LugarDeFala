<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Atualizar Relato</title>
    <style type="text/css"><%@includefile="/assets/css/style.css"%></style>
</head>
<body>
<div>
    <h1>Atualizar relato</h1>
    <form action="/atualizar-relato" method="post">
    <c:out value="${relato.conteudo}"/>
        <input type="text" value="${conteudo}" id="conteudo" name="conteudo">
        <button type="submit">Publicar</button>
    </form>
    </div>
</body>
</html>