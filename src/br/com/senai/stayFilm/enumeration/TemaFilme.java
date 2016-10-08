package br.com.senai.stayFilm.enumeration;

public enum TemaFilme {

	DISNEY("Disney"),CHELSEA("Chelsea"),;

	private String tema;

	TemaFilme(String tema) {
		this.tema = tema;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

}
