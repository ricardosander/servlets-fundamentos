package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns = "/busca")
public class BuscaEmpresa extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String filtro = req.getParameter("filtro");

		EmpresaDAO empresaDAO = new EmpresaDAO();
		Collection<Empresa> empresas = empresaDAO.buscaPorSimilaridade(filtro);

		PrintWriter writer = resp.getWriter();

		writer.println("<html>");
		writer.println("<body>");
		writer.println("Resultado da busca:<br/>");

		writer.write("<ul>");

		for (Empresa empresa : empresas) {

			writer.write("<li>");
			writer.write(empresa.getId() + ": " + empresa.getNome());
			writer.write("</li>");
		}

		writer.write("</ul>");

		writer.println("</body>");
		writer.println("</html>");
	}
}
