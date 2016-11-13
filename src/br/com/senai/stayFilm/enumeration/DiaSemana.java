package br.com.senai.stayFilm.enumeration;

public enum DiaSemana {
	
	
	DOMINGO("Domingo"),
	SEGUNDA("Segunda-feira"),
	TERCA("Terca-feira"),
	QUARTA("Quarta-feira"),
	QUINTA("Quinta-feira"),
	SEXTA("Sexta-feira"),
	SABADO("Sabado");
	
	
	private String diaSemana;
	
	DiaSemana(String diaSemana){
		 this.diaSemana=diaSemana;
	}
		

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	
	
	

}
