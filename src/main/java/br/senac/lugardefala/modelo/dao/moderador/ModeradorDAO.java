package br.senac.lugardefala.modelo.dao.moderador;

import java.util.List;

import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.moderador.Moderador;

public interface ModeradorDAO {

	void inserirModerador(Moderador moderador);
	
	void deletarModerador(Moderador moderador);

	void atualizarModerador(Moderador moderador);

	List<Moderador> recuperarModeradoresPelaComunidade(Comunidade comunidade);
	
	List<Moderador> recuperarModeradoresPeloId(Long id);
	
	Moderador recuperarModeradorPeloNome(String nome);
}