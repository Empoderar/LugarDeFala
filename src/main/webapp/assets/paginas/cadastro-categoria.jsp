<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>

		<head>

			<meta charset="UTF-8">

			<meta name="viewport" content="width=device-width, initial-scale=1.0">

			<title>Cadastrar Categoria</title>

			<style type="text/css">
				<%@includefile="/assets/css/style.css" %>
			</style>

		</head>

		<body>

			<div class="cadastro-categoria">

				<h1>Cadastrar categoria</h1>


				<form action="/LugarDeFala/inserir-categoria" method="post">

					<div class="label-nome">
						<label for="nomeCategoria">Nome</label>
					</div>

					<div>
						<input class="input-cadastro" type="text" id="nomeCategoria" name="nome" required>
					</div>

					<div>
						<button type="submit">SALVAR</button>
					</div>

				</form>

			</div>

			<%@include file="/assets/rodape/rodape.jsp" %>

		</body>

		</html>