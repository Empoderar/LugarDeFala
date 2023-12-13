package br.senac.modelo.entidade.usuario;

import java.time.LocalDate;

import br.senac.modelo.entidade.conselho.Conselho;
import br.senac.modelo.entidade.contato.Contato;
import br.senac.modelo.entidade.denuncia.Denuncia;

public class Usuario extends Contato {
	private String nome;
	private String sobrenome;
	private LocalDate dataNascimento;
	private String user;
	private String senha;
	private Conselho conselho;
	private Denuncia denuncia;

	public Usuario(String nome, String sobrenome, LocalDate dataNascimento, String user, String senha,
			Conselho conselho, Denuncia denuncia, String telefone, String email) {
		super(telefone, email);
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.user = user;
		this.senha = senha;
		this.conselho = conselho;
		this.denuncia = denuncia;
	}

	public Conselho getConselho() {
		return conselho;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public Denuncia getDenuncia() {
		return denuncia;
	}

	public String getNome() {
		return nome;
	}

	public String getSenha() {
		return senha;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getUser() {
		return user;
	}

	public void setConselho(Conselho conselho) {
		this.conselho = conselho;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setDenuncia(Denuncia denuncia) {
		this.denuncia = denuncia;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public void setUser(String user) {
		this.user = user;
	}
}
