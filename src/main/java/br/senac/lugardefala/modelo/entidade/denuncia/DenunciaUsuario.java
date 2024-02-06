package br.senac.lugardefala.modelo.entidade.denuncia;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario_denunciado")
    protected Usuario usuarioDenunciado;
	

	@Enumerated(EnumType.STRING)
	private Status status;

	public DenunciaUsuario() {
		
	}
	
    public DenunciaUsuario(Usuario usuarioDenunciante, long id, LocalDate data, String motivo, Status status, Usuario usuarioDenunciado) {
        super(id, data, motivo, status, usuarioDenunciante);
        this.usuarioDenunciado = usuarioDenunciado;
    }
    
    public DenunciaUsuario(Usuario usuarioDenunciante, String motivo, Usuario usuarioDenunciado) {
        super(motivo, usuarioDenunciante);
        this.usuarioDenunciado = usuarioDenunciado;
    }

    public Usuario getUsuarioDenunciado() {
        return usuarioDenunciado;
    }

    public void setUsuarioDenunciado(Usuario usuarioDenunciado) {
        this.usuarioDenunciado = usuarioDenunciado;
    }
}