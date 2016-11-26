package br.com.senai.stayFilm.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.senai.stayFilm.enumeration.StatusFilme;

@Entity
public class Avaliacao {

	public Avaliacao() {
	}

	public Avaliacao(Date data, Time hora, StatusFilme statusFilme, Colaborador idColaborador) {
		this.dataAvaliacao = data;
		this.statusFilme = statusFilme;
		this.setColaborador(colaborador);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAvaliacao;

	private Date dataAvaliacao;


	@ManyToOne
	@JoinColumn(name = "filme_id")
	private Filme filme;
	@ManyToOne
	private Resposta idResposta;
	@ManyToOne
	@JoinColumn(name = "colaborador_id")
	private Colaborador colaborador;

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

	public Date getData() {
		return dataAvaliacao;
	}

	public void setData(Date data) {
		this.dataAvaliacao = data;
	}

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

}
