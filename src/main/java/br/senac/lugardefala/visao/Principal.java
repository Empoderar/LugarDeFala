package br.senac.lugardefala.visao;

import br.senac.lugardefala.modelo.dao.usuario.UsuarioDAO;
import br.senac.lugardefala.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.lugardefala.modelo.entidade.categoria.Categoria;
import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.conselho.Conselho;
import br.senac.lugardefala.modelo.entidade.contato.Contato;
import br.senac.lugardefala.modelo.entidade.denuncia.Denuncia;
import br.senac.lugardefala.modelo.entidade.moderador.Moderador;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.entidade.status.Status;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

import java.time.LocalDate;

public class Principal {

	public static void main(String[] args) {

		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		Usuario usuario = new Usuario("João", "Silva", LocalDate.of(1990, 1, 1), "joao.silva", "senha", "123456789",
				"joao.silva@example.com", null, null);

		Contato contato = new Contato("987654321", "joao.silva@gmail.com");

		Comunidade comunidade = new Comunidade("Programadores", "Uma comunidade para programadores", null);

		usuario.setContato(contato);
		usuario.setComunidade(comunidade);

		Status status = new Status();

		Relato relato = new Relato(LocalDate.now(), usuario, "Experiência positiva", null, status, comunidade);

		Moderador moderador = new Moderador("Moderador", "Um", LocalDate.of(1985, 5, 5), "moderador", "senhaModerador",
				"987654321", "moderador@example.com", comunidade, contato, null, null);

		Denuncia denuncia = new Denuncia(LocalDate.now(), "Conteúdo inadequado", usuario, null, relato, moderador);

		Conselho conselho = new Conselho("Fornecer feedback construtivo", LocalDate.now(), usuario, 5, relato,
				comunidade);

		Categoria categoria = new Categoria("Programação", "Azul", comunidade);

		comunidade.setCategoria(categoria);

		usuarioDAO.inserirUsuario(usuario);
	}
}
