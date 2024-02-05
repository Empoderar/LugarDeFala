<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Denunciar</title>
    </head>
    <body>
        <!--
            cada div é uma tela
        -->
        <div>
            <h1>Denunciar</h1>
            <form action="Fazer-denuncia" method="post">
  	<input type="button" id="Spam" name="É spam"><br>
  	<input type="button" id="Violação das diretrizes" name="Violando as diretrizes"><br>
  	<input type="button" id="Discurso de ódio" name="Discurso de ódio"><br>
  	</form>
        </div>
         <hr>
        <div>
            <h2>Denunciar</h2>
            <form action="inserir-denuncia-relato" method="post">
            <label for="Justifique sua denuncia">Justifique sua denuncia</label> <input type="text" id="justifique" name="justificativa-denuncia" required
					maxlength="500">
				 <button type="submit">Salvar</button>
				</form>
        </div>
        <hr>
        <div>
            <h1>Denunciar</h1>
            <p>Denúncia concluída, deseja bloquear usuário?</p>
            <button>Sim</button>
            <button>Não</button>
        </div>
    </body>
</html>