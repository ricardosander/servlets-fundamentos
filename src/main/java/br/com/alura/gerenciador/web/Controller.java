package br.com.alura.gerenciador.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.util.StringUtils;

@WebServlet(urlPatterns = "/app/*")
public class Controller extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {

		String uri = request.getRequestURI();
		String[] split = uri.split("/");

		if (split == null || split.length < 4) {
			throw new IllegalArgumentException("Você esqueceu de passar a tarefa.");
		}

		String model = StringUtils.capitalize(split[3]);
		String nomeDaClasse = "br.com.alura.gerenciador.web." + model;
		try {

			Class<?> type = Class.forName(nomeDaClasse);
			Model controller = (Model) type.newInstance();
			String pagina = controller.executa(request, response);
			request.getRequestDispatcher(pagina).forward(request, response);

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
