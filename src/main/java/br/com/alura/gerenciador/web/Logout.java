package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Usuario;

public class Logout implements Model {

	public String executa(HttpServletRequest request, HttpServletResponse response) {

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
		if (usuario != null) {
			request.getSession().removeAttribute("usuarioLogado");
		} 
		return"/WEB-INF/pages/logout.html";
	}
}
