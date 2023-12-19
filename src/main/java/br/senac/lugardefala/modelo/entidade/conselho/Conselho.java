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

    @Column(name = "avaliacao_conselho", nullable = false)
    private Integer avaliacaoBoa;  

    @Column(name = "avaliacao_conselho", nullable = false)
    private Integer avaliacaoRuim;  
    
    @Column(name = "data_conselho", nullable = false)
    private LocalDate data;

    @Column(name = "resposta_conselho", nullable = true)
    private Conselho conselhoResposta;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_relato")
    private Relato relato;
    
    public Conselho(){}

    public Conselho(String conteudo, LocalDate data, Usuario usuario, int avaliacaoBoa,int avaliacaoRuim, Relato relato, Conselho conselhoResposta) {
		this.conteudo = conteudo;
		this.data = data;
		this.usuario = usuario;
		this.avaliacaoBoa = avaliacaoBoa;
		this.avaliacaoRuim = avaliacaoRuim;
		this.relato = relato;
		this.conselhoResposta = conselhoResposta;
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

	public Conselho getConselhoResposta() {
		return conselhoResposta;
	}

	public void setConselhoResposta(Conselho conselhoResposta) {
		this.conselhoResposta = conselhoResposta;
	}

}