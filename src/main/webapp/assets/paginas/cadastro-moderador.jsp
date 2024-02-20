<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
    	<meta charset="UTF-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
   		<title>Cadastrar Moderador</title>
    	<style>
    	</style>
	</head>
	<body>
		<div>
    		<h1>Cadastro de moderador</h1>
    		<div>
        		<form action="inserir-moderador" method="post">
            		<label for="fnome">Nome</label>
            			<input type="text" id="fnome" name="nome" required maxlength="50">
            		<label for="sobrenome">Sobrenome</label>
            			<input type="text" id="sobrenome" name="sobrenome" required maxlength="50">
            		<label for="telefone">Telefone</label>
            			<input type="tel" id="telefone" name="telefone" pattern="[0-9]{2}[0-9]{5}[0-9]{4}" required>
            		<label for="user">Nome de usuário</label>
            			<input type="text" id="user" name="apelido" required maxlength="35">
           	 		<label for="email">E-mail</label>
            			<input type="email" id="email" name="email" required maxlength="40">
            		<label for="nascimento">Data de Nascimento</label>
            			<input type="date" id="data-nascimento" name="data-nascimento">
            		<label for="senha">Senha</label>
            			<input type="password" id="senha" name="senha" required maxlength="20">
            		<label for="csenha">Confirmar senha</label>
            			<input type="password" id="csenha" name="outra-senha" required maxlength="20">
            		<button type="submit">Próximo</button>
        		</form>
    		</div>
    		<div>
        		<p>Enviamos um código para o e-mail</p>
        		<p>Reenviar código em 60 segundos</p>
        		<button type="button">Próximo</button>
    		</div>
    		<div>
        		<p>Cadastro concluído com sucesso!</p>
        		<button type="button">Ok!</button>
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
