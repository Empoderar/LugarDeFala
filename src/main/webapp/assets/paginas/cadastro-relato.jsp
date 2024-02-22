<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Cadastrar Relato</title>
    <style type="text/css">
        <%@ include file="/assets/css/style.css" %>
    </style>
</head>
<body>
<div>
    <h1>Cadastrar relato</h1>
    <form action="/LugarDeFala/inserir-relato" method="post">
        <input type="text" value="${conteudo}" id="conteudo" name="conteudo" placeholder="Digite aqui seu relato...">
        <p>Data atual do relato: ${dataAtual}</p>

        <fieldset>
            <legend>Categorias:</legend>

            <c:forEach var="categoria" items="${categorias}">
                <div>
                    <input type="checkbox" id="${categoria.nome}" name="${categoria.nome}" />
                    <label for="${categoria.nome}">${categoria.nome}</label>
                </div>
            </c:forEach>
        </fieldset>

        <button type="submit">Salvar</button>
        <button type="reset">Cancelar</button>
    </form>

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
</div> 
</body>
</html>