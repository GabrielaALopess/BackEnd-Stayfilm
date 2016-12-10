package br.com.senai.stayFilm.model;

import javax.persistence.Entity;
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
	private int horaInicio;
	private int HoraFim;
	
	private DiaSemana diaSemana;
	
	@Fetch(FetchMode.SELECT)
	@ManyToOne
	@JoinColumn(name =  "colaborador_id")
	private Colaborador colaborador;


	public int getHoraInicio() {
		return horaInicio;
	}


	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}


	public int getHoraFim() {
		return HoraFim;
	}


	public void setHoraFim(int horaFim) {
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
