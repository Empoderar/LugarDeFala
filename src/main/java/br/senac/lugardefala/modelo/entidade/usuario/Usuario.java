package br.senac.modelo.entidade.usuario;

import java.io.Serializable;
import java.time.LocalDate;

import br.senac.modelo.entidade.conselho.Conselho;
import br.senac.modelo.entidade.contato.Contato;
import br.senac.modelo.entidade.denuncia.Denuncia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario extends Contato implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;

	@Column(name = "nome_Usuario", length = 50, nullable = false, unique = true)
	private String nome;

	@Column(name = "sobrenome_Usuario", length = 50, nullable = false, unique = true)
	private String sobrenome;

	@Column(name = "data_nascimento_usuario", nullable = false, unique = false)
	private LocalDate dataNascimento;

	@Column(name = "user_usuario", length = 25, nullable = false, unique = false)
	private String user;

	@Column(name = "senha_usuario", length = 20, nullable = false, unique = false)
	private String senha;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_conselho")
	private Conselho conselho;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_denuncia")
	private Denuncia denuncia;

	public Usuario() {
	}

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
