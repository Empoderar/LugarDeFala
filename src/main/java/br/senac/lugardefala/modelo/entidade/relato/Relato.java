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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.lugardefala.modelo.entidade.categoria.Categoria;
import br.senac.lugardefala.modelo.entidade.conselho.Conselho;
import br.senac.lugardefala.modelo.entidade.denuncia.Denuncia;
import br.senac.lugardefala.modelo.entidade.moderador.Moderador;
import br.senac.lugardefala.modelo.entidade.status.Status;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

@Entity
@Table(name = "Relato")
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
	
	@OneToMany(mappedBy = "Relato", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Conselho> conselhoRelato = new ArrayList<Conselho>();
	
	@OneToMany(mappedBy = "Relato", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Categoria> categoriaRelato = new ArrayList<Categoria>();

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_denuncia")
	private Denuncia denuncia;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_moderador")
	private Moderador moderador;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_conselho")
	private Conselho conselho;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_status")
	private Status status;

	public Relato() {
	}

	public Relato(Conselho conselho, LocalDate data, Usuario usuario, String avaliacao, Moderador moderador,
			Denuncia denuncia, Status status) {
		this.conselho = conselho;
		this.data = data;
		this.usuario = usuario;
		this.avaliacao = avaliacao;
		this.moderador = moderador;
		this.denuncia = denuncia;
		this.status = status;
		conselhoRelato = new ArrayList<>();
		categoriaRelato = new ArrayList<>();
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

	public Conselho getConselho() {
		return conselho;
	}

	public LocalDate getData() {
		return data;
	}

	public Denuncia getDenuncia() {
		return denuncia;
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

	public void setConselho(Conselho conselho) {
		this.conselho = conselho;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public void setDenuncia(Denuncia denuncia) {
		this.denuncia = denuncia;
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
