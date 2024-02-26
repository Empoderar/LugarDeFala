<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Login</title>
<style type="text/css">
<%@include file="/assets/css/style.css"%>
</style>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
	<div class="moldura">
		<div class="esquerda-login">
			<img src="img/mulher.svg" alt="" class="imagem-mulher" />
		</div>

		<div class="direita-login">
			<div class="login-caixa">
				<form action="/LugarDeFala/fazer-login" method="post">
					<h1>Login</h1>

					<c:if test="${not empty requestScope.erroLogin}">
						<div class="erro-login">
							<p>${requestScope.erroLogin}</p>
						</div>
					</c:if>

					<div class="input-box">
						<input type="text" placeholder="Email" name="email" required>
						<i class="fa-solid fa-user"></i>
					</div>
					<div class="input-box">
   						 <input type="password" placeholder="Senha" name="senha" id="senha" required>
   						 <i class="fa-solid fa-lock" id="iconeCadeado" onclick="mostrarSenha('senha', 'iconeCadeado')"></i>
					</div>
					<div class="lembrar-esqueceu">
						<a href="#"></a> <a href="#">Esqueceu a senha?</a>
					</div>

					<button
						href="/LugarDeFala/home-logada"
						type="submit" class="button">Confirmar</button>
					<div class="cadastrar-link">
						<p>
							Não tem uma conta? <a href="/LugarDeFala/cadastro-usuario">Cadastre-se</a>
						</p>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script>
	function mostrarSenha(idCampoSenha, idIcone) {
	    var campoSenha = document.getElementById(idCampoSenha);
	    var icone = document.getElementById(idIcone);

	    if (campoSenha.type === "password") {
	        campoSenha.type = "text";
	        icone.classList.remove("fa-eye");
	        icone.classList.add("fa-eye-slash");
	    } else {
	        campoSenha.type = "password";
	        icone.classList.remove("fa-eye-slash");
	        icone.classList.add("fa-eye");
	    }
	}
	</script>
</body>
</html>
