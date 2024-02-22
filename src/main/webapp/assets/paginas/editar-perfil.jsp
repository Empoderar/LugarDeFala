<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar perfil</title>
<style type="text/css"><%@includefile="/assets/css/style.css"%></style>
</head>
<body>
<div>
	<div>
		<p>Editar Perfil:</p>
	</div>
	<div>

		<form action="/LugarDeFala/metodo-editar-perfil" method="post">
		
			<label for="fnome">Nome</label> 
			<input type="text" id="fnome" name="nome" required maxlength="50" value="${usuarioLogado.nome}"> 
			<label for="lnome">Sobrenome</label>
			<input type="text" id="lnome" name="sobrenome" required maxlength="50" value="${usuarioLogado.sobrenome}"> 
			<label for="descricao">Biografia</label> 
			<input type="text" id="descricao" name="descricao" required maxlength="500"  value="${usuarioLogado.descricao}">
			<label for="user">Nome de usuário</label> 
			<input type="text" id="apelido" name="apelido" required maxlength="50" value="${usuarioLogado.apelido}"> 
			<label for="email">E-mail</label> 
    		<input type="email" id="email" name="email" required maxlength="40" value="${usuarioLogado.contato.email}"> 
			<label for="telefone">Telefone</label>
			<input type="tel" id="telefone" name="telefone" pattern="[0-9]{2}[0-9]{5}[0-9]{4}" value="${usuarioLogado.contato.telefone}"> 
			<button type="submit">Salvar</button>
		</form>
	</div>
</div>
</body>
</html>
