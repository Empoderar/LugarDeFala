package br.senac.modelo.dao.conselho;

import java.util.List;

import br.senac.modelo.entidade.conselho.Conselho;

public interface ConselhoDAO {

	void inserirConselho(Conselho conselho);

	void deletarConselho(Conselho conselho);

	void atualizarConselho(Conselho conselho);

	List<Conselho> recuperarConselho();

}
