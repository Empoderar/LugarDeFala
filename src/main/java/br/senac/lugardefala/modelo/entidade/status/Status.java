package br.senac.lugardefala.modelo.entidade.status;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.lugardefala.modelo.entidade.relato.Relato;

@Entity
@Table(name = "status")
public class Status implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status")
    private Long id;
    
    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Relato> relato = new ArrayList<Relato>();

    @Enumerated(EnumType.STRING)
    private StatusEnum statusEnum;

    public Status() {}

    public enum StatusEnum {
        APROVADO, REJEITADO, PENDENTE, ARQUIVADO
    }
}
