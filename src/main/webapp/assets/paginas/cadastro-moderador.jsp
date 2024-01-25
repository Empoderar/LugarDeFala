<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	</head>
	<body>
<h1>Cadastro de moderador</h1>
		<div>
		    <form>
			    <label for="fnome">Nome</label>
			    <input type="text" id="fnome" name="Nome" required maxlength="50">
			    <label for="sobrenome">Sobrenome</label>
			    <input type="text" id="sobrenome" name="Sobrenome" required maxlength="50">
			    <label for="telefone">Telefone</label>
			    <input type="tel" id="telefone" name="Telefone" pattern="[0-9]{3}-[0-9]{2}-[0-9]{3}" required>
			    <label for="user">Nome de usuário</label>
			    <input type="text" id="user" name="usuario" required maxlength="35">
			    <label for="email">E-mail</label>
			    <input type="email" id="email" name="Email" required maxlength="40">
                <label for="nascimento">Data de Nascimento</label>
				<input type="date" id="nascimento" name="nascimento">
			    <label for="senha">Senha</label>
			    <input type="password" id="senha" name="Senha" required maxlength="20">
			    <label for="csenha">Confirmar senha</label>
			    <input type="password" id="csenha" name="confirmação" required maxlength="20">
			    <button type="button" disabled>Próximo</button>
		    </form>
		</div>
		<div>
			<p>Enviamos um código para o e-mail</p>
			<p>Reenviar código em 60 segundos</p>
			<button type="button">Próximo</button>
		</div>
		<div>
			<p>Cadastro concluído com sucesso!</p>
			<button type="button">Ok!</button>
		</div>
</body>
</html>