package br.com.senai.stayFilm.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.stayFilm.bo.ColaboradorBo;
import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.viewModel.ColaboradorViewModel;
import br.com.senai.stayFilm.vizualizacao.viewModel.ColaboradorVisualizacaoViewModel;

/**
 * 23/10/2016
 * 
 * @author Equipe StayFilme Controller de Colaborador
 */

@RestController
public class ColaboradorRestController {

	@Autowired
	public ColaboradorBo colaboradorBO;

	@RequestMapping(value = "/colaborador", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ColaboradorVisualizacaoViewModel> inserir(@RequestBody ColaboradorViewModel viewModel) throws SQLException {

		try {
			Colaborador colaborador = viewModel.toColaborador();		
			colaboradorBO.insert(colaborador);
			
			URI location = new URI("/colaborador" + colaborador.getIdColaborador());
			return ResponseEntity.created(location).body(new ColaboradorVisualizacaoViewModel(colaborador));
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new ResponseEntity<>(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/colaborador/{idColaborador}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Colaborador pesquisarColaborador(@PathVariable Long idColaborador) throws SQLException {
//		return colaboradorDao.search(idColaborador);
		return null;
	}

	@RequestMapping(value = "/colaborador/editar/{idColaborador}", method = RequestMethod.PUT)
	public Colaborador altera(@RequestBody Colaborador colaborador, @PathVariable long idColaborador)
			throws SQLException {
//		return colaboradorDao.update(colaborador);
	return null;
	}

	@RequestMapping(value = "/colaborador/{idColaborador}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> remover(@PathVariable long idColaborador) throws SQLException {
//		colaboradorDao.delete(idColaborador);
		return ResponseEntity.noContent().build();
	}

}
