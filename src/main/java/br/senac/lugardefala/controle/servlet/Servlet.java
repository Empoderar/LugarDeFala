package br.senac.lugardefala.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senac.lugardefala.modelo.dao.usuario.UsuarioDAO;
import br.senac.lugardefala.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

@WebServlet("/")
public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDao;

	public void init() {
		usuarioDao = new UsuarioDAOImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ligacao = request.getServletPath();

		try {

			switch (ligacao) {

			case "/novo-usuario":
				mostrarTelaCadastroUsuario(request, response);
				break;

			case "/inserir-usuario":
				inserirUsuario(request, response);
				break;

			case "/deletar-usuario":
				deletarUsuario(request, response);
				break;

			case "/atualizar-usuario":
				atualizarUsuario(request, response);
				break;

			case "/editar-usuario":
				editarUsuario(request, response);

			default:
				listarUsuarios(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listarUsuarios(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Usuario> usuarios = usuarioDao.recuperarUsuarios();
		request.setAttribute("usuarios", usuarios);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listar-usuarios.jsp");
		dispatcher.forward(request, response);
	}

	private void editarUsuario(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, ServletException, IOException {
	
		String nome =(request.getParameter("nome"));
		Usuario usuario = usuarioDao.buscarUsuarioPeloNome(nome);
		request.setAttribute("usuario", nome);
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cadastro-usuario.jsp");
		dispatcher.forward(request, response);
	}
	
	private void atualizarUsuario(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, ServletException, IOException {
		
	}


	private void deletarUsuario(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, ServletException, IOException {
		
	}

	private void inserirUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		LocalDate dataNascimento = LocalDate.parse(request.getParameter("dataNascimento"));
		String apelido = request.getParameter("apelido");
		String senha = request.getParameter("senha");

		usuarioDao.inserirUsuario(new Usuario(nome, sobrenome, dataNascimento, apelido, senha));
		response.sendRedirect("listar");
	}
	
	private void mostrarTelaCadastroUsuario(HttpServletRequest request, HttpServletResponse response) 
		
		throws ServletException, IOException {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cadastro-usuario.jsp");
			dispatcher.forward(request, response);
	


	}
}
