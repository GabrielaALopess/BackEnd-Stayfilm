package br.com.senai.stayFilm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.senai.stayFilm.enumeration.Periodo;

@Entity
public class Atividade {

	public Atividade() {
	}

	public Atividade(String instituicao, String atividade, Periodo periodo, Colaborador colaborador) {
		this.instituicao = instituicao;
		this.atividade = atividade;
		this.periodo = periodo;
		this.colaborador = colaborador;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAtividade;
	private String instituicao;
	private String atividade;
	
	private Periodo periodo;

	@ManyToOne
	@JoinColumn(name = "idColaborador")
	private Colaborador colaborador;

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

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

}
