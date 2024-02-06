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
	@JoinColumn(name = "id_relato_denunciado")
	private Relato relato;
	
	public DenunciaRelato() {
		
	}
	
	public DenunciaRelato(long id, LocalDate data, String motivo, Status status,
			Usuario usuarioDenunciante,Relato relato) {
		super(id, data, motivo, status, usuarioDenunciante);
		this.relato = relato;
	}
	
	public DenunciaRelato(String motivo, Usuario usuarioDenunciante,Relato relato) {
		super(motivo, usuarioDenunciante);
		this.relato = relato;
	}

	public Relato getDenunciaDeRelato() {
		return relato;
	}

	public void setDenunciaDeRelato(Relato relato) {
		this.relato = relato;
	}

}