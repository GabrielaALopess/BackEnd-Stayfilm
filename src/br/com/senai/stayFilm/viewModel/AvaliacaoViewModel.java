package br.com.senai.stayFilm.viewModel;

import java.util.Date;

import br.com.senai.stayFilm.enumeration.StatusFilme;
import br.com.senai.stayFilm.model.Avaliacao;
import br.com.senai.stayFilm.model.Filme;
import br.com.senai.stayFilm.model.Resposta;

public class AvaliacaoViewModel {

	private Date dataAvaliacao;
	private StatusFilme status;
	private Resposta idResposta;
	private Filme filme;
	
	


	public StatusFilme getStatus() {
		return status;
	}

	public void setStatus(StatusFilme status) {
		this.status = status;
	}

	public Resposta getIdResposta() {
		return idResposta;
	}

	public void setIdResposta(Resposta idResposta) {
		this.idResposta = idResposta;
	}


	public Avaliacao toAvaliacao() {
		System.out.println("QUE SE FODA"+dataAvaliacao);
		return new Avaliacao(getDataAvaliacao(),getStatus(),getIdResposta(),getFilme());
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
