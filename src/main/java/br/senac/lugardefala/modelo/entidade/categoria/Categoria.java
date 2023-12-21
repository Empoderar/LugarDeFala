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
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

	@OneToMany(cascade = CascadeType.ALL)
	private List<Relato> relatos;

	public Categoria() {
	}

	public Categoria(long id, String nome) {
		this.id = id;
		this.nome = nome;
		relatos = new ArrayList<>();
	}

	public boolean inserirRelato(Relato relato) {
        return relatos.add(relato);
    }

    public boolean removerRelato(long id){ 
        for (Relato relato : relatos) {
			if (relato.getId().equals(id)) {
				relatos.remove(relato);
				return true;
			}
		}

		return false;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Relato> getRelatos() {
		return relatos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}