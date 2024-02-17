<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>tela-de-pesquisa</title>
</head>
<body>
	<form action="/perfil-usuario" method="post">
		<input type="text" placeholder="pesquisar">
		<c:out value="${comunidades.nome} "/>
		<button>ok</button>
	</form>
</body>
</html>