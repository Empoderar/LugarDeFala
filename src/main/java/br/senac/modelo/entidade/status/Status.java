package br.senac.modelo.entidade.status;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "status")
public class Status implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status")
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatusEnum statusEnum;

    public Status() {}

    public enum StatusEnum {
        APROVADO, REJEITADO, PENDENTE, ARQUIVADO
    }
}
