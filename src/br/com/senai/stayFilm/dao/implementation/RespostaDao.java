package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Atividade;
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

	@Override
	public List<Resposta> pesquisa(Resposta resposta) throws SQLException {
//		TypedQuery<Resposta> query = manager.createQuery("select r from Resposta r", Resposta.class);
//		return query.getResultList();
	return null;
	}
	
	@Transactional
	@Override
	public Resposta altera(Resposta resposta) throws SQLException {
//		return manager.merge(resposta);
		return null;
	}
	
	@Transactional
	@Override
	public void exclui(Long idObj) throws SQLException {
//		Resposta resposta = manager.find(Resposta.class, idObj);
//		manager.remove(resposta);

	}

}
