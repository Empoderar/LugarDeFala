<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Home</title>
    <style type="text/css"><%@include file="/assets/css/style.css"%></style>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  </head>
  <body>
    <header class="cabecalho">
    <img src="img/logo.svg" alt="" class="logo-lugar" />
    <div class="menu-escolhas">
    	<%@ include file="/assets/barras-navegacao/deslogado-usuario.jsp"%>
    </div>
</header>
    <main class="menu-inicio">
      <img src="img/mulher.svg" alt="" class="imagem-mulher" />
 
      <div class="conteudo-home-principal">
        <h1 class="titulo-fala">LUGAR DE FALA</h1>
 
        <h2 class="subtitulo">
          Junte-se a nós como voluntária nesta rede de apoio pró-mulher!
        </h2>
 
        <p class="texto-home">
          Somos uma rede de apoio dedicada a oferecer assistência para mulheres
          cisgêneras, transgêneras e travestis que foram vítimas de violência.
          Nosso compromisso é criar um espaço seguro onde essas mulheres possam
          encontrar conforto
        </p>
 
        <div class="conteudo-home">
            <div class="botao-conteudo">
                 <button href="/LugarDeFala/cadastro-usuario" class="botao-home"> FaÃ§a seu cadastro</button>
                <button href="/LugarDeFala/perfil-comunidade" class="botao-home"> Comunidades</button>
            </div>
            <div class="botao-conteudo">
                <button class="botao-home">Seja Voluntário</button>
                <button class="botao-home">Sobre Nós</button>
            </div>
        </div>
    </main>
 
    <section class="conteudos-cartoes">
      <div class="cartao-1">
        <div>
          <img
            src="img/cartoes/027e0b5b-326c-4829-bb4e-57909479e858 1.svg"
            alt=""
            class="imagem-cartao-1"
          />
        </div>
 
        <p class="texto-cartao-1">Violência</p>
        <p class="texto-cartao-1">Física</p>
      </div>
 
      <div class="cartao-1">
        <div>
          <img
            src="img/cartoes/Untitled Project 1.svg"
            alt=""
            class="imagem-cartao-2"
          />
        </div>
 
        <p class="texto-cartao-1">Violência</p>
        <p class="texto-cartao-1">Psicológica</p>
      </div>
 
      <div class="cartao-1">
        <div>
          <img
            src="img/cartoes/Mulher jovem com uma folha de papel vítima de bullying e mãos atacando _ Vetor Premium 1.svg"
            alt=""
            class="imagem-cartao-3"
          />
        </div>
 
        <p class="texto-cartao-1">Violência</p>
        <p class="texto-cartao-1">Moral</p>
      </div>
 
      <div class="cartao-1">
        <div>
          <img
            src="img/cartoes/Untitled Project (2) 1.svg"
            alt=""
            class="imagem-cartao-4"
          />
        </div>
 
        <p class="texto-cartao-1">Violência</p>
        <p class="texto-cartao-1">Sexual</p>
      </div>
 
      <div class="cartao-1">
        <div>
          <img
            src="img/cartoes/Horoskop_ Warum du das Sternzeichen Fische im Leben brauchst 1.svg"
            alt=""
            class="imagem-cartao-5"/>
        </div>
 
        <p class="texto-cartao-1">Violência</p>
        <p class="texto-cartao-1">Patrimonial</p>
      </div>
    </section>
 
    <section class="conteudo-parte">
      <div>
        <h1 class="titulo-parte">VENHA FAZER PARTE</h1>
        <p class="texto-parte">Durante a pandemia, 8 mulheres apanharam por minuto no Brasil. A violência psicológica, que não deixa marcas físicas, feriu também a dignidade de muitas.
          Mostre seu apoio à outras mulheres fazendo seu relato, pois nõo estamos sozinhas nessa luta!</p>
      </div>
    </section>
    <section class="conteudo-duvidas">
      <div class="fundo-duvidas">
        <div class="container-duvidas">
          <div>
            <h1 class="titulo-duvida">Como me tornar um voluntário? <i class="fa-solid fa-magnifying-glass"></i></h1>
            <p class="texto-duvida-1">Para se tornar um voluntário é necessário fazer o cadastro de voluntário, que apresenta um PDF com as informações que um voluntário deve saber e um breve teste sobre os conhecimentos adquiridos.</p>
          </div>
 
          <div>
            <h1 class="titulo-duvida">Como fazer um relato? <i class="fa-solid fa-magnifying-glass"></i></h1>
            <p class="texto-duvida">Para  fazer seu relato é necessário criar uma conta, fazer login no site e escolher uma comunidade, então clicar no botão reletar e se abrir com pessoas que passam ou já passaram pelo mesmo.</p>
          </div>
        </div>
 
        <div class="container-duvidas-2">          
          <div>
            <h1 class="titulo-duvida">O que é um voluntário? <i class="fa-solid fa-magnifying-glass"></i></h1>
            <p class="texto-duvida">Voluntários são usuários comuns que moderam as comunidades e gerenciam possiveis problemas.</p>
          </div>
 
          <div>
            <h1 class="titulo-duvida">O que são as comunidades? <i class="fa-solid fa-magnifying-glass"></i></h1>
            <p class="texto-duvida">As comunidades são grandes grupos, cada comunidade representa um tipo de violência onde você pode buscar acolhimento</p>
          </div>
        </div>
      </div>
    </section>
    <%@include file="/assets/rodape/rodape.jsp" %>  
   </body>
</html>