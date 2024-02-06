<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head></head>
<body>
	<div>
		<p>Bem-vindo!</p>
		<h1>Login</h1>
		<form>
			<label for="lemail">Email</label> <input type="text" id="lemail"
				name="login" required> <label for="lsenha">Senha</label> <input
				type="password" name="senha" id="lsenha" required maxlength="20">
			<a href="recuperar-senha.html" target="_self">Esqueceu a senha?</a><br>
			<button type="button">Confirmar</button>
		</form>
		<p>N�o tem uma conta?</p>
		<a href="cadastro-usuario" target="_self">Cadaste-se</a>
	</div>
	<div>
		<footer>
			<div>
				<p>Lugar de Fala</p>
				<a href="#">Sobre n�s</a> <a href="#">P�gina inicial</a>
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
</body>
</html>
