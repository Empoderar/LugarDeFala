package br.senac.lugardefala.modelo.dao.usuario;

import java.util.List;

import br.senac.lugardefala.modelo.entidade.usuario.Usuario;


public interface UsuarioDAO {

	void inserirUsuario(Usuario usuario);

	void deletarUsuario(Usuario usuario);

	void atualizarUsuario(Usuario usuario);

	Usuario buscarUsuarioPeloNome(String nome);
	
	List<Usuario> recuperarUsuarios();
	

//	List<Usuario> recuperarUsuariosPorComunidade(Comunidade comunidade);

//	Usuario recuperarUsuarioPorConselho(Conselho conselho);
//
//	List<Usuario> recuperarUsuariosPorDenuncia(Denuncia denuncia);

//	List<Usuario> recuperarUsuariosPorRelato(Relato relato);
}