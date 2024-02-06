package br.senac.lugardefala.modelo.entidade.denuncia;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.senac.lugardefala.modelo.entidade.usuario.Usuario;
import br.senac.lugardefala.modelo.enumeracao.Status;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "denuncia_usuario")

public class DenunciaUsuario extends Denuncia {

	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_usuario_denunciado")
	private Usuario usuario;

	public DenunciaUsuario() {
		
	}
	
    public DenunciaUsuario(Usuario usuarioDenunciante, long id, LocalDate data, String motivo, Status status, Usuario usuario) {
        super(id, data, motivo, status, usuarioDenunciante);
        this.usuario = usuario;
    }
    
    public DenunciaUsuario(Usuario usuarioDenunciante, String motivo, Usuario usuarioDenunciado,Usuario usuario) {
        super(motivo, usuarioDenunciante);
        this.usuario = usuario;
    }

    
    public Usuario getUsuario() {
    	return usuario;
    }
    public void setUsuario(Usuario usuario) {
    	this.usuario = usuario;
    }
}