package br.senac.modelo.entidade.comunidade;
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
import javax.persistence.Table;

import br.senac.modelo.entidade.conselho.Conselho;
import br.senac.modelo.entidade.moderador.Moderador;
import br.senac.modelo.entidade.relato.Relato;
import br.senac.modelo.entidade.usuario.Usuario;

@Entity
@Table(name = "Comunidade")
public class Comunidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Comunidade")
	private Long id;

	@Column(name = "nome_comunidade", length = 50, nullable = false, unique = true)
	private String nome;

	@Column(name = "descricao_comunidade", length = 500, nullable = false, unique = true)
	private String descricao;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_conselho")
	private Conselho conselho;

	@OneToMany(mappedBy = "Comunidade", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Relato> listaRelatos = new ArrayList<Relato>();

	@OneToMany(mappedBy = "Comunidade", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Moderador> listaModeradores = new ArrayList<Moderador>();

	public Comunidade() {
	}

	public Comunidade(String nome, String descricao, Usuario usuario, Conselho conselho) {
		this.nome = nome;
		this.descricao = descricao;
		listaRelatos = new ArrayList<>();
		listaModeradores = new ArrayList<>();
		this.usuario = usuario;
		this.conselho = conselho;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Conselho getConselho() {
		return conselho;
	}

	public void setConselho(Conselho conselho) {
		this.conselho = conselho;
	}
}
