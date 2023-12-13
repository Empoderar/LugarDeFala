package br.senac.modelo.dao.usuario;

import java.util.List;

import br.senac.modelo.entidade.usuario.Usuario;

public interface UsuarioDAO {

    void inserirUsuario(Usuario usuario);

    void deletarUsuario(Usuario usuario);

    void atualizarUsuario(Usuario usuario);

    List<Usuario> recuperarUsuarios();
}