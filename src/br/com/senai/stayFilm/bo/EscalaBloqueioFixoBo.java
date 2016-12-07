package br.com.senai.stayFilm.bo;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.dao.implementation.EscalaBloqueioFixoDao;
import br.com.senai.stayFilm.model.EscalaBloqueioFixo;


@Component
public class EscalaBloqueioFixoBo {
	
	
	@Autowired
	@Qualifier("escalaBloqueioFixoDao")
	private GenericDao<EscalaBloqueioFixo> escalaBloqueioFixoDao;
	
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
	
	public List<EscalaBloqueioFixo>ListarEscalaBloqueio(long idColaborador){
		return ((EscalaBloqueioFixoDao) escalaBloqueioFixoDao).ListarEscalaBloqueio(idColaborador);
	}
	
	public List<EscalaBloqueioFixo> listarFixosDiaEspecifico(Date data){
		return ((EscalaBloqueioFixoDao) escalaBloqueioFixoDao).listarFixosDiaEspecifico(data);
	}

}
