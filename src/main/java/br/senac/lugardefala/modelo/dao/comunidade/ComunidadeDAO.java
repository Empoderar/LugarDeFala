package br.senac.lugardefala.modelo.dao.comunidade;

import java.util.List;

import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

public interface ComunidadeDAO {

    void inserir(Comunidade comunidade);

    void deletar(Comunidade comunidade);

    void atualizar(Comunidade comunidade);

    List<Comunidade> recuperarPorIdModerador(Long id);

    List<Comunidade> recuperarPorIdUsuario(Long id);

    List<Comunidade> recuperarPorUsuario(Usuario usuario);
    
    List<Comunidade> recuperarPorNome(String nome);

    Comunidade recuperarPorId(Long id);
}
