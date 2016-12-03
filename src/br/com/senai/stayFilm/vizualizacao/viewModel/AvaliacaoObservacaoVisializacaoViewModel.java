package br.com.senai.stayFilm.vizualizacao.viewModel;

import br.com.senai.stayFilm.model.Avaliacao;
import br.com.senai.stayFilm.model.AvaliacaoObservacao;

public class AvaliacaoObservacaoVisializacaoViewModel {

	private String observacao;
	private Avaliacao avaliacao;

	public AvaliacaoObservacaoVisializacaoViewModel(AvaliacaoObservacao avaliacaoObservacao) {
		setObservacao(avaliacaoObservacao.getObservacao());
		setAvaliacao(avaliacaoObservacao.getAvaliacao());
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
