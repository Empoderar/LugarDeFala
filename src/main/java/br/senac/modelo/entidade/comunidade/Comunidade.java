package br.senac.modelo.entidade.comunidade;

import java.util.ArrayList;
import java.util.List;

import br.senac.modelo.entidade.conselho.Conselho;
import br.senac.modelo.entidade.moderador.Moderador;
import br.senac.modelo.entidade.relato.Relato;
import br.senac.modelo.entidade.usuario.Usuario;

public class Comunidade {

	private String nome;
	private String descricao;
	private List<Relato> listaRelatos;
	private List<Moderador> listaModeradores;
	private Usuario usuario;
	private Conselho conselho;

	public Comunidade(String nome, String descricao, Usuario usuario, Conselho conselho) {
		this.nome = nome;
		this.descricao = descricao;
		listaRelatos = new ArrayList<>();
		listaModeradores = new ArrayList<>();
		this.usuario = usuario;
		this.conselho = conselho;
	}

	public String getNome() {
		return nome;
	}

	public void inserirListaRelato() {

	}

	public void removerListaRelato() {

	}

	public void inserirlistaModeradores() {

	}

	public void removerlistaModeradores() {

	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
}
