package br.senac.lugardefala.modelo.entidade.denuncia;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.enumeracao.Status;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "denunciaRelato")
public class DenunciaRelato extends Denuncia {

	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_relato")
	private Relato denunciaDeRelato;

	public DenunciaRelato(Relato denunciaDeRelato, long id, LocalDate data, String motivo, Status status) {
		super(id, data, motivo, status);
		this.denunciaDeRelato = denunciaDeRelato;
	}

	public Relato getDenunciaDeRelato() {
		return denunciaDeRelato;
	}

	public void setDenunciaDeRelato(Relato denunciaDeRelato) {
		this.denunciaDeRelato = denunciaDeRelato;
	}

}
