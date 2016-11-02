package br.com.senai.stayFilm.vizualizacao.viewModel;

import br.com.senai.stayFilm.enumeration.Periodo;
import br.com.senai.stayFilm.model.Atividade;
import br.com.senai.stayFilm.model.Colaborador;

public class AtividadeVisualizacaoViewModel {

	public AtividadeVisualizacaoViewModel(Atividade atividade) {
		setInstituicao(atividade.getInstituicao());
		setAtividade(atividade.getAtividade());
		setPeriodo(atividade.getPeriodo());
		setColaborador(atividade.getIdColaborador());
		

	}

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

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
}
