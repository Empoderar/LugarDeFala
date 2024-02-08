<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Denunciar relato</title>
    </head>
    <body>
        <div>
            <h1>Denunciar relato</h1>
            <form action="inserir-denuncia-de-relato" method="post">
  	<input type="submit" value="Spam" name="É spam"><br>
  	<input type="submit" value="Violação das diretrizes" name="Violando as diretrizes"><br>
  	<input type="submit" value="Discurso de ódio" name="Discurso de ódio"><br>
  	</form>
        </div>
         <hr>
        <div>
            <h2>Denunciar</h2> 
            <form action="inserir-denuncia-de-relato" method="post">
            <label for="motivo">Justifique sua denuncia</label> <input type="text" id="motivo" name="motivo" required
					maxlength="500">
					<br>
						<strong>Usuário Denunciante:</strong>
				<c:out value="${usuario.nome}" />
			<p>
				<strong>Relato Denunciado:</strong>
				<c:out value="${relato.conteudo}" />
			</p>
			
			<p>Data atual da Denúncia: ${dataAtual}</p>
			<p>
				<strong>Status da Denúncia:</strong>
				<c:out value="${status}" />
			</p>
				 <input type="submit" value="Salvar">
				</form>
        </div>
        <hr>
        <div>
            <h3>Denunciar</h3>
            <p>Denúncia concluída, deseja bloquear usuário que fez este relato?</p>
          <form action="Bloquear-usuario" method="post">
          <input type="submit" value="Sim">
          <input type="submit" value="Não">
          </form>
        </div>
    </body>
</html>