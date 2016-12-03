package br.com.senai.stayFilm.viewModel;



import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.EscalaBloqueioEspecifico;



public class EscalaBloqueioEspecificoViewModel {

	private Long idBloqueioEspecifico;
	private int horaInicio;
	private int horaFim;
	private Long colaboradorId;
	
	private Date data;
	
	public Long getIdBloqueioEspecifico() {
		return idBloqueioEspecifico;
	}
	public void setIdBloqueioEspecifico(Long idBloqueioEspecifico) {
		this.idBloqueioEspecifico = idBloqueioEspecifico;
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
	
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data =data;
	}
	
	public EscalaBloqueioEspecifico toEscala(Colaborador colaboradorId){
		EscalaBloqueioEspecifico escala = new EscalaBloqueioEspecifico();
		escala.setData(getData());
		escala.setHoraInicio(getHoraInicio());
		escala.setHoraFim(getHoraFim());
		escala.setColaboradorId(colaboradorId);
		return escala;
	}
	
	
}
