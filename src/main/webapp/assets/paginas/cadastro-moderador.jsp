<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
    	<meta charset="UTF-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
   		<title>Cadastrar Moderador</title>
    	 <style type="text/css"><%@includefile="/assets/css/style.css"%></style>
	</head>
	<body>
	<div>
    <h1>Cadastro de Moderador</h1>
    <div>
    	<form action="/form-moderador" method="post">
        <p>Leia as informações no PDF para responder ao formulário</p>
        <a href="#" target="_self">Link para o PDF</a>
        <button type="submit">Próximo</button>
        </form>
    </div>
    <div>
    	<h1>Cadastro de Moderador</h1>
        <p>Responda o formulário com base nas informações fornecidas no PDF</p>
        <a href="#" target="_self">Link para o formulário</a>
    </div>    
	</div>
		<div>
    		<h1>Cadastro de moderador</h1>
    		<div>
        		<form action="/inserir-moderador" method="post">
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
            			<input type="password" id="csenha" name="senha" required maxlength="20">
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
		</div>
		  <%@include file="/assets/rodape/rodape.jsp" %>  
	</body>
</html>
