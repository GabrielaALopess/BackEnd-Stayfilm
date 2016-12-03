package br.com.senai.stayFilm.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Colaborador;

@Component
public class SendEmaiBo {
	
	@Autowired
	@Qualifier("sendEmailDao")
	private GenericDao<Colaborador> sendEmailDao;

}
