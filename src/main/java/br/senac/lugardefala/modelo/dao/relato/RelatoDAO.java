package br.senac.lugardefala.modelo.dao.relato;

import br.senac.lugardefala.modelo.entidade.categoria.Categoria;
import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;
import br.senac.lugardefala.modelo.enumeracao.Status;

import java.util.List;

public interface RelatoDAO {

    void inserir(Relato relato);

    void deletar(Relato relato);

    void atualizar(Relato relato);

    List<Relato> recuperarRelatosPorUsuario(Usuario usuario);

    List<Relato> recuperarRelatosPorStatus(Status status);

    List<Relato> recuperarRelatosPorComunidade(Comunidade comunidade);

    List<Relato> recuperarRelatosPorCategoria(Categoria categoria);
    
    List<Relato> recuperarTodosRelato();

    Relato recuperarRelatoPorId(Long id);
}
