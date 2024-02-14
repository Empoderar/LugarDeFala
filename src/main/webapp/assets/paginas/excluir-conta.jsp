<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Excluir Conta</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
	<div>
	<a href="#"> <img src="#" alt="setinha"
			style="width: 42px; height: 42px;">
		</a>
		</div>
	<h1>Excluir a conta</h1>
	<h3>Ao prosseguir você excluirá permanentemente sua conta</h3>
	<p>Ao excluir sua conta você não poderá ativar ou usar ela no
		futuro, depois de excluir sua conta Lugar de Fala, não será mais
		possível ver relatos e conselhos, acessar comunidades ou postar
		relatos. Se ainda deseja excluir sua conta clique no botão “excluir”
		no canto inferior direito da página.</p>

	<h3>Ao prosseguir você excluirá pernamentemente sua conta</h3>
	<p>Você pode arquivar sua conta Lugar de Fala ao invés de excluí-la
		permanentemente , para arquivar sua conta vá em “Arquivar Conta”.</p>
	<p>Você não poderá recuperar sua conta depois de excluí-la</p>

	<div class="container">
		<h2>Excluir a conta</h2>
			<form action="excluir-conta" method="post">
				<label for="apelido">Apelido:</label> <input type="text" id="apelido"
				name="apelido" required><label
				for="senha">Senha:</label> <input type="password" id="senha"
				name="senha" required>

				<button type="submit">Excluir Conta</button>
			</form>
	
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
		<div>
			
	<a href="#"> <img src="#" alt="setinha"
			style="width: 42px; height: 42px;">
		</a>
	</div>
	<div>
	<h1>Excluir a conta</h1>
	
	<p>Confirme sua senha para excluir a conta </p>
	<form action="confirma-senha" method="post">
            <label for="senha">Senha</label>
            <input type="password" id="senha" name="senha" required maxlength="20">
            <button onclick="#">Esqueceu sua senha?</button>
            <button type="submit">Excluir Conta</button>
            </form>
	</div>
	<div>
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
	</div>
</body>
</html>