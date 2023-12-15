package br.senac.lugardefala.visao;

import br.senac.lugardefala.modelo.dao.contato.ContatoDAO;
import br.senac.lugardefala.modelo.dao.contato.ContatoDAOImpl;
import br.senac.lugardefala.modelo.dao.relato.RelatoDAO;
import br.senac.lugardefala.modelo.dao.relato.RelatoDAOImpl;
import br.senac.lugardefala.modelo.dao.usuario.UsuarioDAO;
import br.senac.lugardefala.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

public class Principal {

	public static void main(String[] args) {

		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		ContatoDAO contatoDAO = new ContatoDAOImpl();
		RelatoDAO relatoDAO = new RelatoDAOImpl();

		String nome = "Allan";
		String cpf = "123.456.789-10";

		Usuario usuario = new Usuario();

		usuario.setNome(nome);

		usuarioDAO.inserirUsuario(usuario);

	}
}