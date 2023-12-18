package br.senac.lugardefala.visao;

import java.time.LocalDate;

import br.senac.lugardefala.modelo.dao.categoria.CategoriaDAO;
import br.senac.lugardefala.modelo.dao.categoria.CategoriaDAOImpl;
import br.senac.lugardefala.modelo.dao.comunidade.ComunidadeDAO;
import br.senac.lugardefala.modelo.dao.comunidade.ComunidadeDAOImpl;
import br.senac.lugardefala.modelo.dao.conselho.ConselhoDAO;
import br.senac.lugardefala.modelo.dao.conselho.ConselhoDAOImpl;
import br.senac.lugardefala.modelo.dao.contato.ContatoDAO;
import br.senac.lugardefala.modelo.dao.contato.ContatoDAOImpl;
import br.senac.lugardefala.modelo.dao.denuncia.DenunciaDAO;
import br.senac.lugardefala.modelo.dao.denuncia.DenunciaDAOImpl;
import br.senac.lugardefala.modelo.dao.moderador.ModeradorDAO;
import br.senac.lugardefala.modelo.dao.moderador.ModeradorDAOImpl;
import br.senac.lugardefala.modelo.dao.relato.RelatoDAO;
import br.senac.lugardefala.modelo.dao.relato.RelatoDAOImpl;
import br.senac.lugardefala.modelo.dao.usuario.UsuarioDAO;
import br.senac.lugardefala.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.contato.Contato;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

public class Principal {

	public static void main(String[] args) {

		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		ContatoDAO contatoDAO = new ContatoDAOImpl();
		ComunidadeDAO comunidadeDAO = new ComunidadeDAOImpl();
		ConselhoDAO conselhoDAO = new ConselhoDAOImpl();
		DenunciaDAO denunciaDAO = new DenunciaDAOImpl();
		ModeradorDAO moderadorDAO = new ModeradorDAOImpl();
		RelatoDAO relatoDAO = new RelatoDAOImpl();
		CategoriaDAO categoriaDAO = new CategoriaDAOImpl();

		Comunidade programadores = new Comunidade("Programadores", "Uma comunidade para programadores");
		Contato contato1 = new Contato("987654321", "joao.silva@gmail.com");

		Usuario usuario = new Usuario("João", "Silva", LocalDate.of(1990, 1, 1), "joao.silva", "senha", "123456789",
				"joao.silva@example.com", programadores, contato1);

		usuario.setContato(contato1);
		usuario.setComunidade(programadores);
		usuario.setNome("Joao");
		usuario.setSobrenome("Silva");
		usuario.setDataNascimento(LocalDate.of(1990, 1, 1));
		usuario.setUser("joao.silva");
		usuario.setSenha("senha");
		usuario.setTelefone("123456789");
		usuario.setEmail("joao.silva@example.com");

//		Status status = new Status();
//
//		Relato relato = new Relato(LocalDate.now(), usuario, "Experiência positiva", null, status, comunidade);
//
//		Moderador moderador = new Moderador("Moderador", "Um", LocalDate.of(1985, 5, 5), "moderador", "senhaModerador",
//				"987654321", "moderador@example.com", comunidade, contato, null, null);
//
//		Denuncia denuncia = new Denuncia(LocalDate.now(), "Conteúdo inadequado", usuario, null, relato, moderador);
//
//		Conselho conselho = new Conselho("Fornecer feedback construtivo", LocalDate.now(), usuario, 5, relato,
//				comunidade);
//
//		Categoria categoria = new Categoria("Programação", "Azul", comunidade);
//
//		comunidade.setCategoria(categoria);

		usuarioDAO.inserirUsuario(usuario);
//		contatoDAO.inserirContato(contato);
//		comunidadeDAO.inserirComunidade(comunidade);
//		conselhoDAO.inserirConselho(conselho);
//		denunciaDAO.inserirDenuncia(denuncia);
//		moderadorDAO.inserirModerador(moderador);
//		relatoDAO.inserirRelato(relato);
//		categoriaDAO.inserirCategoria(categoria);

	}
}
