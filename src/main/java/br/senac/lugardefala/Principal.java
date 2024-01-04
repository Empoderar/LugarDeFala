package br.senac.lugardefala;

import java.time.LocalDate;

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

        // Criação de usuários
        Usuario usuario2 = new Usuario(null, "João", "Toureiro", LocalDate.of(2004, 8, 10), "joao.toureiro", "whey", contato2);
        usuarioDAO.inserirUsuario(usuario2);

        Usuario usuario3 = new Usuario(null, "Maria Fernanda", "Rengel", LocalDate.of(1995, 3, 22), "maria.fernanda", "senha123", contato3);
        usuarioDAO.inserirUsuario(usuario3);

        Usuario usuario4 = new Usuario(null, "Lucas", "Loes", LocalDate.of(1990, 7, 15), "lucas.loes", "senha456", contato4);
        usuarioDAO.inserirUsuario(usuario4);

        Usuario usuario5 = new Usuario(null, "Aquila", "Hapuque", LocalDate.of(1988, 5, 10), "aquila.hapuque", "senha789", contato5);
        usuarioDAO.inserirUsuario(usuario5);

        Usuario usuario6 = new Usuario(null, "Gabriela", "Adara", LocalDate.of(1998, 12, 3), "gabriela.adara", "senha101", contato6);
        usuarioDAO.inserirUsuario(usuario6);

        Usuario usuario7 = new Usuario(null, "Ana", "de Abreu", LocalDate.of(1992, 6, 7), "ana.abreu", "senha111", contato7);
        usuarioDAO.inserirUsuario(usuario7);

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

        // Criação de comunidades
        Comunidade comunidade1 = new Comunidade(1, "Violência Física", "Comunidade de relatos sobre agressões físicas, como bater, empurrar, chutar, entre outras formas de violência que causem dano ao corpo.");
        comunidadeDAO.inserirComunidade(comunidade1);

        Comunidade comunidade2 = new Comunidade(2, "Violência Psicológica/Emocional", "Comunidade de relatos sobre humilhação, ameaças, manipulação emocional, controle excessivo, isolamento social e outras formas de abuso psicológico.");
        comunidadeDAO.inserirComunidade(comunidade2);

        Comunidade comunidade3 = new Comunidade(3, "Violência Sexual", "Comunidade de relatos sobre qualquer forma de coerção ou forçar uma mulher a se envolver em atividades sexuais contra a sua vontade.");
        comunidadeDAO.inserirComunidade(comunidade3);

        // Criação de moderadores
        Contato contatoModeradorAmanda = new Contato();
        contatoModeradorAmanda.setTelefone("(47)98525-4121");
        contatoModeradorAmanda.setEmail("amanda.moderadora@gmail.com");
        contatoDAO.inserirContato(contatoModeradorAmanda);

        Moderador moderadorAmanda = new Moderador(1, "Amanda", "Lucs", LocalDate.of(2002, 11, 27), "amanda.lsc", "senhaModerador", comunidade2, contatoModeradorAmanda);
        moderadorDAO.inserirModerador(moderadorAmanda);
        
     // Criação de relatos
        Relato relato1 = new Relato(
        	null,
        	"Um relato sobre sororidade",
        	LocalDate.now(),
        	usuario2, 
        	5,
        	moderadorAmanda,
        	Status.APROVADO,
        	comunidade1
        );
        relato1.inserirCategoriaRelato(categoria);
        relatoDAO.inserirRelato(relato1);

        Relato relato2 = new Relato(
        	null,
        	"Outro relato sobre sororidade",
        	LocalDate.now(),
        	usuario3, 
        	4,
        	moderadorAmanda,
        	Status.APROVADO,
        	comunidade1
        );
        relato2.inserirCategoriaRelato(categoria);
        relatoDAO.inserirRelato(relato2);

        // Criação de conselhos
        Conselho conselho1 = new Conselho(
                1,
                "Mantenha-se forte!",
                5,
                0,
                LocalDate.now(),
                usuario2,
                relato1
        );
        conselhoDAO.inserirConselho(conselho1);

        Conselho conselho2 = new Conselho(
                2,
                "Isso já aconteceu comigo também...",
                2,
                0,
                LocalDate.now(),
                usuario2,
                relato1
        );
        conselhoDAO.inserirConselho(conselho2);

        Conselho conselho3 = new Conselho(
                3,
                "Você é forte só por compartilhar isso conosco :)",
                9,
                0,
                LocalDate.now(),
                usuario4,
                relato2
        );
        conselhoDAO.inserirConselho(conselho3);

        // Criação de denúncias
        DenunciaConselho denunciaConselho = new DenunciaConselho(
        	    conselho1,
        	    0,
        	    LocalDate.now(), 
        	    "Conteúdo inadequado", 
        	    Status.PENDENTE
        	);
        	denunciaConselhoDAO.inserirDenunciaConselho(denunciaConselho);

        	DenunciaModerador denunciaModerador = new DenunciaModerador(
        					moderadorAmanda,
        	    0,
        	    LocalDate.now(),
        	    "Comportamento inadequado",
        	    Status.PENDENTE
        	);
        	denunciaModeradorDAO.inserirDenunciaModerador(denunciaModerador);

        	DenunciaUsuario denunciaUsuario = new DenunciaUsuario(
        	    usuario5,
        	    0,
        	    LocalDate.now(),
        	    "Uso indevido do aplicativo",
        	    Status.PENDENTE
        	);
        	denunciaUsuarioDAO.inserirDenunciaUsuario(denunciaUsuario);

        	DenunciaRelato denunciaRelato = new DenunciaRelato(
        	    relato1,
        	    0,
        	    LocalDate.now(),
        	    "Conteúdo falso",
        	    Status.PENDENTE
        	);
        	denunciaRelatoDAO.inserirDenunciaRelato(denunciaRelato);     
    }
}
