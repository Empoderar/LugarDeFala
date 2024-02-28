<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

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

<body>
    <header class="cabecalho">
    <button onclick="alternarMenu('hamburguer')" class="menu-hamburguer-hamburguer">
        <i class="fa-solid fa-bars"></i>
    </button>

    <div id="hamburguer" class="menu-content">
        <ol>
            <li><a href="home">Página inicial</a></li>
            <li><a href="perfil-comunidade">Comunidades</a></li>
            <li><a href="#">c=Categorias</a></li>
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

    <main class="menu-logado">
        <div class="conteudo-logado">
            <h1 class="titulo-logado"> Comunidades em destaque </h1>
        </div>

        <div class="comunidades-destaque">
            <img src="img/violencia-F.svg" alt="" class="violencia-F">

            <img src="img/violencia-ps.svg" alt="" class="violencia-Ps">

            <img src="img/violencia-pa.svg" alt="" class="violencia-Pa">
        </div>

        <h1 class="relatos-recente"> Relatos recentes </h1>
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
    <footer>
        <div id="footer_conteudo">
            <div id="footer_contatos">
                <h3>Lugar de Fala</h3>
                <p>Rede de apoio pró-mulher.</p>
    
                <div id="footer_rede_social">
                    <a href="#" class="footer-link" id="instagram"> 
                        <i class="fa-brands fa-instagram"></i>
    
                        <a href="#" class="footer-link" id="linkedin"> 
                            <i class="fa-brands fa-linkedin"></i>
                        </a>
    
                        <a href="#" class="footer-link" id="github"> 
                            <i class="fa-brands fa-github"></i>
                        </a>
                    </a>
                </div>
            </div>
            <ul class="footer-lista">
                <li>
                    <h3>Lugar de Fala</h3>
                </li>
                <li>
                    <a href="#" class="footer-link">Sobre Nós</a>
                </li>
                <li>
                    <a href="#" class="footer-link">Página inicial</a>
                </li>
            </ul>
    
            <ul class="footer-lista">
                <li>
                    <h3>Atendimento</h3>
                </li>
                <li>
                    <a href="#" class="footer-link">Contato</a>
                </li>
                <li>
                    <a href="#" class="footer-link">Termos de uso</a>
                </li>
            </ul>
    
            <ul class="footer-lista">
                <li>
                    <h3>Redes Sociais</h3>
                </li>
                <li>
                    <a href="#" class="footer-link">Whatsapp</a>
                </li>
                <li>
                    <a href="#" class="footer-link">Instagram</a>
                </li>
            </ul>
            
        </div>
        <div id="footer-copyright">
            &#169
            2024 todos os direitos reservados.
        </div>
    </footer>
</body>



</html>
