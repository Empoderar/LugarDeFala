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

import br.senac.lugardefala.modelo.entidade.relato.Relato;

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

	public Comunidade() {
	}

	public Comunidade(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
		relatos = new ArrayList<>();
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
