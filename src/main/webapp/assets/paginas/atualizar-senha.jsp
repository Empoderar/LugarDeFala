<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualizar Senha</title>
</head>
<body>
	<div>
		<a href="#"> <img src="#" alt="casinha"
			style="width: 42px; height: 42px;">
		</a>
		<h1>Alterar senha</h1>
		<form action="atualizar-senha" method="post">
			<input type="password" id="senhaatual" name="senha" required
				maxlength="20" placeholder="Senha atual"> <input
				type="password" id="novasenha" name="senhanova" required
				maxlength="20" placeholder="Nova senha"> <input
				type="password" id="confirmarsenha" name="senhaconfirmada" required
				maxlength="20" placeholder="Confirmar senha">
			<!-- <input type="password" id="novasenha" name="senha" required maxlength="20" placeholder="Confirmar senha"> -->
			<button type="submit">Confirmar</button>
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