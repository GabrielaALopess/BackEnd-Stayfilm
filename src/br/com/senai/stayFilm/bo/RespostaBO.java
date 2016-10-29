package br.com.senai.stayFilm.bo;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.dao.implementation.RespostaDao;
import br.com.senai.stayFilm.model.Resposta;

public class RespostaBO {
	
	@Autowired
	@Qualifier("respostaDao")
	private GenericDao<Resposta> respostaDao;
	
	public RespostaBO(){
		respostaDao = new RespostaDao();
	}
	
	public void insert(Resposta resposta) throws SQLException{
		respostaDao.insert(resposta);
	}
	
	public Resposta search(Long id){
		return respostaDao.search(id);
	}
	
	public Resposta edit(Resposta resposta) throws SQLException{
		if(exist(resposta.getIdResposta())){
			return respostaDao.update(resposta);
		}
		return null;
	}
	
	public boolean exist(Long id){
		return search(id) != null;
	}
	
}
