<div>
	<header>
		<a href="#"> <img src="#" alt="hamburguer"></a>

		<div>
			<a href="#">Hamburguer</a>

			<button onclick="hamburguer()">Hamburguer</button>

			<div id="hambuguer">

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
						<li><a href="perfil-usuario">Meu perfil</a></li>
						<li><a href="tela-de-bloqueado">Bloqueados</a></li>
						<li><a href="deletar-usuario">Excluir Conta</a></li>
						<li><a href="desativar-perfil">Desativar Conta</a></li>
						<li><a href="home-deslogada">Sair</a></li>
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