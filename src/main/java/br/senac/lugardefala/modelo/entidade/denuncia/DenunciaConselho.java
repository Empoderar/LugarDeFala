package br.senac.lugardefala.modelo.entidade.denuncia;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.senac.lugardefala.modelo.entidade.conselho.Conselho;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;
import br.senac.lugardefala.modelo.enumeracao.Status;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "denuncia_conselho")
public class DenunciaConselho extends Denuncia {

	private static final long serialVersionUID = 1L;

	  @ManyToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name = "id_conselho_denunciado")
	  private Conselho conselhoDenunciado;
	  
	    public DenunciaConselho(long id,Usuario usuarioDenunciante, LocalDate data, String motivo, 
	    		Status status, Conselho conselhoDenunciado) {
	        super(id, data, motivo, status, usuarioDenunciante);
	        this.conselhoDenunciado = conselhoDenunciado;
	    }
	
	    public DenunciaConselho(Usuario usuarioDenunciante, String motivo,  Conselho conselhoDenunciado) {
	        super(motivo,usuarioDenunciante);
	        this.conselhoDenunciado = conselhoDenunciado;
	    }

	    public Conselho getConselhoDenunciado() {
	        return conselhoDenunciado;
	    }

	    public void setConselhoDenunciado(Conselho conselhoDenunciado) {
	        this.conselhoDenunciado = conselhoDenunciado;
	    }
	}