package br.com.senai.stayFilm.controller.ViewModel.Resposta;

import br.com.senai.stayFilm.enumeration.Idioma;
import br.com.senai.stayFilm.model.Resposta;

public class VisualizacaoViewModel {
	
	public VisualizacaoViewModel(Resposta resposta){
		setTituloResposta(resposta.getTituloResposta());
		setIdioma(resposta.getIdioma());
		setResposta(resposta.getResposta());
	}

	private String tituloResposta;
	private String resposta;
	private Idioma idioma;
	
	public String getTituloResposta() {
		return tituloResposta;
	}
	public void setTituloResposta(String tituloResposta) {
		this.tituloResposta = tituloResposta;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	public Idioma getIdioma() {
		return idioma;
	}
	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}
	
}
