package br.com.senai.stayFilm.vizualizacao.viewModel;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.senai.stayFilm.enumeration.TipoPermissao;
import br.com.senai.stayFilm.model.Colaborador;

/**
 * VisualizacaoViewModel de Colaborador
 * 
 * @author Gabriela Lopes
 *
 */
public class ColaboradorVisualizacaoViewModel {

	public ColaboradorVisualizacaoViewModel(Colaborador colaborador) {
		setNome(colaborador.getNome());
		setDataNasc(colaborador.getDataNasc());
		setStatus(colaborador.isStatus());
		setTelefoneResidencial(colaborador.getTelefoneResidencial());
		setTelefoneCelular(colaborador.getTelefoneCelular());
		setEmail(colaborador.getEmail());
		setSenha(colaborador.getSenha());
		setPermissao(colaborador.getPermissao());
	}

	private String nome;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dataNasc;
	private boolean status;
	private String telefoneResidencial;
	private String telefoneCelular;
	private String email;
	private String senha;
	private TipoPermissao permissao;

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
		this.senha = senha;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public TipoPermissao getPermissao() {
		return permissao;
	}

	public void setPermissao(TipoPermissao permissao) {
		this.permissao = permissao;
	}

	
}
