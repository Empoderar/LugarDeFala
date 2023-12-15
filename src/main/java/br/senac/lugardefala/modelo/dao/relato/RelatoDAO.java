package br.senac.lugardefala.modelo.dao.relato;

import java.util.List;

import br.senac.lugardefala.modelo.entidade.relato.Relato;

 public interface RelatoDAO {

	void inserirRelato(Relato relato);

	void atualizarRelato(Relato relato);
	
	void deletarRelato(Relato relato);

	List<Relato> recuperarRelatos();
}