package br.senac.modelo.entidade.moderador;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.senac.modelo.entidade.categoria.Categoria;
import br.senac.modelo.entidade.comunidade.Comunidade;
import br.senac.modelo.entidade.conselho.Conselho;
import br.senac.modelo.entidade.denuncia.Denuncia;
import br.senac.modelo.entidade.relato.Relato;
import br.senac.modelo.entidade.usuario.Usuario;

public class Moderador extends Usuario {

	private List<Relato> relatosModerados;
	private Comunidade comunidade;
	private List<Categoria> categoriaRelato;

	public Moderador(Comunidade comunidade, String nome, String sobrenome, LocalDate dataNascimento, String user,
			String senha, Conselho conselho, Denuncia denuncia, String telefone, String email) {
		super(nome, sobrenome, dataNascimento, user, senha, conselho, denuncia, telefone, email);
		setComunidade(comunidade);
		categoriaRelato = new ArrayList<>();
		relatosModerados = new ArrayList<>();
	}

	public void InserirRelato() {

	}

	public void InserirCategoria() {

	}

	public void removerRelatoPorUsuario() {

	}

	private Comunidade getComunidde() {
		return comunidade;
	}

	private void setComunidade(Comunidade comunidade) {
		this.comunidade = comunidade;
	}
}
