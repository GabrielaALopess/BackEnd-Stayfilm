package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.enumeration.StatusFilme;
import br.com.senai.stayFilm.model.Avaliacao;
import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.Filme;
import br.com.senai.stayFilm.model.Resposta;

@Repository
public class AvaliacaoDao implements GenericDao<Avaliacao> {

	
	@PersistenceContext
	private EntityManager manager;


	@Transactional
	public void insert(Avaliacao avaliacao, long idColaborador,long idResposta) throws SQLException {
		Colaborador colaborador = manager.find(Colaborador.class, idColaborador);
		Resposta resposta = manager.find(Resposta.class, idResposta);
		avaliacao.setIdResposta(resposta);
		manager.persist(avaliacao);

	}
	
	
	/**
	 * Esse metodo e utilizado para persistir a atualizacao
	 */
	@Transactional
	@Override
	public void insert(Avaliacao avaliacao, Long idColaborador, Long idResposta, Long idFilme) {
		Colaborador colaborador = manager.find(Colaborador.class, idColaborador);
		Resposta resposta = manager.find(Resposta.class, idResposta);
		Filme filme = manager.find(Filme.class, idFilme);
		avaliacao.setIdResposta(resposta);
		avaliacao.setFilme(filme);
		System.out.println("PASSOU AQUI");
		manager.persist(avaliacao);
	}

	
	
	
	
	@Override
	public void insert(Avaliacao obj) throws SQLException {
		//NOT USE 

	}

	@Override
	public void delete(Long idObj) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Avaliacao update(Avaliacao obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Avaliacao search(Long idObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public void insertWithKey(Avaliacao obj, long id) {
		//NOT USE

	}
	
//	@Override
//	public void insertWithKey(Avaliacao obj, long idColaborador,long idResposta) {
//		// TODO Auto-generated method stub
//
//	}
//	
	
	@Override
	public Avaliacao updateWithKey(Avaliacao obj, long idObj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Avaliacao> listar(long idObj) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	public List<Avaliacao> listarPorStatus(StatusFilme status) {
		String hql = "select a from Avaliacao a where a.status = :status";
		TypedQuery<Avaliacao> query = manager.createQuery(hql, Avaliacao.class);
		query.setParameter("status", status);
		return query.getResultList();
	}
	
	
	
	
	@Transactional
	@Override
	public void insert(Avaliacao avaliacao, Long idColaborador, Long idResposta) {

		Resposta resposta = manager.find(Resposta.class, idResposta);
		avaliacao.setIdResposta(resposta);
		manager.persist(avaliacao);

	}



	@Override
	public List<Colaborador> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Avaliacao buscarPorId(Long idObj) {
		// TODO Auto-generated method stub
		return null;
	}



}
