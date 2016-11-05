package br.com.senai.stayFilm.bo;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.dao.implementation.AvaliacaoDao;
import br.com.senai.stayFilm.model.Avaliacao;

/**
 * Bo de Avaliacao
 * 
 * @author Equipe StayFilm
 *
 */
@Component
public class AvaliacaoBo {

	@Autowired
	@Qualifier("avaliacaoDao")
	private GenericDao<Avaliacao> avaliacaoDao;

	public void insert(Avaliacao avaliacao, Long idColaborador, Long idResposta) throws SQLException {
		avaliacaoDao.insert(avaliacao, idColaborador, idResposta);
	}

}
