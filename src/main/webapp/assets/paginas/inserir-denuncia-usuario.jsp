<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro Denúncia de Usuário</title>
</head>
<body>

    <h2>Cadastro Denúncia de Usuário</h2>

    <form action="inserir-denuncia-usuario" method="post">
        <label for="usuario-denunciante">Usuário Denunciante:</label>
        <input type="text" name="usuario-denunciante" required>
        <br>

        <label for="usuario-denunciado">Usuário Denunciado:</label>
        <input type="text" name="usuario-denunciado" required>
        <br>

        <label for="motivo">Motivo:</label>
        <textarea name="motivo" rows="4" cols="50" required></textarea>
        <br>

        <input type="submit" value="Enviar Denúncia">
    </form>

</body>
</html>
