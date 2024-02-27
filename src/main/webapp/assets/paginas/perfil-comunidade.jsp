<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
        integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" type="text/css" href="style.css" />
    <title>Comunidades</title>
    <style type="text/css">
<%@include file="/assets/css/style.css"%>
</style>
</head>
 <header class="cabecalho">
    <button onclick="alternarMenu('hamburguer')" class="menu-hamburguer-hamburguer">
        <i class="fa-solid fa-bars"></i>
    </button>

    <div id="hamburguer" class="menu-content">
        <ol>
            <li><a href="home">Página inicial</a></li>
            <li><a href="perfil-comunidade">Comunidades</a></li>
            <li><a href="#">categorias</a></li>
            <li><a href="pesquisar-usuario">Encontrar usuários</a></li>
            <li><a href="relatos-arquivados">Relatos arquivados</a></li>
            <li><a href="tela-denuncias-usuarios">Denuncias</a></li>
            <li><a href="usuario-virar-moderador">Virar moderador</a></li>
        </ol>
    </div>

    <button onclick="alternarMenu('icone')" class="menu-icone-icone">Icone</button>

    <div id="icone" class="icone-content">
        <ol>
            <li><a href="perfil-usuario">Meu perfil</a></li>
            <li><a href="tela-de-bloqueado">Bloqueados</a></li>
            <li><a href="deletar-usuario">Excluir Conta</a></li>
            <li><a href="desativar-perfil">Desativar Conta</a></li>
            <li><a href="home-deslogada">Sair</a></li>
        </ol>
    </div>

    <script>
        function alternarMenu(menuId) {
            var menu = document.getElementById(menuId);
            if (menu.style.display === "none" || menu.style.display === "") {
                menu.style.display = "block";
            } else {
                menu.style.display = "none";
            }
        }
    </script>
</header>
<body>
	<body>
    <header class="cabeçalho-logado">
        <a href="#" class="menu-link" id="menu">
            <i class="fa-solid fa-bars"></i>
        </a>
        <img src="img/perfil.svg" alt="" class="perfil-foto">
    </header>

    <main class="header-comunidade">
       <div class="esquerda-header-comunidade">
           <h1>VIOLÊNCIA FÍSICA</h1>
           <span>“Muda tuas ideias e mudarás teu mundo”</span>
       </div>

       <div class="direita-header-comunidade">
            <div class="info-comunidade">
                <span> 485 </span>
                <span> MEMBROS </span>
            </div>
            <div class="info-comunidade">
                <span> 37 </span>
                <span> MODERADORES </span> 
            </div>
            <div class="info-comunidade">
                <span> 501 </span>
                <span> RELATOS </span>
            </div>

            <a href="Comunidade-sair.html" class="botao-sair"> Ingressar na comunidade</a>
       </div>

    </main>
    <section class="principal-pagina">
        <div class="relato-container">
            <div class="header-relato">
                <div class="conteudo-header-relato">
                    <img src="img/foto-relato.svg" alt="">
                    <span class="nome-usuario-relato"> Manuela Silva </span>
                    <span class="comunidade-relato"> Violência Moral</span>
                </div>
                <i class="fa-solid fa-ellipsis"></i>
            </div>

            <div class="categorias-relato">
                <span> Desabafo |</span>
                <span> Aconselhamento jurídico | </span>
                <span> Ajude-me |</span>
                <span> Sororidade</span>
            </div>

            <p class="texto-relato"> Gente, passei pela violência moral, tipo palavras cortantes que me atravessavam.
                Cada xingamento era um
                soco no peito. Mas hoje tô aqui de pé, contando minha história não como vítima, mas como alguém que
                botou o pé na porta da superação. Resiliência é minha vibe, mano, vamo que vamo! </p>

            <div class="footer-relato">
                <i class="fa-regular fa-comment"></i>
                <i class="fa-regular fa-thumbs-up"></i>
                <i class="fa-regular fa-thumbs-down"></i>
            </div>
        </div>

        <div class="relato-container">
            <div class="header-relato">
                <div class="conteudo-header-relato">
                    <img src="img/foto-relato2.svg" alt="">
                    <span class="nome-usuario-relato"> Júlia Oliveira </span>
                    <span class="comunidade-relato"> Violência Física</span>
                </div>
                <i class="fa-solid fa-ellipsis"></i>
            </div>

            <div class="categorias-relato">
                <span> Desabafo |</span>
                <span> Ajude-me |</span>
                <span> Sororidade</span>
            </div>

            <p class="texto-relato"> Tô me sentindo meio perdida. Ontem à noite, meu namorado surtou do nada e acabou me
                agredindo. Foi uma coisa louca, nunca imaginei que ele fosse capaz disso. Eu tava tentando conversar
                sobre algo bobo, sabe, e de repente ele perdeu o controle total. </p>

            <div class="footer-relato">
                <i class="fa-regular fa-comment"></i>
                <i class="fa-regular fa-thumbs-up"></i>
                <i class="fa-regular fa-thumbs-down"></i>
            </div>
        </div>

        <div class="relato-container">
            <div class="header-relato">
                <div class="conteudo-header-relato">
                    <img src="img/foto-relato3.svg" alt="">
                    <span class="nome-usuario-relato"> Mariela Diaz </span>
                    <span class="comunidade-relato"> Violência Moral</span>
                </div>
                <i class="fa-solid fa-ellipsis"></i>
            </div>

            <div class="categorias-relato">
                <span> Desabafo |</span>
                <span> Aconselhamento jurídico | </span>
                <span> Ajude-me |</span>
                <span> Sororidade</span>
            </div>

            <p class="texto-relato"> Ele me diminuía constantemente, fazendo-me sentir insignificante e sem valor. "Você
                é fraca", "ninguém mais te quer", eram suas palavras habituais. Cada insulto era um golpe na minha
                autoestima. Mesmo sabendo que merecia mais, eu me sentia incapaz de sair desse ciclo de abuso. Até
                quando vou suportar isso? </p>

            <div class="footer-relato">
                <i class="fa-regular fa-comment"></i>
                <i class="fa-regular fa-thumbs-up"></i>
                <i class="fa-regular fa-thumbs-down"></i>
            </div>
        </div>

        <div class="relato-container">
            <div class="header-relato">
                <div class="conteudo-header-relato">
                    <img src="img/foto-relato4.svg" alt="">
                    <span class="nome-usuario-relato"> Júlia Oliveira </span>
                    <span class="comunidade-relato"> Violência Moral</span>
                </div>
                <i class="fa-solid fa-ellipsis"></i>
            </div>

            <div class="categorias-relato">
                <span> Desabafo |</span>
                <span> Aconselhamento jurídico | </span>
                <span> Ajude-me |</span>
                <span> Sororidade</span>
            </div>

            <p class="texto-relato"> Gente, passei pela violência moral, tipo palavras cortantes que me atravessavam.
                Cada xingamento era um
                soco no peito. Mas hoje tô aqui de pé, contando minha história não como vítima, mas como alguém que
                botou o pé na porta da superação. Resiliência é minha vibe, mano, vamo que vamo! </p>

            <div class="footer-relato">
                <i class="fa-regular fa-comment"></i>
                <i class="fa-regular fa-thumbs-up"></i>
                <i class="fa-regular fa-thumbs-down"></i>
            </div>
        </div>

        <div class="relato-container">
            <div class="header-relato">
                <div class="conteudo-header-relato">
                    <img src="img/foto-relato5.svg" alt="">
                    <span class="nome-usuario-relato"> Amanda Furtado </span>
                    <span class="comunidade-relato"> Violência Física</span>
                </div>
                <i class="fa-solid fa-ellipsis"></i>
            </div>

            <div class="categorias-relato">
                <span> Desabafo |</span>
                <span> Ajude-me |</span>
                <span> Sororidade</span>
            </div>

            <p class="texto-relato"> Tô me sentindo meio perdida. Ontem à noite, meu namorado surtou do nada e acabou me
                agredindo. Foi uma coisa louca, nunca imaginei que ele fosse capaz disso. Eu tava tentando conversar
                sobre algo bobo, sabe, e de repente ele perdeu o controle total. </p>

            <div class="footer-relato">
                <i class="fa-regular fa-comment"></i>
                <i class="fa-regular fa-thumbs-up"></i>
                <i class="fa-regular fa-thumbs-down"></i>
            </div>
        </div>

        <div class="relato-container">
            <div class="header-relato">
                <div class="conteudo-header-relato">
                    <img src="img/foto-relato6.svg" alt="">
                    <span class="nome-usuario-relato"> Sara Sousa </span>
                    <span class="comunidade-relato"> Violência Moral</span>
                </div>
                <i class="fa-solid fa-ellipsis"></i>
            </div>

            <div class="categorias-relato">
                <span> Desabafo |</span>
                <span> Aconselhamento jurídico | </span>
                <span> Ajude-me |</span>
                <span> Sororidade</span>
            </div>

            <p class="texto-relato"> Ele me diminuía constantemente, fazendo-me sentir insignificante e sem valor. "Você
                é fraca", "ninguém mais te quer", eram suas palavras habituais. Cada insulto era um golpe na minha
                autoestima. Mesmo sabendo que merecia mais, eu me sentia incapaz de sair desse ciclo de abuso. Até
                quando vou suportar isso? </p>

            <div class="footer-relato">
                <i class="fa-regular fa-comment"></i>
                <i class="fa-regular fa-thumbs-up"></i>
                <i class="fa-regular fa-thumbs-down"></i>
            </div>
        </div>
    </section>
    
    <div>
		<hr>
		<div>
			<nav>
				<div>
					<c:out value="${comunidade.nome}"></c:out>
					<c:out value="${comunidade.descricao}"></c:out>
					<a href="/LugarDeFala/" class="botao-home">Sair da
						comunidade</a>
				</div>
				<div>
					<form action="perfil-comunidade" method="post">
						<c:forEach var="relato" items="${relatos}">
							<c:if test="${relato.comunidade eq comunidade}">
								<c:out value="${usuarioLogado.nome}"></c:out>
								<c:out value="${relato.conteudo}"></c:out>
								<!-- <c:out value="${relato.categoria}"></c:out> -->
								<c:out value="${relato.avaliacao}"></c:out>
							</c:if>
						</c:forEach>
					</form>
					<div>
						<a href="/LugarDeFala/cadastro-relato?id=<c:out value='${comunidade.id}'/>">Fazer Relato</a>
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
