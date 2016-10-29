package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.Escala;

@Repository
public class EscalaDao implements GenericDao<Escala> {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void insert(Escala obj) throws SQLException {
		// NOT USE

	}

	@Transactional
	@Override
	public void delete(Long idEscala) throws SQLException {
		Escala escala = manager.find(Escala.class, idEscala);
		manager.remove(escala);

	}

	@Override
	public Escala update(Escala obj) throws SQLException {
		// NOT USE
		return null;
	}

	@Override
	public Escala search(Long idEscala) {
		return manager.find(Escala.class, idEscala);

	}

	@Transactional
	@Override
	public void insertWithKey(Escala escala, long idColaborador) {
		Colaborador colaborador = manager.find(Colaborador.class, idColaborador);
		escala.setIdColaborador(colaborador);
		manager.persist(escala);
	}

	@Transactional
	@Override
	public Escala updateWithKey(Escala escala, long idColaborador) throws SQLException {
		Colaborador colaborador = manager.find(Colaborador.class, idColaborador);
		escala.setIdColaborador(colaborador);
		return manager.merge(escala);

	}

	@Override
	public List<Escala> listar(long idObj) {
		// TODO Auto-generated method stub
		return null;
	}

}
