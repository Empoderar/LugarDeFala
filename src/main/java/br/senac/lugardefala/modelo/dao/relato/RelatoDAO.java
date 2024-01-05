package br.senac.lugardefala.modelo.dao.relato;

import br.senac.lugardefala.modelo.entidade.categoria.Categoria;
import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;
import br.senac.lugardefala.modelo.enumeracao.Status;

public interface RelatoDAO {

	void inserirRelato(Relato relato);

	void deletarRelato(Relato relato);
	
	void atualizarRelato(Relato relato);

	Relato recuperarRelatoUsuario(Usuario usuario);
	
	Relato recuperarRelatoStatus(Status status);
	
	Relato recuperarRelatoComunidade(Comunidade comunidade);
	
	Relato recuperarRelatoCategoria(Categoria categoria);
	
	Relato buscarRelatoPorId(Long id);
}
