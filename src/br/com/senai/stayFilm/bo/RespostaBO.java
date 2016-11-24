package br.com.senai.stayFilm.bo;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.dao.implementation.RespostaDao;
import br.com.senai.stayFilm.model.Resposta;

@Component
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
	
	public Resposta update(Resposta resposta) throws SQLException{
		return respostaDao.update(resposta);
	}
	
	public void delete(Long idResposta) throws SQLException {
		respostaDao.delete(idResposta);
	}
	
	
	public boolean exist(Long id){
		return search(id) != null;
	}
	
}
