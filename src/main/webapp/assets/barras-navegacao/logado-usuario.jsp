<div>
	<header>
		<a href="#"> <img src="#" alt="hamburguer"></a>

		<div>
			<a href="#">Hamburguer</a>

			<button onclick="hamburguer()">Hamburguer</button>

			<div id="hambuguer">

				<div>
					<ol>
						<li><a href="/LugarDeFala/home">Página inicial</a></li>
						<li><a href="/LugarDeFala/perfil-comunidade">Comunidades</a></li>
						<li><a href="/LugarDeFala/#">categorias</a></li>
						<li><a href="/LugarDeFala/pesquisar-usuario">Encontrar usuários</a></li>
						<li><a href="/LugarDeFala/relatos-arquivados">Relatos arquivados</a></li>
						<li><a href="/LugarDeFala/tela-denuncias-usuarios">Denuncias</a></li>
						<li><a href="/LugarDeFala/usuario-virar-moderador">Virar moderador</a></li>
					</ol>
				</div>

			</div>

			<script>
				function hamburguer() {
					var inserir = document.getElementById("hambuguer");
					if (inserir.style.display === "none") {
						inserir.style.display = "block";
					} else {
						inserir.style.display = "none";
					}
				}
			</script>
		</div>
		
		<div>

			<button onclick="icone()">Icone</button>

			<div id="icone">

				<div>
					<ol>
						<li><a href="/LugarDeFala/perfil-usuario">Meu perfil</a></li>
						<li><a href="/LugarDeFala/tela-de-bloqueado">Bloqueados</a></li>
						<li><a href="/LugarDeFala/deletar-usuario">Excluir Conta</a></li>
						<li><a href="/LugarDeFala/desativar-perfil">Desativar Conta</a></li>
						<li><a href="/LugarDeFala/home-deslogada">Sair</a></li>
					</ol>
				</div>

			</div>

			<script>
				function icone() {
					var inserir = document.getElementById("icone");
					if (inserir.style.display === "none") {
						inserir.style.display = "block";
					} else {
						inserir.style.display = "none";
					}
				}
			</script>		
		
		</div>
	</header>
</div>