package br.com.senai.stayFilm.visualizacaoViewModel;

import java.util.Date;

import br.com.senai.stayFilm.enumeration.StatusAvaliacao;
import br.com.senai.stayFilm.model.Avaliacao;
import br.com.senai.stayFilm.model.Resposta;

public class AvaliacaoVisualizacaoViewModel {
	
	public AvaliacaoVisualizacaoViewModel(Avaliacao avaliacao){
		setData(avaliacao.getData());
		setHora(avaliacao.getHora());
		setObservacao(avaliacao.getObservacao());
		setStatus(avaliacao.getStatus());
		setIdResposta(avaliacao.getIdResposta());
	}

	private Date data;
	private Date hora;
	private String observacao;
	private StatusAvaliacao status;
	private Resposta idResposta;

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

}
