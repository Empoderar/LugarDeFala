package br.senac.modelo.entidade.relato;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.senac.modelo.entidade.categoria.Categoria;
import br.senac.modelo.entidade.conselho.Conselho;
import br.senac.modelo.entidade.denuncia.Denuncia;
import br.senac.modelo.entidade.moderador.Moderador;
import br.senac.modelo.entidade.status.Status;
import br.senac.modelo.entidade.usuario.Usuario;

public class Relato {
	private Conselho conselho;
	private LocalDate data;
	private Usuario usuario;
	private String avaliacao;
	private List<Conselho> conselhoRelato;
	private Moderador moderador;
	private Denuncia denuncia;
	private Categoria categoria;
	private List<Categoria> categoriaRelato;
	private Status status;

	public Relato(Conselho conselho, LocalDate data, Usuario usuario, String avaliacao, Moderador moderador,
			Denuncia denuncia, Status status) {
		this.conselho = conselho;
		this.data = data;
		this.usuario = usuario;
		this.avaliacao = avaliacao;
		this.moderador = moderador;
		this.denuncia = denuncia;
		this.status = status;
		conselhoRelato = new ArrayList<>();
		categoriaRelato = new ArrayList<>();
	}

	public void inserirConselhoRelato() {

	}

	public void removerConselhoRelato() {

	}

	public void inserirCategoriaRelato() {

	}

	public void removerCategoriaRelato() {

	}

	public String getAvaliacao() {
		return avaliacao;
	}

	public Conselho getConselho() {
		return conselho;
	}

	public LocalDate getData() {
		return data;
	}

	public Denuncia getDenuncia() {
		return denuncia;
	}

	public Moderador getModerador() {
		return moderador;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}

	public void setConselho(Conselho conselho) {
		this.conselho = conselho;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public void setDenuncia(Denuncia denuncia) {
		this.denuncia = denuncia;
	}

	public void setModerador(Moderador moderador) {
		this.moderador = moderador;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
