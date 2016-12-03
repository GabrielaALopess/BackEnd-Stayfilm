package br.com.senai.stayFilm.vizualizacao.viewModel;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.senai.stayFilm.model.Escala;

public class EscalaVisualizacaoViewModel {

	
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date dataEscala;
	private boolean comparecimento;
	private String observacao;
	private String horario;
	private long idColaborador;

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

	public long getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(long idColaborador) {
		this.idColaborador = idColaborador;
	}

	

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario +"h";
	}

	public EscalaVisualizacaoViewModel(Escala escala){
		
		//setDataEscala(new SimpleDateFormat("dd/MM/yyyy").format(escala.getDataEscala()));
		setDataEscala(escala.getDataEscala());
		setComparecimento(escala.isComparecimento());
		setObservacao(escala.getObservacao()); 
		String horario = escala.getHoraEscalaInicio()+" - "+escala.getHoraEscalaFim();
		setHorario(horario);
		setIdColaborador(escala.getColaborador().getIdColaborador());
	}

}
