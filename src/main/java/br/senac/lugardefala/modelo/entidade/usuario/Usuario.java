package br.senac.lugardefala.modelo.entidade.usuario;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.conselho.Conselho;
import br.senac.lugardefala.modelo.entidade.contato.Contato;
import br.senac.lugardefala.modelo.entidade.denuncia.Denuncia;
import br.senac.lugardefala.modelo.entidade.relato.Relato;

@Entity
@Table(name = "usuario")
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

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Conselho> conselho = new ArrayList<Conselho>();
	
	@OneToOne(fetch = FetchType.LAZY)
	private Contato contato;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_comunidade")
	private Comunidade comunidade;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Denuncia> denuncia = new ArrayList<Denuncia>();
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Relato> relato = new ArrayList<Relato>();
	
	public Usuario() {
	}

	public Usuario(String nome, String sobrenome, LocalDate dataNascimento, String user, String senha, String telefone, String email, Comunidade comunidade, Contato contato) {
		super(telefone, email);
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.user = user;
		this.senha = senha;
		
		denuncia = new ArrayList<>();
		relato = new ArrayList<>();
		conselho = new ArrayList<>();
		this.comunidade = comunidade;
		this.contato = contato;
	}
	
	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Comunidade getComunidade() {
		return comunidade;
	}

	public void setComunidade(Comunidade comunidade) {
		this.comunidade = comunidade;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
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

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
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
