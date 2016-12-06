package br.com.senai.stayFilm.model;

public class HorariosPessoaEscalaDia {
	
	private  Integer horarioInicio;
	private Integer horarioFim;
	
	
	public HorariosPessoaEscalaDia(Integer horarioInicio, Integer horarioFim){
		setHorarioInicio(horarioInicio);
		setHorarioFim(horarioFim);
	}
	
	public Integer getHorarioInicio() {
		return horarioInicio;
	}
	public void setHorarioInicio(Integer horarioInicio) {
		this.horarioInicio = horarioInicio;
	}
	public Integer getHorarioFim() {
		return horarioFim;
	}
	public void setHorarioFim(Integer horarioFim) {
		this.horarioFim = horarioFim;
	}
	
	

}
