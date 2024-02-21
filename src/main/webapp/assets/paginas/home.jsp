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
          Junte-se a n�s como volunt�ria nesta rede de apoio pr�-mulher!
        </h2>
 
        <p class="texto-home">
          Somos uma rede de apoio dedicada a oferecer assist�ncia para mulheres
          cisg�neras, transg�neras e travestis que foram v�timas de viol�ncia.
          Nosso compromisso � criar um espa�o seguro onde essas mulheres possam
          encontrar conforto
        </p>
 
        <div class="conteudo-home">
            <div class="botao-conteudo">
                 <button href="/LugarDeFala/cadastro-usuario" class="botao-home"> Faça seu cadastro</button>
                <button href="/LugarDeFala/perfil-comunidade" class="botao-home"> Comunidades</button>
            </div>
            <div class="botao-conteudo">
                <button class="botao-home">Seja Volunt�rio</button>
                <button class="botao-home">Sobre N�s</button>
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
 
        <p class="texto-cartao-1">Viol�ncia</p>
        <p class="texto-cartao-1">F�sica</p>
      </div>
 
      <div class="cartao-1">
        <div>
          <img
            src="img/cartoes/Untitled Project 1.svg"
            alt=""
            class="imagem-cartao-2"
          />
        </div>
 
        <p class="texto-cartao-1">Viol�ncia</p>
        <p class="texto-cartao-1">Psicol�gica</p>
      </div>
 
      <div class="cartao-1">
        <div>
          <img
            src="img/cartoes/Mulher jovem com uma folha de papel v�tima de bullying e m�os atacando _ Vetor Premium 1.svg"
            alt=""
            class="imagem-cartao-3"
          />
        </div>
 
        <p class="texto-cartao-1">Viol�ncia</p>
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
 
        <p class="texto-cartao-1">Viol�ncia</p>
        <p class="texto-cartao-1">Sexual</p>
      </div>
 
      <div class="cartao-1">
        <div>
          <img
            src="img/cartoes/Horoskop_ Warum du das Sternzeichen Fische im Leben brauchst 1.svg"
            alt=""
            class="imagem-cartao-5"/>
        </div>
 
        <p class="texto-cartao-1">Viol�ncia</p>
        <p class="texto-cartao-1">Patrimonial</p>
      </div>
    </section>
 
    <section class="conteudo-parte">
      <div>
        <h1 class="titulo-parte">VENHA FAZER PARTE</h1>
        <p class="texto-parte">Durante a pandemia, 8 mulheres apanharam por minuto no Brasil. A viol�ncia psicol�gica, que n�o deixa marcas f�sicas, feriu tamb�m a dignidade de muitas.
          Mostre seu apoio � outras mulheres fazendo seu relato, pois n�o estamos sozinhas nessa luta!</p>
      </div>
    </section>
    <section class="conteudo-duvidas">
      <div class="fundo-duvidas">
        <div class="container-duvidas">
          <div>
            <h1 class="titulo-duvida">Como me tornar um volunt�rio? <i class="fa-solid fa-magnifying-glass"></i></h1>
            <p class="texto-duvida-1">Para se tornar um volunt�rio � necess�rio fazer o cadastro de volunt�rio, que apresenta um PDF com as informa��es que um volunt�rio deve saber e um breve teste sobre os conhecimentos adquiridos.</p>
          </div>
 
          <div>
            <h1 class="titulo-duvida">Como fazer um relato? <i class="fa-solid fa-magnifying-glass"></i></h1>
            <p class="texto-duvida">Para  fazer seu relato � necess�rio criar uma conta, fazer login no site e escolher uma comunidade, ent�o clicar no bot�o reletar e se abrir com pessoas que passam ou j� passaram pelo mesmo.</p>
          </div>
        </div>
 
        <div class="container-duvidas-2">          
          <div>
            <h1 class="titulo-duvida">O que � um volunt�rio? <i class="fa-solid fa-magnifying-glass"></i></h1>
            <p class="texto-duvida">Volunt�rios s�o usu�rios comuns que moderam as comunidades e gerenciam possiveis problemas.</p>
          </div>
 
          <div>
            <h1 class="titulo-duvida">O que s�o as comunidades? <i class="fa-solid fa-magnifying-glass"></i></h1>
            <p class="texto-duvida">As comunidades s�o grandes grupos, cada comunidade representa um tipo de viol�ncia onde voc� pode buscar acolhimento</p>
          </div>
        </div>
      </div>
    </section>
    <%@include file="/assets/rodape/rodape.jsp" %>  
   </body>
</html>