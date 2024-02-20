<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Excluir Comunidade</title>
	<style>
	</style>
	</head>
	<body>
		<%@ include file="../barras-navegacao/barra-de-navegacao.jsp"%>
		<div>
			<div>
				<h1>Excluir a comunidade</h1>
				<hr>
				<h2>Ao prosseguir você excluirá permanentemente esta comunidade</h2>
				<hr>
			</div>
			<div>
				<form action="metodo-deletar-comunidade" method="post">
					<p>Confirme sua senha para excluir a conta</p>
					<input type="password" name="senha" id="senha" required
					maxlength="20" placeholder="Digite a senha"> <a
					href="recuperar-senha.html">Esqueci minha senha</a>
					<button type="submit">Excluir</button>
				</form>
			</div>
			<div>
				<p>Esta comunidade foi excluída com sucesso!</p>
				<button type="submit">Ok</button>
			</div>
		</div>
	<%@include file="../rodape/rodape.jsp" %>
	</body>
</html>
