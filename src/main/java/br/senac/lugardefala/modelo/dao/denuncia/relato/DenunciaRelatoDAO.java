package br.senac.lugardefala.modelo.dao.denuncia.relato;

import java.util.List;

import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaRelato;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.enumeracao.Status;

public interface DenunciaRelatoDAO {

    void inserir(DenunciaRelato denunciaRelato);

    void deletar(DenunciaRelato denunciaRelato);

    List<DenunciaRelato> recuperarPorStatus(Status status);

    List<DenunciaRelato> recuperarPorRelato(Relato relato);
}
