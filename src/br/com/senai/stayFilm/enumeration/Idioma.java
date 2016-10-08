package br.com.senai.stayFilm.enumeration;

public enum Idioma {

	INGLES("Inglês"), PORTUGUES("Portugues");
	
	private String idioma;
	
	 Idioma(String idioma){
		this.setIdioma(idioma);
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
}
