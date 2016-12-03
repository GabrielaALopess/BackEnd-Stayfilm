package br.com.senai.stayFilm.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class AvaliacaoObservacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAvaliacaoObservacao;
	private String observacao;
	@ManyToOne
	private Avaliacao avaliacao;
	
	public AvaliacaoObservacao(String observacao, Avaliacao avaliacao) {
		this.observacao = observacao;
		this.avaliacao = avaliacao;
	}
	
	public Long getIdAvaliacaoObservacao() {
		return idAvaliacaoObservacao;
	}
	public void setIdAvaliacaoObservacao(Long idAvaliacaoObservacao) {
		this.idAvaliacaoObservacao = idAvaliacaoObservacao;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Avaliacao getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	
}
