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
		<%@ include file="../barras-navegacao/barra-de-navegacao.jsp"%>
		<div>
			<h1>Desativar a conta</h1>
			<h3>Ao desativar sua conta ela poderá ser reativada a qualquer
			momento no futuro</h3>
			<p>A desativação da conta desabilitará seu perfil e removerá seu
			nome e foto da maior parte do conteúdo compartilhado nas comunidades.
			Ao desativar a conta ela poderá ser reativada a qualquer momento a
			partir do login com seus dados.</p>

			<h3>Mais informações</h3>
			<p>Você poderá reativar sua conta após 30 dias</p>
			<p>Para reativar sua conta basta realizar o Login com Email e Senha
			</p>

			<div class="container">
				<h2>Desativar a conta</h2>
				<form action="metodo-desativar-conta" method="post">
					<label for="apelido">Apelido:</label> 
						<input type="text" id="apelido" name="apelido" required>
					<label for="senha">Senha:</label> 
						<input type="password" id="senha" name="senha" required>
					<button type="submit">Desativar Conta</button>
				</form>
					<p>
					Não deseja desativar sua conta? <a href="home.jsp">Voltar para a
					página inicial</a>
					</p>
			</div>
			<div>
				<a href="#"> <img src="#" alt="setinha"
				style="width: 42px; height: 42px;">
				</a>
			</div>
			<div>
				<h1>Desativar a conta</h1>
				<p>Confirme sua senha para desativar a conta</p>
				<form action="confirma-senha" method="post">
					<label for="senha">Senha</label> 
						<input type="password" id="senha" name="senha" required maxlength="20">
					<button onclick="#">Esqueceu sua senha?</button>
					<button type="submit">Desativar Conta</button>
				</form>
			</div>
		</div>
		<%@include file="../rodape/rodape.jsp" %>
	</body>
</html>