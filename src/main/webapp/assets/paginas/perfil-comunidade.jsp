<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>comunidades</title>
<style type="text/css">
<%@ include file="/assets/css/style.css"%>
</style>
</head>
 <header class="cabecalho">
    <img src="img/logo.svg" alt="" class="logo-lugar" />
    <a href="#"> <img src="#" alt="hamburguer"></a>

    <div>
        <a href="#">Hamburguer</a>

        <button class="hamburguer" onclick="alternarMenu('hamburguer')">Hamburguer</button>

        <div id="hamburguer" style="display: none; float: left;" class="dropdown-menu">

            <div>
                <ol>
                    <li><a href="/LugarDeFala/">Página inicial</a></li>
                    <li><a href="/LugarDeFala/perfil-comunidade">Comunidades</a></li>
                    <li><a href="#">categorias</a></li>
                    <li><a href="/LugarDeFala/pesquisar-usuario">Encontrar usuários</a></li>
                    <li><a href="/LugarDeFala/relatos-arquivados">Relatos arquivados</a></li>
                    <li><a href="/LugarDeFala/tela-denuncias-usuarios">Denuncias</a></li>
                    <li><a href="/LugarDeFala/usuario-virar-moderador">Virar moderador</a></li>
                </ol>
            </div>

        </div>

        <button class="icone" onclick="alternarMenu('icone')">Icone</button>

        <div id="icone" style="display: none; float: right;" class="dropdown-menu">

            <div>
                <ol>
                    <li><a href="/LugarDeFala/perfil-usuario">Meu perfil</a></li>
                    <li><a href="/LugarDeFala/tela-de-bloqueado">Bloqueados</a></li>
                    <li><a href="/LugarDeFala/deletar-usuario">Excluir Conta</a></li>
                    <li><a href="/LugarDeFala/desativar-perfil">Desativar Conta</a></li>
                    <li><a href="/LugarDeFala/home-deslogada">Sair</a></li>
                </ol>
            </div>

        </div>

        <script>
            function alternarMenu(menuId) {
                var menu = document.getElementById(menuId);
                if (menu.style.display === "none") {
                    menu.style.display = "block";
                } else {
                    menu.style.display = "none";
                }
            }
        </script>
    </div>

</header>
<body>
	<div>
		<hr>
		<div>
			<nav>
				<div>
					<c:out value="${comunidade.nome}"></c:out>
					<c:out value="${comunidade.descricao}"></c:out>
					<!-- Adicionar contador de membros relatos e moderadores presentes na comunidade -->
					<a href="/LugarDeFala/" class="botao-home">Sair da
						comunidade</a>
				</div>
				<div>
					<form action="perfil-comunidade" method="post">
						<c:forEach var="relato" items="${relatos}">
							<c:if test="${relato.comunidade eq comunidade}">
								<c:out value="${usuario.nome}"></c:out>
								<c:out value="${relato.conteudo}"></c:out>
								<!-- <c:out value="${relato.categoria}"></c:out> -->
								<c:out value="${relato.avaliacao}"></c:out>
							</c:if>
						</c:forEach>
					</form>
					<div>
						<button id="btnCadastroRelato" onclick="cadastroRelato()">Fazer
							relato</button>
						<div id="cadastro-relato" style="display: none;">
							<div id="user-icon">&#128100;</div>
							<textarea id="relatoTexto"
								placeholder="Digite aqui seu relato..."></textarea>
							<button id="checkboxButton" onclick="alternarCheckbox()">Abrir
								Checkbox</button>
							<div id="checkbox" style="display: none;">
								<fieldset>
									<legend>Categorias:</legend>

									<c:forEach var="categoria" items="${categorias}">
										<div>
											<input type="checkbox" id="${categoria.nome}"
												name="${categoria.nome}" /> <label for="${categoria.nome}">${categoria.nome}</label>
										</div>
									</c:forEach>
								</fieldset>
							</div>
							<button id="confirmButton" onclick="confirmRelato()">Confirmar</button>
						</div>
						<script>
							function cadastroRelato() {
								var inserir = document
										.getElementById("cadastro-relato");
								if (inserir.style.display === "none"
										|| inserir.style.display === "") {
									inserir.style.display = "block";
								} else {
									inserir.style.display = "none";
								}
							}

							function alternarCheckbox() {
								var checkbox = document
										.getElementById("checkbox");
								if (checkbox.style.display === "none"
										|| checkbox.style.display === "") {
									checkbox.style.display = "block";
								} else {
									checkbox.style.display = "none";
								}
							}

							function confirmRelato() {
								var relatoTexto = document
										.getElementById("relatoTexto").value;
								if (relatoTexto.trim() !== "") {
									console.log("Relato confirmed:",
											relatoTexto);
								} else
									console
											.error("Relato text cannot be empty.");
							}}
						</script>
					</div>
				</div>
			</nav>
		</div>
	</div>
</body>
</html>
