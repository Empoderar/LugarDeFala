<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cadastrar Usuário</title>
<style type="text/css"><%@includefile="/assets/css/style.css"%></style>
</head>
<body class="body-cadastro">
    <div class="moldura-cadastro">
      <form action="">
        <h1>Cadastro</h1>
        <div class="input-box-c">
          <label for="nome">Nome</label>
          <input
            type="text"
            name="nome"
            id="nome"
            placeholder="Digite o seu primeiro nome"
            required
          />
        </div>
 
        <div class="input-box-c">
          <label for="sobrenome">Sobrenome</label>
          <input
            type="text"
            name="sobrenome"
            id="sobrenome"
            placeholder="Digite o seu sobrenome"
            required
          />
        </div>
 
        <div class="input-box-c">
          <label for="telefone">Telefone</label>
          <input
            type="tel"
            name="telefone"
            id="telefone"
            placeholder="(xx) xxxx-xxxx"
            required
          />
        </div>
 
        <div class="input-box-c">
          <label for="usuario">Nome de Usuário</label>
          <input
            type="text"
            name="usuario"
            id="usuario"
            placeholder="Crie o seu nome de usuário"
            required
          />
        </div>
 
        <div class="input-box-c">
          <label for="email">E-mail</label>
          <input
            type="email"
            name="email"
            id="email"
            placeholder="Digite o seu e-mail"
            required
          />
        </div>
 
        <div class="input-box-c">
          <label for="data">Data de Nascimento</label>
          <input
            type="date"
            name="data"
            id="data"
            placeholder="Digite a sua data de nascimento"
            required
          />
        </div>
 
        <div class="input-box-c">
          <label for="senha">Senha</label>
          <input
            type="password"
            name="senha"
            id="senha"
            placeholder="Crie a sua senha"
            required
          />
        </div>
 
        <div class="input-box-c">
          <label for="senha-confirme">Confirme a sua senha</label>
          <input
            type="password"
            name="senha-confirme"
            id="senha-confirme"
            placeholder="Repita a sua senha"
            required
          />
        </div>
 
        <button type="submit" class="button">Confirmar</button>
 
        <div class="cadastrar-link">
          <p>Já tem uma conta? <a href="/LugarDeFala/login">Entre</a></p>
        </div>
      </form>
    </div>
  </body>
</html>
