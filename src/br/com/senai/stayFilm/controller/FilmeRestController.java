package br.com.senai.stayFilm.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class FilmeRestController {

//	@Autowired
//	private FilmeDao filmeDao;
//	
//	
//	
//
//	
//	@RequestMapping(value="/Filmes",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public List<Filme> listar(){
//		return filmeDao.listarFilme();
//	}
//	
//	/**
//	 * FILTRA OS FILMES POR TEMA
//	 * @param temafilme
//	 * @return
//	 */
//	@RequestMapping(value="/Filmes/{temafilme}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public List<Filme> listaTema(@PathVariable TemaFilme temafilme){
//		return filmeDao.listarPorTema(temafilme);
//	}
//	
//	/**
//	 * FILTRA POR STATUS
//	 * @param statusFilme
//	 * @return
//	 */
//	@RequestMapping(value="/Filmes/{status}",method=RequestMethod.GET,
//						produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public List<Filme> listaStatus(@PathVariable StatusFilme statusFilme){
//		return filmeDao.listarPorStatus(statusFilme);
//	}
//	
//	
//	/**
//	 * MEXER NESSE METODO 	QUE O GUSTAVO TAVA TRABALHANDO , METODO RESPONSAVEL POR ABRIR O FILME 
//	 * E PEGAR TODAS AS INFORMAÇÕES RELACIONADAS A ELE
//	 * URLS TUDO QUE ESTÁ COM ELE
//	 * FAZER UM MÉTODO PARA MUDAR O STATUS COMO POR EXEMPLO : APROVADO, REPROVADO EM DO CONTROLLER
//	 * @param idFilme
//	 * @return
//	 */
//	@RequestMapping(value="/Filme/{idFilme}",  method= RequestMethod.PATCH, 
//			produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Filme>mudarStatus(@PathVariable long idFilme){
//		try {
//			
//		} catch (Exception e) {
//			
//		}
//		return null;
//	}
//	
//	
//	
//	
//	
	
	
	
	
}
