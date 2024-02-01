package br.senac.lugardefala.modelo.dao.conselho;

import java.util.List;

import br.senac.lugardefala.modelo.entidade.conselho.Conselho;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

public interface ConselhoDAO {

	void inserirConselho(Conselho conselho);

	void deletarConselho(Conselho conselho);

	void atualizarConselho(Conselho conselho);
	
	Conselho recuperarConselhoPeloId (Long id);

	List<Conselho> recuperarConselhoRelato(Relato relato);

	List<Conselho> recuperarConselhoPeloUsuario(Usuario usuario);
}