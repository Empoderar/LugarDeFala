<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Denunciar Moderador</title>
    </head>
    <body>
        <div>
            <h1>Denunciar Moderador</h1>
            <form action="inserir-denuncia-de-moderador" method="post">
  	<input type="submit" value="Abuso "><br>
  	<input type="submit" value="Violação das diretrizes"><br>
  	<input type="submit" value="Discurso de ódio"><br>
  	</form>
        </div>
         <hr>
        <div>
            <h2>Denunciar</h2> 
            <form action="inserir-denuncia-de-moderador" method="post">
            <label for="motivo">Justifique sua denuncia</label> <input type="text" id="motivo" name="motivo" required
					maxlength="500">
				 <input type="submit" value="Salvar">
				</form>
        </div>
    </body>
</html>