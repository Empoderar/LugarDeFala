<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastrar Comunidade</title>
    <style>
    </style>
</head>
	<c:if test="${usuario == null}">
		<%@ include file="../barras-navegacao/home-deslogada.jsp"%>
	</c:if>

	<c:if test="${usuario != null}">
		<%@ include file="../barras-navegacao/home-logada.jsp"%>
	</c:if>
<body>
<div>
    <div>
        <h1>Cadastrar Comunidade</h1>
        <form action="inserir-comunidade" method="post">
            <label for="cor">Cor</label> 
            <input type="color" name="cor" id="cor">
            <label for="nomeComunidade">Nome</label> 
            <input type="text" id="nomeComunidade" name="nome" required maxlength="50">
            <label for="descricao">Descrição</label> 
            <input type="text" id="descricao" name="descricao" required maxlength="500">
            <button type="submit">Salvar</button>
        </form>
    </div>
    <div>
        <footer>
            <div>
                <p>Lugar de Fala</p>
                <a href="#">Sobre nós</a> 
                <a href="#">Página inicial</a>
            </div>
            <div>
                <p>Atendimento</p>
                <a href="#">Contato</a> 
                <a href="#">Termos de uso</a>
            </div>
            <div>
                <p>Redes Sociais</p>
                <a href="#">Whatsapp</a> 
                <a href="#">Instagram</a>
            </div>
            <div>
                <p>Lugar de Fala</p>
            </div>
            <div>
                <p>2023 Todos os direitos reservados</p>
            </div>
        </footer>
    </div>
</div>
</body>
</html>
