<div>
    <header>
        <a href="#"> <img src="#" alt="hamburguer"></a>

        <div>
            <a href="#">Hamburguer</a>

            <button onclick="alternarMenu('hamburguer')">Hamburguer</button>

            <div id="hamburguer" style="display: none; float: right;">

                <div>
                    <ol>
                        <li><a href="home">Página inicial</a></li>
                        <li><a href="perfil-comunidade">Comunidades</a></li>
                        <li><a href="#">categorias</a></li>
                        <li><a href="pesquisar-usuario">Encontrar usuários</a></li>
                        <li><a href="relatos-arquivados">Relatos arquivados</a></li>
                        <li><a href="tela-denuncias-usuarios">Denuncias</a></li>
                        <li><a href="usuario-virar-moderador">Virar moderador</a></li>
                    </ol>
                </div>

            </div>

            <button onclick="alternarMenu('icone')">Icone</button>

            <div id="icone" style="display: none; float: right;">

                <div>
                    <ol>
                        <li><a href="perfil-usuario">Meu perfil</a></li>
                        <li><a href="tela-de-bloqueado">Bloqueados</a></li>
                        <li><a href="deletar-usuario">Excluir Conta</a></li>
                        <li><a href="desativar-perfil">Desativar Conta</a></li>
                        <li><a href="home-deslogada">Sair</a></li>
                    </ol>
                </div>

            </div>

            <script>
                function alternarMenu(menuId) {
                    var menu = document.getElementById(menuId);
                    if (menu.style.display === "none") {
                        menu.style.display = "block";
                    } else {
                        menu.style.display = "none";
                    }
                }
            </script>
        </div>

    </header>
</div>
