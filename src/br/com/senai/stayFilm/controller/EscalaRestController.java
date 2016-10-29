package br.com.senai.stayFilm.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Escala;

@RestController
public class EscalaRestController {

	@Autowired
	@Qualifier("escalaDao")
	private GenericDao<Escala> escalaDao;

	@RequestMapping(value = "/escala/{idColaborador}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Escala> inserir(@PathVariable Long idColaborador, @RequestBody Escala escala)
			throws SQLException {

		try {
			escalaDao.insertWithKey(escala, idColaborador);
			URI location = new URI("/escala" + escala.getIdColaborador());
			return ResponseEntity.created(location).body(escala);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new ResponseEntity<>(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/escala/editar/{idEscala}/{idColaborador}", method = RequestMethod.PUT)
	public Escala altera(@RequestBody Escala escala, @PathVariable long idColaborador) throws SQLException {
		return escalaDao.updateWithKey(escala, idColaborador);
	}
	
	@RequestMapping(value = "/escala/{idEscala}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> remover(@PathVariable long idEscala) throws SQLException {
		escalaDao.delete(idEscala);
		return ResponseEntity.noContent().build();
	}

}
