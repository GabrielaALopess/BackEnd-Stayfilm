package br.com.senai.stayFilm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.senai.stayFilm.enumeration.Idioma;

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
	
	public Resposta(String titulo, String resposta, Idioma idioma){
		setTituloResposta(titulo);
		setIdioma(idioma);
		setResposta(resposta);
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idResposta;
	@Column
	private String tituloResposta;
	@Column
	private String resposta;
	@Column
	private Idioma idioma;

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public String getTituloResposta() {
		return tituloResposta;
	}

	public void setTituloResposta(String tituloResposta) {
		this.tituloResposta = tituloResposta;
	}

	public Long getIdResposta() {
		return idResposta;
	}

	public void setIdResposta(Long idResposta) {
		this.idResposta = idResposta;
	}

}
