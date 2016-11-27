package br.com.senai.stayFilm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.senai.stayFilm.enumeration.StatusFilme;

@Entity
public class Avaliacao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1646271575033390240L;

	public Avaliacao() {
	}

	public Avaliacao(Date dataAvaliacao,StatusFilme statusFilme, Resposta idResposta,Filme idFilme) {
		this.setDataAvaliacao(dataAvaliacao);
		this.statusFilme = statusFilme;
		this.setIdResposta(idResposta);
		this.setFilme(filme);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAvaliacao;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dataAvaliacao;


	@ManyToOne
	@JoinColumn(name = "filme_id")
	private Filme filme;
	@ManyToOne
	private Resposta idResposta;
	
	

	/**
	 * se o filme esta em monitoria, aprovado , etc.S
	 */
	private StatusFilme statusFilme;

	public Long getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(Long idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public Resposta getIdResposta() {
		return idResposta;
	}

	public void setIdResposta(Resposta idResposta) {
		this.idResposta = idResposta;
	}

	public StatusFilme getStatusFilme() {
		return statusFilme;
	}

	public void setStatusFilme(StatusFilme statusFilme) {
		this.statusFilme = statusFilme;
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
