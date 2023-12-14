package br.senac.modelo.dao.contato;

import java.util.List;

import br.senac.modelo.entidade.contato.Contato;
import br.senac.modelo.entidade.usuario.Usuario;

public interface ContatoDAO {

	void inserirContato(Contato contato);

	void atualizarContato(Contato contato);

	List<Contato> recuperarContatos();

	Contato recuperarContatoUsuario(Usuario usuario);
}