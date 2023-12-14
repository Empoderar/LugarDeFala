package br.senac.modelo.dao.categoria;

import java.util.List;

import br.senac.modelo.entidade.categoria.Categoria;

public interface CategoriaDAO {

	void inserirCategoria(Categoria categoria);

	void deletarCategoria(Categoria categoria);

	void atualizarCategoria(Categoria categoria);

	List<Categoria> recuperarCategoria();

}