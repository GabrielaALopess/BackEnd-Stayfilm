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
	 * Metodo utilizado para salvar a avaliacao
	 * @param viewModel
	 * @param idColaborador
	 * @param idResposta
	 * @param idFilme
	 * @return
	 * @throws SQLException
	 * @throws URISyntaxException
	 */
	@RequestMapping(value = "/avaliacao/{idResposta}/{idFilme}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<AvaliacaoVisualizacaoViewModel> inserir(@RequestBody AvaliacaoViewModel viewModel,
			 @PathVariable Long idResposta,@PathVariable Long idFilme) throws SQLException, URISyntaxException {
		try {
			Avaliacao avaliacao = viewModel.toAvaliacao();
			avaliacaoBO.insert(avaliacao, idResposta, idFilme);
			URI location = new URI("/avaliacao/resposta/filme" + avaliacao.getIdResposta());
			return ResponseEntity.created(location).body(new AvaliacaoVisualizacaoViewModel(avaliacao));
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseEntity<>(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
}
