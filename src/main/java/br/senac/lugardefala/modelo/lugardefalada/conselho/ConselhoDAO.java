package br.senac.lugardefala.modelo.lugardefalada.conselho;

import java.util.List;

import br.senac.lugardefala.modelo.entidade.conselho.Conselho;

public interface ConselhoDAO {

	void inserirConselho();

	void deletarConselho();

	void atualizarConselho();

	List<Conselho> recuperarClientes();

	Conselho recuperarContatoCliente(Conselho conselho);
}
