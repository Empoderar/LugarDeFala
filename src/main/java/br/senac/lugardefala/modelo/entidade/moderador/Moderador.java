package br.senac.lugardefala.modelo.entidade.moderador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.conselho.Conselho;
import br.senac.lugardefala.modelo.entidade.contato.Contato;
import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaModerador;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "moderador")
public class Moderador extends Usuario {

    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "moderador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Relato> relatosModerados;

    @OneToMany(mappedBy = "moderador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DenunciaModerador> denunciaDeModerador;

    public Moderador() {
    }

    public Moderador(Long id,String nome, String sobrenome, LocalDate dataNascimento, String apelido, String senha, String descricao) {
        super(id,nome, sobrenome, dataNascimento, apelido, senha, descricao);
        relatosModerados = new ArrayList<>();
        denunciaDeModerador = new ArrayList<>();
    }

    public Moderador(long id, String nome, String sobrenome, LocalDate dataNascimento, String apelido, String senha, String descricao,
            Conselho conselho, Contato contato, Comunidade comunidade) {
        super(id, nome, sobrenome, dataNascimento, apelido, senha,descricao, conselho, contato, comunidade);
        relatosModerados = new ArrayList<>();
        denunciaDeModerador = new ArrayList<>();
    }
    
    public Moderador(Long id,String nome, String sobrenome, String apelido) {
		super(id,nome, sobrenome, apelido);
	}

    public List<DenunciaModerador> getDenunciaDeModerador() {
        return denunciaDeModerador;
    }

    public List<Relato> getRelatosModerados() {
        return relatosModerados;
    }

    public boolean inserirRelatosModerados(Relato relato) {
        return relatosModerados.add(relato);
    }

    public boolean removerRelatoPorId(long id) {
        for (Relato relato : relatosModerados) {
            if (relato.getId().equals(id)) {
                relatosModerados.remove(relato);
                return true;
            }
        }
        return false;
    }

    public boolean inserirDenunciaDeModerador(DenunciaModerador denuncia) {
        return denunciaDeModerador.add(denuncia);
    }

    public boolean removerDenunciaDeModerador(long id) {
        for (DenunciaModerador denuncia : denunciaDeModerador) {
            if (denuncia.getId().equals(id)) {
                denunciaDeModerador.remove(denuncia);
                return true;
            }
        }
        return false;
    }
}