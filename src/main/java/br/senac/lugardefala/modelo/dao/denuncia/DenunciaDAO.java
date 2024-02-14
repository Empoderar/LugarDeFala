package br.senac.lugardefala.modelo.dao.denuncia;

import br.senac.lugardefala.modelo.entidade.conselho.Conselho;
import br.senac.lugardefala.modelo.entidade.denuncia.*;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;
import br.senac.lugardefala.modelo.enumeracao.Status;

public interface DenunciaDAO {

    void inserir(Denuncia denuncia);

    void inserir(DenunciaModerador denunciaModerador);

    void inserir(DenunciaRelato denunciaRelato);

    void inserir(DenunciaUsuario denunciaUsuario);

    void inserir(DenunciaConselho denunciaConselho);

    void deletar(Denuncia denuncia);

    void atualizar(Denuncia denuncia);

    Denuncia recuperarDenunciaUsuario(Usuario usuario);

    Denuncia recuperarDenunciaDeRelatoStatus(Relato relato, Status status);

    Denuncia recuperarDenunciaDeRelatoRelato(Relato relato);

    Denuncia recuperarDenunciaDeConselhoStatus(Conselho conselho, Status status);

    Denuncia recuperarDenunciaDeConselhoRelato(Conselho conselho, Relato relato);

    Denuncia recuperarDenunciaDeUsuarioStatus(Usuario usuario, Status status);

    Denuncia recuperarDenunciaDeUsuarioUsuario(Usuario usuario);
}
