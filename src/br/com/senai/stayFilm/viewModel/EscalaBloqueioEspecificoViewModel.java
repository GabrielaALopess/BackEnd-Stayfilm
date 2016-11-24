package br.com.senai.stayFilm.viewModel;



import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.EscalaBloqueioEspecifico;

@Component
public class EscalaBloqueioEspecificoViewModel {

	private Long idBloqueioEspecifico;
	private int horaInicio;
	private int horaFim;
	private Long colaboradorId;
	
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
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
	
	public EscalaBloqueioEspecifico toEscala(Colaborador colaborador){
		EscalaBloqueioEspecifico escala = new EscalaBloqueioEspecifico();
		escala.setData(getData());
		escala.setHoraInicio(getHoraInicio());
		escala.setHoraFim(getHoraFim());
		escala.setColaborador(colaborador);
		return escala;
	}
	
	
}
