<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Excluir Comunidade</title>
 <style type="text/css"><%@includefile="/assets/css/style.css"%></style>
</head>
<body>
<%@ include file="/assets/barras-navegacao/barra-de-navegacao.jsp"%>
	<div>
		<div>
			<h1>Excluir a comunidade</h1>
			<hr>
			<h2>Ao prosseguir você excluirá permanentemente esta comunidade</h2>
			<hr>
		</div>
		<div>
			<form action="/LugarDeFala/metodo-deletar-comunidade" method="post">
			<c:forEach var="comunidade" items="${comunidades}">
    		<div>
        		<h2>${comunidade.nome}</h2>
 				<h3>${comunidade.descricao}</h3>
        		<a href="/LugarDeFala/deletar-comunidade?idComunidade=<c:out value='${comunidade.id}'/>">Excluir</a>	
        		
    		</div>
			</c:forEach>
				<p>Confirme sua senha para excluir a comunidade</p>
				<input type="password" name="senha" id="senha" required
					maxlength="20" placeholder="Digite a senha"> <a
					href="recuperar-senha.html">Esqueci minha senha</a>
				<button type="submit">Excluir</button>
			</form>
		</div>
		<div>
			<p>Esta comunidade foi excluída com sucesso!</p>
			<button type="submit">Ok</button>
		</div>
	</div>
	<%@include file="/assets/rodape/rodape.jsp" %> 
</body>
</html>

