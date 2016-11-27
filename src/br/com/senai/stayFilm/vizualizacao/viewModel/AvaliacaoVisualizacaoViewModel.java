package br.com.senai.stayFilm.vizualizacao.viewModel;

import java.util.Date;

import br.com.senai.stayFilm.enumeration.StatusFilme;
import br.com.senai.stayFilm.model.Avaliacao;
import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.Filme;
import br.com.senai.stayFilm.model.Resposta;

public class AvaliacaoVisualizacaoViewModel {

	public AvaliacaoVisualizacaoViewModel(Avaliacao avaliacao) {
		setDataAvaliacao(avaliacao.getDataAvaliacao());
		setStatus(avaliacao.getStatusFilme());
		setIdResposta(avaliacao.getIdResposta());
		setFilme(avaliacao.getFilme());
	}

	private Date dataAvaliacao;
	private StatusFilme status;
	private Resposta idResposta;
	private Colaborador colaborador;
	private Filme filme;



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

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Date getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

}
