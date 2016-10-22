package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.Telefone;

@Repository
public class TelefoneDao implements GenericDao<Telefone> {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void insert(Telefone telefone) throws SQLException {
		// NOT USE

	}
	
	@Transactional
	@Override
	public void delete(Long idTelefone) throws SQLException {
		Telefone telefone = manager.find(Telefone.class, idTelefone);
		manager.remove(telefone);
	}

	@Override
	public Telefone update(Telefone telefone) throws SQLException {
		// NOT USE
		return null;
	}

	@Override
	public Telefone search(Long idTelefone) {
		// TODO Auto-generated method stub
		return manager.find(Telefone.class, idTelefone);
	}

	@Transactional
	@Override
	public void insertWithKey(Telefone telefone, long idColaborador) {
		Colaborador colaborador = manager.find(Colaborador.class, idColaborador);
		telefone.setIdColaborador(colaborador);
		manager.persist(telefone);

	}

	@Transactional
	@Override
	public Telefone updateWithKey(Telefone telefone, long idColaborador) throws SQLException {
		Colaborador colaborador = manager.find(Colaborador.class, idColaborador);
		telefone.setIdColaborador(colaborador);
		return manager.merge(telefone);
	}

}
