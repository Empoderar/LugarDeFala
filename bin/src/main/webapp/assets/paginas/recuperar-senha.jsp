<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Recuperar Senha</title>
</head>
<body>
    <div>
    	<form action="recuperar-email" method="post">
        	<h1>Recuperar senha</h1>
        		<p>Ensira o e-mail e enviaremos um link para você recuperar sua conta</p>
        		
        </form>
    </div>
    <div>
        <h2>Criar nova senha</h2>
        <form action="recuperar-senha" method="post">
            <input type="password" id="novasenha" name="senha" required maxlength="20" placeholder="Nova senha">
            <!-- <input type="password" id="cnovasenha" name="csenha" required maxlength="20" placeholder="Confirmar senha"> -->
            <button type="submit">Confirmar</button>
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
