package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.Escala;

@Repository
public class ColaboradorDao implements GenericDao<Colaborador> {

	@PersistenceContext
	private EntityManager manager;

	@Transactional
	@Override
	public void inclui(Colaborador colaborador) throws SQLException {
		manager.persist(colaborador);

	}

	@Override
	public List<Colaborador> pesquisa(Colaborador colaborador) throws SQLException {
		TypedQuery<Colaborador> query = manager.createQuery("select c from Colaborador c", Colaborador.class);
		return query.getResultList();
	}

	@Transactional
	@Override
	public Colaborador altera(Colaborador colaborador) throws SQLException {
		return manager.merge(colaborador);
	}

	@Transactional
	@Override
	public void exclui(Long idObj) throws SQLException {
		Colaborador colaborador = manager.find(Colaborador.class, idObj);
		manager.remove(colaborador);
		
	}

}
