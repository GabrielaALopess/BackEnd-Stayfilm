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
import br.com.senai.stayFilm.model.Resposta;

@RestController
public class RespostaRestController {

	@Autowired
	@Qualifier("respostaDao")
	private GenericDao<Resposta> respostaDao;

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

	@RequestMapping(value = "/resposta/{idResposta}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Resposta pesquisarResposta(@PathVariable Long idResposta) throws SQLException {
		return respostaDao.pesquisa(idResposta);

	}

	@RequestMapping(value = "/resposta/editar/{idResposta}", method = RequestMethod.PUT)
	public Resposta altera(@RequestBody Resposta resposta) throws SQLException {
		return respostaDao.altera(resposta);

	}

	@RequestMapping(value = "/resposta/{idResposta}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> remover(@PathVariable long idResposta) throws SQLException {
		respostaDao.exclui(idResposta);
		return ResponseEntity.noContent().build();
	}

}
