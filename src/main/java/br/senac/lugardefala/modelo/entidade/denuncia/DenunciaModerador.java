package br.senac.lugardefala.modelo.entidade.denuncia;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import br.senac.lugardefala.modelo.entidade.moderador.Moderador;
import br.senac.lugardefala.modelo.enumeracao.Status;

@Entity
@Table(name = "denunciaModerador")

public class DenunciaModerador extends Denuncia implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_moderador")
	private Moderador denunciaDeModerador;

	public DenunciaModerador(Moderador denunciaDeModerador, LocalDate data, String motivo, Status status) {
		super(data, motivo, status);
		this.denunciaDeModerador = denunciaDeModerador;
	}

	public Moderador getDenunciaDeModerador() {
		return denunciaDeModerador;
	}

	public void setDenunciaDeModerador(Moderador denunciaDeModerador) {
		this.denunciaDeModerador = denunciaDeModerador;
	}

}
