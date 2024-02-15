<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Excluir Conta</title>
    <style>
    </style>
</head>
<body>
<div>
    <div>
        <h1>Excluir a conta</h1>
        <hr>
        <h2>Ao prosseguir você excluirá permanentemente sua conta</h2>
        <p>Ao excluir sua conta você não poderá ativar ou usar ela no
            futuro, depois de excluir sua conta Lugar de Fala não será mais
            possível ver relatos e conselhos, acessar comunidades ou postar
            relatos. Se ainda deseja excluir sua conta clique no botão “excluir”
            no canto inferior direito da página.</p>
        <h3>Ao prosseguir você excluirá permanentemente sua conta</h3>
        <p>Você pode arquivar sua conta Lugar de Fala ao invés de
            excluí-la permanentemente, para arquivar sua conta vá em “Arquivar
            Conta”.</p>
        <hr>
        <p>Você não poderá recuperar sua conta depois de excluí-la</p>
    </div>
    <div>
        <form action="método-deletar-usuario" method="post">
            <p>Confirme sua senha para excluir a conta</p>
            <input type="password" name="senha" id="senha" required maxlength="20" placeholder="Digite a senha"> 
            <a href="recuperar-senha.html">Esqueci minha senha</a>
            <button type="submit">Excluir</button>
        </form>
    </div>
    <div>
        <p>Sua conta foi excluída com sucesso!</p>
        <button type="submit">Ok</button>
    </div>
</div>
</body>
</html>
