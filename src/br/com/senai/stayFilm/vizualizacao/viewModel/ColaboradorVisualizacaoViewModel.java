package br.com.senai.stayFilm.vizualizacao.viewModel;

import java.util.Date;

import br.com.senai.stayFilm.enumeration.Status;
import br.com.senai.stayFilm.model.Colaborador;

public class ColaboradorVisualizacaoViewModel {

	public ColaboradorVisualizacaoViewModel(Colaborador colaborador) {
		setNome(colaborador.getNome());
		setDataNasc(colaborador.getDataNasc());
		setStatus(colaborador.getStatus());
	}

	private String nome;
	private Date dataNasc;
	private Status status;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
