package br.com.senai.stayFilm.ViewModel;

import br.com.senai.stayFilm.enumeration.Estado;
import br.com.senai.stayFilm.model.Endereco;

public class EnderecoViewModel {

	private String endereco;
	private String complemento;
	private String bairro;
	private Estado estado;
	private String cidade;
	private String cep;

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Endereco toEndereco() {
		return new Endereco(getEndereco(), getComplemento(), getBairro(), getEstado(), getCidade(), getCep());
	}

}
