package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		Cookie[] cookies = req.getCookies();
		String usuario = getUsuarioLogado(cookies);

		System.out.println("Usuário " + usuario + " acessando URI: " + req.getRequestURI());

		chain.doFilter(request, response);
	}

	private String getUsuarioLogado(Cookie[] cookies) {

		String usuario = "<deslogado>";

		if (cookies == null) {
			return usuario;
		}

		for (Cookie cookie : cookies) {

			if (cookie.getName().equals("email.logado")) {
				return cookie.getValue();
			}
		}
		return usuario;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
