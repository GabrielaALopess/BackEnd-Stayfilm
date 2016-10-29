package br.com.senai.stayFilm.model;

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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAvaliacao;
	private Date data;
	private Date hora;
	private String observacao;
	private StatusAvaliacao status;
	@ManyToOne
	private Resposta idResposta;
	@ManyToOne
	@JoinColumn(name="colaborador_id")
	private Colaborador idColaborador;
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
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
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
	public Colaborador getIdColaborador() {
		return idColaborador;
	}
	public void setIdColaborador(Colaborador idColaborador) {
		this.idColaborador = idColaborador;
	}
}
