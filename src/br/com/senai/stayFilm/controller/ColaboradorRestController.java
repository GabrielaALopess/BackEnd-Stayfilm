package br.com.senai.stayFilm.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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

	/**
	 * Método para cadastrar um colaborador 
	 * @param viewModel
	 * @return
	 * @throws SQLException
	 */
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
	
	/**
	 * Para listar todos os colaboradores que estao salvos
	 * @return
	 */
	@RequestMapping(value = "/listarColaboradores", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Colaborador> listarTodosColaboradores(){
		return colaboradorBO.listarTodos();
	}
	
	
	/**
	 * Alterar os dados do colaborador
	 * @param colaborador
	 * @param idColaborador
	 * @throws SQLException
	 */
	@Transactional
	@RequestMapping(value = "/colaborador/editar/{idColaborador}", method = RequestMethod.PUT)
	public void altera(@RequestBody Colaborador colaborador, @PathVariable Long idColaborador) throws SQLException {
		colaboradorBO.atualizar(colaborador, idColaborador);
	}
	
	
	/**
	 * Metodo para preencher os dados dos colaboradores 
	 * (tela de transicao entre a lista de colaboradores e a acao do alterar)
	 * @param idColaborador
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/colaborador/busca/{idColaborador}", method = RequestMethod.GET)
	public Colaborador buscarPorId(@PathVariable Long idColaborador) throws SQLException {
		return colaboradorBO.buscarPorId(idColaborador);
	}
	
}
