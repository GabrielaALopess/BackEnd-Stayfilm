package br.com.senai.stayFilm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import br.com.senai.stayFilm.enumeration.TipoPermissao;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	@Column(unique=true)
	private String login;
	@Column
	private TipoPermissao permissao;
	@Column
	private String senha;
	//@OneToOne
	//@JoinColumn(name = "colaborador_id")
	//private Colaborador idcolaborador;
	
	
	Usuario(){
		
	}
	
	Usuario(String login, TipoPermissao permissao, String senha){
		this.login=login;
		this.permissao=permissao;
		this.senha=senha;
		//this.idcolaborador=idcolaborador;
		
	}

	
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public TipoPermissao getPermissao() {
		return permissao;
	}

	public void setPermissao(TipoPermissao permissao) {
		this.permissao = permissao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String md5=encoder.encodePassword(senha, null);
		this.senha = md5;
	}

	/*public Colaborador getIdcolaborador() {
		return idcolaborador;
	}

	public void setIdcolaborador(Colaborador idcolaborador) {
		this.idcolaborador = idcolaborador;
	}*/
	
	
	
	
	
}
