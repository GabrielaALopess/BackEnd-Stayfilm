package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Avaliacao;
import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.ColaboradorLogin;

@Repository
public class ColaboradorLoginDao implements GenericDao<ColaboradorLogin>{
	
	@PersistenceContext
	private EntityManager manager;


	@Override
	public void insert(ColaboradorLogin obj) throws SQLException {
		// NOT USE
		
	}

	@Override
	public void delete(Long idObj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ColaboradorLogin update(ColaboradorLogin obj) throws SQLException {
		// NOT USE
		return null;
	}

	@Override
	public ColaboradorLogin search(Long idObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public void insertWithKey(ColaboradorLogin colaboradorLogin, long idColaborador) {
		Colaborador colaborador = manager.find(Colaborador.class, idColaborador);
		colaboradorLogin.setColaborador(colaborador);
		manager.persist(colaboradorLogin);
		
	}

	@Override
	public ColaboradorLogin updateWithKey(ColaboradorLogin obj, long idObj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ColaboradorLogin> listar(long idObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Avaliacao avaliacao, Long idColaborador, Long idResposta) {
		// TODO Auto-generated method stub
		
	}

}
