package br.com.senai.stayFilm.viewModel;

import org.springframework.stereotype.Component;

import br.com.senai.stayFilm.enumeration.DiaSemana;
import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.EscalaBloqueioFixo;


@Component
public class EscalaBloqueioFixoViewModel {

	private Long idBloqueiofixo;
	private int horaInicio;
	private int horaFim;
	private Long colaboradorId;
	private DiaSemana diaSemana;
	
	
	public Long getIdBloqueiofixo() {
		return idBloqueiofixo;
	}
	public void setIdBloqueiofixo(Long idBloqueiofixo) {
		this.idBloqueiofixo = idBloqueiofixo;
	}
	public int getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}
	public int getHoraFim() {
		return horaFim;
	}
	public void setHoraFim(int horaFim) {
		this.horaFim = horaFim;
	}
	public Long getColaboradorId() {
		return colaboradorId;
	}
	public void setColaboradorId(Long colaboradorId) {
		this.colaboradorId = colaboradorId;
	}
	public DiaSemana getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemanaId(DiaSemana diaSemana) {
		this.diaSemana = diaSemana;
	}
	
	public EscalaBloqueioFixo toEscala(Colaborador colaborador){
		EscalaBloqueioFixo escala = new EscalaBloqueioFixo();
		escala.setDiaSemana(getDiaSemana());
		escala.setHoraInicio(getHoraInicio());
		escala.setHoraFim(getHoraFim());
		escala.setColaborador(colaborador);
		return escala;
	}
	
	
}
