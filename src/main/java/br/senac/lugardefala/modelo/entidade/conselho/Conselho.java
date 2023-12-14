package br.senac.lugardefala.modelo.entidade.conselho;

import java.time.LocalDate;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import br.senac.lugardefala.modelo.entidade.denuncia.Denuncia;
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
    private Integer avaliacao;  

    @Column(name = "data_conselho", nullable = false)
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_relato")
    private Relato relato;

    @ManyToOne
    @JoinColumn(name = "id_denuncia")
    private Denuncia denuncia;

    public Conselho(){}

    public Conselho(String conteudo, LocalDate data, Usuario usuario, int avaliacao, Relato relato,
			Denuncia denuncia) {

		this.conteudo = conteudo;
		this.data = data;
		this.usuario = usuario;
		this.avaliacao = avaliacao;
		this.relato = relato;
		this.denuncia = denuncia;
	}

	public int getAvaliacao() {
		return avaliacao;
	}

	public String getConteudo() {
		return conteudo;
	}

	public LocalDate getData() {
		return data;
	}

	public Denuncia getDenuncia() {
		return denuncia;
	}

	public Relato getRelato() {
		return relato;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public void setDenuncia(Denuncia denuncia) {
		this.denuncia = denuncia;
	}

	public void setRelato(Relato relato) {
		this.relato = relato;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}