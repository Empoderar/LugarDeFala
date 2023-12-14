package br.senac.modelo.dao.moderador;

import java.util.List;

import br.senac.modelo.entidade.moderador.Moderador;

public interface ModeradorDAO {

    void inserirModerador(Moderador moderador);

    void deletarModerador(Moderador moderador);

    void atualizarModerador(Moderador moderador);

    List<Moderador> recuperarModeradores();
}
	