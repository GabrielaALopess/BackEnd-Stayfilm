package br.com.senai.stayFilm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.senai.stayFilm.enumeration.TipoTelefone;

@Entity
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTelefone;
	private TipoTelefone tipoTelefone;
	private String numero;

	@ManyToOne
	@JoinColumn(name = "colaborador_id")
	private Colaborador idColaborador;

	public Long getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(Long idTelefone) {
		this.idTelefone = idTelefone;
	}

	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Colaborador getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(Colaborador idColaborador) {
		this.idColaborador = idColaborador;
	}

}
