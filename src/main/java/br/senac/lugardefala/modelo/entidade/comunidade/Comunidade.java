package br.senac.lugardefala.modelo.entidade.comunidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	private List<Relato> relatos;

	@OneToMany(mappedBy = "comunidade", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Moderador> moderadores;

	@OneToMany(mappedBy = "comunidade", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Usuario> usuarios;

	public Comunidade() {
	}

	public Comunidade(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;

	}

	public Comunidade(long id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		relatos = new ArrayList<>();
		moderadores = new ArrayList<>();
		usuarios = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public List<Moderador> getModeradores() {
		return moderadores;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public List<Relato> getRelatos() {
		return relatos;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public boolean inserirListaRelato(Relato relato) {
		return relatos.add(relato);
	}

	public boolean removerListaRelatoPorId(long id) {
		for (Relato relato : relatos) {
			if (relato.getId().equals(id)) {
				relatos.remove(relato);
				return true;
			}
		}
		return false;
	}

	public boolean inserirlistaModeradores(Moderador moderador) {
		return moderadores.add(moderador);
	}

	public boolean removerListaModeradoresPorNome(long id) {
		for (Usuario moderador : moderadores) {
			if (moderador.getId().equals(id)) {
				moderadores.remove(moderador);
				return true;
			}
		}
		return false;
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