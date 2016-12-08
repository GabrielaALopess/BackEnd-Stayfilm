package br.com.senai.stayFilm.model;

public class RespostaFront {

	String assunto;
	String mensagem;
	
	
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public RespostaFront(){}
	
	RespostaFront(String assunto, String mensagem){
		setAssunto(assunto);
		setMensagem(mensagem);
	}
	

}
