package br.com.senai.stayFilm.vizualizacao.viewModel;

import java.sql.Time;
import java.util.Date;

import br.com.senai.stayFilm.enumeration.StatusFilme;
import br.com.senai.stayFilm.model.Avaliacao;
import br.com.senai.stayFilm.model.Resposta;

public class AvaliacaoVisualizacaoViewModel {
	
	public AvaliacaoVisualizacaoViewModel(Avaliacao avaliacao){
		
		setIdResposta(avaliacao.getIdResposta());
	}

	private Date data;
	private Time hora;
	private String observacao;
	private StatusFilme status;
	private Resposta idResposta;

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

	public StatusFilme getStatus() {
		return status;
	}

	public void setStatus(StatusFilme status) {
		this.status = status;
	}

	public Resposta getIdResposta() {
		return idResposta;
	}

	public void setIdResposta(Resposta idResposta) {
		this.idResposta = idResposta;
	}

}
