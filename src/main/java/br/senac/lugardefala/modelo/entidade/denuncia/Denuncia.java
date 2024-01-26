package br.senac.lugardefala.modelo.entidade.denuncia;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.senac.lugardefala.modelo.entidade.usuario.Usuario;
import br.senac.lugardefala.modelo.enumeracao.Status;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "denuncia")
public class Denuncia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_denuncia")
	private Long id;

	@Column(name = "data_denuncia", nullable = false, unique = false)
	private LocalDate data;

	@Column(name = "motivo_denuncia", length = 200, nullable = true, unique = false)
	private String motivo;

	@Enumerated(EnumType.STRING)
	private Status status;

	@ManyToOne
	@JoinColumn(name = "id_usuario_denunciante")
	protected Usuario usuarioDenunciante;
	

	public Denuncia() {
	}

	public Denuncia(Long id, LocalDate data, String motivo, Status status, Usuario usuarioDenunciante) {
		this.id = id;
		this.data = data;
		this.motivo = motivo;
		this.status = status;
		this.usuarioDenunciante = usuarioDenunciante;
	}

	public Long getId() {
		return id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Usuario getUsuarioDenunciante() {
		return usuarioDenunciante;
	}

	public void setUsuarioDenunciante(Usuario usuarioDenunciante) {
		this.usuarioDenunciante= usuarioDenunciante;
	}

	public void setId(Long id) {
		this.id = id;
	}
}