package br.senac.lugardefala.modelo.dao.contato;

import br.senac.lugardefala.modelo.entidade.contato.Contato;
public interface ContatoDAO {

	void inserirContato(Contato contato);

	void atualizarContato(Contato contato);

}