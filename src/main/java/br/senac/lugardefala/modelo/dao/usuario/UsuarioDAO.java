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

    Usuario recuperarPorNome(String nome);

    Usuario recuperarPorApelido(String apelido);

    List<Usuario> recuperarTodos();

    Usuario recuperarPorId(Long id);

    Usuario recuperarPorIdFetch(Long id);

    List<Usuario> recuperarPorComunidade(Comunidade comunidade);

    List<Usuario> recuperarPorConselho(Conselho conselho);

    Usuario recuperarPorIdDenuncia(Long id);

    List<Usuario> recuperarPorRelato(Relato relato);

    boolean verificarCredenciais(String apelido, String senha);

    Usuario obterPorCredenciais(String email, String senha);
}
