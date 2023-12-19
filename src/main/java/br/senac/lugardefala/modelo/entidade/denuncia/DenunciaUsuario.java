package br.senac.lugardefala.modelo.entidade.denuncia;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.senac.lugardefala.modelo.entidade.usuario.Usuario;
import br.senac.lugardefala.modelo.enumeracao.Status;

@Entity
@Table(name = "denunciaUsuario")

public class DenunciaUsuario extends Denuncia implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_conselho")
	private Usuario denunciaDeUsuario;

	public DenunciaUsuario(Usuario denunciaDeUsuario, LocalDate data, String motivo, Status status) {
		super(data, motivo, status);
		this.denunciaDeUsuario = denunciaDeUsuario;
	}

	public Usuario getDenunciaDeUsuario() {
		return denunciaDeUsuario;
	}

	public void setDenunciaDeUsuario(Usuario denunciaDeUsuario) {
		this.denunciaDeUsuario = denunciaDeUsuario;
	}

}
