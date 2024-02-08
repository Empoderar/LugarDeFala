
package br.senac.lugardefala;

import java.time.LocalDate;
import java.util.List;

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

public class Principal {

	public static void main(String[] args) {

		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		ContatoDAO contatoDAO = new ContatoDAOImpl();
		CategoriaDAO categoriaDAO = new CategoriaDAOImpl();
		ModeradorDAO moderadorDAO = new ModeradorDAOImpl();
		ConselhoDAO conselhoDAO = new ConselhoDAOImpl();
		DenunciaConselhoDAO denunciaConselhoDAO = new DenunciaConselhoDAOImpl();
		DenunciaModeradorDAO denunciaModeradorDAO = new DenunciaModeradorDAOImpl();
		DenunciaUsuarioDAO denunciaUsuarioDAO = new DenunciaUsuarioDAOImpl();
		DenunciaRelatoDAO denunciaRelatoDAO = new DenunciaRelatoDAOImpl();
		RelatoDAO relatoDAO = new RelatoDAOImpl();
		ComunidadeDAO comunidadeDAO = new ComunidadeDAOImpl();

		// Criação de contatos
		Contato contato2 = new Contato();
		contato2.setTelefone("(47)99321-8746");
		contato2.setEmail("joao.toureiro@gmail.com");
		contatoDAO.inserirContato(contato2);

		Contato contato3 = new Contato();
		contato3.setTelefone("(47)98765-4321");
		contato3.setEmail("maria.fernanda@gmail.com");
		contatoDAO.inserirContato(contato3);

		Contato contato4 = new Contato();
		contato4.setTelefone("(47)99876-5432");
		contato4.setEmail("lucas.loes@gmail.com");
		contatoDAO.inserirContato(contato4);

		Contato contato5 = new Contato();
		contato5.setTelefone("(47)98765-8765");
		contato5.setEmail("aquila.hapuque@gmail.com");
		contatoDAO.inserirContato(contato5);

		Contato contato6 = new Contato();
		contato6.setTelefone("(47)99999-9999");
		contato6.setEmail("gabriela.adara@gmail.com");
		contatoDAO.inserirContato(contato6);

		Contato contato7 = new Contato();
		contato7.setTelefone("(47)98888-8888");
		contato7.setEmail("ana.abreu@gmail.com");
		contatoDAO.inserirContato(contato7);

		// Criação de comunidades
		Comunidade comunidade1 = new Comunidade(1, "Violência Física",
				"Comunidade de relatos sobre agressões físicas, como bater, empurrar, chutar, entre outras formas de violência que causem dano ao corpo.");
		comunidadeDAO.inserirComunidade(comunidade1);

		Comunidade comunidade2 = new Comunidade(2, "Violência Psicológical",
				"Comunidade de relatos sobre humilhação, ameaças, manipulação emocional, controle excessivo, isolamento social e outras formas de abuso psicológico.");
		comunidadeDAO.inserirComunidade(comunidade2);

		Comunidade comunidade3 = new Comunidade(3, "Violência Sexual",
				"Comunidade de relatos sobre qualquer forma de coerção ou forçar uma mulher a se envolver em atividades sexuais contra a sua vontade.");
		comunidadeDAO.inserirComunidade(comunidade3);

		Comunidade comunidade4 = new Comunidade(4, "Violência Patrimonial",
				"Comunidade de relatos sobre a retenção, subtração, ou destruição dos bens pessoais da mulher, feitas pelo agressor.");
		comunidadeDAO.inserirComunidade(comunidade4);

		Comunidade comunidade5 = new Comunidade(5, "Violência Moral",
				"Comunidade de relatos sobre qualquer conduta que configure calúnia, difamação ou injúria contra a mulher.");
		comunidadeDAO.inserirComunidade(comunidade5);

		// Criação de categorias
		Categoria categoria = new Categoria("Sororidade");
		categoriaDAO.inserirCategoria(categoria);

		Categoria categoria2 = new Categoria("Ajude-me");
		categoriaDAO.inserirCategoria(categoria2);

		Categoria categoria3 = new Categoria("Desabafo");
		categoriaDAO.inserirCategoria(categoria3);

		Categoria categoria4 = new Categoria("Aconselhamento Jurídico");
		categoriaDAO.inserirCategoria(categoria4);

		Categoria categoria5 = new Categoria("Acolhimento Temporário");
		categoriaDAO.inserirCategoria(categoria5);

		Categoria categoria6 = new Categoria("Assistência Social");
		categoriaDAO.inserirCategoria(categoria6);

		// Criação de relatos
		Relato relato1 = new Relato(null, "Um relato sobre sororidade", LocalDate.now(), null, 5, null, Status.APROVADO,
				comunidade1);
		relato1.inserirCategoriaRelato(categoria);
		relatoDAO.inserirRelato(relato1);

		Relato relato2 = new Relato(null, "Outro relato sobre sororidade", LocalDate.now(), null, 4, null,
				Status.APROVADO, comunidade1);
		relato2.inserirCategoriaRelato(categoria);
		relatoDAO.inserirRelato(relato2);

		Relato relato3 = new Relato(null, "Relato sobre acolhimento temporário", LocalDate.now(), null, 2, null,
				Status.ARQUIVADO, comunidade3);

		relato3.inserirCategoriaRelato(categoria);
		relatoDAO.inserirRelato(relato3);
		Relato relato4 = new Relato(null, "Relato sobre desabafo", LocalDate.now(), null, 3, null, Status.ARQUIVADO,
				comunidade1);

		relato4.inserirCategoriaRelato(categoria);
		relatoDAO.inserirRelato(relato4);

		// Criação de conselhos
		Conselho conselho1 = new Conselho(1, "Mantenha-se forte!", 5, 0, LocalDate.now(), null, relato1, comunidade1);
		conselhoDAO.inserirConselho(conselho1);

		Conselho conselho2 = new Conselho(2, "Isso já aconteceu comigo também...", 2, 0, LocalDate.now(), null, relato1,
				comunidade2);
		conselhoDAO.inserirConselho(conselho2);

		Conselho conselho3 = new Conselho(3, "Você é forte só por compartilhar isso conosco :)", 9, 0, LocalDate.now(),
				null, relato2, comunidade3);
		conselhoDAO.inserirConselho(conselho3);

		Conselho conselho4 = new Conselho(4, "Quanto drama", 0, 10, LocalDate.now(), null, relato3, comunidade4);
		conselhoDAO.inserirConselho(conselho4);

		Conselho conselho5 = new Conselho(3, "Espero que tudo melhore.", 8, 0, LocalDate.now(), null, relato4,
				comunidade5);

		conselhoDAO.inserirConselho(conselho5);

		Conselho conselho6 = new Conselho(1, "Eu sinto muito por isso.", 7, 0, LocalDate.now(), null, relato4,
				comunidade5);

		conselhoDAO.inserirConselho(conselho6);

		// Criação de usuários
		Usuario usuario2 = new Usuario(null, "João", "Toureiro", LocalDate.of(2004, 8, 10), "joao.tourei1ro", "whey",
				"Aceite seus limites sem jamais desacreditar na sua capacidade de superação.", conselho1, contato2,
				comunidade1);
		usuarioDAO.inserirUsuario(usuario2);

		Usuario usuario3 = new Usuario(null, "Maria Fernanda", "Rengel", LocalDate.of(1995, 3, 22), "maria.fernanda",
				"senha123", "Aceite seus limites sem jamais desacreditar na sua capacidade de superação.", conselho1,
				contato3, comunidade1);
		usuarioDAO.inserirUsuario(usuario3);

		Usuario usuario4 = new Usuario(null, "Lucas", "Loes", LocalDate.of(1990, 7, 15), "lucas.loes", "senha456",
				"Aceite seus limites sem jamais desacreditar na sua capacidade de superação.", conselho1, contato4,
				comunidade1);
		usuarioDAO.inserirUsuario(usuario4);

		Usuario usuario5 = new Usuario(null, "Aquila", "Hapuque", LocalDate.of(1988, 5, 10), "aquila.hapuque",
				"senha789", "Aceite seus limites sem jamais desacreditar na sua capacidade de superação.", conselho1,
				contato5, comunidade1);
		usuarioDAO.inserirUsuario(usuario5);

		Usuario usuario6 = new Usuario(null, "Gabriela", "Adara", LocalDate.of(1998, 12, 3), "gabriela.adara",
				"senha101", "Aceite seus limites sem jamais desacreditar na sua capacidade de superação.", conselho1,
				contato6, comunidade1);
		usuarioDAO.inserirUsuario(usuario6);

		Usuario usuario7 = new Usuario(null, "Ana", "de Abreu", LocalDate.of(1992, 6, 7), "ana.abreu", "senha111",
				"Aceite seus limites sem jamais desacreditar na sua capacidade de superação.", conselho1, contato7,
				comunidade1);
		usuarioDAO.inserirUsuario(usuario7);

		Usuario usuario8 = new Usuario(null, "Teste", "de Teste", LocalDate.of(1995, 6, 7), "teste.teste", "senha123",
				"testetesteteste", conselho1, null, comunidade1);
		usuarioDAO.inserirUsuario(usuario8);
		
//		Contato contato8 = new Contato();
//		contato8.setTelefone("(00)00000-0000");
//		contato8.setEmail("teste@teste.com");
//		contato8.setUsuario(usuario8);
//		contatoDAO.inserirContato(contato8);
//		
//		usuario8.setContato(contato8);

		// Criação de moderadores
		Contato contatoModeradorAmanda = new Contato();
		contatoModeradorAmanda.setTelefone("(47)98525-4121");
		contatoModeradorAmanda.setEmail("amanda.moderadora@gmail.com");
		contatoDAO.inserirContato(contatoModeradorAmanda);

		Moderador moderadorAmanda = new Moderador(1, "Amanda", "Lucs", LocalDate.of(2002, 11, 27), "amanda.lsc",
				"senhaModerador",
				"“A força não vem da capacidade física. Ela vem de uma vontade indomável.” - Mahatma Gandhi", conselho1,
				contatoModeradorAmanda, comunidade2);
		moderadorDAO.inserirModerador(moderadorAmanda);

		Contato contatoModeradorBrenda = new Contato();
		contatoModeradorBrenda.setTelefone("(48)98646-7254");
		contatoModeradorBrenda.setEmail("brenda.moderadora@gmail.com");
		contatoDAO.inserirContato(contatoModeradorBrenda);
		Moderador moderadorBrenda = new Moderador(2, "Brenda", "Monteiro", LocalDate.of(2000, 8, 30), "brenda.monteiro",
				"senhaModerador2",
				"“A força não vem da capacidade física. Ela vem de uma vontade indomável.” - Mahatma Gandhi", conselho1,
				contatoModeradorBrenda, comunidade1);
		moderadorDAO.inserirModerador(moderadorBrenda);

		Contato contatoModeradorLuciene = new Contato();
		contatoModeradorLuciene.setTelefone("(21)98734-5477");
		contatoModeradorLuciene.setEmail("luciene.moderadora@gmail.com");
		contatoDAO.inserirContato(contatoModeradorLuciene);
		Moderador moderadorLuciene = new Moderador(3, "Luciene", "Queiroz", LocalDate.of(1975, 5, 31),
				"luciene.queiroz", "senhaModerador3",
				"“A força não vem da capacidade física. Ela vem de uma vontade indomável.” - Mahatma Gandhi", conselho1,
				contatoModeradorLuciene, comunidade3);
		moderadorDAO.inserirModerador(moderadorLuciene);

		Contato contatoModeradorMariana = new Contato();
		contatoModeradorMariana.setTelefone("(68)98525-4121");
		contatoModeradorMariana.setEmail("mariana.moderadora@gmail.com");
		contatoDAO.inserirContato(contatoModeradorMariana);
		Moderador moderadorMariana = new Moderador(4, "Mariana", "Abreu", LocalDate.of(2001, 5, 20), "mariana.abreu",
				"senhaModerador4",
				"“A força não vem da capacidade física. Ela vem de uma vontade indomável.” - Mahatma Gandhi", conselho1,
				contatoModeradorMariana, comunidade4);
		moderadorDAO.inserirModerador(moderadorMariana);

		Contato contatoModeradorGiovanna = new Contato();
		contatoModeradorGiovanna.setTelefone("(54)96465-9876");
		contatoModeradorGiovanna.setEmail("giovanna.moderadora@gmail.com");
		contatoDAO.inserirContato(contatoModeradorGiovanna);
		Moderador moderadorGiovanna = new Moderador(5, "Giovanna", "Soriano", LocalDate.of(1991, 12, 27),
				"giovanna.soriano", "senhaModerador5",
				"“A força não vem da capacidade física. Ela vem de uma vontade indomável.” - Mahatma Gandhi", conselho1,
				contatoModeradorGiovanna, comunidade5);
		moderadorDAO.inserirModerador(moderadorGiovanna);

		Contato contatoModeradorMarcella = new Contato();
		contatoModeradorMarcella.setTelefone("(21)9345-1234");
		contatoModeradorMarcella.setEmail("marcella.moderadora@gmail.com");
		contatoDAO.inserirContato(contatoModeradorMarcella);
		Moderador moderadorMarcella = new Moderador(6, "Marcella", "Barboza", LocalDate.of(2002, 3, 21),
				"marcella.barboza", "senhaModerador6",
				"“A força não vem da capacidade física. Ela vem de uma vontade indomável.” - Mahatma Gandhi", conselho1,
				contatoModeradorMarcella, comunidade2);
		moderadorDAO.inserirModerador(moderadorMarcella);

		Contato contatoModeradorBruna = new Contato();
		contatoModeradorBruna.setTelefone("(47)99645-4121");
		contatoModeradorBruna.setEmail("bruna.moderadora@gmail.com");
		contatoDAO.inserirContato(contatoModeradorBruna);
		Moderador moderadorBruna = new Moderador(7, "Bruna", "Caria", LocalDate.of(1987, 11, 7), "bruna.caria",
				"senhaModerador7",
				"“A força não vem da capacidade física. Ela vem de uma vontade indomável.” - Mahatma Gandhi", conselho1,
				contatoModeradorBruna, comunidade3);
		moderadorDAO.inserirModerador(moderadorBruna);

		Contato contatoModeradorAlice = new Contato();
		contatoModeradorAlice.setTelefone("(47)99262-4221");
		contatoModeradorAlice.setEmail("alice.moderadora@gmail.com");
		contatoDAO.inserirContato(contatoModeradorAlice);
		Moderador moderadorAlice = new Moderador(8, "Alice", "Rocha", LocalDate.of(1992, 4, 7), "alice.rocha",
				"senhaModerador8",
				"“A força não vem da capacidade física. Ela vem de uma vontade indomável.” - Mahatma Gandhi", conselho1,
				contatoModeradorAlice, comunidade1);
		moderadorDAO.inserirModerador(moderadorAlice);

		// Criação de denúncias
		DenunciaConselho denunciaConselho = new DenunciaConselho(0, usuario2, LocalDate.now(), "Conteúdo inadequado",
				Status.PENDENTE, conselho1);
		denunciaConselhoDAO.inserirDenunciaConselho(denunciaConselho);

		DenunciaModerador denunciaModerador = new DenunciaModerador(0, LocalDate.now(), "Comportamento inadequado",
				Status.PENDENTE, usuario5, moderadorAlice);
		denunciaModeradorDAO.inserirDenunciaModerador(denunciaModerador);

		DenunciaUsuario denunciaUsuario = new DenunciaUsuario(usuario5, 0, LocalDate.now(), "Motivo da denúncia",
				Status.PENDENTE, usuario2);
		denunciaUsuarioDAO.inserirDenunciaUsuario(denunciaUsuario);


		DenunciaRelato denunciaRelato = new DenunciaRelato(0, LocalDate.now(), "Conteúdo falso",
				Status.PENDENTE, usuario5, relato2);
		denunciaRelatoDAO.inserirDenunciaRelato(denunciaRelato);

		// Adicionando os Usuários e Moderadores ao Relato, Conselho

		relato1.setUsuario(usuario2);
		relato2.setUsuario(usuario3);
		relato3.setUsuario(usuario4);
		relato4.setUsuario(usuario5);
		relato1.setModerador(moderadorAlice);
		relato2.setModerador(moderadorAmanda);
		relato3.setModerador(moderadorBrenda);
		relato4.setModerador(moderadorBruna);

		conselho1.setUsuario(usuario2);
		conselho2.setUsuario(usuario3);
		conselho3.setUsuario(usuario4);
		conselho4.setUsuario(usuario5);
		conselho5.setUsuario(usuario6);
		conselho6.setUsuario(usuario7);

		conselhoDAO.atualizarConselho(conselho1);
		conselhoDAO.atualizarConselho(conselho2);
		conselhoDAO.atualizarConselho(conselho3);
		conselhoDAO.atualizarConselho(conselho4);
		conselhoDAO.atualizarConselho(conselho5);
		conselhoDAO.atualizarConselho(conselho6);

		// Criação de consultas

		// Teste Usuario

		Usuario usuarioPeloNome = usuarioDAO.recuperarUsuarioPeloNome("Alice");
		if (usuarioPeloNome != null) {
			System.out.println("Buscar usuário pelo nome: " + usuarioPeloNome.getNome());
		} else {
			System.out.println("Não ha usuario com este nome");
		}

		List<Usuario> usuarios = usuarioDAO.recuperarUsuariosPorComunidade(comunidade3);

		for (Usuario usuario1 : usuarios) {
			if (usuario1 != null) {
				System.out.println("Buscar usuário por comunidade: " + usuario1.getNome());
			} else {
				System.out.println("Não ha usuario nessa comunidade");
			}
		}

		List<Usuario> usuariosPorConselho = usuarioDAO.recuperarUsuariosPorConselho(conselho1);
		for (Usuario usuarios2 : usuariosPorConselho) {
			if (usuarios2 != null) {
				System.out.println("Buscar usuário por conselho: " + usuarios2.getNome());
			} else {
				System.out.println("Não ha usuario nesse conselho");
			}
		}

		List<Usuario> usuarios3 = usuarioDAO.recuperarUsuariosPorRelato(relato2);

		for (Usuario usuario : usuarios3) {
			if (usuario != null) {
				System.out.println("Buscar usuário por relato: " + usuario.getNome());
			} else {
				System.out.println("Não ha usuario para esse relato");
			}
		}
		Usuario recuperarUsuarioId = usuarioDAO.recuperarUsuarioPeloId(1L);
		if (recuperarUsuarioId != null) {
			System.out.println("Buscar usuário por id: " + recuperarUsuarioId.getNome());
		} else {
			System.out.println("Não ha usuario com esse id");
		}

		// Teste Moderador

		Moderador moderadorPeloNome = moderadorDAO.recuperarModeradorPeloNome("Bruna");
		if (moderadorPeloNome != null) {
			System.out.println("Buscar Moderador por nome: " + moderadorPeloNome.getNome());
		} else {
			System.out.println("Não ha Moderador com esse nome");
		}

		List<Moderador> moderador = moderadorDAO.recuperarModeradoresPeloId(12L);
		for (Moderador moderadorRecuperado : moderador) {
			if (moderadorRecuperado != null) {
				System.out.println("Buscar Moderador por id: " + moderadorRecuperado.getNome());
			} else {
				System.out.println("Não ha Moderador com esse id");
			}
		}

//		List<Moderador> parametroComunidade = moderadorDAO.recuperarModeradoresPelaComunidade(comunidade1);
//		for (Moderador moderadores : parametroComunidade) {
//			if (moderadores != null) {
//				System.out.println("Buscar Moderador comunidade: " + moderadores.getNome());
//			} else {
//				System.out.println("Não ha Moderador nessa comunidade");
//			}
//		}

		// Teste Conselho

		List<Conselho> recuperarConselhoPeloUsuario = conselhoDAO.recuperarConselhoPeloUsuario(usuario5);

		for (Conselho conselho : recuperarConselhoPeloUsuario) {
			if (conselho != null) {
				System.out.println("Buscar conselho pelo usuario: " + conselho.getConteudo());
			} else {
				System.out.println("Esse usuario não posui conselhos");
			}
		}

		List<Conselho> conselhos = conselhoDAO.recuperarConselhoRelato(relato1);

		for (Conselho conselho : conselhos) {
			if (conselho != null) {
				System.out.println("Buscar conselho pelo Relato: " + conselho.getConteudo());
			} else {
				System.out.println("Este relato não possui conselhos");
			}
		}

		Conselho recuperarPeloId = conselhoDAO.recuperarConselhoPeloId(1L);
		if (recuperarPeloId != null) {
			System.out.println("Buscar conselho pelo id: " + recuperarPeloId.getConteudo());
		} else {
			System.out.println("Este conselho com este id");
		}

		// Teste Relato

		List<Relato> recuperarRelatosPeloUsuario = relatoDAO.recuperarRelatosPeloUsuario(usuario2);

		for (Relato relato : recuperarRelatosPeloUsuario) {
			if (relato != null) {
				System.out.println("Relato pelo usuario: " + relato.getConteudo());
			} else {
				System.out.println("Relato inexistente");
			}
		}

		List<Relato> recuperarRelatosPelaCategoria = relatoDAO.recuperarRelatosPelaCategoria(categoria);

		for (Relato relato : recuperarRelatosPelaCategoria) {
			if (relato != null) {
				System.out.println("Relato pela categoria: " + relato.getConteudo());
			} else {
				System.out.println("Relato inexistente");
			}
		}

		List<Relato> relatos = relatoDAO.recuperarRelatosPeloStatus(Status.APROVADO);

		for (Relato relato : relatos) {
			if (relato != null) {
				System.out.println("Relato pelo status: " + relato.getConteudo());
			} else {
				System.out.println("Relato inexistente");
			}
		}

		List<Relato> comunidade = relatoDAO.recuperarRelatosPelaComunidade(comunidade1);

		for (Relato relato : comunidade) {
			if (relato != null) {
				System.out.println("Relato pela comunidade: " + relato.getConteudo());
			} else {
				System.out.println("Relato inexistente");
			}
		}

			Relato relatoPorId = relatoDAO.recuperarRelatoPorId(2L);
			if (relatoPorId != null) {
				System.out.println("Relato pelo ID: " + relatoPorId.getConteudo());
			} else {
				System.out.println("Relato inexistente");
			}

			// Teste Contato

			Contato contatoRecuperado = contatoDAO.recuperarContatoDoUsuarioPeloId(1L);
			if (contatoRecuperado != null) {
				System.out.println("Contato usuario pelo ID: " + contatoRecuperado.getTelefone());
			} else {
				System.out.println("Usuario invalido ou sem contato");
			}

			// Teste Categoria
			
			Categoria recuperarCategoriaId = categoriaDAO.recuperarCategoriaPeloId(1L);
			if (recuperarCategoriaId != null) {
				System.out.println("Recuperar categoria pelo id: " + recuperarCategoriaId.getNome());
			} else {
				System.out.println("Sem categoria");
			}

			Categoria recuperarCategoriaRelato = categoriaDAO.recuperarCategoriaRelato(relato4);
			if (recuperarCategoriaRelato != null) {
				System.out.println("Recuperar categoria pelo relato: " + recuperarCategoriaRelato.getNome());
			} else {
				System.out.println("Relato não existe");
			}
		
			Categoria recuperarCategoriaNome = categoriaDAO.recuperarCategoriaPeloNome("Sororidade");
			if (recuperarCategoriaNome != null) {
				System.out.println("Recuperar categoria pelo nome: " + recuperarCategoriaNome.getNome());
			} else {
				System.out.println("Sem categoria");
			}


		// Teste Denuncia
		List<DenunciaUsuario> DenunciasUsuarios = denunciaUsuarioDAO.recuperarDenunciaUsuarioPeloUsuario(usuario5);
		for (DenunciaUsuario denunciaUsuario2 : DenunciasUsuarios) {
			System.out.println("Denuncias de usuarios por usuario: " + denunciaUsuario2.getMotivo());
		}

		List<DenunciaUsuario> DenunciasUsuarios2 = denunciaUsuarioDAO.recuperarDenunciaUsuarioStatus(Status.PENDENTE);
		for (DenunciaUsuario denunciaUsuario2 : DenunciasUsuarios2) {
			System.out.println("Denuncias de usuarios por status: " + denunciaUsuario2.getMotivo());
		}

		
		List<DenunciaConselho> denunciasConselhos = denunciaConselhoDAO.recuperarDenunciaDeConselhoRelato(relato1);
		for (DenunciaConselho denunciaConselho1 : denunciasConselhos) {
		    System.out.println("Denuncia de conselho pelo relato: " + denunciaConselho1.getMotivo());
		}

		List<DenunciaConselho> denunciasConselhos3 = denunciaConselhoDAO.recuperarDenunciaDeConselhoStatus(Status.PENDENTE);
		for (DenunciaConselho denunciaConselho3 : denunciasConselhos3) {
		    System.out.println("Denuncia de conselho pelo status: " + denunciaConselho3.getMotivo());


		List<DenunciaRelato> denunciaRelatoPorStatus = denunciaRelatoDAO.recuperarDenunciaRelatoStatus(Status.PENDENTE);
		for (DenunciaRelato denunciaRelato1 : denunciaRelatoPorStatus) {
		    System.out.println("Buscar denuncia de relato pelo status: " + denunciaRelato1.getMotivo());
		}

		List <DenunciaRelato> denunciaRelatoPorRelato = denunciaRelatoDAO.recuperarDenunciaRelatoPeloRelato(relato1);
		for (DenunciaRelato denunciaRelato2 : denunciaRelatoPorRelato) {
		    System.out.println("Buscar denuncia de relato pelo relato: " + denunciaRelato2.getMotivo());


		DenunciaModerador denunciaModerador1 = denunciaModeradorDAO.recuperarDenunciaModeradorPorId(2L);
		if (denunciaModerador1 != null) {
		    System.out.println("DenunciaModerador por ID: " + denunciaModerador1.getMotivo());
		} else {
		    System.out.println("DenunciaModerador por ID não encontrada");
		}

		// Teste Comunidade

		Comunidade recuperarComunidadeNome = comunidadeDAO.recuperarComunidadePeloId(1L);
		if (recuperarComunidadeNome != null) {
			System.out.println("Recuperar comunidade pelo nome: " + recuperarComunidadeNome.getNome());
		} else {
			System.out.println("Não existe comunidade com esse nome");
		}

		List<Comunidade> recuperarComunidadeModerador = comunidadeDAO.recuperarComunidadesPeloIdModerador(12L);
		for (Comunidade comunidades : recuperarComunidadeModerador) {
			if (comunidades != null) {
				System.out.println("Recuperar comunidades pelo id do moderador : " + comunidades.getNome());
			} else {
				System.out.println("Não existem comunidades com esse moderador");
			}
		}

		List<Comunidade> recuperarComunidadeUsuario = comunidadeDAO.recuperarComunidadesPeloIdUsuario(1L);
		for (Comunidade comunidades : recuperarComunidadeUsuario) {
			if (comunidades != null) {
				System.out.println("Recuperar comunidades pelo id do usuario : " + comunidades.getNome());
			} else {
				System.out.println("Não existem comunidades com esse usuario");
			}
		}

		List<Comunidade> recuperarComunidadePeloUsuario = comunidadeDAO.recuperarComunidadesPeloUsuario(usuario2);

		if (!recuperarComunidadePeloUsuario.isEmpty()) {
			for (Comunidade c : recuperarComunidadePeloUsuario) {
				System.out.println("Recuperar comunidades pelo nome do usuário: " + c.getNome());
			}
		} else {
			System.out.println("Não existem comunidades com esse usuário");
		}

// -----------------------------------------------------------------------------------------//
		String email = "teste@teste.com";
		String senha = "senha123";
		Usuario usuario = usuarioDAO.obterUsuarioPorCredenciais(email, senha);

		if (usuario != null) {
			System.out.println("Usuário encontrado: " + usuario.getNome());
		} else {
			System.out.println("Usuário não encontrado. Credenciais inválidas.");
		}
	}
}}}
