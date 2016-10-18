package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Resposta;

@Repository
public class RespostaDao implements GenericDao<Resposta> {

	@PersistenceContext
	private EntityManager manager;

	@Transactional
	@Override
	public void inclui(Resposta resposta) throws SQLException {
		manager.persist(resposta);

	}

	@Transactional
	@Override
	public Resposta altera(Resposta resposta) throws SQLException {
		
//		MyEntity e2 = em.merge(e);
//		e2.setAtributo(novoValor); 
//
//		resposta.setIdioma(Idioma.valueOf(Idioma.class,"?"));
//		resposta.setResposta("?");
//		resposta.setTituloResposta("?");
		
		//String exemplo = Idioma.valueOf(Idioma.class, name)
		
		
		return manager.merge(resposta);
	}

	@Transactional
	@Override
	public void exclui(Long idResposta) throws SQLException {
		 Resposta resposta = manager.find(Resposta.class, idResposta);
		 manager.remove(resposta);

	}

	@Override
	public Resposta pesquisa(Long idResposta) {
		return manager.find(Resposta.class, idResposta);
	}

}
