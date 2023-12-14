package br.senac.modelo.entidade.denuncia;

import java.time.LocalDate;

import br.senac.modelo.entidade.conselho.Conselho;
import br.senac.modelo.entidade.moderador.Moderador;
import br.senac.modelo.entidade.relato.Relato;
import br.senac.modelo.entidade.usuario.Usuario;

public class Denuncia {

	private LocalDate data;
	private String motivo;
	private Usuario usuario;
	private Conselho conselho;
	private Relato relato;
	private Moderador moderador;

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
