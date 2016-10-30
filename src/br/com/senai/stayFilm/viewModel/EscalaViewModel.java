package br.com.senai.stayFilm.viewModel;

import java.util.Date;

import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.Escala;

public class EscalaViewModel {

	private boolean comparecimento;
	private String observacao;
	private Date dataEscala;
	private Date horaEscala;
	private Colaborador idColaborador;

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

	public Date getHoraEscala() {
		return horaEscala;
	}

	public void setHoraEscala(Date horaEscala) {
		this.horaEscala = horaEscala;
	}

	public Colaborador getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(Colaborador idColaborador) {
		this.idColaborador = idColaborador;
	}

	public Escala toEscala() {
		return new Escala(isComparecimento(), getObservacao(), getDataEscala(), getHoraEscala(), getIdColaborador());
	}

}
