<div>
	<header>
         <c:if test="${usuario == null}">
            <a href="/LugarDeFala/login"> FA�A SEU RELATO</a>
        </c:if>
        <c:if test="${usuario != null}">
            <a href="/LugarDeFala/cadastro-relato">FA�A SEU RELATO</a>
        </c:if>
        <a href="/LugarDeFala/cadastro-usuario">CADASTRE-SE</a>
        <a href="/LugarDeFala/perfil-comunidade">COMUNIDADES</a>
        <a href="/LugarDeFala/login">ENTRAR</a>
	</header>
</div>