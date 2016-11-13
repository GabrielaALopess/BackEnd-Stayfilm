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


@Entity
public class EscalaBloqueioEspecifico {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idBloqueioEspecifico;
	
	private Date horaInicio;
	private Date HoraFim;
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

