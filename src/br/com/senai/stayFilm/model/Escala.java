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

	public Escala() {

	}

	public Escala(boolean comparecimento, String observacao, Date dataEscala, Date horaEscalaInicio, Date horaEscalaFim,
			Colaborador idColaborador) {
		setComparecimento(comparecimento);
		setObservacao(observacao);
		setDataEscala(dataEscala);
		setHoraEscalaInicio(horaEscalaInicio);
		setHoraEscalaFim(horaEscalaFim);
		setIdColaborador(idColaborador);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEscala;
	private boolean comparecimento;
	private String observacao;
	private Date dataEscala;
	private Date horaEscalaInicio;
	private Date horaEscalaFim;
	@ManyToOne
	@JoinColumn(name = "colaborador_id")
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

	public Colaborador getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(Colaborador idColaborador) {
		this.idColaborador = idColaborador;
	}

	public Date getHoraEscalaInicio() {
		return horaEscalaInicio;
	}

	public void setHoraEscalaInicio(Date horaEscalaInicio) {
		this.horaEscalaInicio = horaEscalaInicio;
	}

	public Date getHoraEscalaFim() {
		return horaEscalaFim;
	}

	public void setHoraEscalaFim(Date horaEscalaFim) {
		this.horaEscalaFim = horaEscalaFim;
	}

}
