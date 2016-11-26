package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Avaliacao;
import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.Resposta;

/**
 * 23/10/2016
 * 
 * @author Equipe Stayfilm Classe utilizada para a persistência dos dados da
 *         Resposta.
 */

@Repository
public class RespostaDao implements GenericDao<Resposta> {

	@PersistenceContext
	private EntityManager manager;

	@Transactional
	@Override
	public void insert(Resposta resposta) throws SQLException {
		manager.persist(resposta);

	}

	@Transactional
	@Override
	public void delete(Long idResposta) throws SQLException {
		Resposta resposta = manager.find(Resposta.class, idResposta);
		manager.remove(resposta);
	}

	@Transactional
	@Override
	public Resposta update(Resposta resposta) throws SQLException {
		return manager.merge(resposta);
	}

	@Override
	public Resposta search(Long idResposta) {
		return manager.find(Resposta.class, idResposta);
	}

	
	public List<Resposta> listarRespostas(){
		String hql= "SELECT	r FROM Resposta r ORDER BY r.tituloResposta ASC";
		TypedQuery<Resposta> query = manager.createQuery(hql, Resposta.class);
		return query.getResultList();
		
	}
	
	
	
	
	@Override
	public void insertWithKey(Resposta obj, long idColaborador) {
		// NOT USE

	}

	@Override
	public Resposta updateWithKey(Resposta obj, long idObj) throws SQLException {
		// NOT USE
		return null;
	}

	@Override
	public List<Resposta> listar(long idObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Avaliacao avaliacao, Long idColaborador, Long idResposta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Colaborador> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resposta buscarPorId(Long idObj) {
		// TODO Auto-generated method stub
		return null;
	}

}
