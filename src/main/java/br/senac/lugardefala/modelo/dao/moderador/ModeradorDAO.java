package br.senac.lugardefala.modelo.dao.moderador;

import java.util.List;

import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.moderador.Moderador;

public interface ModeradorDAO {

	void inserirModerador(Moderador moderador);

	List<Moderador> consultarModeradoresPelaComunidade(Comunidade comunidade);
	
	List<Moderador> consultarModeradoresPeloId(Long id);
	
	Moderador consultarModeradorPeloNome(String nome);
}