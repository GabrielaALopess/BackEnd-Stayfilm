package br.com.senai.stayFilm.viewModel;

import java.util.Date;

import br.com.senai.stayFilm.enumeration.Status;
import br.com.senai.stayFilm.model.Colaborador;

public class ColaboradorViewModel {

	private String nome;
	private Date dataNasc;
	private Status status;
	private String email;
	private String senha;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Colaborador toColaborador() {
		return new Colaborador(getNome(), getDataNasc(), getStatus(), getEmail(), getSenha());
	}

}
