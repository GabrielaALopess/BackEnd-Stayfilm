package br.com.senai.stayFilm.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.stayFilm.bo.RespostaBO;
import br.com.senai.stayFilm.model.Resposta;
import br.com.senai.stayFilm.model.RespostaFront;
import br.com.senai.stayFilm.sendMail.SendMail;
import br.com.senai.stayFilm.viewModel.RespostaViewModel;
import br.com.senai.stayFilm.vizualizacao.viewModel.RespostaVisualizacaoViewModel;

/**
 * 23/10/2016
 * @author Equipe StayFilme
 * Controller de Resposta
 */
@CrossOrigin
@RestController
public class RespostaRestController {


	@Autowired
	public RespostaBO respostaBo;


	/**
	 *  metodo responsavel por cadastrar uma resposta 
	 * @param viewModel
	 * @return Resposta resposta; return 201 created 
	 * @throws SQLException
	 */
	@RequestMapping(value = "/private/resposta", method = RequestMethod.POST)
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
	
	/**
	 * metodo responsavel por realizar o 
	 * @param idResposta
	 * @return
	 * @throws SQLException
	 */

	@RequestMapping(value = "/resposta/{idResposta}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Resposta pesquisarResposta(@PathVariable Long idResposta) throws SQLException {
		return respostaBo.search(idResposta);
	}


	/**
	 * metodo responsavel por listar todas as respostas cadastradas, ordenada por titulo em ordem alfabetica
	 * @return
	 */
	@RequestMapping(value="/respostas", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE) 
	public List<Resposta> pesquisar(){
		return respostaBo.ListarTodos();
	}

	/**
	 *  Metodo responsavel por realizar o editar a resposta passando o id no body e no  uri
	 * @param resposta
	 * @return 200 sucess ! -> resposta do front- alterado com sucsso .
	 * @throws SQLException
	 */
	@RequestMapping(value = "/private/resposta/editar/{idResposta}", method = RequestMethod.PUT)
	public Resposta altera(@RequestBody Resposta resposta) throws SQLException {
		return respostaBo.update(resposta);

	}

	/**
	 * metodo responsavel por excluir uma reposta.
	 * @param idResposta
	 * @return  null <- 204 no contest <- indicar uma resposta no front-como removido com sucesso!
	 * @throws SQLException
	 */
	@RequestMapping(value = "/private/resposta/remove/{idResposta}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> remover(@PathVariable long idResposta) throws SQLException {
		respostaBo.delete(idResposta);
		return ResponseEntity.noContent().build();
	}
	
	
	/**
	 * Metodo utilizado no envio de uma resposta
	 * 
	 * @param viewModel
	 * @throws SQLException
	 */
	@RequestMapping(value = "/sendResposta", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void recuperarSenha(@RequestBody RespostaFront mensagem, RespostaFront assunto) throws SQLException {
		
		new Thread() {
			
				public void run() {
					
					super.run();

					SendMail sendMail = new SendMail();
					String from = "correo.stayfilm@gmail.com";
					String to = "sf-senai@googlegroups.com";
					String subject = "MOTIVO DA REPROVAÇÃO: "+ " -- " + assunto.getAssunto()+" -- " ;
					String message = "O Filme não poderá ser aprovado devido:\n"+
							mensagem.getMensagem() + ", recomendamos um tema diferente.\n"
									+ "Obrigado! =)";
					sendMail.sendMail(from, to, subject, message);
					System.out.println(message);
				}
			}.start();


		}
}
