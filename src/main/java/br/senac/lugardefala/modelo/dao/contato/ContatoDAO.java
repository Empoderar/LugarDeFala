package br.senac.lugardefala.modelo.dao.contato;

import br.senac.lugardefala.modelo.entidade.contato.Contato;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

public interface ContatoDAO {

	void inserirContato(Contato contato);

	void atualizarContato(Contato contato);

	Contato recuperarContatoDoUsuarioPeloId(Long id);
}