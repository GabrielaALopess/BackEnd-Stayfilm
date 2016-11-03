package br.com.senai.stayFilm.ViewModel;
import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.ColaboradorLogin;

public class ColaboradorLoginViewModel {
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
	
	public ColaboradorLogin toColaboradorLoginViewModel(){
		return new ColaboradorLogin(getEmail(),getSenha(),getColaborador());
	}

}
