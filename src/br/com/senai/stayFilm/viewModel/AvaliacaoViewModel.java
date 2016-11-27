package br.com.senai.stayFilm.viewModel;

import java.util.Date;

import br.com.senai.stayFilm.enumeration.StatusFilme;
import br.com.senai.stayFilm.model.Avaliacao;
import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.Filme;
import br.com.senai.stayFilm.model.Resposta;

public class AvaliacaoViewModel {

	private Date dataAvaliacao;
	private StatusFilme statusFilme;
	private Colaborador idColaborador;
	private Resposta idResposta;
	private Filme idFilme;

	public Resposta getIdResposta() {
		return idResposta;
	}

	public void setIdResposta(Resposta idResposta) {
		this.idResposta = idResposta;
	}


	public Avaliacao toAvaliacao() {
		return new Avaliacao(getDataAvaliacao(),getStatusFilme(),getIdColaborador(),getIdResposta(),getIdFilme());
	}

	public Date getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	public StatusFilme getStatusFilme() {
		return statusFilme;
	}

	public void setStatusFilme(StatusFilme statusFilme) {
		this.statusFilme = statusFilme;
	}

	public Filme getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(Filme idFilme) {
		this.idFilme = idFilme;
	}

	public Colaborador getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(Colaborador idColaborador) {
		this.idColaborador = idColaborador;
	}
}
