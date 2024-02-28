<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Denunciar</title>
    <style type="text/css">
        <%@include file="/assets/css/style.css"%>
    </style>
</head>
<body>

<%@include file="/assets/barras-navegacao/barra-de-navegacao.jsp"%>

<div class="secao-denuncias">

    <div class="tipo-denuncia">
        <h1>Denúncias de relatos</h1>
        <a href="#">Filtrar denúncias</a>
        <form action="julgar-denuncia-relato" method="post">
            <button type="submit">Aprovar</button>
            <button type="submit">Rejeitar</button>
            <button type="submit">Arquivar</button>
        </form>
    </div>

    <div class="tipo-denuncia">
        <h1>Denúncias de usuários</h1>
        <form action="julgar-denuncia-usuario" method="post">
            <button type="submit">Aprovar</button>
            <button type="submit">Rejeitar</button>
            <button type="submit">Arquivar</button>
        </form>
    </div>

    <div class="tipo-denuncia">
        <h1>Denúncias de moderadores</h1>
        <form action="julgar-denuncia-moderador" method="post">
            <button type="submit">Aprovar</button>
            <button type="submit">Rejeitar</button>
            <button type="submit">Arquivar</button>
        </form>
    </div>

    <div class="tipo-denuncia">
        <h1>Denúncias de conselhos</h1>
        <form action="julgar-denuncia-conselho" method="post">
            <button type="submit">Aprovar</button>
            <button type="submit">Rejeitar</button>
            <button type="submit">Arquivar</button>
        </form>
    </div>

</div>

<%@include file="/assets/rodape/rodape.jsp" %>

</body>
</html>
