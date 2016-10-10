package br.com.alura.gerenciador.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/executa")
public class Controller extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
		String tarefa = request.getParameter("tarefa");
		
		if (tarefa == null) {
			throw new IllegalArgumentException("Você esqueceu de passar a tarefa."); 
		}
		
		String nomeDaClasse = "br.com.alura.gerenciador.web." + tarefa;
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
