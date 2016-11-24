package br.com.senai.stayFilm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * PREPARAR A RESPOSTA PARA SALVAR UMA RESPOSTA EM VÁRIOS IDIOMAS , NA MESMA TELA O MOTIVO, INGLES E ESPANHOL
 * 
 * NALISTAGEM MOSTRAR O MOTIVO E A RESPOSTA
 * @author Gustavo
 *
 */
@Entity
public class Resposta {

	public Resposta(){

	}

	public Resposta(String titulo, String respostaBRA,String respostaUSA,String respostaESP){
		setTituloResposta(titulo);
		setRespostaBRA(respostaBRA);
		setRespostaUSA(respostaUSA);
		setRespostaESP(respostaESP);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idResposta;
	private String tituloResposta;

	private String respostaBRA;
	private String respostaUSA;
	private String respostaESP;
	

	public Long getIdResposta() {
		return idResposta;
	}

	public void setIdResposta(Long idResposta) {
		this.idResposta = idResposta;
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

	public String getTituloResposta() {
		return tituloResposta;
	}

	public void setTituloResposta(String tituloResposta) {
		this.tituloResposta = tituloResposta;
	}


}
