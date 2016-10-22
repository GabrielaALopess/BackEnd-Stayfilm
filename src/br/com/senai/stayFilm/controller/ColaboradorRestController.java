package br.com.senai.stayFilm.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.Endereco;

@RestController
public class ColaboradorRestController {

	@Autowired
	@Qualifier("colaboradorDao")
	private GenericDao<Colaborador> colaboradorDao;

	@RequestMapping(value = "/colaborador", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Colaborador> inserir(@RequestBody Colaborador colaborador) throws SQLException {

		try {
			colaboradorDao.inclui(colaborador);
			URI location = new URI("/colaborador" + colaborador.getIdColaborador());
			return ResponseEntity.created(location).body(colaborador);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new ResponseEntity<>(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
