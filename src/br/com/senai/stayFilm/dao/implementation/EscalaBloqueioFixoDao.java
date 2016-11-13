package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Avaliacao;
import br.com.senai.stayFilm.model.EscalaBloqueioFixo;

@Repository
public class EscalaBloqueioFixoDao implements GenericDao<EscalaBloqueioFixo> {

	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void insert(EscalaBloqueioFixo escalaBloqueioFixo) throws SQLException {
		manager.persist(escalaBloqueioFixo);
	}

	@Override
	public void delete(Long idBloqueiofixo) throws SQLException {
		EscalaBloqueioFixo escalaBloqueioFixo = manager.find(EscalaBloqueioFixo.class, idBloqueiofixo);
		manager.remove(idBloqueiofixo);
	}

	@Override
	public EscalaBloqueioFixo update(EscalaBloqueioFixo obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EscalaBloqueioFixo search(Long id) {
		return manager.find(EscalaBloqueioFixo.class, id);
	}

	@Override
	public void insertWithKey(EscalaBloqueioFixo obj, long idObj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EscalaBloqueioFixo updateWithKey(EscalaBloqueioFixo obj, long idObj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EscalaBloqueioFixo> listar(long idObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Avaliacao avaliacao, Long idColaborador, Long idResposta) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
