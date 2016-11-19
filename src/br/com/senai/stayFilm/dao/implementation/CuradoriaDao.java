package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Avaliacao;
import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.Curadoria;

@Repository
public class CuradoriaDao implements GenericDao<Curadoria> {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void insert(Curadoria curadoria) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long idCuradoria) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Curadoria update(Curadoria curadoria) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curadoria search(Long idCuradoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertWithKey(Curadoria curadoria, long idCuradoria) {
		// TODO Auto-generated method stub

	}

	@Override
	public Curadoria updateWithKey(Curadoria curadoria, long idCuradoria) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Curadoria> listar(long idCuradoria) {
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
	public Curadoria buscarPorId(Long idObj) {
		// TODO Auto-generated method stub
		return null;
	}

}
