package br.senac.lugardefala.modelo.dao.relato;

import java.util.List;

import br.senac.lugardefala.modelo.entidade.categoria.Categoria;
import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;
import br.senac.lugardefala.modelo.enumeracao.Status;

public interface RelatoDAO {

	void inserirRelato(Relato relato);

	void deletarRelato(Relato relato);
	
	void atualizarRelato(Relato relato);

	List <Relato> recuperarRelatosPeloUsuario(Usuario usuario);
	
	List <Relato> recuperarRelatosPeloStatus(Status status);
	
	List <Relato> recuperarRelatosPelaComunidade(Comunidade comunidade);
	
	List <Relato> recuperarRelatosPelaCategoria(Categoria categoria);
	
	Relato recuperarRelatoPorId(Long id);
}