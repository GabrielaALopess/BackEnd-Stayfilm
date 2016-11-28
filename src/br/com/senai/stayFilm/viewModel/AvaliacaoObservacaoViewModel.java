package br.com.senai.stayFilm.viewModel;

import br.com.senai.stayFilm.model.Avaliacao;
import br.com.senai.stayFilm.model.AvaliacaoObservacao;

public class AvaliacaoObservacaoViewModel {
	
	private String observacao;
	private Avaliacao avaliacao;
	
	public AvaliacaoObservacao toAvaliacaoObservacao(){
		return new AvaliacaoObservacao(getObservacao(), getAvaliacao());	
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
