package br.senac.lugardefala.visao;

import br.senac.lugardefala.modelo.dao.usuario.UsuarioDAO;
import br.senac.lugardefala.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

public class Principal {

	public static void main(String[] args) {

		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

		String nome = "Brenda";
		Usuario usuario = new Usuario();

		usuario.setNome(nome);

		usuarioDAO.inserirUsuario(usuario);
	}
}