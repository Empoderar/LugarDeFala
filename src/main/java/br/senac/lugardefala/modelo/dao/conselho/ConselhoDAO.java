package br.senac.lugardefala.modelo.dao.conselho;

import java.util.List;

import br.senac.lugardefala.modelo.entidade.conselho.Conselho;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

public interface ConselhoDAO {

    void inserir(Conselho conselho);

    void deletar(Conselho conselho);

    void atualizar(Conselho conselho);
    
    Conselho recuperarConselhoPorId(Long id);

    List<Conselho> recuperarConselhosPorRelato(Relato relato);

    List<Conselho> recuperarConselhosPorUsuario(Usuario usuario);
}
