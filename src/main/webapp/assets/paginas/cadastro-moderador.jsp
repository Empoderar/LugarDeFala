<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head> 
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cadastrar Mopderador</title>
<style>
</style>
</head>
<h1>Cadastro de moderador</h1>
		<div>
		    <form>
			    <label for="fnome">Nome</label>
			    <input type="text" id="fnome" name="nome" required maxlength="50">
			    <label for="sobrenome">Sobrenome</label>
			    <input type="text" id="sobrenome" name="sobrenome" required maxlength="50">
			    <label for="telefone">Telefone</label>
			    <input type="tel" id="telefone" name="telefone" pattern="[0-9]{3}-[0-9]{2}-[0-9]{3}" required>
			    <label for="user">Nome de usu�rio</label>
			    <input type="text" id="user" name="usuario" required maxlength="35">
			    <label for="email">E-mail</label>
			    <input type="email" id="email" name="email" required maxlength="40">
                <label for="nascimento">Data de Nascimento</label>
				<input type="date" id="nascimento" name="data-nascimento">
			    <label for="senha">Senha</label>
			    <input type="password" id="senha" name="senha" required maxlength="20">
			    <label for="csenha">Confirmar senha</label>
			    <input type="password" id="csenha" name="outra-senha" required maxlength="20">
			    <button type="button" disabled>Pr�ximo</button>
		    </form>
		</div>
		<div>
			<p>Enviamos um c�digo para o e-mail</p>
			<p>Reenviar c�digo em 60 segundos</p>
			<button type="button">Pr�ximo</button>
		</div>
		<div>
			<p>Cadastro conclu�do com sucesso!</p>
			<button type="button">Ok!</button>
		</div>
</body>
</html>