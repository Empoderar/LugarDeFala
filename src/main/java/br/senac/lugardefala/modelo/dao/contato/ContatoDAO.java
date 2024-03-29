package br.senac.lugardefala.modelo.dao.contato;

import br.senac.lugardefala.modelo.entidade.contato.Contato;

public interface ContatoDAO {

	void inserirContato(Contato contato);

	void atualizarContato(Contato contato);
	
	void deletarContato (Contato contato);

	Contato recuperarContatoDoUsuarioPeloId(Long id);
}