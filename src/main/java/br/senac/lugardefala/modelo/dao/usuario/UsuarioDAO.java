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

    boolean verificarCredenciais(String apelido, String senha);

    Usuario recuperarPorNome(String nome);

    Usuario recuperarPorApelido(String apelido);

    Usuario recuperarPorId(Long id);

    Usuario recuperarPorIdFetch(Long id);

    Usuario recuperarPorIdDenuncia(Long id);

    Usuario obterPorCredenciais(String email, String senha);

    List<Usuario> recuperarTodos();

    List<Usuario> recuperarPorComunidade(Comunidade comunidade);

    List<Usuario> recuperarPorConselho(Conselho conselho);

    List<Usuario> recuperarPorRelato(Relato relato);
}
