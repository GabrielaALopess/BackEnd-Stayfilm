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

import br.com.senai.stayFilm.bo.EnderecoBo;
import br.com.senai.stayFilm.model.Endereco;
import br.com.senai.stayFilm.vizualizacao.viewModel.EnderecoVisualizacaoViewModel;

/**
 * 22/10/2016
 * 
 * @author Equipe Stayfilm Controller do Endereco
 */

@CrossOrigin
@RestController
public class EnderecoRestController {

	@Autowired
	
	private EnderecoBo enderecoBO;

	/**
	 * Metodo responsavel por inserir o endereco
	 * @param idColaborador
	 * @param endereco
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/endereco/{idColaborador}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<EnderecoVisualizacaoViewModel> inserir(@PathVariable Long idColaborador, @RequestBody Endereco endereco)
			throws SQLException {

		try {
			enderecoBO.insert(endereco, idColaborador);
			URI location = new URI("/endereco" + endereco.getIdColaborador());
			return ResponseEntity.created(location).body(new EnderecoVisualizacaoViewModel(endereco));
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new ResponseEntity<>(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	
	/**
	 * Esse  metodo e responsavel por retornar o endereco preenchido para edicao
	 * @param idEndereco
	 * @return
	 * @throws SQLException/endereco/{idEndereco}
	 */
	@RequestMapping(value = "/endereco/{idEndereco}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Endereco pesquisarEndereco(@PathVariable Long idEndereco) throws SQLException {
		return enderecoBO.buscarPorId(idEndereco);
	}

	
	/**
	 * Esse  metodo e responsavel por retornar o endereco preenchido para edicao
	 * @param idColaborador
	 * @return
	 * @throws SQLException/endereco/{idColaborador}
	 */
	@RequestMapping(value = "/buscarEndereco/{idColaborador}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Endereco pesquisarEnderecoColaborador(@PathVariable long idColaborador) throws SQLException {
		return enderecoBO.buscarEnderecoColab(idColaborador);
	}
	

	/**
	 * Metodo para alterar os dados do endereco do colaborador
	 * @param endereco
	 * @param idColaborador
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/endereco/editar/{idEndereco}/{idColaborador}", method = RequestMethod.PUT)
	public Endereco altera(@RequestBody Endereco endereco, @PathVariable long idColaborador) throws SQLException {
		return enderecoBO.edit(endereco, idColaborador);
	}


	/**
	 * Metodo implementado, porem nao utilizado
	 * @param idEndereco
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/endereco/{idEndereco}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> remover(@PathVariable long idEndereco) throws SQLException {
		return ResponseEntity.noContent().build();
	}

}
