package br.com.senai.stayFilm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.stayFilm.dao.implementation.FilmeDao;
import br.com.senai.stayFilm.enumeration.StatusFilme;
import br.com.senai.stayFilm.enumeration.TemaFilme;
import br.com.senai.stayFilm.model.Filme;

@CrossOrigin
@RestController
public class FilmeRestController {

	@Autowired
	private FilmeDao filmeDao;

	@RequestMapping(value = "/Filmes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Filme> listar() {
		return filmeDao.listarFilme();
	}

	/**
	 * FILTRA OS FILMES POR TEMA
	 * 
	 * @param temafilme
	 * @return
	 */
	@RequestMapping(value = "/Filmes/{temafilme}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Filme> listaTema(@PathVariable TemaFilme temafilme) {
		return filmeDao.listarPorTema(temafilme);
	}

	/**
	 * FILTRA POR STATUS
	 * 
	 * @param statusFilme
	 * @return
	 */
	@RequestMapping(value = "/Filmes/{status}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Filme> listaStatus(@PathVariable StatusFilme statusFilme) {
		return filmeDao.listarPorStatus(statusFilme);
	}

	/**
	 * MEXER NESSE METODO QUE O GUSTAVO TAVA TRABALHANDO , METODO RESPONSAVEL
	 * POR ABRIR O FILME E PEGAR TODAS AS INFORMAÇÕES RELACIONADAS A ELE URLS
	 * TUDO QUE ESTÁ COM ELE FAZER UM MÉTODO PARA MUDAR O STATUS COMO POR
	 * EXEMPLO : APROVADO, REPROVADO EM DO CONTROLLER
	 * 
	 * @param idFilme
	 * @return
	 */

	@RequestMapping(value = "/Filme/{idFilme}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Filme> mudarStatus(@PathVariable long idFilme) {
		try {

		} catch (Exception e) {

		}
		return null;
	}

}
