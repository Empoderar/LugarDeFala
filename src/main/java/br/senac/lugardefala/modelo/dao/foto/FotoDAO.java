package br.senac.lugardefala.modelo.dao.foto;

import br.senac.lugardefala.modelo.entidade.foto.Foto;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

import java.util.List;

public interface FotoDAO {

    void inserir(Foto foto);

    void deletar(Foto foto);

    void atualizar(Foto foto);

    List<Foto> recuperarPorUsuario(Usuario usuario);

    Foto recuperarPorId(int id);
}