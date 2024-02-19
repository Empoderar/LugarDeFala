package br.senac.lugardefala.modelo.dao.denuncia.moderador;

import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaModerador;

public interface DenunciaModeradorDAO {

    void inserir(DenunciaModerador denunciaModerador);

    void deletar(DenunciaModerador denunciaModerador);

    DenunciaModerador recuperarDenunciaModeradorPorId(long id);
}
