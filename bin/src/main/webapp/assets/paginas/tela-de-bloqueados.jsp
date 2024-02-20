<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
	<head>
 	 <title>tela-de-bloqueados</title>
	</head>
	<body>
		<div>
  			<h1>Contas Bloqueadas</h1> 
  			<p>Você pode bloquear ou desbloquear uma conta a qualquer momento.</p>
			<div>
				<c:forEach var="usario" items="${usuarios}">
					USUARIOS:
						<c:out value="${usuario.nome}"></c:out>
						<c:out value="${usario.apelido}"></c:out>
						<c:out value="${usario.descricao}"></c:out>
							<form action="desbloquear-usuario" method="post">
       							<button type="submit">Desbloquear</button>
       						</form>
				</c:forEach>
			</div>
  		<footer>
      		<div>
          		<p>Lugar de Fala</p>
          		<a href="#">Sobre nós</a>
          		<a href="#">Página inicial</a>
      		</div>
      		<div>
          		<p>Atendimento</p>
         		<a href="#">Contato</a>
          		<a href="#">Termos de uso</a>
      		</div>
     		<div>
         		<p>Redes Sociais</p>
          		<a href="#">Whatsapp</a>
          		<a href="#">Instagram</a>
     		</div>
      		<div>
          		<p>Lugar de Fala</p>
      		</div>
      		<div>
          		<p>2023 Todos os direitos reservados</p>
      		</div>
  		</footer>
		</div>
	</body>
</html>