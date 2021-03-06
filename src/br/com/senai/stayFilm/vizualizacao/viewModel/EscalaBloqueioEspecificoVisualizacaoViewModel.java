package br.com.senai.stayFilm.vizualizacao.viewModel;


import java.util.Date;

import com.auth0.jwt.internal.com.fasterxml.jackson.annotation.JsonFormat;

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
		this.horario = horario+"h";
	}
	
	/*public String converteData(Date data){
	SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
	String dataToString=sdf.format(new Date()); 
	return dataToString;		
	}*/
	
	public EscalaBloqueioEspecificoVisualizacaoViewModel(EscalaBloqueioEspecifico escala){
		String horario = escala.getHoraInicio()+ " - "+ escala.getHoraFim();
		setData(escala.getData());
		setHorario(horario);
	}
	
}
