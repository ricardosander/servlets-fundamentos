package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Usuario;

@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario.logado");
;
		if (usuario != null) {
			req.getSession().removeAttribute("usuario.logado");
		} 
		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/pages/logout.html");
		dispatcher.forward(req, resp);
	}
}
