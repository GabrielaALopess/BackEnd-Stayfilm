package br.com.senai.stayFilm.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.stayFilm.bo.AvaliacaoBo;
import br.com.senai.stayFilm.enumeration.StatusFilme;
import br.com.senai.stayFilm.model.Avaliacao;
import br.com.senai.stayFilm.viewModel.AvaliacaoViewModel;
import br.com.senai.stayFilm.vizualizacao.viewModel.AvaliacaoVisualizacaoViewModel;



/**
 * FAZER O REDIRECT PARA A TELA DE RESPOSTA 
 * @author Gustavo
 *
 */
@CrossOrigin
@RestController
public class AvaliacaoRestController {

	@Autowired
	public AvaliacaoBo avaliacaoBO;

	/**
	 * Metodo utilizado para salvar a avaliacao que esta aprovada
	 * @param viewModel
	 * @param idColaborador
	 * @param idResposta
	 * @param idFilme
	 * @return
	 * @throws SQLException
	 * @throws URISyntaxException
	 */
	@RequestMapping(value = "/avaliacao/aprovado/{idResposta}/{idFilme}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<AvaliacaoVisualizacaoViewModel> inserir(
			 @RequestBody AvaliacaoViewModel viewModel,
			 @PathVariable Long idResposta,
			 @PathVariable Long idFilme, @PathVariable Long idColaborador) throws SQLException, URISyntaxException {
		try {
			viewModel.setStatusFilme(StatusFilme.APROVADO);	
			Avaliacao avaliacao = viewModel.toAvaliacao();		
			avaliacaoBO.insert(avaliacao,idColaborador ,idResposta, idFilme);
			URI location = new URI("/avaliacao/resposta/filme" + avaliacao.getIdFilme());
			return ResponseEntity.created(location).body(new AvaliacaoVisualizacaoViewModel(avaliacao));
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseEntity<>(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	/**
	 * Metodo utilizado para salvar a avaliacao que esta reprovada
	 * @param viewModel
	 * @param idResposta
	 * @param idFilme
	 * @param idColaborador
	 * @return
	 * @throws SQLException
	 * @throws URISyntaxException
	 */
	@RequestMapping(value = "/avaliacao/reprovado/{idResposta}/{idFilme}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<AvaliacaoVisualizacaoViewModel> inserirReprovado(
			 @RequestBody AvaliacaoViewModel viewModel,
			 @PathVariable Long idResposta,
			 @PathVariable Long idFilme, @PathVariable Long idColaborador) throws SQLException, URISyntaxException {
		try {
			viewModel.setStatusFilme(StatusFilme.REPROVADO);	
			Avaliacao avaliacao = viewModel.toAvaliacao();		
			avaliacaoBO.insert(avaliacao,idColaborador ,idResposta, idFilme);
			URI location = new URI("/avaliacao/resposta/filme" + avaliacao.getIdFilme());
			return ResponseEntity.created(location).body(new AvaliacaoVisualizacaoViewModel(avaliacao));
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseEntity<>(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	/**
	 * Metodo utilizado para salvar a avaliacao que esta em monitoria
	 * @param viewModel
	 * @param idResposta
	 * @param idFilme
	 * @param idColaborador
	 * @return
	 * @throws SQLException
	 * @throws URISyntaxException
	 */
	@RequestMapping(value = "/avaliacao/monitoria/{idResposta}/{idFilme}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<AvaliacaoVisualizacaoViewModel> inserirMonitoria(
			 @RequestBody AvaliacaoViewModel viewModel,
			 @PathVariable Long idResposta,
			 @PathVariable Long idFilme, @PathVariable Long idColaborador) throws SQLException, URISyntaxException {
		try {
			viewModel.setStatusFilme(StatusFilme.MONITORIA);	
			Avaliacao avaliacao = viewModel.toAvaliacao();		
			avaliacaoBO.insert(avaliacao,idColaborador ,idResposta, idFilme);
			URI location = new URI("/avaliacao/resposta/filme" + avaliacao.getIdFilme());
			return ResponseEntity.created(location).body(new AvaliacaoVisualizacaoViewModel(avaliacao));
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseEntity<>(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	/**
	 * Metodo utilizado para salvar a avaliacao quando e favorito
	 * @param viewModel
	 * @param idResposta
	 * @param idFilme
	 * @param idColaborador
	 * @return
	 * @throws SQLException
	 * @throws URISyntaxException
	 */
	@RequestMapping(value = "/avaliacao/favorito/{idResposta}/{idFilme}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<AvaliacaoVisualizacaoViewModel> inserirFavorito(
			 @RequestBody AvaliacaoViewModel viewModel,
			 @PathVariable Long idResposta,
			 @PathVariable Long idFilme, @PathVariable Long idColaborador) throws SQLException, URISyntaxException {
		try {
			viewModel.setStatusFilme(StatusFilme.FAVORITO);	
			Avaliacao avaliacao = viewModel.toAvaliacao();		
			avaliacaoBO.insert(avaliacao,idColaborador ,idResposta, idFilme);
			URI location = new URI("/avaliacao/resposta/filme" + avaliacao.getIdFilme());
			return ResponseEntity.created(location).body(new AvaliacaoVisualizacaoViewModel(avaliacao));
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseEntity<>(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
}
