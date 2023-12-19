package br.senac.lugardefala.modelo.entidade.relato;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaRelato;
import br.senac.lugardefala.modelo.entidade.moderador.Moderador;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;
import br.senac.lugardefala.modelo.enumeracao.Status;

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
	private int avaliacao;

	@Column(name = "descricao_relato", length = 500, nullable = true, unique = false)
	private String descricao;

	@OneToMany(mappedBy = "relato", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Conselho> conselhoRelato = new ArrayList<Conselho>();

	@OneToMany(mappedBy = "relato", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Categoria> categoriaRelato = new ArrayList<Categoria>();

	@OneToMany(mappedBy = "relato", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DenunciaRelato> denuncia = new ArrayList<DenunciaRelato>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_moderador")
	private Moderador moderador;

	@OneToMany(mappedBy = "relato", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Conselho> conselho = new ArrayList<Conselho>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@Enumerated(EnumType.STRING)
	private Status status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_comunidade")
	private Comunidade comunidade;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

	public Relato() {
	}

	public Relato(LocalDate data, Usuario usuario, int avaliacao, String descricao, Moderador moderador, Status status,
			Comunidade comunidade) {
		this.data = data;
		this.usuario = usuario;
		this.avaliacao = avaliacao;
		this.descricao = descricao;
		this.moderador = moderador;
		this.status = status;
		this.comunidade = comunidade;
		conselhoRelato = new ArrayList<>();
		categoriaRelato = new ArrayList<>();
		denuncia = new ArrayList<>();
		conselho = new ArrayList<>();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getComunidade() {
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

	public int getAvaliacao() {
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

	public void setAvaliacao(int avaliacao) {
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
