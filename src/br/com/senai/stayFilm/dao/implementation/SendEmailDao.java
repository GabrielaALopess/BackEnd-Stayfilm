package br.com.senai.stayFilm.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class SendEmailDao {

	@PersistenceContext
	private EntityManager manager;

	
}
