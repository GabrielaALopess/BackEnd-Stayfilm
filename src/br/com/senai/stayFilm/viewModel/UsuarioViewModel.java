package br.com.senai.stayFilm.viewModel;

import br.com.senai.stayFilm.model.Usuario;

public class UsuarioViewModel {

	private String email;
	private String senha;
	private String idColaborador;

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

	public Usuario toUsuario() {
		return new Usuario(getEmail(), getSenha(), getIdColaborador());
	}

}
