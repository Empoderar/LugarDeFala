<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Desativar Conta</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
	<h1>Desativar a conta</h1>
		<h3>Ao desativar sua conta ela poderá ser reativada a qualquer momento no futuro</h3>
			<p> A desativação da conta desabilitará seu perfil e removerá seu nome e 
				foto da maior parte do conteúdo compartilhado nas comunidades. 
				Ao desativar a conta ela poderá ser reativada a qualquer momento a partir do login com seus dados.
			</p>

		<h3>Mais informações</h3>
<p>Você  poderá reativar sua conta após 30 dias</p>
<p>Para reativar sua conta basta realizar o Login com Email e Senha </p>

	<div class="container">
		<h2>Desativar a conta</h2>
		<form action="metodo-desativar-conta" method="post">
			<label for="apelido">Apelido:</label> <input type="text" id="apelido"
				name="apelido" required><br>
			<br> <label for="senha">Senha:</label> <input type="password"
				id="senha" name="senha" required><br>
			<br>

			<button type="submit">Desativar Conta</button>
		</form>
		<p>
			Não deseja desativar sua conta? <a href="home.jsp">Voltar
				para a página inicial</a>
		</p>
	</div>
	<footer>
		<div>
			<p>Lugar de Fala</p>
			<a href="#">Sobre nós</a> <a href="#">Página inicial</a>
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
</body>
</html>