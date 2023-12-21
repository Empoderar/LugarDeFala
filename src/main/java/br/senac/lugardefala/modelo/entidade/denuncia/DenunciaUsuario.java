package br.senac.lugardefala.modelo.entidade.denuncia;

import java.time.LocalDate;

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
@Table(name = "denunciaUsuario")

public class DenunciaUsuario extends Denuncia {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public DenunciaUsuario(Usuario usuario, long id, LocalDate data, String motivo, Status status) {
		super(id, data, motivo, status);
		this.usuario = usuario;
	}

	public Usuario getDenunciaDeUsuario() {
		return usuario;
	}

	public void setDenunciaDeUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
