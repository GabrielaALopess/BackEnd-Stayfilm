package br.com.senai.stayFilm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Modelo utilizado na persistencia do Colaborador
 * 
 * @author Gabriela Lopes
 *
 */

@Entity
public class Colaborador {

	public Colaborador() {
	}

	public Colaborador(String nome, Date dataNasc, boolean status, String telefoneResidencial, String telefoneCelular,
			Endereco endereco, String email, String senha) {

		this.nome = nome;
		this.dataNasc = dataNasc;
		this.status = status;
		this.telefoneResidencial = telefoneResidencial;
		this.telefoneCelular = telefoneCelular;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idColaborador;

	private String nome;

	private Date dataNasc;

	private boolean status;

	private String telefoneResidencial;

	private String telefoneCelular;

	private String email;

	@Column
	private String senha;

	/**
	 * id do colaborador
	 * 
	 * @return
	 */
	public Long getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(Long idColaborador) {
		this.idColaborador = idColaborador;
	}

	/**
	 * Entende-se por nome completo do colaborador
	 * 
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * A data de nascimento do colaborador para consulta futura
	 * 
	 * @return
	 */
	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	/**
	 * E realizada a inclusao do telefone residencial para posterior consulta do
	 * colaborador
	 * 
	 * @return
	 */
	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	/**
	 * E realizado a inclusao do telefone celular para posterior consulta do
	 * colaborador
	 * 
	 * @return
	 */
	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	/**
	 * O email sera utilizado para realizar o login para a curadoria e e
	 * utilizado tambem no envio de emails para a recuperacao de senha
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Senha do colaborador que ira logar para realizar a curadoria
	 * 
	 * @return
	 */

	public String getSenha() {
		return senha;
	}

	/**
	 * CRIPTOGRAFIA MD5
	 * 
	 * @param senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * O status representa a quao o colaborador e ativo ou inativo no sistema
	 * 
	 * @return
	 */
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
