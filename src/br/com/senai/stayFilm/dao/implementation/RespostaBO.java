package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Resposta;

public class RespostaBO {
	
	private RespostaDao respostaDao;
	
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
