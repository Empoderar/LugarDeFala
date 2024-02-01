package br.senac.lugardefala.modelo.dao.comunidade;

import java.util.List;

import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

public interface ComunidadeDAO {

	void inserirComunidade(Comunidade comunidade);
	
	void deletarComunidade(Comunidade comunidade);
	
	void atualizarComunidade(Comunidade comunidade);

	List <Comunidade> recuperarComunidadesPeloIdModerador(Long id);

	List <Comunidade> recuperarComunidadesPeloIdUsuario(Long id);
	
	List <Comunidade> recuperarComunidadesPeloUsuario(Usuario usuario);
	
	Comunidade recuperarComunidadePeloId(Long id);
	
}