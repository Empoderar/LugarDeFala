<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Editar perfil</title>
<style type="text/css"><%@includefile="/assets/css/style.css"%></style>
</head>
<body>

	<div>
		<p>Editar Perfil:</p>
	</div>
  
  <div class="fotos">
	<img alt="foto-fundo" class="foto-fundo">
    
    <img alt="foto-perfil" class="foto-perfil">
  
  </div>

    <div class="moldura-editar-perfil">
		<form action="/LugarDeFala/metodo-editar-perfil" method="post">
		<div class="input-box-e">
          <label for="nome">Nome</label>
          <input
            placeholder="Digite aqui... ";
            maxlength="50"
            type="text"
            name="nome"
            id="nome"
            required
			value="${usuarioLogado.nome}"
          />
        </div>
		<div class="input-box-e">
          <label for="sobrenome">Sobrenome</label>
          <input
            placeholder="Digite aqui... ";
            maxlength="50"
            type="text"
            name="sobrenome"
            id="sobrenome"
            required
			value="${usuarioLogado.sobrenome}"
          />
        </div>
	    <div class="input-box-e">
          <label for="descricao">Biografia</label>
          <input
            placeholder="Digite aqui... ";
            maxlength="500"
            type="text"
            name="descricao"
            id="descricao"
            required
			value="${usuarioLogado.descricao}"
          />
        </div>
		<div class="input-box-e">
          <label for="apelido">Nome de usuário</label>
          <input
            placeholder="Digite aqui... ";
            maxlength="50"
            type="text"
            name="apelido"
            id="apelido"
            required
			value="${usuarioLogado.apelido}"
          />
        </div>
		<div class="input-box-e">
          <label for="email">E-mail</label>
          <input
            placeholder="Digite aqui... ";
            maxlength="40"
            type="text"
            name="email"
            id="email"
            required
			value="${usuarioLogado.contato.email}"
          />
        </div>
		<div class="input-box-e">
          <label for="telefone">Telefone</label>
          <input
            placeholder="Digite aqui... ";
		        pattern="[0-9]{2}[0-9]{5}[0-9]{4}"
            maxlength="40"
            type="tel"
            name="telefone"
            id="telefone"
            required
			value="${usuarioLogado.contato.telefone}"
          />
        </div>
        <div class="button">
			<button type="submit">Salvar</button>
    </div>
		</form>
	</div>

</body>
</html>
