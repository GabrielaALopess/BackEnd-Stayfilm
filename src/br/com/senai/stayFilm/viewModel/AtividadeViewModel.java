package br.com.senai.stayFilm.viewModel;

import br.com.senai.stayFilm.enumeration.Periodo;
import br.com.senai.stayFilm.model.Atividade;
import br.com.senai.stayFilm.model.Colaborador;

public class AtividadeViewModel {
	private String instituicao;
	private String atividade;
	private Periodo periodo;
	private Colaborador colaborador;

	private Long idAtividade;

	public Long getIdAtividade() {
		return idAtividade;
	}

	public void setIdAtividade(Long idAtividade) {
		this.idAtividade = idAtividade;
	}

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
		return new Atividade(getInstituicao(), getAtividade(), getPeriodo());
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
}
