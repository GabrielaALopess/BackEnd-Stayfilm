package br.com.senai.stayFilm.vizualizacao.viewModel;

import java.util.Date;
import java.util.List;

import br.com.senai.stayFilm.enumeration.Status;
import br.com.senai.stayFilm.model.Atividade;
import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.Endereco;

public class ColaboradorVisualizacaoViewModel {

	public ColaboradorVisualizacaoViewModel(Colaborador colaborador) {
		setNome(colaborador.getNome());
		setDataNasc(colaborador.getDataNasc());
		setStatus(colaborador.getStatus());
		setTelefone_1(colaborador.getTelefone_1());
		setTelefone_2(colaborador.getTelefone_2());
		setTelefone_3(colaborador.getTelefone_3());
		setEndereco(colaborador.getEndereco());
		setAtividade(colaborador.getAtividades());
		setEmail(colaborador.getEmail());
	}

	private String nome;
	private Date dataNasc;
	private Status status;
	private String telefone_1;
	private String telefone_2;
	private String telefone_3;
	private Endereco endereco;
	private List<Atividade> atividade;
	private String email;

	public String getTelefone_1() {
		return telefone_1;
	}

	public void setTelefone_1(String telefone_1) {
		this.telefone_1 = telefone_1;
	}

	public String getTelefone_2() {
		return telefone_2;
	}

	public void setTelefone_2(String telefone_2) {
		this.telefone_2 = telefone_2;
	}

	public String getTelefone_3() {
		return telefone_3;
	}

	public void setTelefone_3(String telefone_3) {
		this.telefone_3 = telefone_3;
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
