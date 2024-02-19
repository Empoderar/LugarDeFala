package br.senac.lugardefala.modelo.dao.moderador;

import java.util.List;

import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.moderador.Moderador;

public interface ModeradorDAO {

	void inserir(Moderador moderador);

	void deletar(Moderador moderador);

	void atualizar(Moderador moderador);

	Moderador recuperarModeradorPorNome(String nome);
	
	Moderador obterModeradorPorCredenciais(String email, String senha);
	
	List<Moderador> recuperarModeradoresPorComunidade(Comunidade comunidade);

	List<Moderador> recuperarModeradoresPorId(Long id);

}
