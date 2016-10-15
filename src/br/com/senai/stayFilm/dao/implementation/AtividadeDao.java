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

@Repository
public class AtividadeDao implements GenericDao<Atividade> {

	@PersistenceContext
	private EntityManager manager;

	@Transactional

	@Override
	public void inclui(Atividade avaliacao) throws SQLException {
		manager.persist(avaliacao);
	}

	@Override
	public List<Atividade> pesquisa(Atividade atividade) throws SQLException {
		TypedQuery<Atividade> query = manager.createQuery("select a from Avaliacao a", Atividade.class);
		return query.getResultList();
	}

	@Transactional
	@Override
	public Atividade altera(Atividade atividade) throws SQLException {
		return manager.merge(atividade);
	}

	@Transactional
	@Override
	public void exclui(Long idObj) throws SQLException {
		Atividade atividade= manager.find(Atividade.class, idObj);
		manager.remove(atividade);

	}

}
