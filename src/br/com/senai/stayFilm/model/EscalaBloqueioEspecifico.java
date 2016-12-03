package br.com.senai.stayFilm.model;

import java.util.Date;

import javax.persistence.Column;
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
public class EscalaBloqueioEspecifico {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idBloqueioEspecifico;
	
	private int horaInicio;
	
	private int horaFim;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name="dataEspecifica")
	private Date data;
	
	@Fetch(FetchMode.SELECT)
	@ManyToOne
	@JoinColumn(name="colaboradorId")
	private Colaborador colaboradorId;
	
	
	

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
		return horaFim;
	}

	public void setHoraFim(int horaFim) {
		this.horaFim = horaFim;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Colaborador getColaboradorId() {
		return colaboradorId;
	}

	public void setColaboradorId(Colaborador colaboradorId) {
		this.colaboradorId = colaboradorId;
	}

	


	
	
	
}

