package br.com.senai.stayFilm.vizualizacao.viewModel;

import br.com.senai.stayFilm.model.Resposta;

public class RespostaVisualizacaoViewModel {
	
	public RespostaVisualizacaoViewModel(Resposta resposta){
		setTituloResposta(resposta.getTituloResposta());
		setRespostaBRA(resposta.getRespostaBRA());
		setRespostaUSA(resposta.getRespostaUSA());
		setRespostaESP(resposta.getRespostaESP());
	}

	
	private String tituloResposta;
	private String respostaBRA;
	private String respostaUSA;
	private String respostaESP;
	

	public String getRespostaBRA() {
		return respostaBRA;
	}

	public void setRespostaBRA(String respostaBRA) {
		this.respostaBRA = respostaBRA;
	}

	public String getRespostaUSA() {
		return respostaUSA;
	}

	public void setRespostaUSA(String respostaUSA) {
		this.respostaUSA = respostaUSA;
	}

	public String getRespostaESP() {
		return respostaESP;
	}

	public void setRespostaESP(String respostaESP) {
		this.respostaESP = respostaESP;
	}

	public String getTituloResposta() {
		return tituloResposta;
	}

	public void setTituloResposta(String tituloResposta) {
		this.tituloResposta = tituloResposta;
	}

	
}
