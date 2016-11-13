package br.com.senai.stayFilm.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.senai.stayFilm.enumeration.DiaSemana;


@Entity
public class EscalaBloqueioFixo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idBloqueiofixo;
	private Date horaInicio;
	private Date HoraFim;
	
	@Enumerated(EnumType.ORDINAL)
	private DiaSemana diaSemana;
	
	@Fetch(FetchMode.SELECT)
	@ManyToOne
	@JoinColumn(name =  "colaborador_id")
	private Colaborador colaborador;


	public Date getHoraInicio() {
		return horaInicio;
	}


	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}


	public Date getHoraFim() {
		return HoraFim;
	}


	public void setHoraFim(Date horaFim) {
		HoraFim = horaFim;
	}


	public DiaSemana getDiaSemana() {
		return diaSemana;
	}


	public void setDiaSemana(DiaSemana diaSemana) {
		this.diaSemana = diaSemana;
	}


	public Colaborador getColaborador() {
		return colaborador;
	}


	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}


	public Long getIdBloqueiofixo() {
		return idBloqueiofixo;
	}


	public void setIdBloqueiofixo(Long idBloqueiofixo) {
		this.idBloqueiofixo = idBloqueiofixo;
	}
	
	
	
	
	
}
