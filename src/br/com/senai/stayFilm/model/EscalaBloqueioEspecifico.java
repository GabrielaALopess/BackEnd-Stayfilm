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
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class EscalaBloqueioEspecifico {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idBloqueioEspecifico;
	
	private int horaInicio;
	private int HoraFim;
	
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private Date data;
	
	@Fetch(FetchMode.SELECT)
	@ManyToOne
	@JoinColumn(name =  "colaborador_id")
	private Colaborador colaborador;
	
	
	

	public Long getIdBloqueioEspecifico() {
		return idBloqueioEspecifico;
	}

	public void setIdBloqueioEspecifico(Long idBloqueioEspecifico) {
		this.idBloqueioEspecifico = idBloqueioEspecifico;
	}

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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	
	
	
}

