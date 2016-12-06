package br.com.senai.stayFilm.model;

import java.util.List;

public class PessoaBloqueadaDia {

	private Long id;
	private String nome;
	private List<Integer> horario;
	
	
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Integer> getHorario() {
		return horario;
	}
	
	public void setHorario(List<Integer> horario) {
		this.horario = horario;
	}
	
	public void addListaHorarios(List<Integer> horarios){
		this.horario.addAll(horarios);
	}
	
	
	
	
}
