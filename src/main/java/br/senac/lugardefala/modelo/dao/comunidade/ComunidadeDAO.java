package br.senac.lugardefala.modelo.dao.comunidade;

import java.util.List;

import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

public interface ComunidadeDAO {

    void inserir(Comunidade comunidade);

    void deletar(Comunidade comunidade);

    void atualizar(Comunidade comunidade);

    List<Comunidade> recuperarComunidadesPorIdModerador(Long id);

    List<Comunidade> recuperarComunidadesPorIdUsuario(Long id);

    List<Comunidade> recuperarComunidadesPorUsuario(Usuario usuario);
    
    List<Comunidade> recuperarComunidadesPorNome(String nome);
    
    List<Comunidade> recuperarTodasComunidades();

    Comunidade recuperarComunidadePorId(Long id);
}
