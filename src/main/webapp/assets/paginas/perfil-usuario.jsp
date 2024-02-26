<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Perfil Usuário</title>
<style type="text/css"><%@includefile="/assets/css/style.css"%></style>
</head>
 
<header class="cabecalho">
 
<img src="../img/logo.svg" alt="" class="logo-lugar" />
 
</header>
 
<body>
	<%@ include file="/assets/barras-navegacao/barra-de-navegacao.jsp"%>
	
  <div class="fotos">
	<img alt="foto-fundo" class="foto-fundo">
    
    <img alt="foto-perfil" class="foto-perfil">
  
  </div>
	
	<div class="nome">
	
	<div><button class="button" onclick="/editar-perfil">Editar perfil</button></div>
	
	<p><c:out value="${usuarioLogado.nome}" /></p>
	
	<p class="user"><c:out value="${usuarioLogado.apelido}" /></p>
	
	<p><c:out value="${usuarioLogado.descricao}" /></p>
	
	</div>	
    
        <section class="conteudos-cartoes">
      <div class="comunidade">
        <div>
          <img alt="foto-comunidade"/>
 
        </div>
 
        <p class="texto-cartao-1"><c:forEach var="comunidade" items="${comunidades}">
				<c:out value="${comunidade.nome}" />
				</c:forEach></p>
 
      </div>
    </section>
    
    <section>
    <div class="relato">
    <div class="botoes">
    <button type="button"><%@includefile="../img/tres-pontos.svg"%></button>
    </div>
    <img alt="foto-perfil" class="fotinha-perfil">
    <div >
    <div class="nomes">
    <p class="nome-usuario">Nome Usuario</p>
    <p class="nome-comunidade">Nome Comunidade</p>  
    </div>
    <p class="categoria" >Categorias</p>
    <p class="conteudo">Conteúdo relato</p>
    <div class="botoes">
    <button type="button"><%@includefile="../img/comentario.svg"%></button>
    <button type="button"><%@includefile="../img/like.svg"%></button>
    <button type="button"><%@includefile="../img/deslike.svg"%></button>
    </div>
    </div>
    </div>
    </section>
    
   <div class="opcoes-relato">
   <button type="button"><%@includefile="../img/arquivar.svg"%>Arquivar</button>
   <button type="button"><%@includefile="../img/editar.svg"%>Editar</button>
   <button type="button"><%@includefile="../img/excluir.svg"%>Excluir</button>
   </div>
 
      <div class="arquivar-sucesso">
            <div>
                <%@includefile="../img/sucesso.svg"%>
            </div>
            <p>Relato arquivado com sucesso!</p>
            <button type="button">Ok!</button>
        </div>
      
      <div class="excluir-relato">
      
      <p>Excluir Relato</p>
      <p>Tem certeza que deseja excluir este relato?</p>
      <div class="botoes">
      <button type="button" class="button-sim">SIM</button>
      <button type="button" class="button-nao">NÃO</button>
      </div>
      </div>
 
         <div class="excluir-sucesso">
            <div>
                <%@includefile="../img/sucesso.svg"%>
            </div>
            <p>Relato excluído com sucesso!</p>
            <button type="button">Ok!</button>
        </div>
 
    <footer>
 
		<%@include file="/assets/rodape/rodape.jsp" %> 
	
	
	<a href="<%=request.getContextPath()%>/editar-perfil">Editar perfil</a>
<button onclick="/editar-perfil"></button>
	
				<p>Relatos:</p>
				<c:forEach var="relato" items="${relatos}">
				</c:forEach>
	
</body>
</html>


	

