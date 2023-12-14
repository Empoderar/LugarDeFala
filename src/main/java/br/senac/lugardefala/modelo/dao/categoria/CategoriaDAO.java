package br.senac.lugardefala.modelo.dao.categoria;

import java.util.List;

import br.senac.lugardefala.modelo.entidade.categoria.Categoria;

public interface CategoriaDAO {

	void inserirCategoria();

	void deletarCategoria();

	void atualizarCategoria();

	List<Categoria> recuperarClientes();

	Categoria recuperarContatoCliente(Categoria categoria);
}