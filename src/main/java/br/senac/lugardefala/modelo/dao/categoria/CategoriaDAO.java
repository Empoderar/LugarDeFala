package br.senac.lugardefala.modelo.dao.categoria;

import java.util.List;

import br.senac.lugardefala.modelo.entidade.categoria.Categoria;
import br.senac.lugardefala.modelo.entidade.relato.Relato;

public interface CategoriaDAO {

	void inserirCategoria(Categoria categoria);

	void deletarCategoria(Categoria categoria);

	void atualizarCategoria(Categoria categoria);

	List<Categoria> recuperarCategoria();
	
	Categoria recuperarCategoriaNome(String nome);

	Categoria recuperarCategoriaRelato(Relato relato);

}