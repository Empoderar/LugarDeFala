package br.senac.lugardefala.modelo.entidade.denuncia;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;
import br.senac.lugardefala.modelo.enumeracao.Status;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "denuncia_relato")
public class DenunciaRelato extends Denuncia {

	private static final long serialVersionUID = 1L;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_relato")
	private Relato relato;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_usuario")
	private Relato relatoDenunciado;
	
	@JoinColumn(name = "id_usuario_denunciante")
	protected Usuario usuario;
	
	public DenunciaRelato(Relato relato, long id, LocalDate data, String motivo, Status status,
			Usuario usuarioDenunciante,Relato relatoDenunciado) {
		super(id, data, motivo, status, usuarioDenunciante);
		this.relato = relato;
		this.relatoDenunciado = relatoDenunciado;
	}
	
	public DenunciaRelato(String motivo, Usuario usuarioDenunciante,Relato relatoDenunciado) {
		super(motivo, usuarioDenunciante);
		this.relatoDenunciado = relatoDenunciado;
	}

	public Relato getDenunciaDeRelato() {
		return relato;
	}

	public void setDenunciaDeRelato(Relato relato) {
		this.relato = relato;
	}

}