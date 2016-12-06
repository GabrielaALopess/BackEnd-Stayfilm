package br.com.senai.stayFilm.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.stayFilm.dao.implementation.AttachmentDao;
import br.com.senai.stayFilm.model.Attachment;

@CrossOrigin
@RestController
public class AttachmentRestController {
	
	@Autowired
	private AttachmentDao attachmentDao;
	
	@RequestMapping(value = "/insert/attachment", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Attachment> inserir(
			@RequestBody Attachment attachment) throws SQLException {
		try {
			attachmentDao.insert(attachment);
			URI location = new URI("/attachment" + attachment.getIdAttachment());
			return ResponseEntity.created(location).body(attachment);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new ResponseEntity<>(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	
}
