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

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_moderador_denunciado")
	private Moderador moderador;

	public DenunciaModerador() {
		
	}
	
	public DenunciaModerador(long id, LocalDate data, String motivo, Status status,
			Usuario usuarioDenunciante,Moderador moderador) {
		super(id, data, motivo, status, usuarioDenunciante);
		this.moderador = moderador;
	}
	
	public DenunciaModerador(LocalDate data,String motivo, Status status,
			Usuario usuarioDenunciante,Moderador moderadorDenunciado) {
		super(data, motivo,status,usuarioDenunciante);
		this.moderador = moderadorDenunciado;
	}
	
	public DenunciaModerador(String motivo,
			Usuario usuarioDenunciante) {
		super(motivo, usuarioDenunciante);
	}

	public Moderador getModerador() {
		return moderador;
	}
	
	public void setModeradro(Moderador moderador) {
		this.moderador = moderador;
	}

}