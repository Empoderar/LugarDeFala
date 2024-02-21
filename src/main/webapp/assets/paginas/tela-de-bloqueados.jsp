<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
	<head>
 	 <title>tela-de-bloqueados</title>
 	 <style type="text/css"><%@includefile="/assets/css/style.css"%></style>
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
		</div>
    		<%@include file="/assets/rodape/rodape.jsp" %>
	</body>
</html>