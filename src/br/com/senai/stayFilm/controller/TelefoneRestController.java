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

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Telefone;

public class TelefoneRestController {

//	@Autowired
//	@Qualifier("telefoneDao")
//	private GenericDao<Telefone> telefoneDao;
//
//	@RequestMapping(value = "/telefone", method = RequestMethod.POST)
//	public ResponseEntity<Telefone> inserir(@RequestBody Telefone telefone) throws SQLException {
//
//		try {
//			telefoneDao.inclui(telefone);
//			URI location = new URI("/telefone" + telefone.getIdTelefone());
//			return ResponseEntity.created(location).body(telefone);
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//			return new ResponseEntity<>(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}
//
//	@RequestMapping(value = "/resposta/{idTelefone}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public Telefone pesquisarAtividade(@PathVariable Long idTelefone) throws SQLException {
//		return telefoneDao.pesquisa(idTelefone);
//
//	}
//
//	@RequestMapping(value = "/resposta/editar/{idTelefone}", method = RequestMethod.PUT)
//	public Telefone altera(@RequestBody Telefone telefone) throws SQLException {
//		return telefoneDao.altera(telefone);
//
//	}
//
//	@RequestMapping(value = "/resposta/{idTelefone}", method = RequestMethod.DELETE)
//	public ResponseEntity<Void> remover(@PathVariable long idTelefone) throws SQLException {
//		telefoneDao.exclui(idTelefone);
//		return ResponseEntity.noContent().build();
//	}

}