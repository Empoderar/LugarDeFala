package br.senac.lugardefala.modelo.dao.usuario;

import java.util.List;

import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.conselho.Conselho;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;


public interface UsuarioDAO {

	void inserirUsuario(Usuario usuario);

	void deletarUsuario(Usuario usuario);

	void atualizarUsuario(Usuario usuario);

	Usuario recuperarUsuarioPeloNome(String nome);
	
	Usuario recuperarUsuarioPeloApelido(String apelido);
	
	List<Usuario> recuperarUsuarios();
	
	Usuario recuperarUsuarioPeloId(Long id);
	
	Usuario recuperarUsuarioPeloIdFetch(Long id);
	
	List<Usuario> recuperarUsuariosPorComunidade(Comunidade comunidade);

	List <Usuario> recuperarUsuariosPorConselho(Conselho conselho);

	Usuario recuperarUsuariosPorIdDenuncia(Long id);

	List<Usuario> recuperarUsuariosPorRelato(Relato relato);
	
	boolean verificarUsuario(String apelido, String senha);

}