<div>
	<header>
		<button onclick="alternarMenu('icone')">Icone</button>

            <div id="icone" style="display: none; float: right;">

                <div>
                    <ol>
                        <li><a href="/LugarDeFala/perfil-usuario">Meu perfil</a></li>
                        <li><a href="/LugarDeFala/tela-de-bloqueado">Bloqueados</a></li>
                        <li><a href="/LugarDeFala/deletar-usuario">Excluir Conta</a></li>
                        <li><a href="/LugarDeFala/desativar-perfil">Desativar Conta</a></li>
                        <li><a href="/LugarDeFala/home">Sair</a></li>
                    </ol>
                </div>
            </div>
		<!-- uma setinha de voltar aqui --><c:out value="${usuario.apelido}"></c:out>
	</header>
</div>