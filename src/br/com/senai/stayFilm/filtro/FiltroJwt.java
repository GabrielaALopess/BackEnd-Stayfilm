package br.com.senai.stayFilm.filtro;

import java.io.IOException;
import java.util.Map;

//import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;

import com.auth0.jwt.JWTVerifier;

import br.com.senai.stayFilm.controller.ColaboradorRestController;
import br.com.senai.stayFilm.enumeration.TipoPermissao;

//import br.com.senai.stayFilm.controller.UsuarioRestController;

@WebFilter("/*")
public class FiltroJwt implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
	//primeiro passo dofilter
	if (request.getRequestURI().contains("login")){
		chain.doFilter(req, resp);
		return;//ultimo passo doFilter
	}
	
	String token = request.getHeader("Authorization");
		try {
			JWTVerifier verifier= new JWTVerifier(ColaboradorRestController.SECRET);			
			Map<String, Object>claims = verifier.verify(token);
			//claims.get("colaborador_id");
			//System.out.println(claims);			
			// pegar o id do usuário no payload do token (criar o token com o id do usuario)
			if(request.getRequestURI().contains("/curadoria") || 
					request.getRequestURI().contains("/escala") || 
					request.getRequestURI().contains("/colaborador")){
				chain.doFilter(req, resp);
				return;
			}
					
			TipoPermissao permissao = (TipoPermissao) claims.get("permissao");
			if(permissao == TipoPermissao.ADMINISTRADOR){
				chain.doFilter(req, resp);
				return;
			}else{
				response.sendError(HttpStatus.FORBIDDEN.value());
				return;
			}
		} catch (Exception e) {
			if(token ==null){
				response.sendError(HttpStatus.UNAUTHORIZED.value());
			}else{
				response.sendError(HttpStatus.FORBIDDEN.value());
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
