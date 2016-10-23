package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Atividade;
import br.com.senai.stayFilm.model.Colaborador;

/**
 * 23/10/2016
 * 
 * @author Equipe Stayfilm Classe utilizada para a persistência dos dados do
 *         Atividade.
 */

@Repository
public class AtividadeDao implements GenericDao<Atividade> {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void insert(Atividade atividade) throws SQLException {
		// NOT USE

	}

	@Override
	public void delete(Long idAtividade) throws SQLException {
		Atividade atividade = manager.find(Atividade.class, idAtividade);
		manager.remove(atividade);

	}

	@Override
	public Atividade update(Atividade atividade) throws SQLException {
		// NOT USE
		return null;
	}

	@Override
	public Atividade search(Long idAtividade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public void insertWithKey(Atividade atividade, long idColaborador) {
		Colaborador colaborador = manager.find(Colaborador.class, idColaborador);
		atividade.setIdColaborador(colaborador);
		manager.persist(atividade);

	}

	@Transactional
	@Override
	public Atividade updateWithKey(Atividade atividade, long idColaborador) throws SQLException {
		Colaborador colaborador = manager.find(Colaborador.class, idColaborador);
		atividade.setIdColaborador(colaborador);
		return manager.merge(atividade);
	}

}
