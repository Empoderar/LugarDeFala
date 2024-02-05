<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <title>Conselhos</title>
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
                    <input type="checkbox" id="filtroUsuario" name="filtro1"
                        value="usuarios"> <label for="filtro1">Usuários</label> <input
                        type="checkbox" id="filtroRelato" name="filtro2" value="relatos">
                    <label for="filtro2">Relatos</label> <input type="checkbox"
                        id="filtroConselho" name="filtro3" value="conselho"> <label
                        for="filtro3">Conselhos</label> <input type="checkbox"
                        id="filtroData" name="filtro4" value="data"> <label
                        for="filtro4">Data</label> <label for="dataInicio" id="dataInicio">De</label>
                    <input type="date" id="dataInicio" name="DataInicial"> <label
                        for="dataFinal" id="dataFinal">Até</label> <input type="date"
                        id="dataFinal" name="DataFinal">
                </form>
                <button type="button">Filtrar</button>
            </div>
        </nav>
    </div>
    <div>
        <p>Relato</p>
        <form action="#">
            <input type="text" placeholder="Aconselhar">
            <button type="submit">Publicar</button>
        </form>
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
