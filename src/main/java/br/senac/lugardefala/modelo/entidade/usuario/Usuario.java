package br.senac.lugardefala.modelo.entidade.usuario;

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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import br.senac.lugardefala.modelo.entidade.conselho.Conselho;
import br.senac.lugardefala.modelo.entidade.contato.Contato;
import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaUsuario;
import br.senac.lugardefala.modelo.entidade.relato.Relato;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;

	@Column(name = "nome_Usuario", length = 50, nullable = false, unique = true)
	private String nome;

	@Column(name = "sobrenome_Usuario", length = 50, nullable = false, unique = true)
	private String sobrenome;

	@Column(name = "data_nascimento_usuario", nullable = false, unique = false)
	private LocalDate dataNascimento;

	@Column(name = "usuario_usuario", length = 25, nullable = false, unique = false)
	private String usuario;

	@Column(name = "senha_usuario", length = 20, nullable = false, unique = false)
	private String senha;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Conselho> conselhos;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contato_id_contato")
	private Contato contato;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DenunciaUsuario> denunciasDeUsuario;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Relato> relatos;

	public Usuario() {
	}

	public Usuario(long id, String nome, String sobrenome, LocalDate dataNascimento, String usuario, String senha, String telefone, String email, Contato contato) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.usuario = usuario;
		this.senha = senha;
		this.contato = contato;
		denunciasDeUsuario = new ArrayList<>();
		relatos = new ArrayList<>();
		conselhos = new ArrayList<>();
	}

	public boolean inserirDenunciaDeUsuario(DenunciaUsuario denuncia) {
        return denunciasDeUsuario.add(denuncia);
    }

    public boolean removerDenunciaRelato(long id){ 
        for (DenunciaUsuario denuncia : denunciasDeUsuario) {
			if (denuncia.getId().equals(id)) {
				denunciasDeUsuario.remove(denuncia);
				return true;
			}
		}

		return false;
    }

	public boolean inserirRelatos(Relato relato) {
        return relatos.add(relato);
    }

    public boolean removerRelatos(long id){ 
        for (Relato relato : relatos) {
			if (relato.getId().equals(id)) {
				relatos.remove(relato);
				return true;
			}
		}

		return false;
    }

	public boolean inserirConselhos(Conselho conselho) {
        return conselhos.add(conselho);
    }

    public boolean removerConselhos(long id){ 
        for (Conselho conselho : conselhos) {
			if (conselho.getId().equals(id)) {
				conselhos.remove(conselho);
				return true;
			}
		}

		return false;
    }

	public List<Conselho> getConselho() {
		return conselhos;
	}

	public Contato getContato() {
		return contato;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public List<DenunciaUsuario> getDenunciaDeUsuario() {
		return denunciasDeUsuario;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public List<Relato> getRelato() {
		return relatos;
	}

	public String getSenha() {
		return senha;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	

}
