package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Endereco;

@Repository
public class EnderecoDao implements GenericDao<Endereco> {

	@PersistenceContext
	private EntityManager manager;
	
	
	@Transactional
	@Override
	public void inclui(Endereco endereco) throws SQLException {
		manager.persist(endereco);

	}


	@Transactional
	@Override
	public Endereco altera(Endereco endereco) throws SQLException {
		return manager.merge(endereco);
	}

	@Override
	public void exclui(Long idEndereco) throws SQLException {
			Endereco endereco = manager.find(Endereco.class, idEndereco);
			manager.remove(endereco);
	}

	
	
	@Override
	public Endereco pesquisa(Long idEndereco) {
		return manager.find(Endereco.class, idEndereco);
	}




}
