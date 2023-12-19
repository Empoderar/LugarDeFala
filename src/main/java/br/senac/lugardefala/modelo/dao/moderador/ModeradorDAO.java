package br.senac.lugardefala.modelo.dao.moderador;

import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.moderador.Moderador;

public interface ModeradorDAO {

	Moderador recuperarModeradorNome(String nome);

	Moderador recuperarModeradorComunidade(Comunidade comunidade);
}
