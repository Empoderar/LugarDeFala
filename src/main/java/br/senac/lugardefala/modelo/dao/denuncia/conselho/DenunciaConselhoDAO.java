package br.senac.lugardefala.modelo.dao.denuncia.conselho;

import br.senac.lugardefala.modelo.entidade.denuncia.Denuncia;
import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaConselho;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.enumeracao.Status;

import java.util.List;

public interface DenunciaConselhoDAO {

    void inserir(Denuncia denuncia);

    void deletar(Denuncia denuncia);

    List<DenunciaConselho> recuperarPorStatus(Status status);

    List<DenunciaConselho> recuperarPorRelato(Relato relato);
}
