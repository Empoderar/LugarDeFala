<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<meta charset="UTF-8">
<body>
	<hl>Cadastro</hl>
		<div>
			<form action="tela-inserir-usuario" method="post">
				<label for="fnome">Nome</label>
				<input type="text" id="fnome" name="nome" required maxlength="50">
				<br>
				<label for="sobrenome">Sobrenome</label>
				<input type="text" id="sobrenome" name="sobrenome" required maxlength="50">
				<br>
				<label for="telefone">Telefone</label>
				<input type="tel" id="telefone" name="telefone" pattern="[0-9]{3}-[0-9]{2}-[0-9]{3}" required>
				<br>
				<label for="user">Nome de usuário</label>
				<input type="text" id="user" name="apelido" required maxlength="35">
				<br>
				<label for="email">E-mail</label>
				<input type="email" id="email" name="email" required maxlength="40">
				<br>
				<label for="nascimento">Data de Nascimento</label>
				<input type="date" id="nascimento" name="data-nascimento">
				<br>
				<label for="senha">Senha</label>
				<input type="password" id="senha" name="senha" required maxlength="20">
				<br>
				<label for="csenha">Confirmar senha</label>
				<input type="password" id="csenha" name="outra-senha" required maxlength="20">
				<br>
				<button type="submit">Próximo</button>
			</form>
		</div>
		<div>
			<p>Enviamos um código para o e-mail</p>
			<p>Reenviar código em 60 segundos</p>
			<button type="button">Validar</button>
		</div>
		<div>
			<p>Cadastro concluído com sucesso!</p>
			<button type="button">Ok!</button>
		</div>

</body>
</html>