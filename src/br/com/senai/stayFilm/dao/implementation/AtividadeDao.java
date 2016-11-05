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
import br.com.senai.stayFilm.model.Avaliacao;
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
	
	@Transactional
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
		return manager.find(Atividade.class, idAtividade);
	}

	@Transactional
	@Override
	public void insertWithKey(Atividade atividade, long idColaborador) {
		Colaborador colaborador = manager.find(Colaborador.class, idColaborador);
		atividade.setColaborador(colaborador);
		manager.persist(atividade);

	}

	@Transactional
	@Override
	public Atividade updateWithKey(Atividade atividade, long idColaborador) throws SQLException {
		Colaborador colaborador = manager.find(Colaborador.class, idColaborador);
		atividade.setColaborador(colaborador);
		return manager.merge(atividade);
	}


	@Override
	public List<Atividade> listar(long idColaborador) { 
		TypedQuery<Atividade> query = manager.createQuery("select a from Atividade a where a.idColaborador.idColaborador = :idColaborador", Atividade.class);
		query.setParameter("idColaborador", idColaborador);
		return query.getResultList();
	}

	@Override
	public void insert(Avaliacao avaliacao, Long idColaborador, Long idResposta) {
		// TODO Auto-generated method stub
		
	}

}
