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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

	@Column(name = "conteudo_relato", length = 500, nullable = true, unique = false)
	private String conteudo;

	@Column(name = "data_relato", nullable = false, unique = false)
	private LocalDate data;

	@Column(name = "avaliacao_relato", length = 200, nullable = true, unique = false)
	private Integer avaliacao;

	@Enumerated(EnumType.STRING)
	private Status status;

	@OneToMany(mappedBy = "relato", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Conselho> conselhoRelato;
	
	@ManyToMany
	@JoinTable(
    name = "relato_categoria", 
    joinColumns = @JoinColumn(name = "id_relato"),
    inverseJoinColumns = @JoinColumn(name = "id_categoria")
	)
	private List<Categoria> categoriaRelato;

	@OneToMany(mappedBy = "relato", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DenunciaRelato> denunciaRelato;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_moderador")
	private Moderador moderador;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_comunidade")
	private Comunidade comunidade;
	
	public Relato() {
	}
	
	public Relato(Long id, String conteudo, LocalDate data, Integer avaliacao, Status status) {
		this.id = id;
		this.conteudo = conteudo;
		this.data = data;
		this.avaliacao = avaliacao;
		this.status = status;
		conselhoRelato = new ArrayList<>();
		categoriaRelato = new ArrayList<>();
		denunciaRelato = new ArrayList<>();
	}


	public Relato(Long id, String conteudo, LocalDate data, Usuario usuario, Integer avaliacao, Moderador moderador, Status status, Comunidade comunidade) {
		this.id = id;
		this.conteudo = conteudo;
		this.data = data;
		this.usuario = usuario;
		this.avaliacao = avaliacao;
		this.moderador = moderador;
		this.status = status;
		this.comunidade = comunidade;
		conselhoRelato = new ArrayList<>();
		categoriaRelato = new ArrayList<>();
		denunciaRelato = new ArrayList<>();
	}

	public boolean inserirConselhoRelato(Conselho conselho) {
        return conselhoRelato.add(conselho);
    }

    public boolean removerConselhoRelato(long id){ 
        for (Conselho conselho : conselhoRelato) {
			if (conselho.getId().equals(id)) {
				conselhoRelato.remove(conselho);
				return true;
			}
		}

		return false;
    }

	public boolean inserirCategoriaRelato(Categoria categoria) {
        return categoriaRelato.add(categoria);
    }

    public boolean removerCategoriaRelato(long id){ 
        for (Categoria categoria : categoriaRelato) {
			if (categoria.getId().equals(id)) {
				categoriaRelato.remove(categoria);
				return true;
			}
		}

		return false;
    }

	public boolean inserirDenunciaRelato(DenunciaRelato denuncia) {
        return denunciaRelato.add(denuncia);
    }

    public boolean removerDenunciaRelato(long id){ 
        for (DenunciaRelato denuncia : denunciaRelato) {
			if (denuncia.getId().equals(id)) {
				denunciaRelato.remove(denuncia);
				return true;
			}
		}

		return false;
    }

	public Long getId() {
		return id;
	}

	public Integer getAvaliacao() {
		return avaliacao;
	}

	public List<Categoria> getCategoriaRelato() {
		return categoriaRelato;
	}

	public Comunidade getComunidade() {
		return comunidade;
	}

	public List<Conselho> getConselhoRelato() {
		return conselhoRelato;
	}

	public String getConteudo() {
		return conteudo;
	}

	public LocalDate getData() {
		return data;
	}

	public List<DenunciaRelato> getDenunciaRelato() {
		return denunciaRelato;
	}

	public Moderador getModerador() {
		return moderador;
	}

	public Status getStatus() {
		return status;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setAvaliacao(Integer avaliacao) {
		this.avaliacao = avaliacao;
	}

	public void setComunidade(Comunidade comunidade) {
		this.comunidade = comunidade;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setModerador(Moderador moderador) {
		this.moderador = moderador;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void setCategoriaRelato(List<Categoria> categoriaRelato) {
	    this.categoriaRelato = categoriaRelato;
	}
}















