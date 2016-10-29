package br.com.senai.stayFilm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.senai.stayFilm.enumeration.Estado;

/**
 * 22/10/2016
 * 
 * @author Equipe Stayfilm Classe modelo para o endereço do colaborador.
 */
@Entity
public class Endereco {

	public Endereco() {
	}

	public Endereco(String endereco, String complemento, String bairro, Estado estado, String cidade, String cep) {
		this.endereco = endereco;
		this.complemento = complemento;
		this.bairro = bairro;
		this.estado = estado;
		this.cidade = cidade;
		this.cep = cep;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEndereco;
	private String endereco;
	private String complemento;
	private String bairro;
	private Estado estado;
	private String cidade;
	private String cep;

	@OneToOne(orphanRemoval = true)
	private Colaborador idColaborador;

	/**
	 * @return idEndereco
	 */
	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	/**
	 * @return endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return complemento
	 */
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * @return bairro
	 */
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return estado
	 */
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	/**
	 * @return cidade
	 */
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return cep
	 */
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * @return idColaborador
	 */
	public Colaborador getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(Colaborador idColaborador) {
		this.idColaborador = idColaborador;
	}

}
