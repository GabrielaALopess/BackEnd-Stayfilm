package br.com.senai.stayFilm.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Avaliacao {

	public Avaliacao() {
	}

	public Avaliacao(Date data, Time hora, String observacao, Boolean statusFilme,
			Colaborador idColaborador) {
		this.dataAvaliacao = data;
		this.observacao = observacao;
		this.statusReport = statusFilme;
		this.setColaborador(colaborador);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAvaliacao;
	
	private Date dataAvaliacao;

	private String observacao;
	
	/**
	 * TRATA SE O FILME FOI FEITO OU NÃO
	 */
	private Boolean statusReport;
	
	@ManyToOne
	@JoinColumn(name = "filme_id")
	private Filme filme;
	
	@ManyToOne
	private Resposta idResposta;
	
	@ManyToOne
	@JoinColumn(name = "colaborador_id")
	private Colaborador colaborador;

	
	
	
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


	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Boolean isStatusReport() {
		return statusReport;
	}

	public void setStatusReport(Boolean statusReport) {
		this.statusReport = statusReport;
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

}
