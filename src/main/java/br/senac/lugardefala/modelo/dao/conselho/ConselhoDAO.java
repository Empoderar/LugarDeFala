package br.senac.lugardefala.modelo.dao.conselho;

import java.util.List;

import br.senac.lugardefala.modelo.entidade.conselho.Conselho;
import br.senac.lugardefala.modelo.entidade.relato.Relato;

public interface ConselhoDAO {

	void inserirConselho(Conselho conselho);

	void deletarConselho(Conselho conselho);

	void atualizarConselho(Conselho conselho);

	List<Conselho> recuperarConselhoRelato(Relato relato);

}