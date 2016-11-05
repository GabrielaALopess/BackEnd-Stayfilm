package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Avaliacao;

@Repository
public class AvaliacaoDao implements GenericDao<Avaliacao> {

	@Override
	public void insert(Avaliacao obj) throws SQLException {
		// TODO Auto-generated method stub

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

	@Override
	public void insertWithKey(Avaliacao obj, long idColaborador) {
		// TODO Auto-generated method stub

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

}
