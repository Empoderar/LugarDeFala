package br.senac.lugardefala.modelo.entidade.contato;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

@Entity
@Table(name = "contato")
public class Contato implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contato")
    private Long id;

    @Column(name = "telefone_contato", length = 20, nullable = true, unique = true)
    private String telefone;

    @Column(name = "email_contato", length = 40, nullable = true, unique = true)
    private String email;
    
    @OneToOne(fetch = FetchType.LAZY)
    private Usuario usuario;
    


    @ManyToMany(mappedBy = "contatos")
    private List<Usuario> usuarios;
    
    public Contato() {

    }

    public Contato(String telefone, String email) {
        this.telefone = telefone;
        this.email = email;
    }

    public Contato(long id, String telefone, String email, Usuario usuario) {
        this.id = id;
        this.telefone = telefone;
        this.email = email;
        usuarios = new ArrayList<>();
        this.usuario = usuario;
    }
    
    public Contato(String telefone, String email, Usuario usuario) {
        this.telefone = telefone;
        this.email = email;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}