package br.senac.lugardefala.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senac.lugardefala.modelo.dao.categoria.CategoriaDAO;
import br.senac.lugardefala.modelo.dao.categoria.CategoriaDAOImpl;
import br.senac.lugardefala.modelo.dao.comunidade.ComunidadeDAO;
import br.senac.lugardefala.modelo.dao.comunidade.ComunidadeDAOImpl;
import br.senac.lugardefala.modelo.dao.conselho.ConselhoDAO;
import br.senac.lugardefala.modelo.dao.conselho.ConselhoDAOImpl;
import br.senac.lugardefala.modelo.dao.contato.ContatoDAO;
import br.senac.lugardefala.modelo.dao.contato.ContatoDAOImpl;
import br.senac.lugardefala.modelo.dao.denuncia.conselho.DenunciaConselhoDAO;
import br.senac.lugardefala.modelo.dao.denuncia.conselho.DenunciaConselhoDAOImpl;
import br.senac.lugardefala.modelo.dao.denuncia.moderador.DenunciaModeradorDAO;
import br.senac.lugardefala.modelo.dao.denuncia.moderador.DenunciaModeradorDAOImpl;
import br.senac.lugardefala.modelo.dao.denuncia.relato.DenunciaRelatoDAO;
import br.senac.lugardefala.modelo.dao.denuncia.relato.DenunciaRelatoDAOImpl;
import br.senac.lugardefala.modelo.dao.denuncia.usuario.DenunciaUsuarioDAO;
import br.senac.lugardefala.modelo.dao.denuncia.usuario.DenunciaUsuarioDAOImpl;
import br.senac.lugardefala.modelo.dao.moderador.ModeradorDAO;
import br.senac.lugardefala.modelo.dao.moderador.ModeradorDAOImpl;
import br.senac.lugardefala.modelo.dao.relato.RelatoDAO;
import br.senac.lugardefala.modelo.dao.relato.RelatoDAOImpl;
import br.senac.lugardefala.modelo.dao.usuario.UsuarioDAO;
import br.senac.lugardefala.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.lugardefala.modelo.entidade.categoria.Categoria;
import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.conselho.Conselho;
import br.senac.lugardefala.modelo.entidade.contato.Contato;
import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaConselho;
import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaModerador;
import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaRelato;
import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaUsuario;
import br.senac.lugardefala.modelo.entidade.moderador.Moderador;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;
import br.senac.lugardefala.modelo.enumeracao.Status;

@WebServlet("/")

public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private UsuarioDAO usuarioDao;

	private ModeradorDAO moderadorDao;

	private ComunidadeDAO comunidadeDao;

	private ContatoDAO contatoDao;

	private RelatoDAO relatoDao;

	private ConselhoDAO conselhoDao;

	private DenunciaConselhoDAO denunciaConselhoDao;

	private DenunciaModeradorDAO denunciaModeradorDao;

	private DenunciaRelatoDAO denunciaRelatoDao;

	private DenunciaUsuarioDAO denunciaUsuarioDao;

	private CategoriaDAO categoriaDao;

	public void init() {

		moderadorDao = new ModeradorDAOImpl();

		comunidadeDao = new ComunidadeDAOImpl();

		contatoDao = new ContatoDAOImpl();

		relatoDao = new RelatoDAOImpl();

		conselhoDao = new ConselhoDAOImpl();

		denunciaConselhoDao = new DenunciaConselhoDAOImpl();

		denunciaModeradorDao = new DenunciaModeradorDAOImpl();

		denunciaRelatoDao = new DenunciaRelatoDAOImpl();

		denunciaUsuarioDao = new DenunciaUsuarioDAOImpl();

		categoriaDao = new CategoriaDAOImpl();

		usuarioDao = new UsuarioDAOImpl();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		doGet(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (usuario instanceof Usuario) {
			String usuarioLogado = "1";
			request.setAttribute("usuarioLogado", usuarioLogado);
		}

		else if (usuario instanceof Moderador) {
			String moderadorLogado = "2";
			request.setAttribute("moderadorLogado", moderadorLogado);
		} else {
			String usuarioDeslogado = "3";
			request.setAttribute("usuarioDeslogado", "usuarioDeslogado");
		}

		String action = request.getServletPath();

		try {

			switch (action) {

			case "/cadastro-usuario": // funcionando-dinâmico

				mostrarTelaCadastroUsuario(request, response);

				break;

			case "/cadastro-moderador": // funcionando-dinâmico

				mostrarTelaCadastroModerador(request, response);

				break;

			case "/cadastro-comunidade": // funcionando-dinâmico

				mostrarTelaCadastroComunidade(request, response);

				break;

			case "/cadastro-categoria": // funcionando-dinâmico

				mostrarTelaCadastroCategoria(request, response);

				break;

			case "/cadastro-conselho": // funcionando-dinâmico

				mostrarTelaCadastroConselho(request, response);

				break;

			case "/cadastro-relato": // funcionando-dinâmico

				mostrarTelaCadastroRelato(request, response);

				break;

			case "/form-moderador": // funcionando

				mostrarTelaFormularioModerador(request, response);

				break;

			case "/login": // funcionando-dinâmico

				mostrarTelaLoginUsuario(request, response);

				break;

			case "/": // funcionando

				mostrarHome(request, response);

				break;

			case "/perfil-usuario": // funcionando

				mostrarTelaPerfilDoUsuario(request, response);

				break;

			case "/perfil-moderador": // em teste

				mostrarTelaPerfilDoModerador(request, response);

				break;

			case "/perfil-comunidade": // funcionando

				mostrarTelaPerfilDaComunidade(request, response);

				break;

			case "/tela-relatos": // funcionando

				mostrarTelaRelatos(request, response);

				break;

			case "/tela-conselhos": // funcionando

				mostrarTelaConselhos(request, response);

				break;

			case "/tela-denuncias": // funcionando

				mostrarTelaDenuncias(request, response);

				break;

			case "/denuncia-conselho": // funcionando

				mostrarTelaDenunciaConselho(request, response);

				break;

			case "/denuncia-moderador": // funcionando

				mostrarTelaDenunciaModerador(request, response);

				break;

			case "/denuncia-relato": // funcionando

				mostrarTelaDenunciaRelato(request, response);

				break;

			case "/denuncia-usuario": // funcionando

				mostrarTelaDenunciaUsuario(request, response);

				break;

			case "/desativar-conta": // funcionando

				mostrarTelaDesativarConta(request, response);

				break;

			case "/deletar-usuario": // funcionando

				mostrarTelaDeletarUsuario(request, response);

				break;

			case "/deletar-moderador": // precisa testar

				mostrarTelaDeletarModerador(request, response);

				break;

			case "/deletar-comunidade": // precisa testar

				mostrarTelaDeletarComunidade(request, response);

				break;

			case "/editar-perfil": // funcionando

				mostrarTelaEditarPerfil(request, response);

				break;

			case "/editar-relato": // funcionando

				mostrarTelaEditarRelato(request, response);

				break;

			case "/editar-senha": // em teste

				mostrarTelaEditarSenha(request, response);

				break;

			case "/pesquisar-usuario": // funcionando
				mostrarTelaPesquisarUsuario(request, response);

				break;
				
			case "/resultado-pesquisar-usuario": // precisa testar
				resultadoPesquisarUsuario(request, response);
				
				break;
				
			case "/pesquisar-comunidade": // precisa testar
				mostrarTelaPesquisarComunidade(request, response);
				
				break;

			case "/resultado-pesquisar-comunidade": // funcionando
				resultadoPesquisarComunidade(request, response);

				break;

			case "/inserir-usuario": // salvando

				inserirUsuario(request, response);

				break;

			case "/fazer-login": // precisa arrumar com moderador

				fazerLogin(request, response);

				break;

			case "/inserir-relato": // salvando

				inserirRelato(request, response);

				break;

			case "/inserir-conselho": // salvando

				inserirConselho(request, response);

				break;

			case "/inserir-comunidade": // salvando

				inserirComunidade(request, response);

				break;

			case "/inserir-categoria": // salvando

				inserirCategoria(request, response);

				break;

			case "/inserir-moderador": // salvando

				inserirModerador(request, response);

				break;

			case "/inserir-denuncia-de-conselho": // salvando

				inserirDenunciaConselho(request, response);

				break;

			case "/inserir-denuncia-de-moderador": // salvando

				inserirDenunciaModerador(request, response);

				break;

			case "/inserir-denuncia-de-relato": // salvando

				inserirDenunciaRelato(request, response);

				break;

			case "/inserir-denuncia-de-usuario": // salvando

				inserirDenunciaUsuario(request, response);

				break;

			case "/metodo-deletar-usuario": // precisa testar

				deletarUsuario(request, response);

				break;

			case "/metodo-deletar-moderador": // precisa ser feito

				deletarModerador(request, response);

				break;

			case "/metodo-deletar-comunidade": // precisa ser feito

				deletarComunidade(request, response);

				break;

			case "/deletar-relato": // precisa ser feito

				deletarRelato(request, response);

				break;

			case "/deletar-conselho": // precisa ser feito

				deletarConselho(request, response);

				break;

			case "/metodo-editar-perfil": // precisa ser feito

				editarPerfil(request, response);

				break;

			case "/metodo-editar-senha": // em teste

				editarSenha(request, response);

				break;

			case "/atualizar-comunidade": // precisa ser feito

				atualizarComunidade(request, response);

				break;

			case "/metodo-editar-relato": // precisa ser feito

				editarRelato(request, response);

				break;

			case "/atualizar-conselho": // precisa ser feito

				atualizarConselho(request, response);

				break;

			case "/logout": // em ajuste

				logout(request, response);

				break;

			case "/metodo-desativar-conta": // precisa testar

				desativarConta(request, response);

				break;

			default:

				mostrarTelaDeErro(request, response);

				break;

			}

		} catch (SQLException ex) {

			request.setAttribute("erro", ex.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/tela-de-erro.jsp");
			dispatcher.forward(request, response);

		}

	}

	private void resultadoPesquisarUsuario(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    String termoPesquisa = request.getParameter("pesquisar");
	    List<Usuario> usuarios = usuarioDao.recuperarUsuariosPorNomes(termoPesquisa);
	    request.setAttribute("usuarios", usuarios);

	    RequestDispatcher dispatcher = request.getRequestDispatcher("/assets/paginas/pesquisar-usuario.jsp");
	    dispatcher.forward(request, response);
	}

	private void mostrarTelaPesquisarUsuario(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");

		if (usuario instanceof Usuario) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("./assets/paginas/pesquisar-usuario.jsp");
			dispatcher.forward(request, response);

		} else if (usuario instanceof Moderador) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("./assets/paginas/pesquisar-usuario.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void resultadoPesquisarComunidade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String termoPesquisa = request.getParameter("pesquisar");
		List<Comunidade> comunidades = comunidadeDao.recuperarComunidadesPorNome(termoPesquisa);
		request.setAttribute("comunidades", comunidades);

		RequestDispatcher dispatcher = request.getRequestDispatcher("./assets/paginas/pesquisar-comunidade.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarTelaPesquisarComunidade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");

		if (usuario instanceof Moderador) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("./assets/paginas/pesquisar-comunidade.jsp");
			dispatcher.forward(request, response);

		} else if (usuario instanceof Usuario) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("./assets/paginas/pesquisar-comunidade.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarTelaCadastroUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("./assets/paginas/cadastro-usuario.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarTelaCadastroModerador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cadastro-moderador.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarTelaCadastroComunidade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");

		if (usuario instanceof Moderador) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cadastro-comunidade.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cadastro-moderador.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarTelaCadastroRelato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");

		List<Categoria> categorias = categoriaDao.recuperarTodasCategorias();
		LocalDate dataAtual = LocalDate.now();

		request.setAttribute("categorias", categorias);
		request.setAttribute("dataAtual", dataAtual);

		if (usuario instanceof Usuario) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cadastro-relato.jsp");
			dispatcher.forward(request, response);

		} else if (usuario instanceof Moderador) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cadastro-relato.jsp");
			dispatcher.forward(request, response);
		}

	}

	private void mostrarTelaFormularioModerador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");

		if (usuario instanceof Moderador) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/form-moderador.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarTelaLoginUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/login.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarHome(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/home.jsp");
		dispatcher.forward(request, response);

	}

	private void mostrarTelaPerfilDoUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");

		if (usuario instanceof Usuario) {

			List<Comunidade> comunidades = comunidadeDao.recuperarComunidadesPorUsuario(usuario);
			request.setAttribute("comunidades", comunidades);

			List<Relato> relatos = relatoDao.recuperarRelatosPorUsuario(usuario);
			request.setAttribute("relatos", relatos);

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/perfil-usuario.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cadastro-usuario.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarTelaPerfilDoModerador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");

		if (usuario instanceof Moderador) {
			String descricao = request.getParameter("descricao");
			usuario.setDescricao(descricao);

			List<Comunidade> comunidades = comunidadeDao.recuperarComunidadesPorUsuario(usuario);
			request.setAttribute("comunidades", comunidades);

			List<Relato> relatos = relatoDao.recuperarRelatosPorUsuario(usuario);
			request.setAttribute("relatos", relatos);

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/perfil-moderador.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cadastro-moderador.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarTelaPerfilDaComunidade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Comunidade comunidade = comunidadeDao.recuperarComunidadePorId(Long.parseLong(request.getParameter("id")));
		List<Relato> relatos = relatoDao.recuperarRelatosPorComunidade(comunidade);

		request.setAttribute("comunidade", comunidade);
		request.setAttribute("relatos", relatos);

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/perfil-comunidade.jsp");
			dispatcher.forward(request, response);


	}

	private void mostrarTelaDeErro(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/tela-de-erro.jsp");

		dispatcher.forward(request, response);

	}

	private void mostrarTelaConselhos(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");

		if (usuario instanceof Usuario) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/tela-conselhos.jsp");
			dispatcher.forward(request, response);
		} else if (usuario instanceof Moderador) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/tela-conselhos.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarTelaCadastroCategoria(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");

		if (usuario instanceof Moderador) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cadastro-categoria.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarTelaCadastroConselho(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");

		if (usuario instanceof Usuario) {
			List<Relato> relatos = relatoDao.recuperarRelatosPorUsuario(usuario);

			request.setAttribute("usuario", usuario);
			request.setAttribute("relatos", relatos);

			for (Relato r : relatos) {
				System.out.println("Conteúdo dos relatos: " + r.getConteudo());
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cadastro-conselho.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarTelaDenuncias(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");

		if (usuario instanceof Moderador) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/tela-denuncias.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarTelaDenunciaConselho(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");

		if (usuario instanceof Usuario) {
			Conselho conselho = (Conselho) request.getSession().getAttribute("conselho");
			LocalDate dataAtual = LocalDate.now();

			Status status = Status.PENDENTE;

			request.setAttribute("usuario", usuario);
			request.setAttribute("conselho", conselho);
			request.setAttribute("dataAtual", dataAtual);
			request.setAttribute("status", status);

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/denuncia-conselho.jsp");
			dispatcher.forward(request, response);
		} else if (usuario instanceof Moderador) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/denuncia-conselho.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarTelaDenunciaModerador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		Moderador moderador = (Moderador) sessao.getAttribute("moderador");

		if (usuario instanceof Usuario) {
			LocalDate dataAtual = LocalDate.now();
			Status status = Status.PENDENTE;

			request.setAttribute("usuario", usuario);
			request.setAttribute("moderador", moderador);
			request.setAttribute("dataAtual", dataAtual);
			request.setAttribute("status", status);

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/denuncia-moderador.jsp");
			dispatcher.forward(request, response);
		} else if ((usuario instanceof Moderador)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/denuncia-moderador.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarTelaDenunciaRelato(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");

		if (usuario instanceof Usuario) {

			Relato relato = (Relato) sessao.getAttribute("relato");
			LocalDate dataAtual = LocalDate.now();
			Status status = Status.APROVADO;

			request.setAttribute("usuario", usuario);
			request.setAttribute("relato", relato);
			request.setAttribute("dataAtual", dataAtual);
			request.setAttribute("status", status);

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/denuncia-relato.jsp");
			dispatcher.forward(request, response);

		} else if (usuario instanceof Moderador) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/denuncia-relato.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarTelaDenunciaUsuario(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuarioDenunciante = (Usuario) sessao.getAttribute("usuarioLogado");
		Usuario usuarioDenunciado = (Usuario) sessao.getAttribute("usuario");

		if (usuarioDenunciante instanceof Usuario) {

			LocalDate dataAtual = LocalDate.now();
			Status status = Status.APROVADO;

			request.setAttribute("usuarioDenunciante", usuarioDenunciante);
			request.setAttribute("usuarioDenunciado", usuarioDenunciado);
			request.setAttribute("dataAtual", dataAtual);
			request.setAttribute("status", status);

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/denuncia-usuario.jsp");
			dispatcher.forward(request, response);
		} else if (usuarioDenunciante instanceof Moderador) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/denuncia-usuario.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarTelaDesativarConta(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		if (usuario instanceof Usuario) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/desativar-conta.jsp");
			dispatcher.forward(request, response);
		} else if (usuario instanceof Moderador) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/desativar-conta.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarTelaDeletarUsuario(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		if (usuario instanceof Usuario) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/deletar-usuario.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarTelaDeletarModerador(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		if (usuario instanceof Moderador) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/deletar-moderador.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarTelaDeletarComunidade(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		
		List<Comunidade> comunidades = comunidadeDao.recuperarTodasComunidades();
		request.setAttribute("comunidades", comunidades);
		
		
		if (usuario instanceof Moderador) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/deletar-comunidade.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarTelaEditarPerfil(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/editar-perfil.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarTelaEditarRelato(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		if (usuario instanceof Usuario) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/editar-relato.jsp");
			dispatcher.forward(request, response);
		} else if (usuario instanceof Moderador) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/editar-relato.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarTelaEditarSenha(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		if (usuario instanceof Usuario) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/editar-senha.jsp");
			dispatcher.forward(request, response);

		} else if (usuario instanceof Moderador) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/editar-senha.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarTelaRelatos(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		if (usuario instanceof Usuario) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/tela-relatos.jsp");
			dispatcher.forward(request, response);
		} else if (usuario instanceof Moderador) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/tela-relatos.jsp");
			dispatcher.forward(request, response);
		}

	}

	private void fazerLogin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		HttpSession sessao = request.getSession();

		if (!usuarioDao.verificarCredenciaisUsuario(email, senha)) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/login.jsp");
			dispatcher.forward(request, response);
		}

		Usuario usuario = usuarioDao.obterUsuarioPorCredenciais(email, senha);
		sessao.setAttribute("usuarioLogado", usuario);

		if (usuario instanceof Moderador) {

			request.getRequestDispatcher("assets/paginas/home.jsp").forward(request, response);

		} else {
			request.getRequestDispatcher("assets/paginas/home.jsp").forward(request, response);
		}

	}

	private void inserirUsuario(HttpServletRequest request, HttpServletResponse response)

			throws SQLException, IOException, ServletException {

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		LocalDate dataNascimento = LocalDate.parse(request.getParameter("data-nascimento"));
		String apelido = request.getParameter("apelido");
		String senha = request.getParameter("senha");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");

		Usuario usuarioParaInserir = new Usuario(nome, sobrenome, dataNascimento, apelido, senha);
		Contato contatoParaInserir = new Contato(telefone, email);
		usuarioParaInserir.setContato(contatoParaInserir);

		contatoDao.inserir(contatoParaInserir);
		usuarioDao.inserir(usuarioParaInserir);

		RequestDispatcher dispatcher = request.getRequestDispatcher("./assets/paginas/login.jsp");
		dispatcher.forward(request, response);

	}

	private void inserirModerador(HttpServletRequest request, HttpServletResponse response)

			throws SQLException, IOException, ServletException {

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		LocalDate dataNascimento = LocalDate.parse(request.getParameter("data-nascimento"));
		String apelido = request.getParameter("apelido");
		String senha = request.getParameter("senha");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");

		Moderador moderadorParaInserir = new Moderador(nome, sobrenome, dataNascimento, apelido, senha);
		Contato contatoParaInserir = new Contato(telefone, email);
		moderadorParaInserir.setContato(contatoParaInserir);

		contatoDao.inserir(contatoParaInserir);
		moderadorDao.inserir(moderadorParaInserir);

		RequestDispatcher dispatcher = request.getRequestDispatcher("./assets/paginas/login.jsp");
		dispatcher.forward(request, response);

	}

	private void inserirRelato(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		try {
			String conteudo = request.getParameter("conteudo");
			LocalDate dataAtual = LocalDate.now();

			Relato relatoParaInserir = new Relato(usuario, conteudo, dataAtual);

			relatoDao.inserir(relatoParaInserir);

			List<Categoria> categorias = categoriaDao.recuperarTodasCategorias();

			request.setAttribute("categorias", categorias);
			request.setAttribute("dataAtual", dataAtual);
			request.setAttribute("relato", relatoParaInserir);
			request.setAttribute("conteudo", conteudo);

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/perfil-comunidade.jsp");
			dispatcher.forward(request, response);

			System.out.println("Relato inserido com sucesso.");

		} catch (Exception e) {
			System.out.println("Erro ao inserir relato: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private void inserirCategoria(HttpServletRequest request, HttpServletResponse response)

			throws SQLException, IOException, ServletException {

		String nome = request.getParameter("nome");
		Categoria categoria = new Categoria(nome);

		categoriaDao.inserir(categoria);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/assets/paginas/cadastro-relato.jsp");
		dispatcher.forward(request, response);

	}

	private void inserirComunidade(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		Moderador moderador = (Moderador) session.getAttribute("usuarioLogado");

		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");

		Comunidade comunidadeParaInserir = new Comunidade(moderador, nome, descricao);

		comunidadeDao.inserir(comunidadeParaInserir);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/assets/paginas/perfil-comunidade.jsp");
		dispatcher.forward(request, response);
	}

	private void inserirConselho(HttpServletRequest request, HttpServletResponse response)

			throws SQLException, IOException, ServletException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");

		String conteudo = request.getParameter("conteudo");
		LocalDate dataAtual = LocalDate.now();

		Conselho conselhoParaInserir = new Conselho(usuario, conteudo, dataAtual);

		conselhoDao.inserir(conselhoParaInserir);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/assets/paginas/tela-conselhos.jsp");
		dispatcher.forward(request, response);

	}

	private void inserirDenunciaConselho(HttpServletRequest request, HttpServletResponse response)

			throws SQLException, IOException, ServletException {

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

		String motivo = request.getParameter("motivo");

		Conselho conselho = (Conselho) request.getSession().getAttribute("conselho");

		DenunciaConselho denunciaConselhoParaInserir = new DenunciaConselho(LocalDate.now(), motivo, Status.PENDENTE,

				usuario, conselho);

		denunciaConselhoDao.inserir(denunciaConselhoParaInserir);

		request.setAttribute("usuario", usuario);

		request.setAttribute("conselho", conselho);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/assets/paginas/tela-denuncias.jsp");

		dispatcher.forward(request, response);

	}

	private void inserirDenunciaModerador(HttpServletRequest request, HttpServletResponse response)

			throws SQLException, IOException, ServletException {

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

		String motivo = request.getParameter("motivo");

		Moderador moderador = (Moderador) request.getSession().getAttribute("moderador");

		DenunciaModerador denunciaModeradorParaInserir = new DenunciaModerador(LocalDate.now(), motivo, Status.PENDENTE,

				usuario, moderador);

		denunciaModeradorDao.inserir(denunciaModeradorParaInserir);

		request.setAttribute("usuario", usuario);

		request.setAttribute("moderador", moderador);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/assets/paginas/tela-denuncias.jsp");

		dispatcher.forward(request, response);

	}

	private void inserirDenunciaRelato(HttpServletRequest request, HttpServletResponse response)

			throws SQLException, IOException, ServletException {

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		String motivo = request.getParameter("motivo");

		Relato relato = (Relato) request.getSession().getAttribute("relato");

		DenunciaRelato denunciaRelatoParaInserir = new DenunciaRelato(LocalDate.now(), motivo, Status.APROVADO,

				usuario, relato);

		denunciaRelatoDao.inserir(denunciaRelatoParaInserir);

		request.setAttribute("usuario", usuario);

		request.setAttribute("Relato", relato);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/assets/paginas/tela-denuncias.jsp");

		dispatcher.forward(request, response);

	}

	private void inserirDenunciaUsuario(HttpServletRequest request, HttpServletResponse response)

			throws SQLException, IOException, ServletException {

		Usuario usuarioDenunciante = (Usuario) request.getSession().getAttribute("usuarioDenunciante");

		String motivo = request.getParameter("motivo");

		Usuario usuarioDenunciado = (Usuario) request.getSession().getAttribute("usuarioDenunciado");

		DenunciaUsuario denunciaUsuarioParaInserir = new DenunciaUsuario(LocalDate.now(), motivo, Status.APROVADO,
				usuarioDenunciante, usuarioDenunciado);

		denunciaUsuarioDao.inserir(denunciaUsuarioParaInserir);

		request.setAttribute("usuarioDenunciante", usuarioDenunciante);

		request.setAttribute("usuarioDenunciado", usuarioDenunciado);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/assets/paginas/tela-denuncias.jsp");

		dispatcher.forward(request, response);

	}

	private void editarPerfil(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String descricao = request.getParameter("descricao");
		String apelido = request.getParameter("apelido");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");

		usuario.setNome(nome);
		usuario.setSobrenome(sobrenome);
		usuario.setDescricao(descricao);
		usuario.setApelido(apelido);

		Contato contato = usuario.getContato();
		contato.setEmail(email);
		contato.setTelefone(telefone);
		usuario.setContato(contato);

		usuarioDao.atualizar(usuario);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/assets/paginas/perfil-usuario.jsp");
		dispatcher.forward(request, response);
	}

	private void editarSenha(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuarioParaAtualizar = (Usuario) sessao.getAttribute("usuario");
		String senha = request.getParameter("senha");
		usuarioParaAtualizar.setSenha(senha);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/assets/paginas/perfil-usuario.jsp");
		dispatcher.forward(request, response);
	}

	private void atualizarComunidade(HttpServletRequest request, HttpServletResponse response)

			throws SQLException, IOException {

		long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		Comunidade comunidadeParaAtualizar = new Comunidade(id, nome, descricao);

		comunidadeDao.atualizar(comunidadeParaAtualizar);

		response.sendRedirect("perfil-comunidade.jsp");

	}

	private void editarRelato(HttpServletRequest request, HttpServletResponse response) {

		String conteudo = request.getParameter("conteudo");

		Relato relatoParaAtualizar = new Relato(conteudo);

		relatoDao.atualizar(relatoParaAtualizar);

	}

	private void atualizarConselho(HttpServletRequest request, HttpServletResponse response) {

		long id = Long.parseLong(request.getParameter("id"));
		String conteudo = request.getParameter("conteudo");
		Integer avaliacaoBoa = Integer.parseInt(request.getParameter("avaliacao"));
		Integer avaliacaoRuim = Integer.parseInt(request.getParameter("avaliacao"));
		LocalDate data = LocalDate.parse(request.getParameter("data"));
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String apelido = request.getParameter("apelido");
		Integer avaliacao = Integer.parseInt(request.getParameter("avaliacao"));
		Status status = Status.valueOf(request.getParameter("status"));
		Conselho conselhoParaAtualizar = new Conselho(id, conteudo, avaliacaoBoa, avaliacaoRuim, data);

		conselhoDao.atualizar(conselhoParaAtualizar);
		Usuario usuarioParaAtualizar = new Usuario(nome, sobrenome, apelido);
		usuarioDao.atualizar(usuarioParaAtualizar);
		Relato relatoParaAtualizar = new Relato(conteudo, data, avaliacao, status);
		relatoDao.atualizar(relatoParaAtualizar);

		conselhoParaAtualizar.setUsuario(usuarioParaAtualizar);
		conselhoParaAtualizar.setRelato(relatoParaAtualizar);

	}

	private void deletarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		HttpSession session = request.getSession();
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");

		if (usuarioLogado instanceof Usuario) {

			Contato contatoUsuarioLogado = usuarioLogado.getContato();
			String senhaDoUsuario = usuarioLogado.getSenha();
			String senhaDigitada = request.getParameter("senha");

			if (senhaDigitada.equals(senhaDoUsuario)) {
				usuarioDao.deletar(usuarioLogado);
				contatoDao.deletar(contatoUsuarioLogado);
				session.invalidate();
				RequestDispatcher dispatcher = request.getRequestDispatcher("/assets/paginas/home.jsp");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/assets/paginas/deletar-usuario.jsp");
				dispatcher.forward(request, response);
				System.out.println("Senhas incompatíveis");
			}
		}
	}

	private void deletarModerador(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		HttpSession session = request.getSession();
		Moderador moderadorLogado = (Moderador) session.getAttribute("moderador");

		if (moderadorLogado != null) {
			Contato contatoModeradorLogado = moderadorLogado.getContato();

			String senhaDoModerador = moderadorLogado.getSenha();
			String senhaDigitada = request.getParameter("senha");

			if (senhaDigitada.equals(senhaDoModerador)) {
				moderadorDao.deletar(moderadorLogado);
				contatoDao.deletar(contatoModeradorLogado);
				session.invalidate();
				response.sendRedirect(request.getContextPath() + "/home.jsp");
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/assets/paginas/tela-de-erro.jsp");
				dispatcher.forward(request, response);
				System.out.println("Senhas incompatíveis");
			}
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/assets/paginas/home.jsp");
			dispatcher.forward(request, response);
			System.out.println("Não foi possível realizar a exclusão: moderador não está logado");

		}
	}

	private void deletarComunidade(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		HttpSession session = request.getSession();
		Comunidade comunidadeExistente = comunidadeDao.recuperarComunidadePorId(Long.parseLong(request.getParameter("idComunidade")));
		Moderador moderadorLogado = (Moderador) session.getAttribute("moderador");

		if (comunidadeExistente != null && moderadorLogado != null) {
			List<Relato> relatosComunidadeExistente = comunidadeExistente.getRelatos();
			List<Conselho> conselhosComunidadeExistente = comunidadeExistente.getConselhos();

			String senhaDoModerador = moderadorLogado.getSenha();
			String senhaDigitada = request.getParameter("senha");

			if (senhaDigitada != null && senhaDoModerador != null && senhaDigitada.equals(senhaDoModerador)) {
				for (Relato relato : relatosComunidadeExistente) {
					relatoDao.deletar(relato);
				}
				for (Conselho conselho : conselhosComunidadeExistente) {
					conselhoDao.deletar(conselho);
				}
				comunidadeDao.deletar(comunidadeExistente);

				session.invalidate();
				RequestDispatcher dispatcher = request.getRequestDispatcher("/assets/paginas/home.jsp");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/assets/paginas/deletar-comunidade.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/assets/paginas/home.jsp");
			dispatcher.forward(request, response);
			System.out.println("Não achou nada"); // usado para debbug
		}
	}

	private void deletarRelato(HttpServletRequest request, HttpServletResponse response) {

		long id = Long.parseLong(request.getParameter("id"));

		String conteudo = request.getParameter("conteudo");

		LocalDate data = LocalDate.parse(request.getParameter("data"));

		Integer avaliacao = Integer.parseInt(request.getParameter("avaliacao"));

		Status status = Status.valueOf(request.getParameter("status"));

		String nome = request.getParameter("nome");

		String sobrenome = request.getParameter("sobrenome");

		String apelido = request.getParameter("apelido");

		Relato relatoParaDeletar = new Relato(id, conteudo, data, avaliacao, status);

		relatoDao.deletar(relatoParaDeletar);

		Moderador moderadorParaDeletar = new Moderador(nome, sobrenome, apelido);

		moderadorDao.deletar(moderadorParaDeletar);

		Usuario usuarioParaDeletar = new Usuario(nome, sobrenome, apelido);

		usuarioDao.deletar(usuarioParaDeletar);

		relatoParaDeletar.setUsuario(usuarioParaDeletar);

		relatoParaDeletar.setModerador(moderadorParaDeletar);

	}

	private void deletarConselho(HttpServletRequest request, HttpServletResponse response) {

		long id = Long.parseLong(request.getParameter("id"));

		String conteudo = request.getParameter("conteudo");

		Integer avaliacaoBoa = Integer.parseInt(request.getParameter("avaliacao"));

		Integer avaliacaoRuim = Integer.parseInt(request.getParameter("avaliacao"));

		LocalDate data = LocalDate.parse(request.getParameter("data"));

		String nome = request.getParameter("nome");

		String sobrenome = request.getParameter("sobrenome");

		String apelido = request.getParameter("apelido");

		Integer avaliacao = Integer.parseInt(request.getParameter("avaliacao"));

		Status status = Status.valueOf(request.getParameter("status"));

		Conselho conselhoParaDeletar = new Conselho(id, conteudo, avaliacaoBoa, avaliacaoRuim, data);

		conselhoDao.deletar(conselhoParaDeletar);

		Usuario usuarioParaDeletar = new Usuario(nome, sobrenome, apelido);

		usuarioDao.deletar(usuarioParaDeletar);

		Relato relatoParaDeletar = new Relato(conteudo, data, avaliacao, status);

		relatoDao.deletar(relatoParaDeletar);

		conselhoParaDeletar.setUsuario(usuarioParaDeletar);

		conselhoParaDeletar.setRelato(relatoParaDeletar);

	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getSession().invalidate();
		RequestDispatcher dispatcher = request.getRequestDispatcher("resources/paginas/home.jsp");
		dispatcher.forward(request, response);
	}

	private void desativarConta(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		String apelido = request.getParameter("apelido");

		String senha = request.getParameter("senha");

		boolean existe = usuarioDao.verificarCredenciaisUsuario(apelido, senha);

		if (!existe)

			response.sendRedirect("confirmar-exclusao");

		Usuario usuario = usuarioDao.recuperarUsuarioPorApelido(apelido);

		usuarioDao.deletar(usuario);

		RequestDispatcher dispatcher = request.getRequestDispatcher("resources/paginas/home.jsp"); // colocar dps a
		dispatcher.forward(request, response);

	}

}
