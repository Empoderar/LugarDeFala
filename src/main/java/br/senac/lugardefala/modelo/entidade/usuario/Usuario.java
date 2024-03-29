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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.conselho.Conselho;
import br.senac.lugardefala.modelo.entidade.contato.Contato;
import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaUsuario;
import br.senac.lugardefala.modelo.entidade.relato.Relato;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "nome_usuario", length = 50, nullable = false, unique = false)
    private String nome;

    @Column(name = "sobrenome_usuario", length = 50, nullable = false, unique = false)
    private String sobrenome;

    @Column(name = "data_nascimento_usuario", nullable = false, unique = false)
    private LocalDate dataNascimento;

    @Column(name = "apelido_usuario", length = 35, nullable = false, unique = true)
    private String apelido;

    @Column(name = "senha_usuario", length = 20, nullable = false, unique = false)
    private String senha;
    
    @Column(name = "descricao_usuario", length = 500, nullable = false, unique = false)
	private String descricao;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Conselho> conselhos;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contato_id_contato", referencedColumnName = "id_contato")
    private Contato contato;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DenunciaUsuario> denunciasDeUsuario;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Relato> relatos;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "comunidade_usuario",joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_comunidade")
    )
    private List<Comunidade> comunidades;

    public Usuario() {
    	
    }
    
    
//    public Usuario(denunciasDeUsuario {
//        denunciasDeUsuario = new ArrayList<>();
//        relatos = new ArrayList<>();
//        conselhos = new ArrayList<>();
//        comunidades = new ArrayList<>();
//    }

    public Usuario(Long id,String nome, String sobrenome, LocalDate dataNascimento, String apelido, String senha, String descricao) {
       this.id = id;
    	this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.apelido = apelido;
        this.senha = senha;
        this.descricao = descricao;
        denunciasDeUsuario = new ArrayList<>();
        relatos = new ArrayList<>();
        conselhos = new ArrayList<>();
        comunidades = new ArrayList<>();
    }

    public Usuario(Long id,String nome, String sobrenome, String apelido) {
    	this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.apelido = apelido;
	}
    
    
    public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Usuario(Long id, String nome, String sobrenome, LocalDate dataNascimento, String apelido, String senha, String descricao,
            Conselho conselho, Contato contato, Comunidade comunidade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.apelido = apelido;
        this.senha = senha;
        this.descricao = descricao;
        this.id = id;
        this.contato = contato;
        denunciasDeUsuario = new ArrayList<>();
        relatos = new ArrayList<>();
        conselhos = new ArrayList<>();
        this.comunidades = new ArrayList<>();
        this.comunidades.add(comunidade);
    }

    public List<Comunidade> getComunidades() {
        return comunidades;
    }

    public void setComunidades(List<Comunidade> comunidades) {
        this.comunidades = comunidades;
    }

    public boolean adicionarComunidade(Comunidade comunidade) {
        return comunidades.add(comunidade);
    }

    public boolean removerComunidade(Comunidade comunidade) {
        return comunidades.remove(comunidade);
    }

    public List<Conselho> getConselhos() {
        return conselhos;
    }

    public void setConselhos(List<Conselho> conselhos) {
        this.conselhos = conselhos;
    }

    public List<DenunciaUsuario> getDenunciasDeUsuario() {
        return denunciasDeUsuario;
    }

    public void setDenunciasDeUsuario(List<DenunciaUsuario> denunciasDeUsuario) {
        this.denunciasDeUsuario = denunciasDeUsuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public List<Relato> getRelatos() {
        return relatos;
    }

    public void setRelatos(List<Relato> relatos) {
        this.relatos = relatos;
    }
}