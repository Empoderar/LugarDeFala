<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html lang="pt-br">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Cadastro</title>
<style type="text/css"><%@includefile="/assets/css/style.css"%></style>
</head>

<body class="cadastro">

	<div class="container">

		<div class="form">

			<form action="/LugarDeFala/inserir-usuario" method="post">

				<div class="form-header">

					<div class="titulo">

						<h1>Cadastre-se</h1>

					</div>

					<div class="input-group-cadastro">

						<div class="input-box-cadastro">

							<label for="nome">Nome</label> <input type="text" name="nome"
								id="nome" placeholder="Digite o seu primeiro nome" required>

						</div>

						<div class="input-box-cadastro">

							<label for="sobrenome">Sobrenome</label> <input type="text"
								name="sobrenome" id="sobrenome"
								placeholder="Digite o seu sobrenome" required>

						</div>

						<div class="input-box-cadastro">

							<label for="telefone">Telefone</label> <input type="tel"
								name="telefone" id="telefone" placeholder="(xx) xxxx-xxxx"
								required>

						</div>

						<div class="input-box-cadastro">

							<label for="usuario">Nome de Usuário</label> <input type="text"
								name="apelido" id="apelido"
								placeholder="Crie o seu nome de usuário" required>

						</div>

						<div class="input-box-cadastro">

							<label for="email">E-mail</label> <input type="email"
								name="email" id="email" placeholder="Digite o seu e-mail"
								required>

						</div>

						<div class="input-box-cadastro">

							<label for="data">Data de Nascimento</label> <input type="date"
								name="data-nascimento" id="data-nascimento"
								placeholder="Digite a sua data de nascimento" required>

						</div>

						<div class="input-box-cadastro">

							<label for="senha">Senha</label> <input type="password"
								name="senha" id="senha" placeholder="Crie a sua senha" required>

						</div>

						<div class="input-box-cadastro">

							<label for="senha-confirme">Confirme a sua senha</label> <input
								type="password" name="senha" id="senha"
								placeholder="Repita a sua senha" required>

						</div>

					</div>

				</div>

				<div class="continuar-button">

					<button type="submit">Continuar</button>

				</div>

			</form>

		</div>

	</div>

</body>

</html>
