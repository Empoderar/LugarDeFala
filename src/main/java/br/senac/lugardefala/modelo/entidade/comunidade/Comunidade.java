package br.senac.lugardefala.modelo.entidade.comunidade;
import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.lugardefala.modelo.entidade.categoria.Categoria;
import br.senac.lugardefala.modelo.entidade.conselho.Conselho;
import br.senac.lugardefala.modelo.entidade.moderador.Moderador;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

@Entity
@Table(name = "comunidade")
public class Comunidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_comunidade")
	private Long id;

	@Column(name = "nome_comunidade", length = 50, nullable = false, unique = true)
	private String nome;

	@Column(name = "descricao_comunidade", length = 500, nullable = false, unique = true)
	private String descricao;

	@OneToMany(mappedBy = "comunidade", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Usuario> usuario = new ArrayList<Usuario>();

	@OneToMany(mappedBy = "comunidade", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Conselho> conselhos = new ArrayList<Conselho>();

	@OneToMany(mappedBy = "comunidade", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Relato> relatos = new ArrayList<Relato>();

	@OneToMany(mappedBy = "comunidade", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Moderador> moderador = new ArrayList<Moderador>();
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

	public Comunidade() {
	}

	public Comunidade(String nome, String descricao, Categoria categoria) {
		this.nome = nome;
		this.descricao = descricao;
		relatos = new ArrayList<>();
		moderador = new ArrayList<>();
		usuario = new ArrayList<>();
		conselhos = new ArrayList<>();
		this.categoria = categoria;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public String getNome() {
		return nome;
	}

	public void inserirListaRelato() {

	}

	public void removerListaRelato() {

	}

	public void inserirlistaModeradores() {

	}

	public void removerlistaModeradores() {

	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
