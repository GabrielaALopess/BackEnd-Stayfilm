package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Colaborador;

@Repository
public class ColaboradorDao implements GenericDao<Colaborador>{
	
	private EntityManager manager;
	
	ColaboradorDao(){
		
	}

	@Override
	public void inclui(Colaborador obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public List<Colaborador> pesquisa(Colaborador obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void altera(Colaborador obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exclui(Colaborador obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
