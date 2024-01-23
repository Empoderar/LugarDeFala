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

		Contato contato8 = new Contato();
		contato8.setTelefone("(47)99740-3171");
		contato8.setEmail("renan.batista@gmail.com");
		contatoDAO.inserirContato(contato8);

		Contato contato9 = new Contato();
		contato9.setTelefone("(47)98509-1502");
		contato9.setEmail("renato.junior@gmail.com");
		contatoDAO.inserirContato(contato9);

		Contato contato10 = new Contato();
		contato10.setTelefone("(47)94663-3471");
		contato10.setEmail("yan.silva@gmail.com");
		contatoDAO.inserirContato(contato10);

		Contato contato11 = new Contato();
		contato11.setTelefone("(47)97502-9801");
		contato11.setEmail("thiago.pereira@gmail.com");
		contatoDAO.inserirContato(contato11);

		Contato contato12 = new Contato();
		contato12.setTelefone("(47)94925-8514");
		contato12.setEmail("eduardo.schimmit@gmail.com");
		contatoDAO.inserirContato(contato12);

		Contato contato13 = new Contato();
		contato13.setTelefone("(47)95632-6510");
		contato13.setEmail("marlon.krause@gmail.com");
		contatoDAO.inserirContato(contato13);

		Contato contato14 = new Contato();
		contato14.setTelefone("(47)95703-4167");
		contato14.setEmail("gleidson.sanguanini@gmail.com");
		contatoDAO.inserirContato(contato14);

		Contato contato15 = new Contato();
		contato15.setTelefone("(47)95703-4168");
		contato15.setEmail("silvio.luiz@gmail.com");
		contatoDAO.inserirContato(contato15);

		Contato contato16 = new Contato();
		contato16.setTelefone("(47)94170-6137");
		contato16.setEmail("ernesto.soares@gmail.com");
		contatoDAO.inserirContato(contato16);

		Contato contato17 = new Contato();
		contato17.setTelefone("(47)97813-6190");
		contato17.setEmail("arthur.fernandes@gmail.com");
		contatoDAO.inserirContato(contato17);

		Contato contato18 = new Contato();
		contato18.setTelefone("(47)99567-0792");
		contato18.setEmail("kaio.aleixo@gmail.com");
		contatoDAO.inserirContato(contato18);

		Contato contato19 = new Contato();
		contato19.setTelefone("(47)99992-1906");
		contato19.setEmail("beatriz.rodrigues@gmail.com");
		contatoDAO.inserirContato(contato19);

		Contato contato20 = new Contato();
		contato20.setTelefone("(47)99872-2963");
		contato20.setEmail("cristiane.santos@gmail.com");
		contatoDAO.inserirContato(contato20);

		Contato contato21 = new Contato();
		contato21.setTelefone("(47)91482-8310");
		contato21.setEmail("pamela.bernardo@gmail.com");
		contatoDAO.inserirContato(contato21);

		Contato contato22 = new Contato();
		contato22.setTelefone("(47)95402-3311");
		contato22.setEmail("mathias.garcia@gmail.com");
		contatoDAO.inserirContato(contato22);

		Contato contato23 = new Contato();
		contato23.setTelefone("(11)97777-7777");
		contato23.setEmail("bruna.koprowisk@gmail.com");
		contatoDAO.inserirContato(contato23);

		Contato contato24 = new Contato();
		contato24.setTelefone("(48)96666-6666");
		contato24.setEmail("vera.cruz@gmail.com");
		contatoDAO.inserirContato(contato24);

		Contato contato25 = new Contato();
		contato25.setTelefone("(48)95555-5555");
		contato25.setEmail("rafaela.gomes@gmail.com");
		contatoDAO.inserirContato(contato25);

		Contato contato26 = new Contato();
		contato26.setTelefone("(75)94444-4444");
		contato26.setEmail("marcela.arruda@gmail.com");
		contatoDAO.inserirContato(contato26);

		Contato contato27 = new Contato();
		contato27.setTelefone("(21)93333-3333");
		contato27.setEmail("leticia.farias@gmail.com");
		contatoDAO.inserirContato(contato27);

		Contato contato28 = new Contato();
		contato28.setTelefone("(11)92222-2222");
		contato28.setEmail("carla.spudeit@gmail.com");
		contatoDAO.inserirContato(contato28);

		Contato contato29 = new Contato();
		contato29.setTelefone("(23)91111-1111");
		contato29.setEmail("luiza.durangi@gmail.com");
		contatoDAO.inserirContato(contato29);

		Contato contato30 = new Contato();
		contato30.setTelefone("(13)90000-0000");
		contato30.setEmail("patricia.aguiar@gmail.com");
		contatoDAO.inserirContato(contato30);

		Contato contato31 = new Contato();
		contato31.setTelefone("(91)99234-8976");
		contato31.setEmail("flavia.diniz@gmail.com");
		contatoDAO.inserirContato(contato31);

		Contato contato32 = new Contato();
		contato32.setTelefone("47)99237-8946");
		contato32.setEmail("elena.cardoso@gmail.com");
		contatoDAO.inserirContato(contato32);

		Contato contato33 = new Contato();
		contato33.setTelefone("(48)99837-2946");
		contato33.setEmail("bianca.shmitt@gmail.com");
		contatoDAO.inserirContato(contato33);

		Contato contato34 = new Contato();
		contato34.setTelefone("(46)99817-2646");
		contato34.setEmail("aparecida.conceicao@gmail.com");
		contatoDAO.inserirContato(contato34);

		Contato contato35 = new Contato();
		contato35.setTelefone("(12)99887-2226");
		contato35.setEmail("felipe.borba@gmail.com");
		contatoDAO.inserirContato(contato35);

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
		Categoria categoria = new Categoria(null, "Sororidade");
		categoriaDAO.inserirCategoria(categoria);

		Categoria categoria2 = new Categoria(null, "Ajude-me");
		categoriaDAO.inserirCategoria(categoria2);

		Categoria categoria3 = new Categoria(null, "Desabafo");
		categoriaDAO.inserirCategoria(categoria3);

		Categoria categoria4 = new Categoria(null, "Aconselhamento Jurídico");
		categoriaDAO.inserirCategoria(categoria4);

		Categoria categoria5 = new Categoria(null, "Acolhimento Temporário");
		categoriaDAO.inserirCategoria(categoria5);

		Categoria categoria6 = new Categoria(null, "Assistência Social");
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
		Conselho conselho1 = new Conselho(1, "Mantenha-se forte!", 5, 0, LocalDate.now(), null, relato1);
		conselhoDAO.inserirConselho(conselho1);

		Conselho conselho2 = new Conselho(2, "Isso já aconteceu comigo também...", 2, 0, LocalDate.now(), null,
				relato1);
		conselhoDAO.inserirConselho(conselho2);

		Conselho conselho3 = new Conselho(3, "Você é forte só por compartilhar isso conosco :)", 9, 0, LocalDate.now(),
				null, relato2);
		conselhoDAO.inserirConselho(conselho3);

		Conselho conselho4 = new Conselho(4, "Quanto drama", 0, 10, LocalDate.now(), null, relato3);
		conselhoDAO.inserirConselho(conselho4);

		Conselho conselho5 = new Conselho(3, "Espero que tudo melhore.", 8, 0, LocalDate.now(), null, relato4);

		conselhoDAO.inserirConselho(conselho5);

		Conselho conselho6 = new Conselho(1, "Eu sinto muito por isso.", 7, 0, LocalDate.now(), null, relato4);

		conselhoDAO.inserirConselho(conselho6);

		// Criação de usuários
		Usuario usuario2 = new Usuario(null, "João", "Toureiro", LocalDate.of(2004, 8, 10), "joao.tourei1ro", "whey",
				conselho1, contato2, comunidade1);
		usuarioDAO.inserirUsuario(usuario2);

		Usuario usuario3 = new Usuario(null, "Maria Fernanda", "Rengel", LocalDate.of(1995, 3, 22), "maria.fernanda",
				"senha123", conselho1, contato3, comunidade1);
		usuarioDAO.inserirUsuario(usuario3);

		Usuario usuario4 = new Usuario(null, "Lucas", "Loes", LocalDate.of(1990, 7, 15), "lucas.loes", "senha456",
				conselho1, contato4, comunidade1);
		usuarioDAO.inserirUsuario(usuario4);

		Usuario usuario5 = new Usuario(null, "Aquila", "Hapuque", LocalDate.of(1988, 5, 10), "aquila.hapuque",
				"senha789", conselho1, contato5, comunidade1);
		usuarioDAO.inserirUsuario(usuario5);

		Usuario usuario6 = new Usuario(null, "Gabriela", "Adara", LocalDate.of(1998, 12, 3), "gabriela.adara",
				"senha101", conselho1, contato6, comunidade1);
		usuarioDAO.inserirUsuario(usuario6);

		Usuario usuario7 = new Usuario(null, "Ana", "de Abreu", LocalDate.of(1992, 6, 7), "ana.abreu", "senha111",
				conselho1, contato7, comunidade1);
		usuarioDAO.inserirUsuario(usuario7);

		Usuario usuario8 = new Usuario(null, "Renan", "Batista", LocalDate.of(1985, 1, 19), "renan.bastista",
				"senha190", conselho1, contato8, comunidade1);
		usuarioDAO.inserirUsuario(usuario8);

		Usuario usuario9 = new Usuario(null, "Renato", "Júnior", LocalDate.of(1979, 5, 29), "renato.junior", "senha191",
				conselho1, contato9, comunidade1);
		usuarioDAO.inserirUsuario(usuario9);

		Usuario usuario10 = new Usuario(null, "Yan", "Silva", LocalDate.of(1991, 1, 8), "yan.silva", "senha192",
				conselho1, contato10, comunidade1);
		usuarioDAO.inserirUsuario(usuario10);

		Usuario usuario11 = new Usuario(null, "Thiago", "Pereira", LocalDate.of(1997, 9, 20), "thiago.pereira",
				"senha193", conselho1, contato11, comunidade1);
		usuarioDAO.inserirUsuario(usuario11);

		Usuario usuario12 = new Usuario(null, "Eduardo", "Schimmit", LocalDate.of(2000, 3, 12), "eduardo.schimmit",
				"senha194", conselho1, contato12, comunidade1);
		usuarioDAO.inserirUsuario(usuario12);

		Usuario usuario13 = new Usuario(null, "Marlon", "Krause", LocalDate.of(2001, 4, 19), "marlon.krause",
				"senha195", conselho1, contato13, comunidade1);
		usuarioDAO.inserirUsuario(usuario13);

		Usuario usuario14 = new Usuario(null, "Gleidson", "Sanguanini", LocalDate.of(2002, 1, 18),
				"gleidson.sanguanini", "senha196", conselho1, contato14, comunidade1);
		usuarioDAO.inserirUsuario(usuario14);

		Usuario usuario15 = new Usuario(null, "Silvio", "Luiz", LocalDate.of(1996, 2, 11), "silvio.luiz", "senha197",
				conselho1, contato15, comunidade1);
		usuarioDAO.inserirUsuario(usuario15);

		Usuario usuario16 = new Usuario(null, "Ernesto", "Soares", LocalDate.of(1996, 2, 11), "ernesto.soares",
				"senha198", conselho1, contato16, comunidade1);
		usuarioDAO.inserirUsuario(usuario16);

		Usuario usuario17 = new Usuario(null, "Arthur", "Fernandes", LocalDate.of(1996, 2, 11), "arthur.fernandes",
				"senha199", conselho1, contato17, comunidade1);
		usuarioDAO.inserirUsuario(usuario17);

		Usuario usuario18 = new Usuario(null, "Kaio", "Aleixo", LocalDate.of(1996, 2, 11), "kaio.aleixo", "senha200",
				conselho1, contato18, comunidade1);
		usuarioDAO.inserirUsuario(usuario18);

		Usuario usuario19 = new Usuario(null, "Beatriz", "Rodrigues", LocalDate.of(1996, 2, 11), "beatriz.rodrigues",
				"senha201", conselho1, contato19, comunidade1);
		usuarioDAO.inserirUsuario(usuario19);

		Usuario usuario20 = new Usuario(null, "Cristiane", "Santos", LocalDate.of(1996, 2, 11), "cristiane.santos",
				"senha202", conselho1, contato20, comunidade1);
		usuarioDAO.inserirUsuario(usuario20);

		Usuario usuario21 = new Usuario(null, "Pamela", "Bernardo", LocalDate.of(1996, 2, 11), "pamela.bernardo",
				"senha203", conselho1, contato21, comunidade1);
		usuarioDAO.inserirUsuario(usuario21);

		Usuario usuario22 = new Usuario(null, "Mathias", "Garcia", LocalDate.of(1996, 2, 11), "mathias.garcia",
				"senha204", conselho1, contato22, comunidade1);
		usuarioDAO.inserirUsuario(usuario22);

		Usuario usuario23 = new Usuario(null, "Bruna", "Koprowisk", LocalDate.of(2005, 2, 6), "bruna.koprowisk",
				"senha777", conselho1, contato23, comunidade1);
		usuarioDAO.inserirUsuario(usuario23);

		Usuario usuario24 = new Usuario(null, "Vera", "Cruz", LocalDate.of(1980, 12, 17), "vera.cruz", "senha645",
				conselho1, contato24, comunidade1);
		usuarioDAO.inserirUsuario(usuario24);

		Usuario usuario25 = new Usuario(null, "Rafaela", "Gomes", LocalDate.of(2003, 8, 22), "rafaela.gomes",
				"senha207", conselho1, contato25, comunidade1);
		usuarioDAO.inserirUsuario(usuario25);

		Usuario usuario26 = new Usuario(null, "Marcela", "Arruda", LocalDate.of(2002, 2, 28), "marcela.arruda",
				"senha456", conselho1, contato26, comunidade1);
		usuarioDAO.inserirUsuario(usuario26);

		Usuario usuario27 = new Usuario(null, "Leticia", "Farias", LocalDate.of(1998, 6, 12), "leticia.farias",
				"senha987", conselho1, contato27, comunidade1);
		usuarioDAO.inserirUsuario(usuario27);

		Usuario usuario28 = new Usuario(null, "Carla", "Spudeit", LocalDate.of(2000, 3, 16), "karla.spudeit",
				"senha654", conselho1, contato28, comunidade1);
		usuarioDAO.inserirUsuario(usuario28);

		Usuario usuario29 = new Usuario(null, "Luiza", "Durangi", LocalDate.of(1994, 7, 23), "luiza.durangi",
				"senha321", conselho1, contato29, comunidade1);
		usuarioDAO.inserirUsuario(usuario29);

		Usuario usuario30 = new Usuario(null, "Patricia", "Aguiar", LocalDate.of(1994, 4, 6), "patricia.aguiar",
				"senha123", conselho1, contato30, comunidade1);
		usuarioDAO.inserirUsuario(usuario30);

		Usuario usuario31 = new Usuario(null, "Flavia", "Diniz", LocalDate.of(1973, 6, 7), "flavia.diniz", "senha173",
				conselho1, contato31, comunidade1);
		usuarioDAO.inserirUsuario(usuario31);

		Usuario usuario32 = new Usuario(null, "Elena", "Cardoso", LocalDate.of(1985, 2, 7), "elena.cardoso", "senha456",
				conselho1, contato32, comunidade1);
		usuarioDAO.inserirUsuario(usuario32);

		Usuario usuario33 = new Usuario(null, "Bianca", "Shimitt", LocalDate.of(1999, 7, 2), "bianca.shmitt",
				"senha789", conselho1, contato33, comunidade1);
		usuarioDAO.inserirUsuario(usuario33);

		Usuario usuario34 = new Usuario(null, "Aparecida", "Conceicao", LocalDate.of(1967, 2, 3), "aparecida.conceicao",
				"senha101", conselho1, contato34, comunidade1);
		usuarioDAO.inserirUsuario(usuario34);

		Usuario usuario35 = new Usuario(null, "Felipe", "Borba", LocalDate.of(2001, 3, 12), "felipe.borba", "senha102",
				conselho1, contato35, comunidade1);
		usuarioDAO.inserirUsuario(usuario35);

		// Criação de moderadores
		Contato contatoModeradorAmanda = new Contato();
		contatoModeradorAmanda.setTelefone("(47)98525-4121");
		contatoModeradorAmanda.setEmail("amanda.moderadora@gmail.com");
		contatoDAO.inserirContato(contatoModeradorAmanda);

		Moderador moderadorAmanda = new Moderador(1, "Amanda", "Lucs", LocalDate.of(2002, 11, 27), "amanda.lsc",
				"senhaModerador", conselho1, contatoModeradorAmanda, comunidade2);
		moderadorDAO.inserirModerador(moderadorAmanda);

		Contato contatoModeradorBrenda = new Contato();
		contatoModeradorBrenda.setTelefone("(48)98646-7254");
		contatoModeradorBrenda.setEmail("brenda.moderadora@gmail.com");
		contatoDAO.inserirContato(contatoModeradorBrenda);
		Moderador moderadorBrenda = new Moderador(2, "Brenda", "Monteiro", LocalDate.of(2000, 8, 30), "brenda.monteiro",
				"senhaModerador2", conselho1, contatoModeradorBrenda, comunidade1);
		moderadorDAO.inserirModerador(moderadorBrenda);

		Contato contatoModeradorLuciene = new Contato();
		contatoModeradorLuciene.setTelefone("(21)98734-5477");
		contatoModeradorLuciene.setEmail("luciene.moderadora@gmail.com");
		contatoDAO.inserirContato(contatoModeradorLuciene);
		Moderador moderadorLuciene = new Moderador(3, "Luciene", "Queiroz", LocalDate.of(1975, 5, 31),
				"luciene.queiroz", "senhaModerador3", conselho1, contatoModeradorLuciene, comunidade3);
		moderadorDAO.inserirModerador(moderadorLuciene);

		Contato contatoModeradorMariana = new Contato();
		contatoModeradorMariana.setTelefone("(68)98525-4121");
		contatoModeradorMariana.setEmail("mariana.moderadora@gmail.com");
		contatoDAO.inserirContato(contatoModeradorMariana);
		Moderador moderadorMariana = new Moderador(4, "Mariana", "Abreu", LocalDate.of(2001, 5, 20), "mariana.abreu",
				"senhaModerador4", conselho1, contatoModeradorMariana, comunidade4);
		moderadorDAO.inserirModerador(moderadorMariana);

		Contato contatoModeradorGiovanna = new Contato();
		contatoModeradorGiovanna.setTelefone("(54)96465-9876");
		contatoModeradorGiovanna.setEmail("giovanna.moderadora@gmail.com");
		contatoDAO.inserirContato(contatoModeradorGiovanna);
		Moderador moderadorGiovanna = new Moderador(5, "Giovanna", "Soriano", LocalDate.of(1991, 12, 27),
				"giovanna.soriano", "senhaModerador5", conselho1, contatoModeradorGiovanna, comunidade5);
		moderadorDAO.inserirModerador(moderadorGiovanna);

		Contato contatoModeradorMarcella = new Contato();
		contatoModeradorMarcella.setTelefone("(21)9345-1234");
		contatoModeradorMarcella.setEmail("marcella.moderadora@gmail.com");
		contatoDAO.inserirContato(contatoModeradorMarcella);
		Moderador moderadorMarcella = new Moderador(6, "Marcella", "Barboza", LocalDate.of(2002, 3, 21),
				"marcella.barboza", "senhaModerador6", conselho1, contatoModeradorMarcella, comunidade2);
		moderadorDAO.inserirModerador(moderadorMarcella);

		Contato contatoModeradorBruna = new Contato();
		contatoModeradorBruna.setTelefone("(47)99645-4121");
		contatoModeradorBruna.setEmail("bruna.moderadora@gmail.com");
		contatoDAO.inserirContato(contatoModeradorBruna);
		Moderador moderadorBruna = new Moderador(7, "Bruna", "Caria", LocalDate.of(1987, 11, 7), "bruna.caria",
				"senhaModerador7", conselho1, contatoModeradorBruna, comunidade3);
		moderadorDAO.inserirModerador(moderadorBruna);

		Contato contatoModeradorAlice = new Contato();
		contatoModeradorAlice.setTelefone("(47)99262-4221");
		contatoModeradorAlice.setEmail("alice.moderadora@gmail.com");
		contatoDAO.inserirContato(contatoModeradorAlice);
		Moderador moderadorAlice = new Moderador(8, "Alice", "Rocha", LocalDate.of(1992, 4, 7), "alice.rocha",
				"senhaModerador8", conselho1, contatoModeradorAlice, comunidade1);
		moderadorDAO.inserirModerador(moderadorAlice);

		// Criação de denúncias
		DenunciaConselho denunciaConselho = new DenunciaConselho(conselho1, 0, LocalDate.now(), "Conteúdo inadequado",
				Status.PENDENTE);
		denunciaConselhoDAO.inserirDenunciaConselho(denunciaConselho);

		DenunciaModerador denunciaModerador = new DenunciaModerador(moderadorAmanda, 0, LocalDate.now(),
				"Comportamento inadequado", Status.PENDENTE);
		denunciaModeradorDAO.inserirDenunciaModerador(denunciaModerador);

		DenunciaUsuario denunciaUsuario = new DenunciaUsuario(usuario5, 0, LocalDate.now(),
				"Uso indevido do aplicativo", Status.PENDENTE);
		denunciaUsuarioDAO.inserirDenunciaUsuario(denunciaUsuario);

		DenunciaRelato denunciaRelato = new DenunciaRelato(relato1, 0, LocalDate.now(), "Conteúdo falso",
				Status.PENDENTE);
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
		

		// Criação de consultas

		Usuario usuarioPeloNome = usuarioDAO.buscarUsuarioPeloNome("Alice");
		System.out.println("Buscar usuário pelo nome: " + usuarioPeloNome.getNome());

		// --------------------------------------------------------------------
		
		Moderador moderadorPeloNome = moderadorDAO.consultarModeradorPeloNome("Bruna");
		System.out.println("Consultar moderador pelo nome: " +moderadorPeloNome.getNome());

		// --------------------------------------------------------------------

		List<Moderador> moderador = moderadorDAO.consultarModeradoresPeloId(36L);

		for (Moderador moderadorRecuperado : moderador) {
			System.out.print("Nome do moderador: " + moderadorRecuperado.getNome());
		}

		// ----------------------------------------------------------------------
		
		List <Moderador> parametroComunidade = moderadorDAO.consultarModeradoresPelaComunidade(comunidade1);
		for (Moderador moderadores : parametroComunidade) {
			System.out.println("Moderador pela comunidade: " + moderadores.getNome());
		}
		// --------------------------------------------------------------------

//
//		List<Usuario> usuarios = usuarioDAO.recuperarUsuariosPorComunidade(comunidade3);
//
//		for (Usuario usuario : usuarios) {
//			System.out.println("Usuario por comunidade:" + usuario.getNome());
//		}

		// ----------------------------------------------------------------------

//		Usuario usuarioPorConselho = usuarioDAO.recuperarUsuarioPorConselho(conselho1);
//			System.out.println("Usuario por conselho:" + usuarioPorConselho.getApelido());
//

		// ----------------------------------------------------------------------

//		List<Usuario> usuarios2 = usuarioDAO.recuperarUsuariosPorDenuncia(denunciaUsuario);
//
//		for (Usuario usuario : usuarios2) {
//			System.out.println("Usuario por denuncia" + usuario.getNome());
//		}

		// ----------------------------------------------------------------------

//		List<Usuario> usuarios3 = usuarioDAO.recuperarUsuariosPorRelato(relato2);
//
//		for (Usuario usuario : usuarios3) {
//			System.out.println(usuario.getNome());
//		}

		// ----------------------------------------------------------------------

		List<Moderador> moderadores = moderadorDAO.consultarModeradoresPelaComunidade(comunidade1);

		for (Moderador moderador2 : moderadores) {
			System.out.println("Moderador pela comunidade:" + moderador2.getNome());
		}

		// ----------------------------------------------------------------------

		List<Conselho> conselhos = conselhoDAO.recuperarConselhoRelato(relato1);

		for (Conselho conselho : conselhos) {
			System.out.println("Conselho por relato:" + conselho.getConteudo());
		}

		// ----------------------------------------------------------------------
//		

		List<Relato> relatos = relatoDAO.consultarRelatosPeloStatus(Status.APROVADO);

		for (Relato relato : relatos) {
			System.out.println("Relato por status:" + relato.getConteudo());
		}
		
		
		// ----------------------------------------------------------------------

		List<Relato> usuario = relatoDAO.consultarRelatosPeloUsuario(usuario2);

		for (Relato relato : usuario) {
			System.out.println("Relato por usuário:" + relato.getConteudo());
		}

		// ----------------------------------------------------------------------

		List<Relato> comunidade = relatoDAO.consultarRelatosPelaComunidade(comunidade1);

		for (Relato relato : comunidade) {
			System.out.println("Relato por comunidade:" + relato.getConteudo());
		}

		// ----------------------------------------------------------------------

//		List<Relato> categorias = relatoDAO.consultarRelatosPelaCategoria(categoria2);
//        	
//        	for (Relato relato : categorias) {
//	        	System.out.println("Relato pela categoria:" +relato.getConteudo());
//        	}

		// ----------------------------------------------------------------------
		
		Relato relatoPorId = relatoDAO.consultarRelatoPorId(2L);
		System.out.println("Relato por ID:" + relatoPorId.getConteudo());


		// ----------------------------------------------------------------------
		
		
		Contato contatoRecuperado = contatoDAO.recuperarContatoDoUsuarioPeloId(1L);
		System.out.println("Usuario pelo ID:" + contatoRecuperado.getTelefone());
		
		
		// ----------------------------------------------------------------------
		
		Categoria recuperarCategoriaNome = categoriaDAO.recuperarCategoriaPeloId(1L);
		System.out.println("Recuperar categoria pelo nome :" + recuperarCategoriaNome);
		
		// ----------------------------------------------------------------------
		
		Categoria recuperarCategoriaRelato = categoriaDAO.recuperarCategoriaRelato(relato4);
		System.out.println("Recuperar categoria pelo relato :" + recuperarCategoriaRelato);
	}
}
