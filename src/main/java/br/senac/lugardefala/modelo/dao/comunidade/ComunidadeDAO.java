package br.senac.lugardefala.modelo.dao.comunidade;

import java.util.List;

import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.moderador.Moderador;

public interface ComunidadeDAO {

	void inserirComunidade(Comunidade comunidade);

	void deletarComunidade(Comunidade comunidade);

	List<Comunidade> recuperarComunidade();

	Comunidade recuperarComunidadeModerador(Moderador moderador);

}