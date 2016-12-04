package br.com.senai.stayFilm.viewModel;

import java.util.Date;

import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.Escala;

public class EscalaViewModel {

	private boolean comparecimento;
	private String observacao;
	
	private Date dataEscala;
	private int horaEscalaInicio;
	private int horaEscalaFim;
	private Long colaboradorId;

	public boolean isComparecimento() {
		return comparecimento;
	}

	public void setComparecimento(boolean comparecimento) {
		this.comparecimento = comparecimento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getDataEscala() {
		return dataEscala;
	}

	public void setDataEscala(Date dataEscala) {
		this.dataEscala = dataEscala;
	}

	

	public int getHoraEscalaInicio() {
		return horaEscalaInicio;
	}

	public void setHoraEscalaInicio(int horaEscalaInicio) {
		this.horaEscalaInicio = horaEscalaInicio;
	}

	public int getHoraEscalaFim() {
		return horaEscalaFim;
	}

	public void setHoraEscalaFim(int horaEscalaFim) {
		this.horaEscalaFim = horaEscalaFim;
	}

	public Long getIdColaborador() {
		return colaboradorId;
	}

	public void setIdColaborador(Long colaboradorId) {
		this.colaboradorId = colaboradorId;
	}

	public Escala toEscala(Colaborador colaborador) {
		Escala escala= new Escala();
		
		escala.setDataEscala(getDataEscala());
		//	escala.setComparecimento(isComparecimento());
		//escala.setObservacao(getObservacao());
		escala.setHoraEscalaInicio(getHoraEscalaInicio());
		escala.setHoraEscalaFim(getHoraEscalaFim());
		escala.setColaborador(colaborador);
		
		return escala;
	}

}
