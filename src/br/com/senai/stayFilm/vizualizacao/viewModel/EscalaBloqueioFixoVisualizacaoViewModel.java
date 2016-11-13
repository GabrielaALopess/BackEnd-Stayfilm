package br.com.senai.stayFilm.vizualizacao.viewModel;

import org.springframework.stereotype.Component;

import br.com.senai.stayFilm.model.EscalaBloqueioFixo;


@Component
public class EscalaBloqueioFixoVisualizacaoViewModel {

	private String dia;
	private String horario;
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public EscalaBloqueioFixoVisualizacaoViewModel(EscalaBloqueioFixo escalaBloqueioFixo){
		setDia(escalaBloqueioFixo.getDiaSemana().getDiaSemana());
		String horario = escalaBloqueioFixo.getHoraInicio().toString() + escalaBloqueioFixo.getHoraFim().toString();
		setHorario(horario);
	}
	
}
