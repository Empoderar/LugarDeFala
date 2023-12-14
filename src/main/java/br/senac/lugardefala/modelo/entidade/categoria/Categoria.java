package br.senac.lugardefala.modelo.entidade.categoria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.relato.Relato;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
	@Entity
	@Table(name = "categoria")
	public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id;

    @Column(name = "nome_categoria", length = 50, nullable = false, unique = true)
    private String nome;

    @Column(name = "cor_categoria", length = 20, nullable = false, unique = true)
    private String cor;

    @OneToMany(mappedBy = "categoria")
    private List<Comunidade> listaComunidade = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_relato")
    private Relato relato;

    public Categoria() {}

    public Categoria(String nome, String cor, Relato relato) {
        this.nome = nome;
        this.cor = cor;
        this.listaComunidade = new ArrayList<>();
        this.relato = relato;
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

	public Relato getRelato() {
		return relato;
	}

	public void setRelato(Relato relato) {
		this.relato = relato;
	}
}