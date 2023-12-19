package br.senac.lugardefala.modelo.dao.conselho;

import br.senac.lugardefala.modelo.entidade.conselho.Conselho;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

public interface ConselhoDAO {

	void inserirConselho(Conselho conselho);

	void deletarConselho(Conselho conselho);

	void atualizarConselho(Conselho conselho);

	Conselho recuperarConselhoUsuario(Usuario usuario);
	
	Conselho recuperarConselhoRelato(Relato relato);

}
