package br.com.senai.stayFilm.bo;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.dao.implementation.EscalaBloqueioEspecificoDao;
import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.EscalaBloqueioEspecifico;

@Component
public class EscalaBloqueioEspecificoBo {

	@Autowired
	@Qualifier("escalaBloqueioEspecificoDao")
	private GenericDao<EscalaBloqueioEspecifico> escalaBloqueioEspecificoDao;
	
	
	
	
/*	EscalaBloqueioEspecificoBo(){
		escalaBloqueioEspecificoDao = new EscalaBloqueioEspecificoDao();
	}*/
	
	
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
		return ((EscalaBloqueioEspecificoDao) escalaBloqueioEspecificoDao).ListarEscalaBloqueioEspecifico();
	}
	
	public List<EscalaBloqueioEspecifico>listarPorMesPorColaborador(Colaborador idColaborador,int mes,int ano){
		return( (EscalaBloqueioEspecificoDao)escalaBloqueioEspecificoDao).listaEscalaMes(idColaborador,mes,ano);
	}
	
	public 	List<EscalaBloqueioEspecifico> listaPorData(Date data){
		return ( (EscalaBloqueioEspecificoDao)escalaBloqueioEspecificoDao).listaPorData(data);
	}
}
