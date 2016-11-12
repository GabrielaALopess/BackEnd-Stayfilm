package br.com.senai.stayFilm.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import br.com.senai.stayFilm.enumeration.Status;

@Entity
public class Colaborador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idColaborador;
	private String nome;
	private Date dataNasc;
	private Status status;
	
	@OneToMany
	private List<Telefone>telefone;

	@OneToOne
	private Endereco endereco;
	private String email;
	
	@Column
	private String senha;

	
	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Atividade> atividades;

	public Colaborador() {
		// NADA NADA NADA NADA ...
	}

	public Colaborador(String nome, Date data, Status status, List<Telefone> telefone, String email, String senha,
			Endereco endereco, List<Atividade> atividade) {
		this.nome = nome;
		this.dataNasc = data;
		this.status = status;

		this.email = email;
		this.senha = senha;
		this.endereco = endereco;
		this.atividades = atividade;
	}

	public List<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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

	/**
	 * CRIPTOGRAFIA MD5
	 * @param senha
	 */
	public void setSenha(String senha) {
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String md5=encoder.encodePassword(senha, null);
		this.senha = md5;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	public Long getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(Long idColaborador) {
		this.idColaborador = idColaborador;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
