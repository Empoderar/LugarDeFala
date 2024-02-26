<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Editar Senha</title>
    <style type="text/css"><%@includefile="/assets/css/style.css"%></style>
</head>
<body class="body-editar-senha">
<div class="moldura-editar-senha">
  <div class="img">
<img alt="logo-projeto"><%@includefile="../img/logo.svg"%></img>
</div>
    <h2>Alterar senha</h2>
    <form action="/metodo-editar-senha" method="post">
        <div class="input-box-e">
          <label for="senha-atual">Senha atual</label>
          <input
            type="text"
            name="senha-atual"
            id="senha-atual"
            maxlength="20"
            required
          />
        </div>
        <div class="input-box-e">
          <label for="nova-senha">Nova senha</label>
          <input
            type="text"
            name="nova-senha"
            id="nova-senha"
            maxlength="20"
            required
          />
        </div>
        <div class="input-box-e">
          <label for="confirmar-senha">Confirmar senha</label>
          <input
            type="text"
            name="confirmar-senha"
            id="confirmar-senha"
            maxlength="20"
            required
          />
        </div>
        <div class="button">
        <button type="submit">Confirmar</button>
      </div>
    </form>
    </div>
</body>
<%@include file="/assets/rodape/rodape.jsp" %>
</html>