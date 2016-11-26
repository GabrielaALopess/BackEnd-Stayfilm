package br.com.senai.stayFilm.filtro;

import com.auth0.jwt.internal.org.bouncycastle.i18n.filter.Filter;

//import br.com.senai.stayFilm.controller.UsuarioRestController;

//@WebFilter("/*")
public class FiltroJwt implements Filter {

	@Override
	public String doFilter(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String doFilterUrl(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public void destroy() {
//
//	}
//
//	@Override
//	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
//			throws IOException, ServletException {
//		HttpServletRequest request = (HttpServletRequest) req;
//		HttpServletResponse response = (HttpServletResponse) resp;
//		// primeiro passo dofilter
//
//		System.out.println("passou aqui " + request);
//		if (request.getRequestURI().contains("login")) {
//			chain.doFilter(req, resp);
//			return;// ultimo passo doFilter
//		}
//
//		String token = request.getHeader("Authorization");
//		try {
//			System.out.println("token" + token);
//			JWTVerifier verifier = new JWTVerifier(ColaboradorRestController.SECRET);
//			Map<String, Object> claims = verifier.verify(token);
//			long colaboradorId = (int) claims.get("id_colaborador");
//			request.setAttribute("id_colaborador", colaboradorId);
//
//			if (!request.getRequestURI().contains("private")) {
//				chain.doFilter(req, resp);
//				return;
//			} else {
//				TipoPermissao permissao = TipoPermissao.valueOf(claims.get("permissao").toString());
//
//				if (permissao == TipoPermissao.ADMINISTRADOR) {
//					chain.doFilter(req, resp);
//					System.out.println("caiu aqui 1");
//					return;
//				} else {
//					response.sendError(HttpStatus.FORBIDDEN.value());
//					System.out.println("caiu aqui depois");
//					return;
//				}
//			}
//		} catch (Exception e) {
//			if (token == null) {
//				e.printStackTrace();
//				response.sendError(HttpStatus.UNAUTHORIZED.value());
//			} else {
//				System.out.println("veio pra ca direto");
//				e.printStackTrace();
//				response.sendError(HttpStatus.FORBIDDEN.value());
//			}
//		}
//	}
//
//	@Override
//	public void init(FilterConfig arg0) throws ServletException {
//
//	}

}
