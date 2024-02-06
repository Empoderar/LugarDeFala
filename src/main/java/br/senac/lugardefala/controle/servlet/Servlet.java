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

			case "/cadastro-usuario":
				mostrarTelaCadastroUsuario(request, response);
				break;

			case "/cadastro-moderador":
				mostrarTelaCadastroModerador(request, response);
				break;

			case "/cadastro-comunidade":
				mostrarTelaCadastroComunidade(request, response);
				break;

			case "/tela-relatos":
				mostrarTelaRelatos(request, response);
				break;

			case "/formulario-moderador":
				mostrarTelaFormularioModerador(request, response);
				break;

			case "/login":
				mostrarTelaLoginUsuario(request, response);
				break;

			case "/":
				mostrarHome(request, response);
				break;

			case "/perfil-usuario":
				mostrarTelaPerfilDoUsuario(request, response);
				break;

			case "/perfil-comunidade":
				mostrarTelaPerfilDaComunidade(request, response);
				break;

			case "/tela-conselhos":
				mostrarTelaConselhos(request, response);
				break;

			case "/cadastro-categoria":
				mostrarTelaCadastroCategoria(request, response);
				break;

			case "/tela-denuncias":
				mostrarTelaDenuncias(request, response);
				break;

			case "/inserir-usuario":
				inserirUsuario(request, response);
				break;

			case "/inserir-relato":
				inserirRelato(request, response);
				break;

			case "/inserir-conselho":
				inserirConselho(request, response);
				break;

			case "/inserir-comunidade":
				inserirComunidade(request, response);
				break;

			case "/inserir-categoria":
				inserirCategoria(request, response);
				break;

			case "/inserir-moderador":
				inserirModerador(request, response);
				break;

			case "/inserir-denuncia-de-conselho":
				inserirDenunciaConselho(request, response);
				break;

			case "/inserir-denuncia-de-moderador":
				inserirDenunciaModerador(request, response);
				break;

			case "/cadastro-denuncia-usuario":
				inserirDenunciaRelato(request, response);
				break;

			case "/inserir-denuncia-de-usuario":
				inserirDenunciaUsuario(request, response);
				break;

			case "/deletar-usuario":
				deletarUsuario(request, response);
				break;

			case "/deletar-moderador":
				deletarModerador(request, response);
				break;

			case "/deletar-comunidade":
				deletarComunidade(request, response);
				break;

			case "/deletar-relato":
				deletarRelato(request, response);
				break;

			case "/deletar-conselho":
				deletarConselho(request, response);
				break;

			case "/atualizar-usuario":
				atualizarUsuario(request, response);
				break;

			case "/atualizar-senha":
				atualizarSenha(request, response);
				break;

			case "/atualizar-moderador":
				atualizarModerador(request, response);
				break;

			case "/atualizar-comunidade":
				atualizarComunidade(request, response);
				break;

			case "/atualizar-relato":
				atualizarRelato(request, response);
				break;

			case "/atualizar-conselho":
				atualizarConselho(request, response);
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
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cadastro-comunidade.jsp");
		dispatcher.forward(request, response);
		
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
		
		Comunidade comunidade1 = new Comunidade("nomebolado", "descricaobolada");
		Comunidade comunidade2 = new Comunidade("ffsdfsolado", "desfsdda");
		comunidadeDao.inserirComunidade(comunidade1);
		comunidadeDao.inserirComunidade(comunidade2);
		
		Usuario usuario2 = new Usuario("joao", "fbgagkhfds", LocalDate.of(2022, 10, 10), "jdvh", "89237");
		
		usuario2.adicionarComunidade(comunidade1);
		usuario2.adicionarComunidade(comunidade2);
		usuarioDao.inserirUsuario(usuario2);
		
		Usuario usuarioRecuperado = usuarioDao.recuperarUsuarioPeloIdFetch(usuario2.getId());
		
		List<Comunidade> comunidades = comunidadeDao.recuperarComunidadesPeloUsuario(usuarioRecuperado);
		comunidades.add(comunidade1);
		comunidades.add(comunidade2);
		
		request.setAttribute("usuario", usuarioRecuperado);
		request.setAttribute("comunidades", comunidades);
		
		for (Comunidade c : comunidades) {
			System.out.println("Nome da comunidade: " + c.getNome());
		}
		
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
	
	private void mostrarTelaDenuncias(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/tela-denuncias.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarTelaRelatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/tela-relatos.jsp");
		dispatcher.forward(request, response);
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
		contatoDao.inserirContato(contatoParaInserir);
		usuarioDao.inserirUsuario(usuarioParaInserir);

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
		contatoDao.inserirContato(contatoParaInserir);
		moderadorDao.inserirModerador(moderadorParaInserir);
		moderadorParaInserir.setContato(contatoParaInserir);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/login.jsp");
		dispatcher.forward(request, response);

	}

	private void inserirRelato(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		try {
			String conteudo = request.getParameter("conteudo");
			LocalDate dataAtual = LocalDate.now();
			Relato relatoParaInserir = new Relato(conteudo, dataAtual);
			relatoDao.inserirRelato(relatoParaInserir);

			List<Categoria> categoriasParaInserir = new ArrayList<Categoria>();
			if (request.getParameter("sororidade") != null) {
				Categoria categoria = new Categoria("Sororidade");
				categoriaDao.inserirCategoria(categoria);
				categoriasParaInserir.add(categoria);
			}
			if (request.getParameter("ajude-me") != null) {
				Categoria categoria = new Categoria("Ajude-me");
				categoriaDao.inserirCategoria(categoria);
				categoriasParaInserir.add(categoria);
			}

			if (request.getParameter("desabafo") != null) {
				Categoria categoria = new Categoria("Desabafo");
				categoriaDao.inserirCategoria(categoria);
				categoriasParaInserir.add(categoria);
			}

			if (request.getParameter("aconselhamento-juridico") != null) {
				Categoria categoria = new Categoria("Aconselhamento Jurídico");
				categoriaDao.inserirCategoria(categoria);
				categoriasParaInserir.add(categoria);
			}

			if (request.getParameter("acolhimento-temporario") != null) {
				Categoria categoria = new Categoria("Acolhimento Temporário");
				categoriaDao.inserirCategoria(categoria);
				categoriasParaInserir.add(categoria);
			}

			if (request.getParameter("assistencia-social") != null) {
				Categoria categoria = new Categoria("Assistência Social");
				categoriaDao.inserirCategoria(categoria);
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
		categoriaDao.inserirCategoria(categoria);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/assets/paginas/inserir-categoria.jsp");
		dispatcher.forward(request, response);

	}

	private void inserirComunidade(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");

		Comunidade comunidadeParaInserir = new Comunidade(nome, descricao);
		comunidadeDao.inserirComunidade(comunidadeParaInserir);
		response.sendRedirect("perfil-comunidade.jsp");
	}

	private void inserirConselho(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		String conteudo = request.getParameter("conteudo");

		Conselho conselhoParaInserir = new Conselho(conteudo);
		conselhoDao.inserirConselho(conselhoParaInserir);
		response.sendRedirect("tela-conselhos");
	}

	private void inserirDenunciaConselho(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		Usuario usuarioDenunciante = usuarioDao
				.recuperarUsuarioPeloId((Long.parseLong(request.getParameter("usuario-denunciante"))));
		String motivo = request.getParameter("motivo");
		Conselho conselhoDenunciado = conselhoDao
				.recuperarConselhoPeloId((Long.parseLong(request.getParameter("conselho-denunciado"))));

		DenunciaConselho denunciaConselhoParaInserir = new DenunciaConselho(usuarioDenunciante, motivo,
				conselhoDenunciado);
		denunciaConselhoDao.inserirDenunciaConselho(denunciaConselhoParaInserir);

		response.sendRedirect("perfil-comunidade");
	}

	private void inserirDenunciaModerador(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		Usuario usuarioDenunciante = usuarioDao.recuperarUsuarioPeloNome(request.getParameter("usuario-denunciante"));
		String motivo = request.getParameter("motivo");
		Moderador moderadorDenunciado = moderadorDao
				.recuperarModeradorPeloNome(request.getParameter("moderador-denunciado"));

		DenunciaModerador denunciaModeradorParaInserir = new DenunciaModerador(motivo, usuarioDenunciante,
				moderadorDenunciado);
		denunciaModeradorDao.inserirDenunciaModerador(denunciaModeradorParaInserir);

		response.sendRedirect("perfil-comunidade");
	}

	private void inserirDenunciaRelato(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		Usuario usuarioDenunciante = usuarioDao.recuperarUsuarioPeloNome(request.getParameter("usuario-denunciante"));
		String motivo = request.getParameter("motivo");
		Relato relatoDenunciado = relatoDao
				.recuperarRelatoPorId((Long.parseLong(request.getParameter("relato-denunciado"))));

		DenunciaRelato denunciaRelatoParaInserir = new DenunciaRelato(motivo, usuarioDenunciante, relatoDenunciado);
		denunciaRelatoDao.inserirDenunciaRelato(denunciaRelatoParaInserir);

		response.sendRedirect("perfil-comunidade");
	}

	private void inserirDenunciaUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		Usuario usuarioDenunciante = usuarioDao
				.recuperarUsuarioPeloApelido(request.getParameter("usuario-denunciante"));
		Usuario usuarioDenunciado = usuarioDao.recuperarUsuarioPeloApelido(request.getParameter("usuario-denunciado"));
		String motivo = request.getParameter("motivo");

		DenunciaUsuario denunciaUsuarioParaInserir = new DenunciaUsuario(usuarioDenunciante, motivo, usuarioDenunciado);
		denunciaUsuarioDao.inserirDenunciaUsuario(denunciaUsuarioParaInserir);

		response.sendRedirect("cadastro-denuncia-usuario");
	}
	
	private void atualizarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		LocalDate dataNascimento = LocalDate.parse(request.getParameter("dataNascimento"));
		String apelido = request.getParameter("apelido");
		String senha = request.getParameter("senha");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String descricao = request.getParameter("descricao");

		Usuario usuarioParaAtualizar = new Usuario(nome, sobrenome, dataNascimento, apelido, senha, descricao);
		usuarioDao.atualizarUsuario(usuarioParaAtualizar);

		Contato contatoParaAtualizar = new Contato(telefone, email);
		contatoDao.atualizarContato(contatoParaAtualizar);
		response.sendRedirect("perfil-usuario.jsp");

		usuarioParaAtualizar.setContato(contatoParaAtualizar);
	}

	private void atualizarSenha(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		String senha = request.getParameter("senha");
		Usuario usuarioParaAtualizar = new Usuario(senha);
		usuarioDao.atualizarUsuario(usuarioParaAtualizar);

		response.sendRedirect("atualizar-senha.jsp");

	}

	private void atualizarModerador(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		LocalDate dataNascimento = LocalDate.parse(request.getParameter("dataNascimento"));
		String apelido = request.getParameter("apelido");
		String senha = request.getParameter("senha");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String descricao = request.getParameter("descricao");

		Moderador moderadorParaAtualizar = new Moderador(nome, sobrenome, dataNascimento, apelido, senha, descricao);
		moderadorDao.atualizarModerador(moderadorParaAtualizar);

		Contato contatoParaAtualizar = new Contato(telefone, email);
		contatoDao.atualizarContato(contatoParaAtualizar);

		response.sendRedirect("perfil-moderador.jsp");

		moderadorParaAtualizar.setContato(contatoParaAtualizar);
	}

	private void atualizarComunidade(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");

		Comunidade comunidadeParaAtualizar = new Comunidade(id, nome, descricao);
		comunidadeDao.atualizarComunidade(comunidadeParaAtualizar);
		response.sendRedirect("perfil-comunidade.jsp");
	}

	private void atualizarRelato(HttpServletRequest request, HttpServletResponse response) {
		long id = Long.parseLong(request.getParameter("id"));
		String conteudo = request.getParameter("conteudo");
		LocalDate data = LocalDate.parse(request.getParameter("data"));
		Integer avaliacao = Integer.parseInt(request.getParameter("avaliacao"));
		Status status = Status.valueOf(request.getParameter("status"));
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String apelido = request.getParameter("apelido");

		Relato relatoParaAtualizar = new Relato(id, conteudo, data, avaliacao, status);
		relatoDao.atualizarRelato(relatoParaAtualizar);

		Moderador moderadorParaAtualizar = new Moderador(nome, sobrenome, apelido);
		moderadorDao.atualizarModerador(moderadorParaAtualizar);

		Usuario usuarioParaAtualizar = new Usuario(nome, sobrenome, apelido);
		usuarioDao.atualizarUsuario(usuarioParaAtualizar);

		relatoParaAtualizar.setUsuario(usuarioParaAtualizar);
		relatoParaAtualizar.setModerador(moderadorParaAtualizar);
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
		conselhoDao.atualizarConselho(conselhoParaAtualizar);

		Usuario usuarioParaAtualizar = new Usuario(nome, sobrenome, apelido);
		usuarioDao.atualizarUsuario(usuarioParaAtualizar);

		Relato relatoParaAtualizar = new Relato(conteudo, data, avaliacao, status);
		relatoDao.atualizarRelato(relatoParaAtualizar);

		conselhoParaAtualizar.setUsuario(usuarioParaAtualizar);
		conselhoParaAtualizar.setRelato(relatoParaAtualizar);

	}

	private void deletarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		String senha = request.getParameter("senha");

		Usuario usuarioParaDeletar = new Usuario(senha);
		usuarioDao.deletarUsuario(usuarioParaDeletar);

		response.sendRedirect("/home.jsp");
	}

	private void deletarModerador(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		long id = Long.parseLong(request.getParameter("id"));

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		LocalDate dataNascimento = LocalDate.parse(request.getParameter("dataNascimento"));
		String apelido = request.getParameter("apelido");
		String senha = request.getParameter("senha");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String descricao = request.getParameter("descricao");

		Moderador moderadorParaDeletar = new Moderador(id, nome, sobrenome, dataNascimento, apelido, senha, descricao);
		moderadorDao.deletarModerador(moderadorParaDeletar);

		Contato contatoParaDeletar = new Contato(telefone, email);
		contatoDao.inserirContato(contatoParaDeletar);

		moderadorParaDeletar.setContato(contatoParaDeletar);

		response.sendRedirect("/home.jsp");
	}

	private void deletarComunidade(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");

		Comunidade comunidadeParaDeletar = new Comunidade(id, nome, descricao);
		comunidadeDao.deletarComunidade(comunidadeParaDeletar);
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
		relatoDao.deletarRelato(relatoParaDeletar);

		Moderador moderadorParaDeletar = new Moderador(nome, sobrenome, apelido);
		moderadorDao.deletarModerador(moderadorParaDeletar);

		Usuario usuarioParaDeletar = new Usuario(nome, sobrenome, apelido);
		usuarioDao.deletarUsuario(usuarioParaDeletar);

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
		conselhoDao.deletarConselho(conselhoParaDeletar);

		Usuario usuarioParaDeletar = new Usuario(nome, sobrenome, apelido);
		usuarioDao.deletarUsuario(usuarioParaDeletar);

		Relato relatoParaDeletar = new Relato(conteudo, data, avaliacao, status);
		relatoDao.deletarRelato(relatoParaDeletar);

		conselhoParaDeletar.setUsuario(usuarioParaDeletar);
		conselhoParaDeletar.setRelato(relatoParaDeletar);

	}

	
}
