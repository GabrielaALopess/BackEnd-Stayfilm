package br.com.senai.stayFilm.model;

import java.util.List;

public class PessoaEscalaDia {
	
	private Long id;
	private String nome;
	private List<HorariosPessoaEscalaDia> horarios;
	
	
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
	public List<HorariosPessoaEscalaDia> getHorarios() {
		return horarios;
	}
	public void setHorarios(List<HorariosPessoaEscalaDia> horarios) {
		this.horarios = horarios;
	}
	
	public void addHorario(HorariosPessoaEscalaDia horario){
		this.horarios.add(horario);
	}
	
	

}
