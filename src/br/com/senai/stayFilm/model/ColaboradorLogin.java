package br.com.senai.stayFilm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ColaboradorLogin {

	public ColaboradorLogin() {

	}

	public ColaboradorLogin(String email, String senha, Colaborador colaborador) {
		this.email = email;
		this.senha = senha;
		this.colaborador = colaborador;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLoginColaborador;
	private String email;
	private String senha;
	@OneToOne
	@JoinColumn(name = "idColaborador")
	private Colaborador colaborador;

	public Long getIdLoginColaborador() {
		return idLoginColaborador;
	}

	public void setIdLoginColaborador(Long idLoginColaborador) {
		this.idLoginColaborador = idLoginColaborador;
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

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

}
