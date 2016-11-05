package br.com.senai.stayFilm.viewModel;

import org.springframework.stereotype.Component;

import br.com.senai.stayFilm.enumeration.TipoPermissao;
import br.com.senai.stayFilm.model.Colaborador;

@Component
public class UsuarioViewModel {

	
	private String login;
	private TipoPermissao permissao;
	private String senha;
	private Colaborador idcolaborador;
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public TipoPermissao getPermissao() {
		return permissao;
	}
	public void setPermissao(TipoPermissao permissao) {
		this.permissao = permissao;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Colaborador getIdcolaborador() {
		return idcolaborador;
	}
	public void setIdcolaborador(Colaborador idcolaborador) {
		this.idcolaborador = idcolaborador;
	}
	
	
	
	
}
