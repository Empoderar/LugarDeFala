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
import br.senac.lugardefala.modelo.dao.moderador.ModeradorDAO;
import br.senac.lugardefala.modelo.dao.moderador.ModeradorDAOImpl;
import br.senac.lugardefala.modelo.dao.usuario.UsuarioDAO;
import br.senac.lugardefala.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.moderador.Moderador;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

@WebServlet("/")
public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDao;
	private ModeradorDAO moderadorDao;
	private ComunidadeDAO comunidadeDao;

	public void init() {
		usuarioDao = new UsuarioDAOImpl();
		moderadorDao = new ModeradorDAOImpl();
		comunidadeDao = new ComunidadeDAOImpl();

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

			case "/inserir-usuario":
				inserirUsuario(request, response);
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

			case "/atualizar-usuario":
				atualizarUsuario(request, response);
				break;

			case "/atualizar-moderador":
				atualizarModerador(request, response);
				break;

			case "/atualizar-comunidade":
				atualizarComunidade(request, response);
				break;

			default:
				response.sendError(HttpServletResponse.SC_NOT_FOUND,
						"Desculpe, não conseguimos encontrar o que você procura :(");
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void atualizarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		LocalDate dataNascimento = LocalDate.parse(request.getParameter("dataNascimento"));
		String apelido = request.getParameter("apelido");
		String senha = request.getParameter("senha");

		Usuario usuarioParaAtualizar = new Usuario(nome, sobrenome, dataNascimento, apelido, senha);
		usuarioDao.atualizarUsuario(usuarioParaAtualizar);
		response.sendRedirect("perfil");
	}

	private void atualizarModerador(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		LocalDate dataNascimento = LocalDate.parse(request.getParameter("dataNascimento"));
		String apelido = request.getParameter("apelido");
		String senha = request.getParameter("senha");

		Moderador moderadorParaAtualizar = new Moderador(nome, sobrenome, dataNascimento, apelido, senha);
		moderadorDao.atualizarModerador(moderadorParaAtualizar);
		response.sendRedirect("perfil");
	}

	private void atualizarComunidade(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");

		Comunidade comunidadeParaAtualizar = new Comunidade(nome, descricao);
		comunidadeDao.atualizarComunidade(comunidadeParaAtualizar);
		response.sendRedirect("home");
	}

	private void deletarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		LocalDate dataNascimento = LocalDate.parse(request.getParameter("dataNascimento"));
		String apelido = request.getParameter("apelido");
		String senha = request.getParameter("senha");

		Usuario usuarioParaDeletar = new Usuario(nome, sobrenome, dataNascimento, apelido, senha);
		usuarioDao.deletarUsuario(usuarioParaDeletar);
		response.sendRedirect("home");
	}

	private void deletarModerador(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		LocalDate dataNascimento = LocalDate.parse(request.getParameter("dataNascimento"));
		String apelido = request.getParameter("apelido");
		String senha = request.getParameter("senha");

		Moderador moderadorParaDeletar = new Moderador(nome, sobrenome, dataNascimento, apelido, senha);
		moderadorDao.deletarModerador(moderadorParaDeletar);
		response.sendRedirect("home");
	}

	private void deletarComunidade(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");

		Comunidade comunidadeParaDeletar = new Comunidade(nome, descricao);
		comunidadeDao.deletarComunidade(comunidadeParaDeletar);
		response.sendRedirect("home");
	}

	private void inserirUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		LocalDate dataNascimento = LocalDate.parse(request.getParameter("dataNascimento"));
		String apelido = request.getParameter("apelido");
		String senha = request.getParameter("senha");

		Usuario usuarioParaInserir = new Usuario(nome, sobrenome, dataNascimento, apelido, senha);
		usuarioDao.inserirUsuario(usuarioParaInserir);
		response.sendRedirect("home");
	}

	private void inserirModerador(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		LocalDate dataNascimento = LocalDate.parse(request.getParameter("dataNascimento"));
		String apelido = request.getParameter("apelido");
		String senha = request.getParameter("senha");

		Moderador moderadorParaInserir = new Moderador(nome, sobrenome, dataNascimento, apelido, senha);
		moderadorDao.inserirModerador(moderadorParaInserir);
		response.sendRedirect("home");
	}

	private void inserirComunidade(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");

		Comunidade comunidadeParaInserir = new Comunidade(nome, descricao);
		comunidadeDao.inserirComunidade(comunidadeParaInserir);
		response.sendRedirect("home");
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
}
