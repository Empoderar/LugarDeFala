package br.senac.lugardefala.modelo.entidade.denuncia;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.senac.lugardefala.modelo.entidade.conselho.Conselho;
import br.senac.lugardefala.modelo.enumeracao.Status;

@Entity
@Table(name = "denunciaCaonselho")
public class DenunciaConselho extends Denuncia implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_conselho")
	private Conselho denunciaDeConselho;

	public DenunciaConselho(Conselho denunciaDeConselho, LocalDate data, String motivo, Status status) {
		super(data, motivo, status);
		this.denunciaDeConselho = denunciaDeConselho;
	}

	public Conselho getDenunciaDeconselho() {
		return denunciaDeConselho;
	}

	public void setDenunciaDeConselho(Conselho denunciaDeConselho) {
		this.denunciaDeConselho = denunciaDeConselho;
	}

}
