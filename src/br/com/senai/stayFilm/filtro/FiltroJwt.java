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


@WebFilter("/*")
public class FiltroJwt implements Filter {


	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
//		chain.doFilter(req, resp);
		
		
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		// primeiro passo dofilter
		
		
		if(request.getMethod().equals("recuperarSenha")){
			chain.doFilter(request, response);
			return;
		}
		
		if(request.getMethod().equals("OPTIONS")){
			chain.doFilter(request, response);
			return;
		}

		//System.out.println("passou aqui " + request);
		if (request.getRequestURI().contains("login") || request.getMethod().equals("recuperarSenha")) {
			chain.doFilter(req, resp);
			return;// ultimo passo doFilter
		}

		String token = request.getHeader("Authorization");
		try {
			//System.out.println("token" + token);
			JWTVerifier verifier = new JWTVerifier(ColaboradorRestController.SECRET);
			Map<String, Object> claims = verifier.verify(token);
			long colaboradorId = (int) claims.get("id_colaborador");
			request.setAttribute("id_colaborador", colaboradorId);

			if (!request.getRequestURI().contains("private")) {
				chain.doFilter(req, resp);
				return;
			} else {
				TipoPermissao permissao = TipoPermissao.valueOf(claims.get("permissao").toString());

				if (permissao == TipoPermissao.ADMINISTRADOR) {
					chain.doFilter(req, resp);
					//System.out.println("caiu aqui 1");
					return;
				} else {
					response.sendError(HttpStatus.FORBIDDEN.value());
					//System.out.println("caiu aqui depois");
					return;
				}
			}
		} catch (Exception e) {
			if (token == null) {
				e.printStackTrace();
				response.sendError(HttpStatus.UNAUTHORIZED.value());
			} else {
				//System.out.println("veio pra ca direto");
				e.printStackTrace();
				response.sendError(HttpStatus.FORBIDDEN.value());
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
