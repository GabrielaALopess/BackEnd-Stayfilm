package br.com.senai.stayFilm.vizualizacao.viewModel;


import java.util.Date;

import org.springframework.stereotype.Component;

import br.com.senai.stayFilm.model.EscalaBloqueioEspecifico;



public class EscalaBloqueioEspecificoVisualizacaoViewModel {

	private Date data;
	private String horario;
	
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public EscalaBloqueioEspecificoVisualizacaoViewModel(EscalaBloqueioEspecifico escala){
		setData(escala.getData());
		String horario = escala.getHoraInicio().toString() + escala.getHoraFim().toString();
		setHorario(horario);
	}
	
}
