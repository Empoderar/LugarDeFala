<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastrar Usuário ou Moderador</title>
    <style type="text/css"><%@ include file="/assets/css/style.css" %></style>
</head>
<body class="body-cadastro">
    <div class="moldura-cadastro">
        <form action="/LugarDeFala/inserir-usuario" onsubmit="return validarFormulario()">
            <h1>Cadastro</h1>

            <div class="input-box-c">
                <label for="nome">Nome</label>
                <input type="text" name="nome" id="nome" placeholder="Digite o seu primeiro nome" required />
            </div>

            <div class="input-box-c">
                <label for="sobrenome">Sobrenome</label>
                <input type="text" name="sobrenome" id="sobrenome" placeholder="Digite o seu sobrenome" required />
            </div>

            <div class="input-box-c">
                <label for="telefone">Telefone</label>
                <input type="tel" name="telefone" id="telefone" placeholder="(xx) xxxx-xxxx" required />
            </div>

            <div class="input-box-c">
                <label for="usuario">Nome de Usuário ou Moderador</label>
                <input type="text" name="apelido" id="apelido" placeholder="Crie o seu nome de usuário" required />
            </div>

            <div class="input-box-c">
                <label for="email">E-mail</label>
                <input type="email" name="email" id="email" placeholder="Digite o seu e-mail" required />
            </div>

            <div class="input-box-c">
                <label for="data">Data de Nascimento</label>
                <input type="date" name="data-nascimento" id="data-nascimento" placeholder="Digite a sua data de nascimento" required />
            </div>

            <div class="input-box-c">
                <label for="senha">Senha</label>
                <input type="password" name="senha" id="senha" placeholder="Crie a sua senha" required />
            </div>

            <div class="input-box-c">
                <label for="confirma-senha">Confirmar Senha</label>
                <input type="password" name="confirma-senha" id="confirma-senha" placeholder="Confirme a sua senha" required />
            </div>

            <button type="submit" class="button">Confirmar</button>

            <div class="cadastrar-link">
                <p>Já tem uma conta? <a href="/LugarDeFala/login">Entre</a></p>
            </div>
        </form>
    </div>

    <script>
        function validarFormulario() {
            var idadeEntrada = document.getElementById("data-nascimento");
            var emailEntrada = document.getElementById("email");
            var nomeEntrada = document.getElementById("nome");
            var sobrenomeEntrada = document.getElementById("sobrenome");

            var hoje = new Date();
            var dataNascimento = new Date(idadeEntrada.value);
            var idade = hoje.getFullYear() - dataNascimento.getFullYear();

            if (idade < 14) {
                alert("Você deve ter no mínimo 14 anos para se cadastrar.");
                return false;
            }

            var emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
            if (!emailRegex.test(emailEntrada.value)) {
                alert("Por favor, insira um endereço de e-mail válido no formato 'x@x.x'.");
                return false;
            }

            var senhaEntrada = document.getElementById("senha");
            var senhaPadrao = /^(?=.*[!@#$%^&*(),.?":{}|<>]).{8,}$/;

            if (!senhaPadrao.test(senhaEntrada.value)) {
                alert("A senha deve ter no mínimo 8 caracteres e conter um caractere especial.");
                return false;
            }

            if (nomeEntrada.value.length < 3 || sobrenomeEntrada.value.length < 3) {
                alert("O nome e sobrenome devem ter no mínimo 3 caracteres.");
                return false;
            }

            var confirmaSenhaEntrada = document.getElementById("confirma-senha");

            if (senhaEntrada.value !== confirmaSenhaEntrada.value) {
                alert("As senhas não coincidem. Por favor, insira senhas iguais.");
                return false;
            }

            return true;
        }
    </script>
</body>
</html>
