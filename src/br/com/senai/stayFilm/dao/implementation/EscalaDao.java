package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Escala;

@Repository
public class EscalaDao implements GenericDao<Escala> {

	@PersistenceContext
	private EntityManager manager;

	@Transactional
	@Override
	public void inclui(Escala escala) throws SQLException {
		manager.persist(escala);
	}

	@Override
	public List<Escala> pesquisa(Escala escala) throws SQLException {
		TypedQuery<Escala> query = manager.createQuery("select e from Escala e", Escala.class);
		return query.getResultList();
	}

	@Override
	public Escala altera(Escala escala) throws SQLException {
		return manager.merge(escala);
	}

	@Transactional
	@Override
	public void exclui(Long idObj) throws SQLException {
		Escala escala = manager.find(Escala.class, idObj);
		manager.remove(escala);
	}

}
