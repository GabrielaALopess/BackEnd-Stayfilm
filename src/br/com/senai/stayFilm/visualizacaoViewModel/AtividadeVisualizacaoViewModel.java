package br.com.senai.stayFilm.visualizacaoViewModel;

import br.com.senai.stayFilm.enumeration.Periodo;
import br.com.senai.stayFilm.model.Atividade;

public class AtividadeVisualizacaoViewModel {

	public AtividadeVisualizacaoViewModel(Atividade atividade) {
		setInstituicao(atividade.getInstituicao());
		setAtividade(atividade.getAtividade());
		setPeriodo(atividade.getPeriodo());

	}

	private String instituicao;
	private String atividade;
	private Periodo periodo;

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
}
