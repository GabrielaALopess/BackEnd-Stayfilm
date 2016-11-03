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

import br.com.senai.stayFilm.ViewModel.RespostaViewModel;
import br.com.senai.stayFilm.bo.RespostaBO;
import br.com.senai.stayFilm.model.Resposta;
import br.com.senai.stayFilm.vizualizacao.viewModel.RespostaVisualizacaoViewModel;

/**
 * 23/10/2016
 * @author Equipe StayFilme
 * Controller de Resposta
 */
@RestController
public class RespostaRestController {


	@Autowired
	public RespostaBO respostaBo;


	
	@RequestMapping(value = "/resposta", method = RequestMethod.POST)
	public ResponseEntity<RespostaVisualizacaoViewModel> inserir(@RequestBody RespostaViewModel viewModel) throws SQLException {

		try {
			Resposta resposta = viewModel.toResposta();
			respostaBo.insert(resposta);
			URI location = new URI("/resposta" + resposta.getIdResposta());
			return ResponseEntity.created(location).body(new RespostaVisualizacaoViewModel(resposta));
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new ResponseEntity<>(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

//	@RequestMapping(value = "/resposta/{idResposta}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public Resposta pesquisarResposta(@PathVariable Long idResposta) throws SQLException {
//		return respostaDao.search(idResposta);
//
//	}
//
//	@RequestMapping(value = "/resposta/editar/{idResposta}", method = RequestMethod.PUT)
//	public Resposta altera(@RequestBody Resposta resposta) throws SQLException {
//		return respostaDao.update(resposta);
//
//	}
//
//	@RequestMapping(value = "/resposta/{idResposta}", method = RequestMethod.DELETE)
//	public ResponseEntity<Void> remover(@PathVariable long idResposta) throws SQLException {
//		respostaDao.delete(idResposta);
//		return ResponseEntity.noContent().build();
//	}
}
