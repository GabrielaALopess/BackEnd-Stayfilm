package br.com.senai.stayFilm.bo;

import java.sql.SQLException;

import org.springframework.stereotype.Component;

import br.com.senai.stayFilm.dao.implementation.EscalaBloqueioFixoDao;
import br.com.senai.stayFilm.model.EscalaBloqueioFixo;


@Component
public class EscalaBloqueioFixoBo {
	
	private EscalaBloqueioFixoDao escalaBloqueioFixoDao;
	
	public EscalaBloqueioFixoBo(){
		escalaBloqueioFixoDao = new EscalaBloqueioFixoDao();
	}
	
	public void insert(EscalaBloqueioFixo escalaBloqueioFixo) throws SQLException {
		escalaBloqueioFixoDao.insert(escalaBloqueioFixo);
	}

	public void delete(Long idBloqueiofixo) throws SQLException {
		escalaBloqueioFixoDao.delete(idBloqueiofixo);
	}
	
	public EscalaBloqueioFixo search(Long id) {
		return escalaBloqueioFixoDao.search(id);
	}
	

}
