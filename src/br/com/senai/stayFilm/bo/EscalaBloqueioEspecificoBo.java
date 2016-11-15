package br.com.senai.stayFilm.bo;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.stayFilm.dao.implementation.EscalaBloqueioEspecificoDao;
import br.com.senai.stayFilm.model.EscalaBloqueioEspecifico;

@Component
public class EscalaBloqueioEspecificoBo {

	@Autowired
	private EscalaBloqueioEspecificoDao escalaBloqueioEspecificoDao;
	
	
	EscalaBloqueioEspecificoBo(){
		escalaBloqueioEspecificoDao = new EscalaBloqueioEspecificoDao();
	}
	
	
	public void insert(EscalaBloqueioEspecifico escalaBloqueioEspecifico) throws SQLException {
		escalaBloqueioEspecificoDao.insert(escalaBloqueioEspecifico);
	}

	public void delete(Long idBloqueioEspec) throws SQLException {
		escalaBloqueioEspecificoDao.delete(idBloqueioEspec);
	}
	
	public EscalaBloqueioEspecifico search(Long id) {
		return escalaBloqueioEspecificoDao.search(id);
	}
	
	public List<EscalaBloqueioEspecifico>ListarEscalaBloqueioEspecifico(){
		return escalaBloqueioEspecificoDao.ListarEscalaBloqueioEspecifico();
	}
}
