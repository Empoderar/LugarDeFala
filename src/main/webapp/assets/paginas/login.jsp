<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html lang="pt-br">

  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <title>Login</title>
    <style type="text/css"><%@includefile="/assets/css/style.css"%></style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" type="text/css" href="style.css" />

  </head>
  <header>
    <img src="img/logo.svg" alt="" class="logo-lugar" />
  </header>

<body>
        <div class="moldura">
            <div class="esquerda-login">
                <img src="img/mulher.svg" alt="" class="imagem-mulher" />
            </div>
            
            <div class="direita-login">
                <div class="login-caixa">
                    <form action="/LugarDeFala/fazer-login" method="post">
                        <h1>Login</h1>
                        <div class="input-box">
                            <input type="text" placeholder="Usuário" name="email" required>
                            <i class="fa-solid fa-user"></i>
                        </div>
                        <div class="input-box">
                            <input type="password" placeholder="Senha" name="senha" required>
                            <i class="fa-solid fa-lock"></i>
                        </div>
                        <div class="lembrar-esqueceu">
                            <a href="#"></a>
                            <a href="#">Esqueceu a senha?</a>
                        </div>

                        <button type="submit" class="button">Confirmar</button>
                        <div class="cadastrar-link">
                            <p>Não tem uma conta? <a href="#">Cadastre-se</a></p>

                        </div>
                    </form>
                </div>
            </div>  
        </div>
</body>
 
<footer>
    <div id="footer_conteudo">
        <div id="footer_contatos">
            <h3>Lugar de Fala</h3>
            <p>Rede de apoio pró-mulher.</p>
            <div id="footer_rede_social">
                <a href="#" class="footer-link" id="instagram"> 
                    <i class="fa-brands fa-instagram"></i>
                    <a href="#" class="footer-link" id="linkedin"> 
                        <i class="fa-brands fa-linkedin"></i>
                    </a>
                    <a href="#" class="footer-link" id="github"> 
                        <i class="fa-brands fa-github"></i>
                    </a>
                </a>
            </div>
        </div>
        <ul class="footer-lista">
            <li>
                <h4>Lugar de Fala</h4>
            </li>
            <li>
                <a href="#" class="footer-link">Sobre Nós</a>
            </li>
            <li>
                <a href="#" class="footer-link">Página inicial</a>
            </li>
        </ul>
        <ul class="footer-lista">
            <li>
                <h3>Atendimento</h3>
            </li>
            <li>
                <a href="#" class="footer-link">Contato</a>
            </li>
            <li>
                <a href="#" class="footer-link">Termos de uso</a>
            </li>
        </ul>
        <ul class="footer-lista">
            <li>
               <h3>Redes Sociais</h3>
            </li>
            <li>
                <a href="#" class="footer-link">Whatsapp</a>
            </li>
            <li>
                <a href="#" class="footer-link">Instagram</a>
            </li>
        </ul>
    </div>
    <div id="footer-copyright">
       <h4>2024 todos os direitos reservados.</h4>
    </div>

</footer>
 
</html>
