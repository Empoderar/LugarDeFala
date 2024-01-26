package br.senac.lugardefala.modelo.entidade.denuncia;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.senac.lugardefala.modelo.entidade.moderador.Moderador;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;
import br.senac.lugardefala.modelo.enumeracao.Status;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "denuncia_moderador")

public class DenunciaModerador extends Denuncia {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "id_moderador")
	private Moderador moderadorDenunciado;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_usuario_denunciado")
	private Moderador moderador;
	
	public DenunciaModerador(long id, LocalDate data, String motivo, Status status,
			Usuario usuarioDenunciante, Moderador moderadorDenunciado) {
		super(id, data, motivo, status, usuarioDenunciante);
		this.moderadorDenunciado = moderadorDenunciado;
	}

	public Moderador getDenunciaDeModerador() {
		return moderadorDenunciado;
	}

	public void setDenunciaDeModerador(Moderador moderadorDenunciado) {
		this.moderadorDenunciado = moderadorDenunciado;
	}

}