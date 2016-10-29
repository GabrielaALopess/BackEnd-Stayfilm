package br.com.senai.stayFilm.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.senai.stayFilm.enumeration.Status;

@Entity
public class Colaborador {

	public Colaborador() {
	}

	public Colaborador(String nome, Date data, Status status, String email, String senha) {
		this.nome = nome;
		this.dataNasc = data;
		this.status = status;
		this.email = email;
		this.senha = senha;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idColaborador;
	private String nome;
	private Date dataNasc;
	private Status status;
	private String email;
	private String senha;

	@OneToMany(mappedBy = "idColaborador", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Atividade> atividades;

	public Long getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(Long idColaborador) {
		this.idColaborador = idColaborador;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
