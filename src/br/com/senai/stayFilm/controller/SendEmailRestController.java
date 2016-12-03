package br.com.senai.stayFilm.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.stayFilm.bo.SendEmaiBo;

@CrossOrigin
@RestController
public class SendEmailRestController {

	public SendEmaiBo sendEmailBo;
}
