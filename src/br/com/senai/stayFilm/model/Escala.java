package br.com.senai.stayFilm.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Escala {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEscala;
	private boolean comparecimento;
	private String observacao;
	
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date dataEscala;
	
	private int horaEscalaInicio;
	private int horaEscalaFim;
	
	@Fetch(FetchMode.SELECT)
	@ManyToOne
	@JoinColumn(name = "colaborador_id")
	private Colaborador colaborador;

	
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

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public int getHoraEscalaInicio() {
		return horaEscalaInicio;
	}

	public void setHoraEscalaInicio(int horaEscalaInicio) {
		this.horaEscalaInicio = horaEscalaInicio;
	}

	public int getHoraEscalaFim() {
		return horaEscalaFim;
	}

	public void setHoraEscalaFim(int horaEscalaFim) {
		this.horaEscalaFim = horaEscalaFim;
	}

	

}
