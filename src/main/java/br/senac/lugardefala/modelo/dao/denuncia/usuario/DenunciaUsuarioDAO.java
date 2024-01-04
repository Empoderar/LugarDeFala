package br.senac.lugardefala.modelo.dao.denuncia.usuario;

import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaUsuario;

public interface DenunciaUsuarioDAO {

    void inserirDenunciaUsuario(DenunciaUsuario denunciaUsuario);

    void deletarDenunciaUsuario(DenunciaUsuario denunciaUsuario);

    DenunciaUsuario recuperarDenunciaUsuarioPorId(long id);
}
