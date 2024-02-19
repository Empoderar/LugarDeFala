package br.senac.lugardefala.modelo.dao.usuario;

import java.util.List;

import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.conselho.Conselho;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

public interface UsuarioDAO {

    void inserir(Usuario usuario);

    void deletar(Usuario usuario);

    void atualizar(Usuario usuario);

    boolean verificarCredenciaisUsuario(String apelido, String senha);

    Usuario recuperarUsuarioPorNome(String nome);
    
    List<Usuario> recuperarUsuariosPorNomes(String nome);

    Usuario recuperarUsuarioPorApelido(String apelido);

    Usuario recuperarUsuarioPorId(Long id);

    Usuario recuperarUsuarioPorIdFetch(Long id);

    Usuario recuperarUsuarioPorIdDenuncia(Long id);

    Usuario obterUsuarioPorCredenciais(String email, String senha);

    List<Usuario> recuperarTodosUsuarios();

    List<Usuario> recuperarUsuariosPorComunidade(Comunidade comunidade);

    List<Usuario> recuperarUsuariosPorConselho(Conselho conselho);

    List<Usuario> recuperarUsuariosPorRelato(Relato relato);
}
