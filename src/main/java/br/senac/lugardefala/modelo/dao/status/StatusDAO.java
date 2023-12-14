package br.senac.lugardefala.modelo.dao.status;

import java.util.List;

import br.senac.lugardefala.modelo.entidade.status.Status;

public interface StatusDAO {
    void inserirStatus(Status status);
    
    void deletarStatus(Status status);
    
    void atualizarStatus(Status status);
    
    List<Status> recuperarStatus();
}
