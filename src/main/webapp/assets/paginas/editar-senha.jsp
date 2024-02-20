<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
   	 	<meta charset="UTF-8">
    	<title>Editar Senha</title>
	</head>
	<body>
		<div>
    		<h2>Criar nova senha</h2>
    		<form action="metodo-editar-senha" method="post">
        		<input type="password" id="novasenha" name="senha" required maxlength="20" placeholder="Nova senha">
        		<button type="submit">Confirmar</button>
    		</form>
   		</div> 
    	<%@include file="../rodape/rodape.jsp" %>
	</body>
</html>