<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulário de Cadastro</title>
  <style type="text/css"><%@includefile="/assets/css/style.css"%></style>
</head>

<body>
<div>
    <h1>Virar Moderador</h1>
    <div>
    	<form action="/form-moderador" method="post">
        <p>Leia as informações no PDF para responder ao formulário</p>
        <a href="#" target="_self">Link para o PDF</a>
        <button type="submit">Próximo</button>
        </form>
    </div>
    <div>
        <p>Responda o formulário com base nas informações fornecidas no PDF</p>
        <a href="#" target="_self">Link para o formulário</a>
    </div>    
</div>
<%@include file="/assets/rodape/rodape.jsp" %>
</body>
</html>