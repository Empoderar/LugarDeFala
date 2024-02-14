package br.senac.lugardefala.modelo.dao.categoria;

import java.util.List;

import br.senac.lugardefala.modelo.entidade.categoria.Categoria;
import br.senac.lugardefala.modelo.entidade.relato.Relato;

public interface CategoriaDAO {

	void inserir(Categoria categoria);

	void deletar(Categoria categoria);

	void atualizar(Categoria categoria);

	List<Categoria> recuperar(String nome);
	
	Categoria recuperarPorId(Long id);

	Categoria recuperarPorRelato(Relato relato);
	
	Categoria recuperarPorNome(String nome);

}