package br.com.senai.stayFilm.controller;

import java.net.URI;
import java.util.HashMap;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.auth0.jwt.JWTSigner;

import br.com.senai.stayFilm.dao.implementation.UsuarioDao;
import br.com.senai.stayFilm.model.Usuario;

public class UsuarioRestController {
	public static final String SECRET="senaistayfilm";
	public static final String ISSUER="http://www.sp.senai.br";
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@RequestMapping(value="/usuario", method=RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Usuario>inserir(@RequestBody Usuario usuario){
		try{
			usuarioDao.inserirUsuario(usuario);
			URI location= new URI("/usuario");
			return ResponseEntity.created(location).body(usuario);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST, 
    		consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
    		produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> logar(@RequestBody Usuario usuario){
		try {
			usuario = usuarioDao.logar(usuario);
			if(usuario !=null){
				//data de emissao do token "issured at"
				long iat = System.currentTimeMillis() / 1000;
				
				//data de expiracao do token
				long  exp = iat + 86400;
				
				// objeto qye ura gerar o token
				JWTSigner signer= new JWTSigner(SECRET);
				HashMap<String, Object> claims = new HashMap<>();
				
				claims.put("iat",iat);
				claims.put("exp", exp);
				claims.put("iss",ISSUER);
				claims.put("id_usuario", usuario.getIdUsuario());
				//gerar o token
				
				String jwt = signer.sign(claims);
				JSONObject token = new JSONObject();
				token.put("token", jwt);
				return  ResponseEntity.ok(token.toString());
				
			}else{
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}


