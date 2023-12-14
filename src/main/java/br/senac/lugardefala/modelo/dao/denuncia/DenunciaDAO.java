package br.senac.modelo.dao.denuncia;

import java.util.List;

import br.senac.modelo.entidade.denuncia.Denuncia;
import br.senac.modelo.entidade.usuario.Usuario;

public interface DenunciaDAO {

	void inserirDenuncia(Denuncia denuncia);

	void deletarDenuncia(Denuncia denuncia);

	void atualizarDenuncia(Denuncia denuncia);

	List<Denuncia> recuperarDenuncias();

	Denuncia recuperarDenunciaUsuario(Usuario usuario);
}
