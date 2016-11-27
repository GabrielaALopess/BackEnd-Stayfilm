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
		setStatusfilme(avaliacao.getStatusFilme());
		setIdResposta(avaliacao.getIdResposta());
		setIdFilme(avaliacao.getIdFilme());
	}

	private Date dataAvaliacao;
	private StatusFilme statusfilme;
	private Resposta idResposta;
	private Colaborador colaborador;
	private Filme idFilme;

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

	public Date getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	public StatusFilme getStatusfilme() {
		return statusfilme;
	}

	public void setStatusfilme(StatusFilme statusfilme) {
		this.statusfilme = statusfilme;
	}

	public Filme getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(Filme idFilme) {
		this.idFilme = idFilme;
	}

}
