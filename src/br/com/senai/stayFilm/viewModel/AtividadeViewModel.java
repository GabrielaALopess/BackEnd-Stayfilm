package br.com.senai.stayFilm.viewModel;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

import br.com.senai.stayFilm.enumeration.Periodo;
import br.com.senai.stayFilm.model.Atividade;
import br.com.senai.stayFilm.model.Colaborador;


@Component
public class AtividadeViewModel {

	private String instituicao;
	private String atividade;
	private Periodo periodo;
	private Colaborador colaborador;

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getAtividade() {
		return atividade;
	}

	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public Atividade toAtividade() {
		return new Atividade(getInstituicao(), getAtividade(), getPeriodo(), getColaborador());
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

}
