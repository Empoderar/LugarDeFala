package br.senac.lugardefala.modelo.dao.denuncia.usuario;

import java.util.List;

import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaUsuario;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;
import br.senac.lugardefala.modelo.enumeracao.Status;

public interface DenunciaUsuarioDAO {

    void inserir(DenunciaUsuario denunciaUsuario);

    void deletar(DenunciaUsuario denunciaUsuario);

    List<DenunciaUsuario> recuperarPorStatus(Status status);

    List<DenunciaUsuario> recuperarPorUsuario(Usuario usuario);
}
