package br.senac.modelo.entidade.denuncia;

import java.io.Serializable;
import java.time.LocalDate;

import br.senac.modelo.entidade.conselho.Conselho;
import br.senac.modelo.entidade.moderador.Moderador;
import br.senac.modelo.entidade.relato.Relato;
import br.senac.modelo.entidade.usuario.Usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "Denuncia")
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_relato")
	private Relato relato;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_moderador")
	private Moderador moderador;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_conselho")
	private Conselho conselho;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public Denuncia() {}

	public Denuncia(LocalDate data, String motivo, Usuario usuario, Conselho conselho, Relato relato,
			Moderador moderador) {
		this.setData(data);
		this.setMotivo(motivo);
		this.setUsuario(usuario);
		this.setConselho(conselho);
		this.setRelato(relato);
		this.setModerador(moderador);
	}

	public void DenunciaUsuario() {

	}

	public void DenunciaConselho() {

	}

	public void DenunciaRelato() {

	}

	public void DenunciaModerador() {

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Conselho getConselho() {
		return conselho;
	}

	public void setConselho(Conselho conselho) {
		this.conselho = conselho;
	}

	public Relato getRelato() {
		return relato;
	}

	public void setRelato(Relato relato) {
		this.relato = relato;
	}

	public Moderador getModerador() {
		return moderador;
	}

	public void setModerador(Moderador moderador) {
		this.moderador = moderador;
	}

}
