<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
   		<title>Denunciar</title>
	</head>
	<body>
		<%@include file="../barras-navegacao/logada.jsp" %>
    	<div>
    		<form action="retirar-denuncia-relato" method="post">
				<c:forEach var="denuncia-relato" items="${denuncias-relatos}">
					<c:out value="${Relato de + usuario.apelido + "na comunidade " + comunidade.nome}></c:out>
<%-- 				<c:out value="${usuario.icone}"></c:out> --%>
					<c:out value="${usuario.apelido}"></c:out>
					<c:out value="${denuncia-relato.conteudo}"></c:out>
				 	<button type="submit">retirar-denuncia</button>
				</c:forEach>
			</form>	
		</div>
		<div>
    		<form action="retirar-denuncia-conselho" method="post">
				<c:forEach var="denuncia-conselho" items="${denuncias-conselhos}">
<%-- 				<c:out value="${Conselho de + usuario.apelido}></c:out> --%>
<%-- 				<c:out value="${usuario.icone}"></c:out> --%>
					<c:out value="${usuario.apelido}"></c:out>
					<c:out value="${denuncia-conselho.conteudo}"></c:out>
				 	<button type="submit">RETIRAR DENUNCIA</button>
				</c:forEach>
			</form>	
		</div>
		<div>
    		<form action="retirar-denuncia-usuario" method="post">
				<c:forEach var="denuncia-usuario" items="${denuncias-usuarios}">
				<div>
<%-- 				<c:out value="${usuario.icone}"></c:out> --%>
					<c:out value="${usuario.apelido}"></c:out>
					<c:out value="${usuario.biografia}"></c:out>
				 	<button type="submit">RETIRAR DENUNCIA</button>
				 	</div>
				</c:forEach>
			</form>	
		</div>
		<div>
    		<form action="retirar-denuncia-moderador" method="post">
				<c:forEach var="denuncia-moderador" items="${denuncias-moderador}">
				<div>
<%-- 				<c:out value="${moderador.icone}"></c:out> --%>
					<c:out value="${moderador.apelido}"></c:out>
					<c:out value="${moderador.biografia}"></c:out>
				 	<button type="submit">RETIRAR DENUNCIA</button>
				 	</div>
				</c:forEach>
			</form>	
		</div>
    	<%@include file="../rodape/rodape.jsp" %>
	</body>
</html>