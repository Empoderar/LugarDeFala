<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Comunidade</title>
    <style>
    </style>
</head>
<body>
    <div>
        <header>
            <form action="#">
                <input type="text" name="pesquisa" id="pesquisa">
            </form>
        </header>
    </div>
    <div>
        <nav>
            <div>
                <a href="#">Página inicial</a> <a href="#">Popular</a>
                <hr>
            </div>
            <div>
                <a href="#">Comunidades</a> <a href="#">Violência física</a> <a
                    href="#">Violência psicológica</a> <a href="#">Violência moral</a>
                <a href="#">Violência sexual</a> <a href="#">Violência
                    patrimonial</a>
                <hr>
            </div>
            <div>
                <a href="#">Filtros</a>
                <form>
                    <input type="checkbox" id="filtroUsuario" name="filtro1" value="usuarios"> <label for="filtroUsuario">Usuários</label>
                    <input type="checkbox" id="filtroRelato" name="filtro2" value="relatos"> <label for="filtroRelato">Relatos</label>
                    <input type="checkbox" id="filtroConselho" name="filtro3" value="conselho"> <label for="filtroConselho">Conselhos</label>
                    <input type="checkbox" id="filtroData" name="filtro4" value="data"> <label for="filtroData">Data</label>
                    <label for="dataInicio">De</label> <input type="date" id="dataInicio" name="DataInicial">
                    <label for="dataFinal">Até</label> <input type="date" id="dataFinal" name="DataFinal">
                </form>
                <button type="button">Filtrar</button>
            </div>
        </nav>
    </div>
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
</body>
</html>
