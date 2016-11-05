package br.com.senai.stayFilm.vizualizacao.viewModel;

import java.util.Date;

import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.Escala;

public class EscalaVizualizacaoViewModel {

	public EscalaVizualizacaoViewModel(Escala escala) {
		setComparecimento(escala.isComparecimento());
		setObservacao(escala.getObservacao());
		setDataEscala(escala.getDataEscala());
		setHoraEscalaInicio(escala.getHoraEscalaInicio());
		setHoraEscalaFim(escala.getHoraEscalaFim());
		setIdColaborador(escala.getIdColaborador());
	}

	private boolean comparecimento;
	private String observacao;
	private Date dataEscala;
	private Date horaEscalaInicio;
	private Date horaEscalaFim;
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

	public Colaborador getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(Colaborador idColaborador) {
		this.idColaborador = idColaborador;
	}

	public Date getHoraEscalaInicio() {
		return horaEscalaInicio;
	}

	public void setHoraEscalaInicio(Date horaEscalaInicio) {
		this.horaEscalaInicio = horaEscalaInicio;
	}

	public Date getHoraEscalaFim() {
		return horaEscalaFim;
	}

	public void setHoraEscalaFim(Date horaEscalaFim) {
		this.horaEscalaFim = horaEscalaFim;
	}

}
