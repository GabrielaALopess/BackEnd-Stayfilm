package br.com.senai.stayFilm.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.senai.stayFilm.model.Usuario;

@Repository
public class UsuarioDao {

	@PersistenceContext
	private EntityManager manager;
//	
//	
//	/*
//	 * método responsavel por realizar a inserçao.
//	 * */
//	@Transactional
//	public void inserirUsuario(Usuario usuario){
//		manager.persist(usuario);
//	}
//	
	
	
	/**
	 * Metodo responsavel por realizar o login
	 */
	public Usuario logar(Usuario usuario){
		TypedQuery<Usuario>query =
				manager.createQuery("SELECT u FROM Usuario u WHERE u.email = :email and "
						+"u.senha= :senha",Usuario.class);
		query.setParameter("email",usuario.getEmail());
		query.setParameter("senha", usuario.getSenha());
		try{
			return query.getSingleResult();
		}catch (Exception e) {
			return null;
		}
		
	}
}
