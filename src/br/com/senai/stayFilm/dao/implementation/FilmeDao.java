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
import br.com.senai.stayFilm.enumeration.TemaFilme;
import br.com.senai.stayFilm.model.Avaliacao;
import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.Filme;

@Repository
public class FilmeDao implements GenericDao<Filme> {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void insert(Filme filme) throws SQLException {
		manager.persist(filme);

	}

	@Override
	public void delete(Long idBloqueiofixo) throws SQLException {
		
	}

	@Override
	public Filme update(Filme filme) throws SQLException {
		//
		///
		//
		return filme;
	}

	@Override
	public Filme search(Long idObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertWithKey(Filme Filme, long idColaborador) {
		// TODO Auto-generated method stub

	}

	@Override
	public Filme updateWithKey(Filme filme, long idObj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Avaliacao avaliacao, Long idColaborador, Long idResposta) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Filme> listar(long idObj) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Filme> listarFilme() {
		TypedQuery<Filme> query = manager.createQuery("select f from Filme f", Filme.class);
		return query.getResultList();
	}

	public List<Filme> listarPorTema(TemaFilme temafilme) {
		String hql = "select f from Filme f where f.temaFilma = :temaFilme";
		TypedQuery<Filme> query = manager.createQuery(hql, Filme.class);
		query.setParameter("temaFilme", temafilme);
		return query.getResultList();
	}
	
	
	public List<Filme>listarPorStatus(StatusFilme statusFilme){
	String hql="select f from Filme f where f.statusFilme = :statusFilme";
	TypedQuery<Filme>query = manager.createQuery(hql, Filme.class);
	query.setParameter("statusFilme", statusFilme);
	return query.getResultList();
	}
	
	/**
	 * PEGAR O ID DO FILME E TROQUE O STATUS DELE CONFORME A AVALIACAO DO DAOOOOOO
	 * @param idFilme
	 * @param statusFilme
	 */
	@Transactional
	public void mudarStatus(long idFilme, StatusFilme statusFilme){
		Filme filme = manager.find(Filme.class, statusFilme);
		manager.merge(filme);
	}

	@Override
	public List<Colaborador> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Filme buscarPorId(Long idObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Avaliacao avaliacao, Long idColaborador, Long idResposta, Long filme) {
		// TODO Auto-generated method stub
		
	}

}
