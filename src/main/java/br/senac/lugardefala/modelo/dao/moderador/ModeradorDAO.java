package br.senac.lugardefala.modelo.dao.moderador;

import java.util.List;

import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.moderador.Moderador;

public interface ModeradorDAO {

	void inserir(Moderador moderador);

	void deletar(Moderador moderador);

	void atualizar(Moderador moderador);

	List<Moderador> recuperarPorComunidade(Comunidade comunidade);

	List<Moderador> recuperarPorId(Long id);

	Moderador recuperarPorNome(String nome);

	Moderador obterPorCredenciais(String email, String senha);
}
