package br.senac.lugardefala.modelo.entidade.denuncia;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import br.senac.lugardefala.modelo.entidade.moderador.Moderador;
import br.senac.lugardefala.modelo.enumeracao.Status;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "denunciaModerador")

public class DenunciaModerador extends Denuncia {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "id_moderador")
	private Moderador moderador;


	public DenunciaModerador(Moderador moderador, long id, LocalDate data, String motivo, Status status) {
		super(id, data, motivo, status);
		this.moderador = moderador;
	}

	public Moderador getDenunciaDeModerador() {
		return moderador;
	}

	public void setDenunciaDeModerador(Moderador moderador) {
		this.moderador = moderador;
	}

}
