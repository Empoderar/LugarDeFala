<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>comunidades</title>
<style type="text/css">
<%@includefile="/assets/css/style.css"%>
</style>
</head>
<body>
	<div>
		<hr>
		<div>
			<nav>
				<div>
					<c:out value="${comunidade.nome}"></c:out>
					<c:out value="${comunidade.descricao}"></c:out>
<!-- 				Adicionar contador de mebros relatos e moderadores presentes na comunidade -->
					<a href="/LugarDeFala/home" class="botao-home">Sair da comunidade</a>
				</div>
                <div>
					<form action="perfil-comunidade" method="post">
			        	<c:forEach var="relato" items="${relatos}">
								<c:out value="${usuario.nome}"></c:out>
								<c:out value="${relato.conteudo}"></c:out>
<%-- 							<c:out value="${relato.categoria}"></c:out> --%>
								<c:out value="${relato.avaliacao}"></c:out>
						</c:forEach>
					</form>
                	<div>
						<button id="btnCadastroRelato" onclick="cadastroRelato()">Fazer relato</button>
						<div id="cadastro-relato"></div>
							<script>
					            function cadastroRelato() {
					                var inserir = document.getElementById("cadastro-relato");
					              if (inserir.style.display === "none" || inserir.style.display === "") {
					                   inserir.style.display = "block";
					                } else {
					                inserir.style.display = "none";
					                 }
					           }
			                </script>
					</div>
				</div>
			</nav>
		</div>
	</div>
</body>
</html>