<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar Categoria</title>
</head>
<body>
	<h1>Cadastrar categoria</h1>
	<form action="/inserir-categoria" method="post">
		<label for="nomeCategoria">Nome</label> <input type="text"
			id="nomeCategoria" name="nome" required>
		<button type="submit">Salvar</button>
	</form>
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