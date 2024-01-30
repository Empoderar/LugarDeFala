package br.senac.lugardefala.modelo.dao.comunidade;

import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.moderador.Moderador;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

public interface ComunidadeDAO {

	void inserirComunidade(Comunidade comunidade);
	
	void deletarComunidade(Comunidade comunidade);
	
	void atualizarComunidade(Comunidade comunidade);

	Comunidade recuperarComunidadeModerador(Moderador moderador);

	Comunidade recuperarComunidadeUsuario(Usuario usuario);
	
	Comunidade recuperarComunidadePeloId(Long id);
	
}