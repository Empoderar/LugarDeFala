package br.senac.lugardefala.modelo.entidade.moderador;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import br.senac.lugardefala.modelo.entidade.contato.Contato;
import br.senac.lugardefala.modelo.entidade.denuncia.Denuncia;
import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaModerador;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

@Entity
@Table(name = "moderador")
public class Moderador extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "moderador", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Relato> relatosModerados = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	private List<Denuncia> denunciasModeradas;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "denunciaDeModerador")
	private List<DenunciaModerador> denunciasDeModerador;

	public Moderador() {
	}

	public Moderador(String nome, String sobrenome, LocalDate dataNascimento, String user, String senha,
			String telefone, String email, Contato contato,
			Denuncia denuncia) {
		super(nome, sobrenome, dataNascimento, user, senha, telefone, email, contato);
		denunciasModeradas = new ArrayList<>();
		relatosModerados = new ArrayList<>();
		denunciasDeModerador = new ArrayList<>();
	}



	public void inserirDenuncia(Denuncia denunciasModeradas) {

	}

	public void excluirDenuncia(Denuncia denunciasModeradas) {

	}

	public void inserirRelato(Relato relato) {

	}

	public void excluirRelato(Relato relato) {

	}

	public void editarRelato(Relato relato) {

	}

}
