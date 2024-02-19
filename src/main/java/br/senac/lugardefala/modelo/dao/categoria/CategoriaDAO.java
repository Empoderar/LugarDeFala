package br.senac.lugardefala.modelo.dao.categoria;

import java.util.List;

import br.senac.lugardefala.modelo.entidade.categoria.Categoria;
import br.senac.lugardefala.modelo.entidade.relato.Relato;

public interface CategoriaDAO {

	void inserir(Categoria categoria);

	void deletar(Categoria categoria);

	void atualizar(Categoria categoria);

	List<Categoria> recuperarTodasCategorias();
	
	Categoria recuperarCategoriaPorId(Long id);

	List <Categoria> recuperarCategoriasPorRelato(Relato relato);
	
	Categoria recuperarCategoriaPorNome(String nome);

}