package br.senac.lugardefala.modelo.dao.relato;

import java.util.List;

import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;
import br.senac.lugardefala.modelo.enumeracao.Status;

public interface RelatoDAO {

	void inserirRelato(Relato relato);

	void deletarRelato(Relato relato);
	
	void atualizarRelato(Relato relato);

	List <Relato> consultarRelatosPeloUsuario(Usuario usuario);
	
	List <Relato> consultarRelatosPeloStatus(Status status);
	
	List <Relato> consultarRelatosPelaComunidade(Comunidade comunidade);
	
//	List <Relato> consultarRelatosPelaCategoria(Categoria categoria);
	
	Relato consultarRelatoPorId(Long id);
}