package br.senac.modelo.dao.conselho;

import java.util.List;

import br.senac.modelo.entidade.conselho.Conselho;

public interface ConselhoDAO {

	void inserirConselho();

	void deletarConselho();

	void atualizarConselho();

	List<Conselho> recuperarClientes();

	Conselho recuperarContatoCliente(Conselho conselho);
}
