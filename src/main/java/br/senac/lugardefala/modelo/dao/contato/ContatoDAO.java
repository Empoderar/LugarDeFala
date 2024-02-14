package br.senac.lugardefala.modelo.dao.contato;

import br.senac.lugardefala.modelo.entidade.contato.Contato;

public interface ContatoDAO {

    void inserir(Contato contato);

    void atualizar(Contato contato);
    
    void deletar(Contato contato);

    Contato recuperarPorId(Long id);
}
