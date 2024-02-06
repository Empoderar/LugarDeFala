<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Denunciar Conselho</title>
    </head>
    <body>
        <!--
            cada div é uma tela
        -->
        <div>
            <h1>Denunciar Conselho</h1>
            <form action="Fazer-denuncia" method="post">
  	<input type="submit" value="Spam"><br>
  	<input type="submit" value="Violação das diretrizes"><br>
  	<input type="submit" value="Discurso de ódio"><br>
  	</form>
        </div>
         <hr>
        <div>
            <h2>Denunciar</h2> 
            <form action="inserir-denuncia-conselho" method="post">
            <label for="Justifique sua denuncia">Justifique sua denuncia</label> <input type="text" id="justificar" name="justificativa-denuncia" required
					maxlength="500">
				 <input type="submit" value="Salvar">
				</form>
        </div>
        <hr>
        <div>
            <h3>Denunciar</h3>
            <p>Denúncia concluída, deseja bloquear usuário que fez este conselho?</p>
          <form action="Bloquear-usuario" method="post">
          <input type="submit" value="Sim">
          <input type="submit" value="Não">
          </form>
        </div>
    </body>
</html>