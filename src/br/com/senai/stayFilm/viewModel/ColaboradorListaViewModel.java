package br.com.senai.stayFilm.viewModel;

import br.com.senai.stayFilm.model.Colaborador;

public class ColaboradorListaViewModel {

	
	
	private String nome;
	private String telefoneResidencial;
	private String telefoneCelular;
	private String email;
	
		
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}
	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}
	public String getTelefoneCelular() {
		return telefoneCelular;
	}
	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	public ColaboradorListaViewModel(Colaborador colaborador) {
		setNome(colaborador.getNome());
		setTelefoneResidencial(colaborador.getTelefoneResidencial());
		setTelefoneCelular(colaborador.getTelefoneCelular());
		setEmail(colaborador.getEmail());
	}
	
	
	
}
