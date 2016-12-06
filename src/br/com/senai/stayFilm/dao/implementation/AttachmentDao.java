package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Attachment;
import br.com.senai.stayFilm.model.Avaliacao;
import br.com.senai.stayFilm.model.Colaborador;

@Repository
public class AttachmentDao implements GenericDao<Attachment>{

	@PersistenceContext
	private EntityManager manager;

	
	
	@Override
	public void insert(Attachment att) throws SQLException {
		manager.persist(att);
	}

	@Override
	public void delete(Long idObj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Attachment update(Attachment obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Attachment search(Long idObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertWithKey(Attachment obj, long idObj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Attachment updateWithKey(Attachment obj, long idObj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Attachment> listar(long idObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Avaliacao avaliacao, Long idColaborador, Long idResposta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Avaliacao avaliacao, Long idColaborador, Long idResposta, Long filme) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Colaborador> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Attachment buscarPorId(Long idObj) {
		// TODO Auto-generated method stub
		return null;
	}

}
