package br.com.senai.stayFilm.vizualizacao.viewModel;

import java.util.Date;
import java.util.List;

import br.com.senai.stayFilm.enumeration.Status;
import br.com.senai.stayFilm.model.Atividade;
import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.Endereco;
import br.com.senai.stayFilm.model.Telefone;

public class ColaboradorVisualizacaoViewModel {

	public ColaboradorVisualizacaoViewModel(Colaborador colaborador) {
		setNome(colaborador.getNome());
		setDataNasc(colaborador.getDataNasc());
		setStatus(colaborador.getStatus());
		setTelefone(colaborador.getTelefone());
		setEndereco(colaborador.getEndereco());
		setAtividade(colaborador.getAtividades());
		setEmail(colaborador.getEmail());
	}

	private String nome;
	private Date dataNasc;
	private Status status;
	private List<Telefone> telefone;
	private Endereco endereco;
	private List<Atividade> atividade;
	private String email;

	public List<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Atividade> getAtividade() {
		return atividade;
	}

	public void setAtividade(List<Atividade> atividade) {
		this.atividade = atividade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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
