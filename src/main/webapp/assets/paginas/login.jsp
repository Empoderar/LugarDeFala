<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head><meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div>
	<div>
		<p>Bem-vindo!</p>
		<h1>Login</h1>
		<form action="fazer-login" method="post">
			<label for="email">Email</label> 
			<input type="text" id="email" name="email" required> 
			<label for="senha">Senha</label> 
			<input type="password" name="senha" id="senha" required maxlength="20">
			<a href="recuperar-senha.html" target="_self">Esqueceu a senha?</a>
			<button type="submit">Confirmar</button>
		</form>
		<p>Não tem uma conta?</p>
		<a href="cadastro-usuario" target="_self">Cadastre-se</a>
	</div>
	<div>
		<footer>
			<div>
				<p>Lugar de Fala</p>
				<a href="#">Sobre nós</a> <a href="#">Pagina inicial</a>
			</div>
			<div>
				<p>Atendimento</p>
				<a href="#">Contato</a> <a href="#">Termos de uso</a>
			</div>
			<div>
				<p>Redes Sociais</p>
				<a href="#">Whatsapp</a> <a href="#">Instagram</a>
			</div>
			<div>
				<p>Lugar de Fala</p>
			</div>
			<div>
				<p>2023 Todos os direitos reservados</p>
			</div>
		</footer>
	</div>
</div>
</body>
</html>
