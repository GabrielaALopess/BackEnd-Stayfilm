package br.com.senai.stayFilm.model;

/*import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import br.com.senai.stayFilm.enumeration.TipoPermissao;

@Embeddable
public class Usuario {

	@Column(name="email_usuario")
	private String email;
	
	@Column(name="senha_usuario")
	private String senha;
	
	@Column(name="permissao_usuario")
	@Enumerated(EnumType.ORDINAL)
	private TipoPermissao permissao;
	

	

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

	public TipoPermissao getPermissao() {
		return permissao;
	}

	public void setPermissao(TipoPermissao permissao) {
		this.permissao = permissao;
	}

	

	

	

}
*/