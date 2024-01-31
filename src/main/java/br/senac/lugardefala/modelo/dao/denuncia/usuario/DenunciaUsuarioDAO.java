package br.senac.lugardefala.modelo.dao.denuncia.usuario;

import java.util.List;

import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaUsuario;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;
import br.senac.lugardefala.modelo.enumeracao.Status;

public interface DenunciaUsuarioDAO {

    void inserirDenunciaUsuario(DenunciaUsuario denunciaUsuario);

    void deletarDenunciaUsuario(DenunciaUsuario denunciaUsuario);

    List<DenunciaUsuario> recuperarDenunciaUsuarioStatus(Status status); 

    List<DenunciaUsuario> recuperarDenunciaUsuarioPeloUsuario(Usuario usuario);
}
