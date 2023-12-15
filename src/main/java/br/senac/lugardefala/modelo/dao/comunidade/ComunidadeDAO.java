package br.senac.lugardefala.modelo.dao.comunidade;

import java.util.List;

import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;

public interface ComunidadeDAO {

	void inserirComunidade(Comunidade comunidade);

	void atualizarComunidade(Comunidade comunidade);
	
	void deletarComunidade(Comunidade comunidade);

	List<Comunidade> recuperarComunidade();

}