package br.com.senai.stayFilm.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.senai.stayFilm.enumeration.Status;

@Entity
public class Curadoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCuradoria;
	
	@OneToOne(orphanRemoval = true)
	private Colaborador idColaborador;

	@OneToOne(orphanRemoval = true)
	private Usuario idUsuario;

	private Date dataCuradoria;

	public Long getIdCuradoria() {
		return idCuradoria;
	}

	public void setIdCuradoria(Long idCuradoria) {
		this.idCuradoria = idCuradoria;
	}

	public Colaborador getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(Colaborador idColaborador) {
		this.idColaborador = idColaborador;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getDataCuradoria() {
		return dataCuradoria;
	}

	public void setDataCuradoria(Date dataCuradoria) {
		this.dataCuradoria = dataCuradoria;
	}

	public Status getStatusCuradoria() {
		return statusCuradoria;
	}

	public void setStatusCuradoria(Status statusCuradoria) {
		this.statusCuradoria = statusCuradoria;
	}

	private Status statusCuradoria;

}
