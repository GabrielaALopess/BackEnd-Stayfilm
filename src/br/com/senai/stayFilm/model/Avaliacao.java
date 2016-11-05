package br.com.senai.stayFilm.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.senai.stayFilm.enumeration.StatusAvaliacao;

@Entity
public class Avaliacao {

	public Avaliacao() {
	}

	public Avaliacao(Date data, Time hora, String observacao, StatusAvaliacao status, Colaborador idColaborador) {
		this.data = data;
		this.hora = hora;
		this.observacao = observacao;
		this.status = status;
		this.setColaborador(colaborador);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAvaliacao;
	private Date data;
	private Time hora;
	private String observacao;
	private StatusAvaliacao status;
	@ManyToOne
	private Resposta idResposta;
	@ManyToOne
	@JoinColumn(name = "colaborador_id")
	private Colaborador colaborador;

	public Long getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(Long idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public StatusAvaliacao getStatus() {
		return status;
	}

	public void setStatus(StatusAvaliacao status) {
		this.status = status;
	}

	public Resposta getIdResposta() {
		return idResposta;
	}

	public void setIdResposta(Resposta idResposta) {
		this.idResposta = idResposta;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

}
