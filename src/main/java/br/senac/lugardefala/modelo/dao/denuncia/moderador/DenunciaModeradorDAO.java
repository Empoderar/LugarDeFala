package br.senac.lugardefala.modelo.dao.denuncia.moderador;

import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaModerador;

public interface DenunciaModeradorDAO {

    void inserirDenunciaModerador(DenunciaModerador denunciaModerador);

    void deletarDenunciaModerador(DenunciaModerador denunciaModerador);

    DenunciaModerador recuperarDenunciaModeradorPorId(long id);
}
