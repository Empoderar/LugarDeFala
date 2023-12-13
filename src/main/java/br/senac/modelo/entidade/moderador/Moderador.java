package br.senac.modelo.entidade.moderador;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.senac.modelo.entidade.categoria.Categoria;
import br.senac.modelo.entidade.comunidade.Comunidade;
import br.senac.modelo.entidade.conselho.Conselho;
import br.senac.modelo.entidade.denuncia.Denuncia;
import br.senac.modelo.entidade.relato.Relato;
import br.senac.modelo.entidade.usuario.Usuario;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "Moderador")
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "moderador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Relato> relatosModerados = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_conselho")
    private Conselho conselho;

	@OneToMany
	@JoinColumn(name = "id_comunidade")
    private Comunidade comunidade;

    @ManyToOne
    @JoinColumn(name = "id_denuncia") 
    private Denuncia denuncia;

	public Moderador(){}

	public Moderador(Comunidade comunidade, String nome, String sobrenome, LocalDate dataNascimento, String user,
			String senha, Conselho conselho, Denuncia denuncia, String telefone, String email) {
		super(nome, sobrenome, dataNascimento, user, senha, conselho, denuncia, telefone, email);
		this.comunidade = comunidade;
		this.conselho = conselho;
        this.denuncia = denuncia;
		relatosModerados = new ArrayList<>();
	}

	 public void inserirRelato(Relato relato) {

    }

    public void excluirRelato(Relato relato) {

    }

    public void editarRelato(Relato relato) {

    }

    public Comunidade getComunidade() {
		return comunidade;
	}

	public void setComunidade(Comunidade comunidade) {
		this.comunidade = comunidade;
	}
}
