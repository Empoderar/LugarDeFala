<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Denunciar</title>
</head>
<style type="text/css"><%@includefile="/assets/css/style.css"%></style>
<body>
    <div>
        <h1>Denúncias de relatos</h1>
        <a href="#">Filtrar denúncias</a>
       		<form action="julgar-denuncia-relato" method="post">
        		<button type="submit">Aprovar</button>
        		<button type="submit">Rejeitar</button>
        		<button type="submit">Arquivar</button>
        	</form>
    </div>
    <div>
    	<h1>Denúncias de usuarios</h1>
        	<form action="julgar-denuncia-usuario" method="post">
        		<button type="submit">Aprovar</button>
        		<button type="submit">Rejeitar</button>
       		 	<button type="submit">Arquivar</button>
        	</form>
    </div>
    <div>
    	<h1>Denúncias de moderadores</h1>
        	<form action="julgar-denuncia-moderador" method="post">
        		<button type="submit">Aprovar</button>
        		<button type="submit">Rejeitar</button>
        		<button type="submit">Arquivar</button>
        	</form>
    </div>
    <div>
    	<h1>Denúncias de conselhos</h1>
        	<form action="julgar-denuncia-conselho" method="post">
        		<button type="submit">Aprovar</button>
        		<button type="submit">Rejeitar</button>
        		<button type="submit">Arquivar</button>
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
</body>
</html>
