package br.senac.lugardefala.modelo.dao.moderador;

import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.moderador.Moderador;

import java.util.List;

public interface ModeradorDAO {

    void inserir(Moderador moderador);

    void deletar(Moderador moderador);

    void atualizar(Moderador moderador);

    List<Moderador> recuperarPelaComunidade(Comunidade comunidade);

    List<Moderador> recuperarPorId(Long id);

    Moderador recuperarPorNome(String nome);
}
