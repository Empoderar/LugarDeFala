package br.senac.lugardefala.visao;

import br.senac.lugardefala.modelo.dao.usuario.UsuarioDAO;
import br.senac.lugardefala.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

public class Principal {

	public static void main(String[] args) {

		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
//		ContatoDAO contatoDAO = new ContatoDAOImpl();
//		RelatoDAO relatoDAO = new RelatoDAOImpl();
//		ConselhoDAO conselhoDAO = new ConselhoDAOImpl();
//		DenunciaDAO denunciaDAO = new DenunciaDAOImpl();
//		CategoriaDAO categoriaDAO = new CategoriaDAOImpl();
//		ComunidadeDAO comunidadeDAO = new ComunidadeDAOImpl();
//		StatusDAO statusDAO = new StatusDAOImpl();
//		ModeradorDAO moderadorDAO = new ModeradorDAOImpl();

		String nome = "Lucas";
		String telefone = "(47) 99111-1111";

		Usuario usuario = new Usuario();

		usuario.setNome(nome);
		usuario.setTelefone(telefone);

		usuarioDAO.inserirUsuario(usuario);

	}
}