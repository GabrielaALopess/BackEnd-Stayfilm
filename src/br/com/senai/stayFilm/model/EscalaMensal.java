package br.com.senai.stayFilm.model;

import java.util.List;

public class EscalaMensal {

	private Integer dia;
	private List<String> escalados;
	private List<String> bloqueado;
	
	
	public Integer getDia() {
		return dia;
	}
	public void setDia(Integer dia) {
		this.dia = dia;
	}
	public List<String> getEscalados() {
		return escalados;
	}
	public void setEscalados(List<String> escalados) {
		this.escalados = escalados;
	}
	public List<String> getBloqueado() {
		return bloqueado;
	}
	public void setBloqueado(List<String> bloqueado) {
		this.bloqueado = bloqueado;
	}
	
	
	
}
