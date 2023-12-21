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
import br.senac.lugardefala.modelo.dao.denuncia.DenunciaDAO;
import br.senac.lugardefala.modelo.dao.denuncia.DenunciaDAOImpl;
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
import br.senac.lugardefala.modelo.entidade.denuncia.Denuncia;
import br.senac.lugardefala.modelo.entidade.moderador.Moderador;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;
import br.senac.lugardefala.modelo.enumeracao.Status;

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

        Comunidade programadores = new Comunidade(0,"Programadores", "Uma comunidade para programadores");

        Contato contato1 = new Contato();
        contato1.setTelefone("987654321");
        contato1.setEmail("joao.silva@gmail.com");
        
        Contato contato2 = new Contato();
        contato1.setTelefone("987655213");
        contato1.setEmail("moderador@example.com");

        Usuario usuario = new Usuario();
        usuario.setNome("João");
        usuario.setSobrenome("Silva");
        usuario.setDataNascimento(LocalDate.of(1990, 1, 1));
        usuario.setUsuario("joao.silva");
        usuario.setSenha("senha");
        contato1.setTelefone("987654321");
        contato1.setEmail("joao.silva@example.com");
        usuario.setContato(contato1);

        Status status = Status.APROVADO;

        Moderador moderador = new Moderador(0,"Moderador", "Um", LocalDate.now(), "moderador", "senhaModerador",
        		"987655213", "moderador@example.com", programadores, contato1);

        Relato relato = new Relato();
        relato.setConteudo("Conteúdo");
        relato.setData(LocalDate.now());
        relato.setAvaliacao(5);
        relato.setModerador(moderador);
        relato.setStatus(status);
        relato.setComunidade(programadores);
        
        Denuncia denuncia = new Denuncia(0,LocalDate.now(), "Me irritou", Status.PENDENTE);

        Conselho conselho = new Conselho(0, "Fornecer feedback construtivo", 5, 5, LocalDate.now(), null, usuario, relato);

        Categoria categoria = new Categoria(0, "Programação");

        //relato.inserirCategoriaRelato(categoria);

        usuarioDAO.inserirUsuario(usuario);
        contatoDAO.inserirContato(contato1);
        comunidadeDAO.inserirComunidade(programadores);
        conselhoDAO.inserirConselho(conselho);
        denunciaDAO.inserirDenuncia(denuncia);
        relatoDAO.inserirRelato(relato);
        categoriaDAO.inserirCategoria(categoria);

    }
}
