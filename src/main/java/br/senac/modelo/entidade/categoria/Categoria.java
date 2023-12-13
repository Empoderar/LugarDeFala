package br.senac.modelo.entidade.categoria;

import java.util.ArrayList;
import java.util.List;

import br.senac.modelo.entidade.comunidade.Comunidade;
import br.senac.modelo.entidade.relato.Relato;

public class Categoria {
	private String nome;
	private String cor;
	private List<Comunidade> listaComunidade;
	private Relato relato;

	public Categoria(String nome, String cor, Relato relato) {
		this.nome = nome;
		this.cor = cor;
		listaComunidade = new ArrayList<>();
		this.relato = relato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Relato getRelato() {
		return relato;
	}

	public void setRelato(Relato relato) {
		this.relato = relato;
	}
}