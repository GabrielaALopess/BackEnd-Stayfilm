package br.com.senai.stayFilm.vizualizacao.viewModel;

import br.com.senai.stayFilm.enumeration.TemaFilme;
import br.com.senai.stayFilm.model.Avaliacao;
import br.com.senai.stayFilm.model.Filme;

public class FilmeVizualizacaoViewModel {

	public FilmeVizualizacaoViewModel(Filme filme) {
		setDescricaoFilme(filme.getDescricaoFilme());
		setTemaFilme(filme.getTemaFilme());
		setIdAvaliacao(filme.getIdAvaliacao());
	}

	private String descricaoFilme;
	private TemaFilme temaFilme;
	private Avaliacao idAvaliacao;

	public String getDescricaoFilme() {
		return descricaoFilme;
	}

	public void setDescricaoFilme(String descricaoFilme) {
		this.descricaoFilme = descricaoFilme;
	}

	public TemaFilme getTemaFilme() {
		return temaFilme;
	}

	public void setTemaFilme(TemaFilme temaFilme) {
		this.temaFilme = temaFilme;
	}

	public Avaliacao getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(Avaliacao idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

}
