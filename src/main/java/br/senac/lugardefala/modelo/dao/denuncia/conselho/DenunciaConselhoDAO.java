package br.senac.lugardefala.modelo.dao.denuncia.conselho;

import br.senac.lugardefala.modelo.entidade.conselho.Conselho;
import br.senac.lugardefala.modelo.entidade.denuncia.Denuncia;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.enumeracao.Status;

public interface DenunciaConselhoDAO {

    void inserirDenunciaConselho(Denuncia denuncia);

    void deletarDenunciaConselho(Denuncia denuncia);

    Denuncia recuperarDenunciaDeConselhoStatus(Conselho conselho, Status status);

    Denuncia recuperarDenunciaDeConselhoRelato(Conselho conselho, Relato relato);
}
