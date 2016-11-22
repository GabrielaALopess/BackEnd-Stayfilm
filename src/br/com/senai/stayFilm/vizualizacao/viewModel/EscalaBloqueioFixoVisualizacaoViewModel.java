package br.com.senai.stayFilm.vizualizacao.viewModel;

import br.com.senai.stayFilm.model.EscalaBloqueioFixo;



public class EscalaBloqueioFixoVisualizacaoViewModel {

	private String dia;
	private int horario;
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public int getHorario() {
		return horario;
	}
	public void setHorario(int horario) {
		this.horario = horario;
	}
	
	public EscalaBloqueioFixoVisualizacaoViewModel(EscalaBloqueioFixo escalaBloqueioFixo){
		setDia(escalaBloqueioFixo.getDiaSemana().getDiaSemana());
		int horario = escalaBloqueioFixo.getHoraInicio() + escalaBloqueioFixo.getHoraFim();
		setHorario(horario);
	}
	
}
