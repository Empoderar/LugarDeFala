package br.senac.lugardefala.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senac.lugardefala.modelo.dao.comunidade.ComunidadeDAO;
import br.senac.lugardefala.modelo.dao.comunidade.ComunidadeDAOImpl;
import br.senac.lugardefala.modelo.dao.conselho.ConselhoDAO;
import br.senac.lugardefala.modelo.dao.conselho.ConselhoDAOImpl;
import br.senac.lugardefala.modelo.dao.contato.ContatoDAO;
import br.senac.lugardefala.modelo.dao.contato.ContatoDAOImpl;
import br.senac.lugardefala.modelo.dao.moderador.ModeradorDAO;
import br.senac.lugardefala.modelo.dao.moderador.ModeradorDAOImpl;
import br.senac.lugardefala.modelo.dao.relato.RelatoDAO;
import br.senac.lugardefala.modelo.dao.relato.RelatoDAOImpl;
import br.senac.lugardefala.modelo.dao.usuario.UsuarioDAO;
import br.senac.lugardefala.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.conselho.Conselho;
import br.senac.lugardefala.modelo.entidade.contato.Contato;
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

	public void init() {
		usuarioDao = new UsuarioDAOImpl();
		moderadorDao = new ModeradorDAOImpl();
		comunidadeDao = new ComunidadeDAOImpl();
		contatoDao = new ContatoDAOImpl();
		relatoDao = new RelatoDAOImpl();
		conselhoDao = new ConselhoDAOImpl();

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

			case "/tela-cadastro-usuario":
				mostrarTelaCadastroUsuario(request, response);
				break;

			case "/tela-cadastro-moderador":
				mostrarTelaCadastroModerador(request, response);
				break;

			case "/tela-cadastro-comunidade":
				mostrarTelaCadastroComunidade(request, response);
				break;

			case "/tela-formulario-moderador":
				mostrarTelaFormularioModerador(request, response);
				break;

			case "/tela-login-usuario":
				mostrarTelaLoginUsuario(request, response);
				break;

			case "/tela-inicial":
				mostrarTelaInicial(request, response);
				break;

			case "/tela-perfil-usuario":
				mostrarTelaPerfilDoUsuario(request, response);
				break;

			case "/tela-perfil-comunidade":
				mostrarTelaPerfilDaComunidade(request, response);
				break;

			case "/tela-atualizar-senha":
				mostrarTelaAtualizarSenha(request, response);
				break;

			case "/tela-conselhos":
				mostrarTelaConselhos(request, response);
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

			case "/inserir-moderador":
				inserirModerador(request, response);
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
			throw new ServletException(ex);
		}
	}

	private void atualizarUsuario(HttpServletRequest request, HttpServletResponse response)
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

		Usuario usuarioParaAtualizar = new Usuario(id, nome, sobrenome, dataNascimento, apelido, senha, descricao);
		usuarioDao.atualizarUsuario(usuarioParaAtualizar);

		Contato contatoParaAtualizar = new Contato(telefone, email);
		contatoDao.atualizarContato(contatoParaAtualizar);
		response.sendRedirect("tela-perfil-usuario");

		usuarioParaAtualizar.setContato(contatoParaAtualizar);
	}

	private void atualizarModerador(HttpServletRequest request, HttpServletResponse response)
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

		Moderador moderadorParaAtualizar = new Moderador(id, nome, sobrenome, dataNascimento, apelido, senha,
				descricao);
		moderadorDao.atualizarModerador(moderadorParaAtualizar);

		Contato contatoParaAtualizar = new Contato(telefone, email);
		contatoDao.atualizarContato(contatoParaAtualizar);

		response.sendRedirect("tela-perfil-moderador");

		moderadorParaAtualizar.setContato(contatoParaAtualizar);
	}

	private void atualizarComunidade(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");

		Comunidade comunidadeParaAtualizar = new Comunidade(id, nome, descricao);
		comunidadeDao.atualizarComunidade(comunidadeParaAtualizar);
		response.sendRedirect("tela-perfil-comunidade");
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

		Moderador moderadorParaAtualizar = new Moderador(id, nome, sobrenome, apelido);
		moderadorDao.atualizarModerador(moderadorParaAtualizar);

		Usuario usuarioParaAtualizar = new Usuario(id, nome, sobrenome, apelido);
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

		Usuario usuarioParaAtualizar = new Usuario(id, nome, sobrenome, apelido);
		usuarioDao.atualizarUsuario(usuarioParaAtualizar);

		Relato relatoParaAtualizar = new Relato(id, conteudo, data, avaliacao, status);
		relatoDao.atualizarRelato(relatoParaAtualizar);

		conselhoParaAtualizar.setUsuario(usuarioParaAtualizar);
		conselhoParaAtualizar.setRelato(relatoParaAtualizar);

	}

	private void deletarUsuario(HttpServletRequest request, HttpServletResponse response)
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

		Usuario usuarioParaDeletar = new Usuario(id, nome, sobrenome, dataNascimento, apelido, senha, descricao);
		usuarioDao.deletarUsuario(usuarioParaDeletar);

		Contato contatoParaDeletar = new Contato(telefone, email);
		contatoDao.deletarContato(contatoParaDeletar);

		usuarioParaDeletar.setContato(contatoParaDeletar);

		response.sendRedirect("/home");
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

		response.sendRedirect("/home");
	}

	private void deletarComunidade(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");

		Comunidade comunidadeParaDeletar = new Comunidade(id, nome, descricao);
		comunidadeDao.deletarComunidade(comunidadeParaDeletar);
		response.sendRedirect("/home");
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

		Moderador moderadorParaDeletar = new Moderador(id, nome, sobrenome, apelido);
		moderadorDao.deletarModerador(moderadorParaDeletar);

		Usuario usuarioParaDeletar = new Usuario(id, nome, sobrenome, apelido);
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

		Usuario usuarioParaDeletar = new Usuario(id, nome, sobrenome, apelido);
		usuarioDao.deletarUsuario(usuarioParaDeletar);

		Relato relatoParaDeletar = new Relato(id, conteudo, data, avaliacao, status);
		relatoDao.deletarRelato(relatoParaDeletar);

		conselhoParaDeletar.setUsuario(usuarioParaDeletar);
		conselhoParaDeletar.setRelato(relatoParaDeletar);

	}

	private void inserirUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		long id = Long.parseLong(request.getParameter("id"));

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		LocalDate dataNascimento = LocalDate.parse(request.getParameter("data-nascimento"));
		String apelido = request.getParameter("apelido");
		String senha = request.getParameter("senha");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String descricao = request.getParameter("descricao");

		Usuario usuarioParaInserir = new Usuario(id, nome, sobrenome, dataNascimento, apelido, senha, descricao);
		Contato contatoParaInserir = new Contato(telefone, email);

		usuarioParaInserir.setContato(contatoParaInserir);
		contatoDao.inserirContato(contatoParaInserir);
		usuarioDao.inserirUsuario(usuarioParaInserir);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/login-usuario.jsp");
		dispatcher.forward(request, response);
	}

	private void inserirModerador(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		long id = Long.parseLong(request.getParameter("id"));

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		LocalDate dataNascimento = LocalDate.parse(request.getParameter("dataNascimento"));
		String apelido = request.getParameter("apelido");
		String senha = request.getParameter("senha");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String descricao = request.getParameter("descricao");

		Moderador moderadorParaInserir = new Moderador(id, nome, sobrenome, dataNascimento, apelido, senha, descricao);
		Contato contatoParaInserir = new Contato(telefone, email);
		contatoDao.inserirContato(contatoParaInserir);
		moderadorDao.inserirModerador(moderadorParaInserir);
		moderadorParaInserir.setContato(contatoParaInserir);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/login-moderador.jsp");
		dispatcher.forward(request, response);

	}

	private void inserirRelato(HttpServletRequest request, HttpServletResponse response) {
		long id = Long.parseLong(request.getParameter("id"));
		String conteudo = request.getParameter("conteudo");
		LocalDate data = LocalDate.parse(request.getParameter("data"));
		Integer avaliacao = Integer.parseInt(request.getParameter("avaliacao"));
		Status status = Status.valueOf(request.getParameter("status"));
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String apelido = request.getParameter("apelido");

		Relato relatoParaInserir = new Relato(id, conteudo, data, avaliacao, status);
		relatoDao.inserirRelato(relatoParaInserir);

		Moderador moderadorParaInserir = new Moderador(id, nome, sobrenome, apelido);
		moderadorDao.inserirModerador(moderadorParaInserir);

		Usuario usuarioParaInserir = new Usuario(id, nome, sobrenome, apelido);
		usuarioDao.inserirUsuario(usuarioParaInserir);

		relatoParaInserir.setUsuario(usuarioParaInserir);
		relatoParaInserir.setModerador(moderadorParaInserir);
	}

	private void inserirComunidade(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");

		Comunidade comunidadeParaInserir = new Comunidade(id, nome, descricao);
		comunidadeDao.inserirComunidade(comunidadeParaInserir);
		response.sendRedirect("tela-perfil-comunidade");
	}

	private void inserirConselho(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {

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

		Conselho conselhoParaInserir = new Conselho(id, conteudo, avaliacaoBoa, avaliacaoRuim, data);
		conselhoDao.inserirConselho(conselhoParaInserir);

		Usuario usuarioParaInserir = new Usuario(id, nome, sobrenome, apelido);
		usuarioDao.inserirUsuario(usuarioParaInserir);

		Relato relatoParaInserir = new Relato(id, conteudo, data, avaliacao, status);
		relatoDao.inserirRelato(relatoParaInserir);

		conselhoParaInserir.setUsuario(usuarioParaInserir);
		conselhoParaInserir.setRelato(relatoParaInserir);
		
		response.sendRedirect("tela-conselhos");
	}

	private void mostrarTelaCadastroUsuario(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cadastro-usuario.jsp");
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

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/login-usuario.jsp");
		dispatcher.forward(request, response);

	}

	private void mostrarTelaInicial(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/tela-inicial.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarTelaPerfilDoUsuario(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/perfil-usuario.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarTelaPerfilDaComunidade(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/perfil-comunidade.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarTelaAtualizarSenha(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/.jsp");
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
}