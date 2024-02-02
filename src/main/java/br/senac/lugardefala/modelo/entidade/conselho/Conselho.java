package br.senac.lugardefala.modelo.entidade.conselho;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

@Entity
@Table(name = "conselho")
public class Conselho implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conselho")
    private Long id;

    @Column(name = "conteudo_conselho", length = 200, nullable = false)
    private String conteudo;

    @Column(name = "avaliacaoBoa_conselho", nullable = false)
    private Integer avaliacaoBoa;  

    @Column(name = "avaliacaoRuim_conselho", nullable = false)
    private Integer avaliacaoRuim;  
    
    @Column(name = "data_conselho", nullable = true)
    private LocalDate data;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_relato")
    private Relato relato;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_comunidade")
    private Comunidade comunidade;
    
    public Conselho(){}
    

	public Conselho(String conteudo) {
		this.conteudo = conteudo;
		
	
	}

	public Conselho(long id, String conteudo, int avaliacaoBoa,int avaliacaoRuim, LocalDate data) {
		this.id = id;
		this.conteudo = conteudo;
		this.avaliacaoBoa = avaliacaoBoa;
		this.avaliacaoRuim = avaliacaoRuim;
		this.data = data;
	
	}


	public Conselho(long id, String conteudo, int avaliacaoBoa, int avaliacaoRuim, LocalDate data, Usuario usuario, Relato relato, Comunidade comunidade) {
		this.id = id;
		this.conteudo = conteudo;
		this.avaliacaoBoa = avaliacaoBoa;
		this.avaliacaoRuim = avaliacaoRuim;
		this.data = data;
		this.usuario = usuario;
		this.relato = relato;
		this.comunidade = comunidade;
	}

	public Long getId() {
		return id;
	}

	public int getAvaliacaoBoa() {
		return avaliacaoBoa;
	}

	public int getAvaliacaoRuim() {
		return avaliacaoRuim;
	}
	
	public String getConteudo() {
		return conteudo;
	}

	public LocalDate getData() {
		return data;
	}

	public Relato getRelato() {
		return relato;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAvaliacaoBoa(int avaliacaoBoa) {
		this.avaliacaoBoa = avaliacaoBoa;
	}

	public void setAvaliacaoRuim(int avaliacaoRuim) {
		this.avaliacaoRuim = avaliacaoRuim;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public void setRelato(Relato relato) {
		this.relato = relato;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
		
	}
	
	public Comunidade getComunidade() {
		return comunidade;
	}
	
	public void setComunidade(Comunidade comunidade) {
		this.comunidade = comunidade;
	}

}