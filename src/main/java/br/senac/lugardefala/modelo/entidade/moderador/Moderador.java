package br.senac.lugardefala.modelo.entidade.moderador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "comunidade_moderador",joinColumns = @JoinColumn(name = "id_moderador"),
            inverseJoinColumns = @JoinColumn(name = "id_comunidade")
    )
    private List<Comunidade> comunidades;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "moderador_usuario",joinColumns = @JoinColumn(name = "id_moderador"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario")
    )
    private List<Usuario> usuarios;

    public Moderador() {
    }
    
    public Moderador(Long id, String nome, String sobrenome, LocalDate dataNascimento, String apelido, String senha, String descricao) {
        super(id, nome, sobrenome, dataNascimento, apelido, senha, descricao);
    }
    
    public Moderador(String nome, String sobrenome, LocalDate dataNascimento, String apelido, String senha, String descricao) {
        super(nome, sobrenome, dataNascimento, apelido, senha, descricao);
    }
    
    
    public Moderador(String nome, String sobrenome, LocalDate dataNascimento, String apelido, String senha) {
        super(nome, sobrenome, dataNascimento, apelido, senha);
    }

    public Moderador(long id, String nome, String sobrenome, LocalDate dataNascimento, String apelido, String senha, String descricao,
            Conselho conselho, Contato contato, Comunidade comunidade) {
        super(id, nome, sobrenome, dataNascimento, apelido, senha,descricao, conselho, contato, comunidade);
        relatosModerados = new ArrayList<>();
        denunciaDeModerador = new ArrayList<>();
        comunidades = new ArrayList<>();
        this.comunidades.add(comunidade);
    }
    
    public Moderador(String nome, String sobrenome, String apelido) {
		super(nome, sobrenome, apelido);
	}

    public List<DenunciaModerador> getDenunciaDeModerador() {
        return denunciaDeModerador;
    }

    public List<Relato> getRelatosModerados() {
        return relatosModerados;
    }
    
    public List<Usuario> getUsuarios(){
    	return usuarios;
    }
    
    public void setUsuarios(List<Usuario> usuarios) {
    	this.usuarios = usuarios;
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
    
    public List <Comunidade> getModeradores(){
    	return comunidades;
    }
    public void setModeradores(List <Comunidade> comunidades) {
    	this.comunidades = comunidades;
    }
    
    public boolean adicionarComunidade(Comunidade comunidade) {
        return comunidades.add(comunidade);
    }

    public boolean removerComunidade(Comunidade comunidade) {
        return comunidades.remove(comunidade);
    }
  
}