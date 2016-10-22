package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Colaborador;

/**
 * 22/10/2016
 * @author Equipe Stayfilm
 * Classe utilizada para a persistência dos dados do colaborador.
 */

@Repository
public class ColaboradorDao implements GenericDao<Colaborador> {

	@PersistenceContext
	private EntityManager manager;

	@Transactional
	@Override
	public void insert(Colaborador colaborador) throws SQLException {
		manager.persist(colaborador);
	}

	@Transactional
	@Override
	public void delete(Long idColaborador) throws SQLException {
		Colaborador colaborador = manager.find(Colaborador.class, idColaborador);
		manager.remove(colaborador);
	}

	@Transactional
	@Override
	public Colaborador update(Colaborador colaborador) throws SQLException {
		return manager.merge(colaborador);
	}

	@Override
	public Colaborador search(Long idColaborador) {
		return manager.find(Colaborador.class, idColaborador);
	}

	@Override
	public void insertWithKey(Colaborador colaborador, long idColaborador) {
		// NOT USE
	}

	@Override
	public Colaborador updateWithKey(Colaborador obj, long idObj) throws SQLException {
		// NOT USE
		return null;
	}

}
