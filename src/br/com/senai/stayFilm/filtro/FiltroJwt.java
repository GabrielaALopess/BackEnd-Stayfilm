package br.com.senai.stayFilm.filtro;

import java.io.IOException;
import java.util.Map;

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

import br.com.senai.stayFilm.controller.UsuarioRestController;

@WebFilter("/*")
public class FiltroJwt implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	/*@Override
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
			JWTVerifier verifier= new JWTVerifier(UsuarioRestController.SECRET);
			
			Map<String, Object>claims = verifier.verify(token);
			System.out.println(claims);
			chain.doFilter(req, resp);
			
			// pegar o id do usuário no payload do token (criar o token com o id do usuario)
			// user = userBo.find(id) // buscar usuário para pegar o id do perfil dele
			// permissao = permissaoBo.find(user.idPerfil) // buscar permissão baseado no id do perfil do usuario
			// if permissao != null CONTINUA
			// else FORBIDDEN
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
	
*/
}
