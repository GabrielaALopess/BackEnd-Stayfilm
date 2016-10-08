package br.com.senai.stayFilm.enumeration;

public enum Periodo {
	MANHA("Manh�"), TARDE("Tarde"), NOITE("Noite");
	
	private String periodo;
	
	Periodo(String periodo){
		this.periodo = periodo;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

}
