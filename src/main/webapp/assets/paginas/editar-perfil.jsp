<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar perfil</title>
</head>
<body>
	<c:if test="${usuario == null}">
		<%@ include file="../barras-navegacao/editar-perfil.jsp"%>
	</c:if>

	<c:if test="${usuario != null}">
		<%@ include file="../barras-navegacao/editar-perfil.jsp"%>
	</c:if>
<div>
	<div>
		<p>Editar Perfil:</p>
	</div>
	<div>

		<form action="metodo-editar-perfil" method="post">
			<label for="fnome">Nome</label> 
			<input type="text" id="fnome" name="nome" required maxlength="50"> 
			<label for="lnome">Sobrenome</label>
			<input type="text" id="lnome" name="sobrenome" required maxlength="50"> 
			<label for="descricao">Biografia</label> 
			<input type="text" id="descricao" name="descricao" required maxlength="500">
			<label for="user">Nome de usuário</label> 
			<input type="text" id="apelido" name="apelido" required maxlength="50"> 
			<label for="email">E-mail</label> 
			<input type="email" id="email" name="email" required maxlength="40"> 
			<label for="telefone">Telefone</label>
			<input type="tel" id="telefone" name="telefone" pattern="[0-9]{2}[0-9]{5}[0-9]{4}" required>
			<button type="submit">Salvar</button>
		</form>
	</div>
</div>
</body>
</html>
