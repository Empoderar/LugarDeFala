<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar Relato</title>
</head>
<body>
	<h1>Cadastrar relato</h1>
	<form action="inserir-relato" method="post">
		<input type="text" value="${conteudo}" id="conteudo" name="conteudo"
			placeholder="Digite aqui seu relato...">
		<p>Data atual do relato: ${dataAtual}</p>

		<fieldset>
			<legend>Categorias:</legend>

			<div>

				<input type="checkbox" id="sororidade" name="sororidade" checked />

				<label for="sororidade">Sororidade</label>

			</div>

			<div>

				<input type="checkbox" id="ajude-me" name="ajude-me" /> <label
					for="ajude-me">Ajude-me</label>

			</div>

			<div>

				<input type="checkbox" id="desabafo" name="desabafo" /> <label
					for="desabafo">Desabafo</label>

			</div>

			<div>

				<input type="checkbox" id="aconselhamento-juridico"
					name="aconselhamento-juridico" /> <label
					for="aconselhamento-juridico">Aconselhamento Jurídico</label>

			</div>

			<div>

				<input type="checkbox" id="acolhimento-temporario"
					name="acolhimento-temporario" /> <label
					for="acolhimento-temporario">Acolhimento Temporário</label>

			</div>

			<div>

				<input type="checkbox" id="assistencia-social"
					name="assistencia-social" /> <label for="assistencia-social">Assistência
					Social</label>

			</div>

		</fieldset>

		<button type="submit">Salvar</button>

		<button type="reset">Cancelar</button>

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