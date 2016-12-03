package br.com.senai.stayFilm.viewModel;


import br.com.senai.stayFilm.model.Resposta;

public class RespostaViewModel {
	
	private String tituloResposta;
	private String respostaBRA;
	private String respostaUSA;
	private String respostaESP;

	
	
	// transforma a view model em model
		public Resposta toResposta(){
			return new Resposta(getTituloResposta(), getRespostaBRA(),getRespostaUSA(),getRespostaESP());
		}
	
	public String getTituloResposta() {
		return tituloResposta;
	}
	public void setTituloResposta(String tituloResposta) {
		this.tituloResposta = tituloResposta;
	}
	
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

	
	
}
