package br.senac.modelo.entidade.conselho;

import java.time.LocalDate;

import br.senac.modelo.entidade.denuncia.Denuncia;
import br.senac.modelo.entidade.relato.Relato;
import br.senac.modelo.entidade.usuario.Usuario;

public class Conselho {
	private String conteudo;
	private LocalDate data;
	private Usuario usuario;
	private String avaliacao;
	private String conselho;
	private Relato relato;
	private Denuncia denuncia;

	public Conselho(String conteudo, LocalDate data, Usuario usuario, String avaliacao, String conselho, Relato relato,
			Denuncia denuncia) {

		this.conteudo = conteudo;
		this.data = data;
		this.usuario = usuario;
		this.avaliacao = avaliacao;
		this.conselho = conselho;
		this.relato = relato;
		this.denuncia = denuncia;
	}

	public String getAvaliacao() {
		return avaliacao;
	}

	public String getConselho() {
		return conselho;
	}

	public String getConteudo() {
		return conteudo;
	}

	public LocalDate getData() {
		return data;
	}

	public Denuncia getDenuncia() {
		return denuncia;
	}

	public Relato getRelato() {
		return relato;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}

	public void setConselho(String conselho) {
		this.conselho = conselho;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public void setDenuncia(Denuncia denuncia) {
		this.denuncia = denuncia;
	}

	public void setRelato(Relato relato) {
		this.relato = relato;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
