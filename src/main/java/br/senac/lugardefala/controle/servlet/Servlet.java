package br.senac.lugardefala.controle.servlet;

import java.io.IOException;

import java.sql.SQLException;

import java.time.LocalDate;

import java.util.ArrayList;

import java.util.List;

import java.util.logging.Logger;

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

	private static final Logger LOGGER = Logger.getLogger(Servlet.class.getName());

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

		String action = request.getServletPath();

		try {

			switch (action) {

			case "/cadastro-usuario": // funcionando

				mostrarTelaCadastroUsuario(request, response);

				break;

			case "/cadastro-moderador": // funcionando

				mostrarTelaCadastroModerador(request, response);

				break;

			case "/cadastro-comunidade": // funcionando

				mostrarTelaCadastroComunidade(request, response);

				break;

			case "/cadastro-categoria": // funcionando

				mostrarTelaCadastroCategoria(request, response);

				break;

			case "/cadastro-conselho": // funcionando

				mostrarTelaCadastroConselho(request, response);

				break;

			case "/cadastro-relato": // funcionando

				mostrarTelaCadastroRelato(request, response);

				break;

			case "/form-moderador": // funcionando

				mostrarTelaFormularioModerador(request, response);

				break;

			case "/login": // funcionando

				mostrarTelaLoginUsuario(request, response);

				break;

			case "/": // funcionando

				mostrarHome(request, response);

				break;

			case "/perfil-usuario": // funcionando

				mostrarTelaPerfilDoUsuario(request, response);

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

			case "/editar-perfil": // funcionando

				mostrarTelaEditarPerfil(request, response);

				break;

			case "/editar-relato": // funcionando

				mostrarTelaEditarRelato(request, response);

				break;

			case "/editar-senha": // funcionando

				mostrarTelaEditarSenha(request, response);

				break;

			case "/inserir-usuario": // salvando

				inserirUsuario(request, response);

				break;

			case "/fazer-login": // em ajuste

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

			case "/deletar-moderador": // precisa ser feito

				deletarModerador(request, response);

				break;

			case "/deletar-comunidade": // precisa ser feito

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

			case "/metodo-editar-senha": // precisa ser feito

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

		Moderador moderador = (Moderador) sessao.getAttribute("moderador");
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (usuario == null && moderador == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/home.jsp");
			dispatcher.forward(request, response);
		}
		if (usuario != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/home.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cadastro-relato.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarTelaCadastroRelato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();

		Moderador moderador = (Moderador) sessao.getAttribute("moderador");
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (moderador == null && usuario == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/home.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cadastro-relato.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void mostrarTelaFormularioModerador(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/form-moderador.jsp");

		dispatcher.forward(request, response);

	}

	private void mostrarTelaLoginUsuario(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("./assets/paginas/login.jsp");

		dispatcher.forward(request, response);

	}

	private void mostrarHome(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/home.jsp");

		dispatcher.forward(request, response);

	}

	private void mostrarTelaPerfilDoUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

		String descricao = request.getParameter("descricao");

		usuario.setDescricao(descricao);

		List<Comunidade> comunidades = comunidadeDao.recuperarPorUsuario(usuario);

		request.setAttribute("comunidades", comunidades);

		List<Relato> relatos = relatoDao.recuperarPorUsuario(usuario);

		request.setAttribute("relatos", relatos);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/perfil-usuario.jsp");

		dispatcher.forward(request, response);

	}

	private void mostrarTelaPerfilDaComunidade(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

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

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/tela-conselhos.jsp");

		dispatcher.forward(request, response);

	}

	private void mostrarTelaCadastroCategoria(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cadastro-categoria.jsp");

		dispatcher.forward(request, response);

	}

	private void mostrarTelaCadastroConselho(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		Relato relato1 = new Relato("Lalalalalallala", LocalDate.now());

		Relato relato2 = new Relato("lelelele", LocalDate.now());

		request.setAttribute("relato", relato1);

		request.setAttribute("relato", relato2);

		relatoDao.inserir(relato1);

		relatoDao.inserir(relato2);

		Usuario usuario2 = new Usuario("joao", "antonio", "busco ajuda", LocalDate.of(2022, 10, 10), "joao.antonio");

		usuarioDao.inserir(usuario2);

		usuario2.adicionarRelato(relato1);

		usuario2.adicionarRelato(relato2);

		Usuario usuarioRecuperado = usuarioDao.recuperarPorIdFetch(usuario2.getId());

		List<Relato> relatos = relatoDao.recuperarPorUsuario(usuarioRecuperado);

		relatos.add(relato1);

		relatos.add(relato2);

		request.setAttribute("relatos", relatos);

		for (Relato r : relatos) {

			System.out.println("Conteúdo dos relatos: " + r.getConteudo());

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cadastro-conselho.jsp");

		dispatcher.forward(request, response);

	}

	private void mostrarTelaDenuncias(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/tela-denuncias.jsp");

		dispatcher.forward(request, response);

	}

	private void mostrarTelaDenunciaConselho(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		Usuario usuario = new Usuario("Anna", "Silva", "anna.silva");

		Conselho conselho = new Conselho(

				"Minha amiga querida, é uma pena que isso tenha acontecido com você, mas vai passar!", LocalDate.now());

		LocalDate dataAtual = LocalDate.now();

		Status status = Status.APROVADO;

		request.setAttribute("usuario", usuario);

		request.setAttribute("conselho", conselho);

		request.setAttribute("dataAtual", dataAtual);

		request.setAttribute("status", status);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/denuncia-conselho.jsp");

		dispatcher.forward(request, response);

	}

	private void mostrarTelaDenunciaModerador(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		Usuario usuario = new Usuario("Ana", "Santos", "ana.santos");

		Moderador moderador = new Moderador("Manuel", "Oliveira", "manoel.oliveira");

		LocalDate dataAtual = LocalDate.now();

		Status status = Status.APROVADO;

		request.setAttribute("usuario", usuario);

		request.setAttribute("moderador", moderador);

		request.setAttribute("dataAtual", dataAtual);

		request.setAttribute("status", status);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/denuncia-moderador.jsp");

		dispatcher.forward(request, response);

	}

	private void mostrarTelaDenunciaRelato(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		Usuario usuario = new Usuario("Elena", "Rocha", "elena.rocha");

		Relato relato = new Relato("Acho que sofri violência doméstica, e agora?", LocalDate.now());

		LocalDate dataAtual = LocalDate.now();

		Status status = Status.APROVADO;

		request.setAttribute("usuario", usuario);

		request.setAttribute("relato", relato);

		request.setAttribute("dataAtual", dataAtual);

		request.setAttribute("status", status);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/denuncia-relato.jsp");

		dispatcher.forward(request, response);

	}

	private void mostrarTelaDenunciaUsuario(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		Usuario usuarioDenunciante = new Usuario("ana", "carolina", LocalDate.of(1997, 1, 9), "ana.carolina", "123");

		Usuario usuarioDenunciado = new Usuario("ester", "ferreira", LocalDate.of(1997, 1, 9), "ester.ferreira", "123");

		LocalDate dataAtual = LocalDate.now();

		Status status = Status.APROVADO;

		request.setAttribute("usuarioDenunciante", usuarioDenunciante);

		request.setAttribute("usuarioDenunciado", usuarioDenunciado);

		request.setAttribute("dataAtual", dataAtual);

		request.setAttribute("status", status);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/denuncia-usuario.jsp");

		dispatcher.forward(request, response);

	}

	private void mostrarTelaDesativarConta(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/desativar-conta.jsp");

		dispatcher.forward(request, response);

	}

	private void mostrarTelaDeletarUsuario(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/deletar-usuario.jsp");

		dispatcher.forward(request, response);

	}

	private void mostrarTelaEditarPerfil(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/editar-perfil.jsp");

		dispatcher.forward(request, response);

	}

	private void mostrarTelaEditarRelato(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/editar-relato.jsp");

		dispatcher.forward(request, response);

	}

	private void mostrarTelaEditarSenha(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/editar-senha.jsp");

		dispatcher.forward(request, response);

	}

	private void mostrarTelaRelatos(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/tela-relatos.jsp");

		dispatcher.forward(request, response);

	}

	private void fazerLogin(HttpServletRequest request, HttpServletResponse response)

			throws SQLException, IOException, ServletException {

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		HttpSession sessao = request.getSession();
		
		Usuario usuario = usuarioDao.obterPorCredenciais(email, senha);

		sessao.setAttribute("usuario", usuario);
		
		if (usuario != null) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/home.jsp");

			dispatcher.forward(request, response);

		} else {

			response.sendRedirect("./assets/paginas/login.jsp");
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

		contatoDao.inserir(contatoParaInserir);

		moderadorDao.inserir(moderadorParaInserir);

		moderadorParaInserir.setContato(contatoParaInserir);

		RequestDispatcher dispatcher = request.getRequestDispatcher("./assets/paginas/login.jsp");

		dispatcher.forward(request, response);

	}

	private void inserirRelato(HttpServletRequest request, HttpServletResponse response)

			throws SQLException, IOException, ServletException {

		try {

			String conteudo = request.getParameter("conteudo");

			LocalDate dataAtual = LocalDate.now();

			Relato relatoParaInserir = new Relato(conteudo, dataAtual);

			relatoDao.inserir(relatoParaInserir);

			List<Categoria> categoriasParaInserir = new ArrayList<Categoria>();

			if (request.getParameter("sororidade") != null) {

				Categoria categoria = new Categoria("Sororidade");

				categoriaDao.inserir(categoria);

				categoriasParaInserir.add(categoria);

			}

			if (request.getParameter("ajude-me") != null) {

				Categoria categoria = new Categoria("Ajude-me");

				categoriaDao.inserir(categoria);

				categoriasParaInserir.add(categoria);

			}

			if (request.getParameter("desabafo") != null) {

				Categoria categoria = new Categoria("Desabafo");

				categoriaDao.inserir(categoria);

				categoriasParaInserir.add(categoria);

			}

			if (request.getParameter("aconselhamento-juridico") != null) {

				Categoria categoria = new Categoria("Aconselhamento Jurídico");

				categoriaDao.inserir(categoria);

				categoriasParaInserir.add(categoria);

			}

			if (request.getParameter("acolhimento-temporario") != null) {

				Categoria categoria = new Categoria("Acolhimento Temporário");

				categoriaDao.inserir(categoria);

				categoriasParaInserir.add(categoria);

			}

			if (request.getParameter("assistencia-social") != null) {

				Categoria categoria = new Categoria("Assistência Social");

				categoriaDao.inserir(categoria);

				categoriasParaInserir.add(categoria);

			}

			relatoParaInserir.setCategoriaRelato(categoriasParaInserir);

			request.setAttribute("dataAtual", dataAtual);

			request.setAttribute("relato", relatoParaInserir);

			request.setAttribute("conteudo", conteudo);

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/perfil-comunidade.jsp");

			dispatcher.forward(request, response);

			LOGGER.info("Relato inserido com sucesso.");

		} catch (Exception e) {

			LOGGER.severe("Erro ao inserir relato: " + e.getMessage());

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

		String nome = request.getParameter("nome");

		String descricao = request.getParameter("descricao");

		Comunidade comunidadeParaInserir = new Comunidade(nome, descricao);

		comunidadeDao.inserir(comunidadeParaInserir);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/assets/paginas/perfil-comunidade.jsp");

		dispatcher.forward(request, response);

	}

	private void inserirConselho(HttpServletRequest request, HttpServletResponse response)

			throws SQLException, IOException, ServletException {

		String conteudo = request.getParameter("conteudo");

		Conselho conselhoParaInserir = new Conselho(conteudo);

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

		Usuario usuario1 = new Usuario("ana", "santos", LocalDate.of(1997, 1, 9), "ana.santos", "123");

		String motivo = request.getParameter("motivo");

		Moderador moderador1 = new Moderador("ana", "luiza", LocalDate.of(1997, 1, 9), "ana.santos", "123");

		moderadorDao.inserir(moderador1);

		DenunciaModerador denunciaModeradorParaInserir = new DenunciaModerador(LocalDate.now(), motivo, Status.APROVADO,

				usuario1, moderador1);

		denunciaModeradorDao.inserir(denunciaModeradorParaInserir);

		request.setAttribute("usuario", usuario1);

		request.setAttribute("moderador", moderador1);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/assets/paginas/tela-denuncias.jsp");

		dispatcher.forward(request, response);

	}

	private void inserirDenunciaRelato(HttpServletRequest request, HttpServletResponse response)

			throws SQLException, IOException, ServletException {

		Usuario usuario1 = new Usuario("ana", "albuquerque", LocalDate.of(1997, 1, 9), "ana.albuquerque", "123");

		String motivo = request.getParameter("motivo");

		Relato relato1 = new Relato("lalalalla", LocalDate.now());

		usuarioDao.inserir(usuario1);

		relatoDao.inserir(relato1);

		DenunciaRelato denunciaRelatoParaInserir = new DenunciaRelato(LocalDate.now(), motivo, Status.APROVADO,

				usuario1, relato1);

		denunciaRelatoDao.inserir(denunciaRelatoParaInserir);

		request.setAttribute("usuario", usuario1);

		request.setAttribute("Relato", relato1);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/assets/paginas/tela-denuncias.jsp");

		dispatcher.forward(request, response);

	}

	private void inserirDenunciaUsuario(HttpServletRequest request, HttpServletResponse response)

			throws SQLException, IOException, ServletException {

		Usuario usuarioDenunciante = new Usuario("ana", "carolina", LocalDate.of(1997, 1, 9), "ana.carolina", "123");

		String motivo = request.getParameter("motivo");

		Usuario usuarioDenunciado = new Usuario("ester", "ferreira", LocalDate.of(1997, 1, 9), "ester.ferreira", "123");

		usuarioDao.inserir(usuarioDenunciado);

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

		String nome = request.getParameter("nome");

		String sobrenome = request.getParameter("sobrenome");

		String descricao = request.getParameter("descricao");

		String apelido = request.getParameter("apelido");

		String email = request.getParameter("email");

		String telefone = request.getParameter("telefone");

		Usuario usuarioParaAtualizar = new Usuario(nome, sobrenome, apelido, descricao);

		usuarioDao.atualizar(usuarioParaAtualizar);

		Contato contatoParaAtualizar = new Contato(telefone, email);

		contatoDao.atualizar(contatoParaAtualizar);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/assets/paginas/perfil-usuario.jsp");

		dispatcher.forward(request, response);

		usuarioParaAtualizar.setContato(contatoParaAtualizar);

	}

	private void editarSenha(HttpServletRequest request, HttpServletResponse response)

			throws SQLException, ServletException, IOException {

		Usuario usuarioParaAtualizar = (Usuario) request.getSession().getAttribute("senha");

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

		Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");

		if (usuarioLogado != null) {

			usuarioDao.deletar(usuarioLogado);

			session.invalidate();

			response.sendRedirect("/home.jsp");

		} else {

			System.out.println("Não foi possível realizar a exclusão");

		}

	}

//	private void deletarUsuario(HttpServletRequest request, HttpServletResponse response)

//			throws SQLException, ServletException, IOException {

//

//		String senha = request.getParameter("senha");

//

//		Usuario usuarioParaDeletar = new Usuario(senha);

//		usuarioDao.deletar(usuarioParaDeletar);

//

//		response.sendRedirect("/home.jsp");

//	}

	private void deletarModerador(HttpServletRequest request, HttpServletResponse response)

			throws SQLException, ServletException, IOException {

		Moderador moderador1 = new Moderador("Brenda", "Monteiro", "brenda.monteiro");

		Moderador moderador2 = new Moderador("Marcella", "Barboza", "marcella.barboza");

		moderadorDao.inserir(moderador1);

		moderadorDao.inserir(moderador2);

		Relato relato1 = new Relato("Um relato sobre sororidade", LocalDate.now(), 5, Status.APROVADO);

		Relato relato2 = new Relato("Relato sobre desabafo", LocalDate.now(), 3, Status.APROVADO);

		relatoDao.inserir(relato1);

		relatoDao.inserir(relato2);

		Comunidade comunidade1 = new Comunidade("Violência Física",

				"Comunidade de relatos sobre agressões físicas, como bater, empurrar, chutar, entre outras formas de violência que causem dano ao corpo.");

		comunidade1.setModerador(moderador1);

		comunidade1.setModerador(moderador2);

		comunidadeDao.inserir(comunidade1);

		comunidade1.adicionarRelato(relato1);

		comunidade1.adicionarRelato(relato2);

		comunidadeDao.inserir(comunidade1);

		Comunidade comunidadeRecuperada = comunidadeDao.recuperarPorId(comunidade1.getId());

		List<Moderador> moderadores = moderadorDao.recuperarPorComunidade(comunidadeRecuperada);

		moderadores.add(moderador1);

		moderadores.add(moderador2);

		List<Relato> relatos = relatoDao.recuperarPorComunidade(comunidadeRecuperada);

		relatos.add(relato1);

		relatos.add(relato2);

		request.setAttribute("comunidade", comunidade1);

		request.setAttribute("moderadores", moderadores);

		request.setAttribute("relatos", relatos);

		System.out.println("Moderadores: ");

		for (Moderador c : moderadores) {

			System.out.println(c.getNome());

		}

	}

	private void deletarComunidade(HttpServletRequest request, HttpServletResponse response)

			throws SQLException, IOException {

		long id = Long.parseLong(request.getParameter("id"));

		String nome = request.getParameter("nome");

		String descricao = request.getParameter("descricao");

		Comunidade comunidadeParaDeletar = new Comunidade(id, nome, descricao);

		comunidadeDao.deletar(comunidadeParaDeletar);

		response.sendRedirect("/home.jsp");

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

		boolean existe = usuarioDao.verificarCredenciais(apelido, senha);

		if (!existe)

			response.sendRedirect("confirmar-exclusao");

		Usuario usuario = usuarioDao.recuperarPorApelido(apelido);

		usuarioDao.deletar(usuario);

		RequestDispatcher dispatcher = request.getRequestDispatcher("resources/paginas/home.jsp"); // colocar dps a
		dispatcher.forward(request, response);

	}

}
