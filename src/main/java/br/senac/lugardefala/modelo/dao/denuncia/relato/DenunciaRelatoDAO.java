package br.senac.lugardefala.modelo.dao.denuncia.relato;

import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaRelato;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.enumeracao.Status;

public interface DenunciaRelatoDAO {

    void inserirDenunciaRelato(DenunciaRelato denunciaRelato);

    void deletarDenunciaRelato(DenunciaRelato denunciaRelato);

    DenunciaRelato recuperarDenunciaDeRelatoStatus(Relato relato, Status status);

    DenunciaRelato recuperarDenunciaDeRelatoRelato(Relato relato);
}
