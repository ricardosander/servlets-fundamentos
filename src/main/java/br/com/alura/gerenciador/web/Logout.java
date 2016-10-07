package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.web.Cookies;

@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario.logado");

		String mensagem = "Usuário deslogado com sucesso.";
		if (usuario != null) {
			req.getSession().removeAttribute("usuario.logado");
		} else {
			mensagem = "Usuário não estava logado.";
		}

		PrintWriter writer = resp.getWriter();
		writer.write("<html><body>" + mensagem + "</body></html>");
	}
}
