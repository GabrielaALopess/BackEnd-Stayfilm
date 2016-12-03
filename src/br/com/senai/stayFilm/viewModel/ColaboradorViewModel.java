package br.com.senai.stayFilm.viewModel;

import java.util.Date;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import br.com.senai.stayFilm.enumeration.TipoPermissao;
import br.com.senai.stayFilm.model.Colaborador;

/**
 * ViewModel de colaborador
 * 
 * @author Gabriela Lopes
 *
 */
public class ColaboradorViewModel {

	private String nome;
	private Date dataNasc;
	private boolean status;
	private String telefoneResidencial;
	private String telefoneCelular;
	private String email;
	private String senha;
	private TipoPermissao permissao;

	
	public Colaborador toColaborador() {
		return new Colaborador(getNome(), getDataNasc(), isStatus(), getTelefoneResidencial(), getTelefoneCelular(), 
				getEmail(),getSenha(),getPermissao());
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

	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String md5 = encoder.encodePassword(senha, null);
		this.senha = md5;
	}

	public boolean isStatus() {
		return status;
	}

	/**
	 * status sempre ira ser true , o que significa que o colaborador esta
	 * ativo(e alterado quando ha update)
	 * @param status
	 */
	public void setStatus(boolean status) {
		this.status=status;
	}

	public TipoPermissao getPermissao() {
		return permissao;
	}

	public void setPermissao(TipoPermissao permissao) {
		this.permissao = permissao;
	}
	
	

}
