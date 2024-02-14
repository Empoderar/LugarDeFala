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

    List<Relato> recuperarPorUsuario(Usuario usuario);

    List<Relato> recuperarPorStatus(Status status);

    List<Relato> recuperarPorComunidade(Comunidade comunidade);

    List<Relato> recuperarPorCategoria(Categoria categoria);

    Relato recuperarPorId(Long id);
}
