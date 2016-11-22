package br.com.senai.stayFilm.model;

import br.com.senai.stayFilm.enumeration.TipoPermissao;

public class Usuario {

	private String email;
	private String senha;
	private TipoPermissao permissao;

	public Usuario() {
		Colaborador colaborador = new Colaborador();
		email=colaborador.getEmail();
		senha=colaborador.getSenha();
		permissao=colaborador.getPermissao();
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

	public TipoPermissao getPermissao() {
		return permissao;
	}

	public void setPermissao(TipoPermissao permissao) {
		this.permissao = permissao;
	}

	

	

	

}
