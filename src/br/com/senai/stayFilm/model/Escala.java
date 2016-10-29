package br.com.senai.stayFilm.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Escala {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEscala;
	private boolean comparecimento;
	private String observacao;
	private Date dataEscala;
	private Date horaEscala;
	@ManyToOne
	@JoinColumn(name="colaborador_id")
	private Colaborador idColaborador;

	public Long getIdEscala() {
		return idEscala;
	}

	public void setIdEscala(Long idEscala) {
		this.idEscala = idEscala;
	}

	public boolean isComparecimento() {
		return comparecimento;
	}

	public void setComparecimento(boolean comparecimento) {
		this.comparecimento = comparecimento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getDataEscala() {
		return dataEscala;
	}

	public void setDataEscala(Date dataEscala) {
		this.dataEscala = dataEscala;
	}

	public Date getHoraEscala() {
		return horaEscala;
	}

	public void setHoraEscala(Date horaEscala) {
		this.horaEscala = horaEscala;
	}

	public Colaborador getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(Colaborador idColaborador) {
		this.idColaborador = idColaborador;
	}


}
