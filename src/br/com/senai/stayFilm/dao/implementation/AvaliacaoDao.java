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
import br.com.senai.stayFilm.model.Escala;
import br.com.senai.stayFilm.model.Resposta;

@Repository
public class AvaliacaoDao implements GenericDao<Avaliacao> {

	@PersistenceContext
	private EntityManager manager;

	@Transactional
	@Override
	public void inclui(Avaliacao avaliacao) throws SQLException {
		manager.persist(avaliacao);
	}


	@Transactional
	@Override
	public Avaliacao altera(Avaliacao avaliacao) throws SQLException {
		return manager.merge(avaliacao);
	}

	@Transactional
	@Override
	public void exclui(Long idAvaliacao) throws SQLException {
		Avaliacao avaliacao = manager.find(Avaliacao.class, idAvaliacao);
		manager.remove(avaliacao);
	}


	@Override
	public Avaliacao pesquisa(Long idObj) {
		// TODO Auto-generated method stub
		return null;
	}


}
