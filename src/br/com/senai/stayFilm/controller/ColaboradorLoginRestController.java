package br.com.senai.stayFilm.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.stayFilm.bo.ColaboradorLoginBo;
import br.com.senai.stayFilm.model.ColaboradorLogin;
import br.com.senai.stayFilm.sendMail.SendMail;

@RestController
public class ColaboradorLoginRestController {

	@Autowired
	public ColaboradorLoginBo colaboradorLoginBO;

	@RequestMapping(value = "colaborador/colaboradorLogin/{idColaborador}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ColaboradorLogin> inserir(@PathVariable Long idColaborador,
			@RequestBody ColaboradorLogin colaboradorLogin) throws SQLException {
		try {
			colaboradorLoginBO.insert(colaboradorLogin, idColaborador);
			URI location = new URI("/colaborador" + colaboradorLogin.getIdLoginColaborador());
			return ResponseEntity.created(location).body(colaboradorLogin);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new ResponseEntity<>(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	@Transactional
	@RequestMapping(value = "/colaboradorLogin/editar/{idColaboradorLogin}/{idColaborador}", method = RequestMethod.PUT)
	public ColaboradorLogin altera(@RequestBody ColaboradorLogin colaboradorLogin, @PathVariable Long idColaborador) throws SQLException {
	
		SendMail sm = new SendMail("smtp.gmail.com","465");

		String origem = colaboradorLogin.getEmail();
		String destino = "emailDestino";
		String assunto = "Assunto";
		String mensagem = "Teste";
		
		sm.sendMail(origem,destino,assunto,mensagem);


		
		return colaboradorLogin;
	}


}
