package br.senac.lugardefala.modelo.dao.denuncia.conselho;

import java.util.List;

import br.senac.lugardefala.modelo.entidade.denuncia.Denuncia;
import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaConselho;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.enumeracao.Status;

public interface DenunciaConselhoDAO {

    void inserirDenunciaConselho(Denuncia denuncia);

    void deletarDenunciaConselho(Denuncia denuncia);

    List<DenunciaConselho> recuperarDenunciaDeConselhoStatus(Status status);

    List<DenunciaConselho> recuperarDenunciaDeConselhoRelato(Relato relato);
}
