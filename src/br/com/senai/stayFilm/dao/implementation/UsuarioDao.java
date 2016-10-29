package br.com.senai.stayFilm.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.senai.stayFilm.model.Usuario;

@Repository
public class UsuarioDao {

	
	private EntityManager manager;
	
	
	/*
	 * método responsavel por realizar a inserçao.
	 * */
	@Transactional
	public void inserirUsuario(Usuario usuario){
		manager.persist(usuario);
	}
	
	
	
	public Usuario logar(Usuario usuario){
		TypedQuery<Usuario> query= manager.createQuery("SELECT u FROM Usuario u WHERE u.login = :login and "+
				"u.senha= :senha",Usuario.class);
		
		query.setParameter("login", usuario.getLogin());
		query.setParameter("senha",usuario.getSenha());
		try {
			return query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		
	}
}
