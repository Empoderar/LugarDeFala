package br.senac.modelo.dao.status;

import java.util.List;
import br.senac.modelo.entidade.status.Status;

public interface StatusDAO {
    void inserirStatus(Status status);
    
    void deletarStatus(Status status);
    
    void atualizarStatus(Status status);
    
    List<Status> recuperarStatus();
}
