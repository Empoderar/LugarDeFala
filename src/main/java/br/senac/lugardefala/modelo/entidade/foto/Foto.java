package br.senac.lugardefala.modelo.entidade.foto;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Lob;

import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "foto")
public class Foto{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne(mappedBy = "foto")
    private Usuario usuario;
    
    @Lob
    @Column(name = "binario_foto", nullable = false)
    private byte[] binario;

    @Column(name = "caminho_foto", nullable = false)
    private String caminho;

    public Foto() {
    }


    public Foto(String caminho, byte[] binario) {
    	setCaminho(caminho);
    	setBinario(binario);
    }

    public Foto(Long id,String caminho, byte[] binario) {
    	setId(id);
    	setCaminho(caminho);
    	setBinario(binario);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public byte[] getBinario() {
    	return binario;
    }


    public void setBinario(byte[] binario) {
    	this.binario = binario;
    }

}
