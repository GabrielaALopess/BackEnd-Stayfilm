package br.com.senai.stayFilm.bo;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.ColaboradorLogin;

@Component
public class ColaboradorLoginBo {

	@Autowired
	@Qualifier("colaboradorLoginDao")
	private GenericDao<ColaboradorLogin> colaboradorLoginDao;

	public void insert(ColaboradorLogin colaboradorLogin, Long idColaborador) throws SQLException {
		colaboradorLoginDao.insertWithKey(colaboradorLogin, idColaborador);
	}
}
