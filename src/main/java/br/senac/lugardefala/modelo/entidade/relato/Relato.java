package br.senac.lugardefala.modelo.entidade.relato;

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
import javax.persistence.Table;

import br.senac.lugardefala.modelo.entidade.categoria.Categoria;
import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.conselho.Conselho;
import br.senac.lugardefala.modelo.entidade.denuncia.Denuncia;
import br.senac.lugardefala.modelo.entidade.moderador.Moderador;
import br.senac.lugardefala.modelo.entidade.status.Status;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

@Entity
@Table(name = "relato")
public class Relato implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_relato")
	private Long id;

	@Column(name = "data_relato", nullable = false, unique = false)
	private LocalDate data;

	@Column(name = "avaliacao_relato", length = 200, nullable = true, unique = false)
	private String avaliacao;
	
	@OneToMany(mappedBy = "relato", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Conselho> conselhoRelato = new ArrayList<Conselho>();
	
	@OneToMany(mappedBy = "relato", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Categoria> categoriaRelato = new ArrayList<Categoria>();

	@OneToMany(mappedBy = "relato", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Denuncia> denuncia = new ArrayList<Denuncia>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_moderador")
	private Moderador moderador;

	@OneToMany(mappedBy = "relato", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Conselho> conselho = new ArrayList<Conselho>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_status")
	private Status status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_comunidade")
	private Comunidade comunidade;
	
	public Relato() {
	}

	public Relato(LocalDate data, Usuario usuario, String avaliacao, Moderador moderador, Status status, Comunidade comunidade) {
		this.data = data;
		this.usuario = usuario;
		this.avaliacao = avaliacao;
		this.moderador = moderador;
		this.status = status;
		this.comunidade = comunidade;
		conselhoRelato = new ArrayList<>();
		categoriaRelato = new ArrayList<>();
		denuncia = new ArrayList<>();
		conselho = new ArrayList<>();
	}

	public String getComunidade() {
		return avaliacao;
	}

	public void setComunidade(Comunidade comunidade) {
		this.comunidade = comunidade;
	}
	
	public void inserirConselhoRelato() {

	}

	public void removerConselhoRelato() {

	}

	public void inserirCategoriaRelato() {

	}

	public void removerCategoriaRelato() {

	}

	public String getAvaliacao() {
		return avaliacao;
	}


	public LocalDate getData() {
		return data;
	}

	public Moderador getModerador() {
		return moderador;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}

	public void setModerador(Moderador moderador) {
		this.moderador = moderador;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
