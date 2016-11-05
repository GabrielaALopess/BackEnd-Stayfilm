package br.com.senai.stayFilm.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.senai.stayFilm.enumeration.Status;

@Entity
public class Colaborador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idColaborador;
	private String nome;
	private Date dataNasc;
	private Status status;
	private String telefone_1;
	private String telefone_2;
	private String telefone_3;

	@OneToOne
	private Endereco endereco;


	private String email;
	private String senha;

	@OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Atividade> atividades;

	public Colaborador() {
		// NADA NADA NADA NADA ...
	}

	public Colaborador(String nome, Date data, Status status, String telefone_1, String telefone_2, String telefone_3,
			String email, String senha, Endereco endereco, List<Atividade> atividade) {
		this.nome = nome;
		this.dataNasc = data;
		this.status = status;
		this.telefone_1 = telefone_1;
		this.telefone_2 = telefone_2;
		this.telefone_3 = telefone_3;
		this.email = email;
		this.senha = senha;
		this.endereco = endereco;
		this.atividades = atividade;
	}

	public String getTelefone_1() {
		return telefone_1;
	}

	public void setTelefone_1(String telefone_1) {
		this.telefone_1 = telefone_1;
	}

	public String getTelefone_2() {
		return telefone_2;
	}

	public void setTelefone_2(String telefone_2) {
		this.telefone_2 = telefone_2;
	}

	public String getTelefone_3() {
		return telefone_3;
	}

	public void setTelefone_3(String telefone_3) {
		this.telefone_3 = telefone_3;
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

	public void setSenha(String senha) {
		this.senha = senha;
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
