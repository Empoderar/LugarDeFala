package br.senac.lugardefala.modelo.entidade.moderador;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.conselho.Conselho;
import br.senac.lugardefala.modelo.entidade.contato.Contato;
import br.senac.lugardefala.modelo.entidade.denuncia.Denuncia;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;
@Entity
@Table(name = "moderador")
public class Moderador extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_moderador")
    private Long id;

    @Column(name = "nome_moderador", length = 20, nullable = false, unique = true)
    private String nome;

    @Column(name = "sobrenome_moderador", length = 20, nullable = false, unique = true)
    private String sobrenome;

    @Column(name = "user_moderador", length = 20, nullable = false, unique = true)
    private String user;

    @Column(name = "senha_moderador", length = 20, nullable = false)
    private String senha;

    @Column(name = "telefone_moderador", length = 20, unique = true)
    private String telefone;

    @Column(name = "email_moderador", length = 20, nullable = false, unique = true)
    private String email;

    @Column(name = "data_nascimento_moderador", nullable = false)
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "moderador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Relato> relatosModerados = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_conselho")
    private Conselho conselho;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_denuncia") 
    private Denuncia denuncia;
    
    @OneToMany(mappedBy = "moderador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comunidade> comunidadeModerador = new ArrayList<>();

	public Moderador(){}

	public Moderador(String nome, String sobrenome, LocalDate dataNascimento, String user, String senha, String telefone, String email, Comunidade comunidade, Contato contato, Conselho conselho, Denuncia denuncia) {
		super(nome, sobrenome, dataNascimento, user, senha, telefone, email, comunidade, contato);
		this.conselho = conselho;
        this.denuncia = denuncia;
        comunidadeModerador = new ArrayList<>();
		relatosModerados = new ArrayList<>();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Conselho getConselho() {
		return conselho;
	}

	public void setConselho(Conselho conselho) {
		this.conselho = conselho;
	}

	public Denuncia getDenuncia() {
		return denuncia;
	}

	public void setDenuncia(Denuncia denuncia) {
		this.denuncia = denuncia;
	}

	public void inserirRelato(Relato relato) {

    }

    public void excluirRelato(Relato relato) {

    }

    public void editarRelato(Relato relato) {

    }

}
