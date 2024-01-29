<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head> 

<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Comunidade</title>

<style>

</style>

</head>

<body>

	<div>

		<header>

			<input type="text" name="pesquisa" id="pesquisa">

		</header>

	</div>

	<div>

		<nav>

			<div>

				<a href="#">Página inicial</a> <a href="#">Popular</a>

				<hr>

			</div>

			<div>

				<a href="#">Comunidades</a> <a href="#">Violência física</a> <a

					href="#">Violência psicológica</a> <a href="#">Violência moral</a>

				<a href="#">Violência sexual</a> <a href="#">Violência

					patrimonial</a>

				<hr>

			</div>

			<div>

				<a href="#">Filtros</a>

				<form>

					<input type="checkbox" id="filtroUsuario" name="filtro1"

						value="usuarios"> 

							<label for="filtro1">Usuários</label> 

						<input type="checkbox" id="filtroRelato" name="filtro2" value="relatos">

							<label for="filtro2">Relatos</label> 

						<input type="checkbox" id="filtroConselho" name="filtro3" value="conselho">

							 <label for="filtro3">Conselhos</label> 

						<input type="checkbox" id="filtroData" name="filtro4" value="data">

							 <label for="filtro4">Data</label> 

							 <label for="dataInicio" id="dataInicio">De</label>

					<input type="date" id="dataInicio" name="DataInicial"> 

							<label for="dataFinal" id="dataFinal">Até</label> 

					<input type="date" id="dataFinal" name="DataFinal">

				</form>

				<button type="button">Filtrar</button>

			</div>

		</nav>

	</div>

	<div>

	<div>

			<div>

				<h1>

					<c:if test="${relato != null}">Editar Relato</c:if>

					<c:if test="${relato == null}">Inserir Relato</c:if>

				</h1>

				<div>

					<c:if test="${relato != null}">

						<form action="atualizar" method="post">

					</c:if>

					<c:if test="${relato == null}">

						<form action="inserir" method="post">

					</c:if>

					<c:if test="${relato != null}">

						<input type="hidden" name="id" value="<c:out value='${relato.id}' />" />

					</c:if>

					<label>Conteúdo:</label>

					<input type="text" value="<c:out value='${relato.conteudo}' />" id="conteudo" name="conteudo" placeholder="Digite aqui seu relato..."> 

					<fieldset>

                       <legend>Categorias:</legend>

                       <div>

                         <input type="checkbox" id="sororidade" name="sororidade" checked />

                         <label for="sororidade">Sororidade</label>

                       </div>

                       <div>

                         <input type="checkbox" id="ajude-me" name="ajude-me" />

                         <label for="ajude-me">Ajude-me</label>

                       </div>

                       <div>

                         <input type="checkbox" id="desabafo" name="desabafo" />

                         <label for="desabafo">Desabafo</label>

                       </div>

                       <div>

                         <input type="checkbox" id="aconselhamento_juridico" name="aconselhamento_juridico" />

                         <label for="aconselhamento_juridico">Aconselhamento Jurídico</label>

                       </div>

                       <div>

                         <input type="checkbox" id="acolhimento_temporario" name="acolhimento_temporario" />

                         <label for="acolhimento_temporario">Acolhimento Temporário</label>

                       </div>

                       <div>

                         <input type="checkbox" id="assistencia_social" name="assistencia_social" />

                         <label for="assistencia_social">Assistência Social</label>

                       </div>

                    </fieldset>

					<button type="submit">Salvar</button>

					<button type="reset">Cancelar</button>

				</form>

				</div>

			</div>

		</div>

		<div>

				<thead>

					<tr>

						<th>Relatos</th>

						<th>Ações</th>

					</tr>

				</thead>

				<tbody>

					<c:forEach var="relato" items="${relatos}">

						<tr>

							<td><c:out value="${relato.conteudo}" /></td>					

							<td><c:out value="${relato.data}" /></td>

							<td><c:out value="${relato.avaliacao}" /></td>

							<td><c:out value="${relato.categoria}" /></td>

							<td><c:out value="${relato.status}" /></td>

							<td><c:out value="${relato.nome}" /></td>

							<td><c:out value="${relato.sobrenome}" /></td>

							<td><c:out value="${relato.apelido}" /></td>

								<td>

								<a href="editar?id=<c:out value='${relato.id}'/>">Editar</a>

								<a href="deletar?id=<c:out value='${relato.id}'/>">Deletar</a>

							</td>

						</tr>

					</c:forEach>

				</tbody>

			</table>

		</div>

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