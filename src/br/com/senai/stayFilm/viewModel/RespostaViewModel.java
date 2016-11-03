package br.com.senai.stayFilm.ViewModel;
import br.com.senai.stayFilm.enumeration.Idioma;
import br.com.senai.stayFilm.model.Resposta;

public class RespostaViewModel {
	private String tituloResposta;
	private String resposta;
	private Idioma idioma;

	public String getTituloResposta() {
		return tituloResposta;
	}

	public void setTituloResposta(String tituloResposta) {
		this.tituloResposta = tituloResposta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

	// transforma a view model em model
	public Resposta toResposta() {
		return new Resposta(getTituloResposta(), getResposta(), getIdioma());
	}
}
