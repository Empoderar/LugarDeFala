package br.senac.lugardefala.modelo.entidade.categoria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.relato.Relato;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Long id;

	@Column(name = "nome_categoria", length = 50, nullable = false, unique = true)
	private String nome;

	@Column(name = "cor_categoria", length = 20, nullable = false, unique = true)
	private String cor;

	@OneToOne(mappedBy = "categoria")
	private Comunidade comunidade;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_relato")
	private List<Relato> relato = new ArrayList<Relato>();

	public Categoria() {
	}

	public Categoria(String nome, String cor, Comunidade comunidade) {
		this.nome = nome;
		this.cor = cor;
		this.comunidade = comunidade;
		relato = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Comunidade getComunidade() {
		return comunidade;
	}

	public void setComunidade(Comunidade comunidade) {
		this.comunidade = comunidade;
	}

}