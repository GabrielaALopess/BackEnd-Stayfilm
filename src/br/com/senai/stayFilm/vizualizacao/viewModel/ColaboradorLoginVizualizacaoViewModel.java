package br.com.senai.stayFilm.vizualizacao.viewModel;

import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.ColaboradorLogin;

public class ColaboradorLoginVizualizacaoViewModel {

	public ColaboradorLoginVizualizacaoViewModel(ColaboradorLogin colaboradorLogin) {
		setEmail(colaboradorLogin.getEmail());
		setSenha(colaboradorLogin.getSenha());
		setColaborador(colaboradorLogin.getColaborador());
	}

	private String email;
	private String senha;
	private Colaborador colaborador;

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
