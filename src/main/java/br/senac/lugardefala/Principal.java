package br.senac.lugardefala;

import java.time.LocalDate;

import br.senac.lugardefala.modelo.dao.categoria.CategoriaDAO;
import br.senac.lugardefala.modelo.dao.categoria.CategoriaDAOImpl;
import br.senac.lugardefala.modelo.dao.comunidade.ComunidadeDAO;
import br.senac.lugardefala.modelo.dao.comunidade.ComunidadeDAOImpl;
import br.senac.lugardefala.modelo.dao.contato.ContatoDAO;
import br.senac.lugardefala.modelo.dao.contato.ContatoDAOImpl;
import br.senac.lugardefala.modelo.dao.usuario.UsuarioDAO;
import br.senac.lugardefala.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.lugardefala.modelo.entidade.categoria.Categoria;
import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.contato.Contato;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;


public class Principal {

	public static void main(String[] args) {

		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		ContatoDAO contatoDAO = new ContatoDAOImpl();
		CategoriaDAO categoriaDAO = new CategoriaDAOImpl();

		Contato contato1 = new Contato();
		contato1.setTelefone("(47)99143-2434");
		contato1.setEmail("eisingbrenda@gmail.com");
		contatoDAO.inserirContato(contato1);

		Usuario usuario1 = new Usuario(null, "Brenda", "Eising", LocalDate.of(2004, 11, 17), "brenda.esg", "LANY",
				contato1);
		usuarioDAO.inserirUsuario(usuario1);

		Contato contato2 = new Contato();
		contato2.setTelefone("(47)99321-8746");
		contato2.setEmail("joao.toureiro@gmail.com");
		contatoDAO.inserirContato(contato2);

		Usuario usuario2 = new Usuario(null, "João", "Toureiro", LocalDate.of(2004, 8, 10), "joao.toureiro", "whey",
				contato2);
		usuarioDAO.inserirUsuario(usuario2);

		Contato contato3 = new Contato();
		contato3.setTelefone("(47)98765-4321");
		contato3.setEmail("maria.fernanda@gmail.com");
		contatoDAO.inserirContato(contato3);

		Usuario usuario3 = new Usuario(null, "Maria Fernanda", "Rengel", LocalDate.of(1995, 3, 22), "maria.fernanda",
				"senha123", contato3);
		usuarioDAO.inserirUsuario(usuario3);

		Contato contato4 = new Contato();
		contato4.setTelefone("(47)99876-5432");
		contato4.setEmail("lucas.loes@gmail.com");
		contatoDAO.inserirContato(contato4);

		Usuario usuario4 = new Usuario(null, "Lucas", "Loes", LocalDate.of(1990, 7, 15), "lucas.loes", "senha456",
				contato4);
		usuarioDAO.inserirUsuario(usuario4);

		Contato contato5 = new Contato();
		contato5.setTelefone("(47)98765-8765");
		contato5.setEmail("aquila.hapuque@gmail.com");
		contatoDAO.inserirContato(contato5);

		Usuario usuario5 = new Usuario(null, "Aquila", "Hapuque", LocalDate.of(1988, 5, 10), "aquila.hapuque",
				"senha789", contato5);
		usuarioDAO.inserirUsuario(usuario5);

		Contato contato6 = new Contato();
		contato6.setTelefone("(47)99999-9999");
		contato6.setEmail("gabriela.adara@gmail.com");
		contatoDAO.inserirContato(contato6);

		Usuario usuario6 = new Usuario(null, "Gabriela", "Adara", LocalDate.of(1998, 12, 3), "gabriela.adara",
				"senha101", contato6);
		usuarioDAO.inserirUsuario(usuario6);

		Contato contato7 = new Contato();
		contato7.setTelefone("(47)98888-8888");
		contato7.setEmail("ana.abreu@gmail.com");
		contatoDAO.inserirContato(contato7);

		Usuario usuario7 = new Usuario(null, "Ana", "de Abreu", LocalDate.of(1992, 6, 7), "ana.abreu", "senha111",
				contato7);
		usuarioDAO.inserirUsuario(usuario7);

		Categoria categoria = new Categoria(null, "Sororidade");
		categoriaDAO.inserirCategoria(categoria);

		ComunidadeDAO comunidadeDAO = new ComunidadeDAOImpl();
		Comunidade comunidade1 = new Comunidade(1, "Violência Física",
				"Comunidade de relatos sobre agressões físicas, como bater, empurrar, chutar, entre outras formas de violência que causem dano ao corpo.");
		comunidadeDAO.inserirComunidade(comunidade1);

		Comunidade comunidade2 = new Comunidade(2, "Violência Psicológica/Emocional",
				"Comunidade de relatos sobre humilhação, ameaças, manipulação emocional, controle excessivo, isolamento social e outras formas de abuso psicológico.");
		comunidadeDAO.inserirComunidade(comunidade2);

		Comunidade comunidade3 = new Comunidade(3, "Violência Sexual",
				"Comunidade de relatos sobre qualquer forma de coerção ou forçar uma mulher a se envolver em atividades sexuais contra a sua vontade.");
		comunidadeDAO.inserirComunidade(comunidade3);

	}
}
