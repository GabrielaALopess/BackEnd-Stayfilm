package br.com.senai.stayFilm.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWTSigner;

import br.com.senai.stayFilm.bo.ColaboradorBo;
import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.viewModel.ColaboradorViewModel;
import br.com.senai.stayFilm.vizualizacao.viewModel.ColaboradorVisualizacaoViewModel;

/**
 * 23/10/2016
 * 
 * @author Equipe StayFilme Controller de Colaborador
 */
@CrossOrigin
@RestController
public class ColaboradorRestController {
	
	public static final String SECRET="senaistayfilm";
	public static final String ISSUER="http://www.sp.senai.br";

	@Autowired
	public ColaboradorBo colaboradorBO;
	
	

	/**
	 * Método para cadastrar um colaborador 
	 * @param viewModel
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/private/colaborador", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
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
	@RequestMapping(value = "private/colaborador/busca/{idColaborador}", method = RequestMethod.GET)
	public Colaborador buscarPorId(@PathVariable Long idColaborador) throws SQLException {
		return colaboradorBO.buscarPorId(idColaborador);
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST, 
    		consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
    		produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> logar(@RequestBody Colaborador colaborador){
		try {
			
			colaborador = colaboradorBO.realizaLogin(colaborador);
			
			if(colaborador !=null){
				//data de emissao do token "issured at"
				long iat = System.currentTimeMillis() / 1000;
				
				//data de expiracao do token
				long  exp = iat + 36400;
				
				// objeto qye ura gerar o token
				JWTSigner signer= new JWTSigner(SECRET);
				HashMap<String, Object> claims = new HashMap<>();
				
				claims.put("iat",iat);
				claims.put("exp", exp);
				claims.put("iss",ISSUER);
				claims.put("id_colaborador", colaborador.getIdColaborador());
				claims.put("email", colaborador.getEmail());
				claims.put("permissao", colaborador.getPermissao());
				
				//gerar o token
				String jwt = signer.sign(claims);
				JSONObject token = new JSONObject();
				token.put("token", jwt);
				return  ResponseEntity.ok(token.toString());
				
			}else{
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
