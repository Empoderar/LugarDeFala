package br.senac.lugardefala.modelo.dao.denuncia;

import java.util.List;

import br.senac.lugardefala.modelo.entidade.denuncia.Denuncia;

public interface DenunciaDAO {

	void inserirDenuncia(Denuncia denuncia);

	void atualizarDenuncia(Denuncia denuncia);

	void deletarDenuncia(Denuncia denuncia);

	List<Denuncia> recuperarDenuncias();
}
