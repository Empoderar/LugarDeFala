package br.senac.lugardefala.modelo.dao.categoria;

import java.util.List;

import br.senac.lugardefala.modelo.entidade.categoria.Categoria;
import br.senac.lugardefala.modelo.entidade.relato.Relato;

public interface CategoriaDAO {

	void inserirCategoria(Categoria categoria);

	void deletarCategoria(Categoria categoria);

	void atualizarCategoria(Categoria categoria);

	List<Categoria> recuperarCategoria(String nome);
	
	Categoria recuperarCategoriaPeloId(Long id);

	Categoria recuperarCategoriaRelato(Relato relato);

}