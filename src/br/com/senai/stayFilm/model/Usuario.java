package br.com.senai.stayFilm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private String idUsuario;
	private String email;
	private String senha;
	private String idColaborador;

	public Usuario() {
	}

	public Usuario(String email, String senha, String idColaborador) {
		this.email = email;
		this.senha = senha;
		this.idColaborador = idColaborador;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
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

	public String getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(String idColaborador) {
		this.idColaborador = idColaborador;
	}

}
