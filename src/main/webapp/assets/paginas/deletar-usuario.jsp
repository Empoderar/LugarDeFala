<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>

            <meta charset="UTF-8">

            <meta name="viewport" content="width=device-width, initial-scale=1.0">

            <title>Excluir Conta</title>

            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
                integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
                crossorigin="anonymous" referrerpolicy="no-referrer" />

            <link rel="stylesheet" type="text/css" href="../css/style.css" />


        </head>

        <body>
            <%@ include file="/assets/barras-navegacao/barra-de-navegacao.jsp" %>

                <div>
                    <div class="deletar-usuario">

                        <h1>Excluir a conta</h1>

                        <div>

                            <h2>Ao prosseguir você excluirá permanentemente sua conta</h2>
                            <div class="ao-prosseguir">

                                <p>Ao excluir sua conta você não poderá ativar ou usar ela no
                                    futuro, depois de excluir sua conta Lugar de Fala não será mais
                                    possível ver relatos e conselhos, acessar comunidades ou postar
                                    relatos. Se ainda deseja excluir sua conta clique no botão “excluir”
                                    no canto inferior direito da página.</p>

                            </div>
                            <h3>Mais informações</h3>

                            <div class="ao-prosseguir">

                                <p>Você pode arquivar sua conta Lugar de Fala ao invés de
                                    excluí-la permanentemente, para arquivar sua conta vá em “Arquivar
                                    Conta”.</p>

                                <p>Você não poderá recuperar sua conta depois de excluí-la</p>

                            </div>

                            <div>
                                <button class="button" type="#">Excluir a conta</button>
                            </div>
                        </div>

                        <div class="confirmar-senha">

                            <form action="/LugarDeFala/metodo-deletar-usuario" method="post">

                                <p>Confirme sua senha para excluir a conta</p>

                                <div>
                                    <input type="password" name="senha" id="senha" required maxlength="20"
                                        placeholder="Digite a senha">
                                </div>

                                <div>
                                    <a href="recuperar-senha.html" class="esqueceu-senha">Esqueci minha senha</a>
                                </div>

                                <button class="button" type="submit">Excluir</button>

                            </form>

                        </div>

                        <div class="deletar-usuario-concluido">
                                <div>
                                    <svg width="170" height="170" viewBox="0 0 170 170" fill="none"
                                        xmlns="http://www.w3.org/2000/svg">
                                        <path
                                            d="M85 168C130.84 168 168 130.84 168 85C168 39.1604 130.84 2 85 2C39.1604 2 2 39.1604 2 85C2 130.84 39.1604 168 85 168Z"
                                            stroke="#F9866F" stroke-width="2.5" stroke-miterlimit="10"
                                            stroke-linecap="round" stroke-linejoin="round" />
                                        <path d="M134.625 55.5566L62.1967 127.985L39.2188 105.007" stroke="#F9866F"
                                            stroke-width="2.5" stroke-miterlimit="10" stroke-linecap="round"
                                            stroke-linejoin="round" />
                                    </svg>

                                </div>
                                <p>Conta excluída com sucesso!</p>
                                <button type="submit">Ok!</button>
                        </div>

                    </div>
                </div>
                <%@include file="/assets/rodape/rodape.jsp" %>
        </body>

        </html>
