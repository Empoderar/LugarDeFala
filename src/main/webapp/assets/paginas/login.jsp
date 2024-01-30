<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html lang="pt-br">

<head>

<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Login</title>

<body>

  <form action="#">

	<div>

	  <div>

		<h1>Bem Vindo!</h1>

		<h2>Login</h2>

	  </div>

	  <div>	

		<label>Email</label>

		<input type="email" name="email" placeholder="Digite seu email" required> 

	  </div>	

	  <div>

		<label>Senha</label>

		<input type="password" name="senha" placeholder="Digite sua senha" required>

	  </div>	

	  <div>

		<label><input type="checkbox">Lembre-me</label>

	  </div>

	  <div>	

		<button type="submit">enviar</button>

	  </div>	

		<h3>Não tem uma conta?</h3>

		<a href="cadastro-usuario.jsp" target="_self">Cadastre-se</a>

	</div>

  </form>

</body>

</html>