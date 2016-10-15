package br.com.senai.stayFilm.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.dao.implementation.RespostaDao;
import br.com.senai.stayFilm.model.Resposta;

@RestController
public class RespostaController {

	@Autowired
	private GenericDao respostaDao = new RespostaDao();

	@RequestMapping(value = "/resposta", method = RequestMethod.POST)
	public ResponseEntity<Resposta> inserir(@RequestBody Resposta resposta) throws SQLException {

		try {
			respostaDao.inclui(resposta);
			URI location = new URI("/usuario" + resposta.getIdResposta());
			return ResponseEntity.created(location).body(resposta);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new ResponseEntity<>(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
