package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns = "/novaEmpresa")
public class NovaEmpresa extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nomeEmpresa = req.getParameter("nome");

		Empresa empresa = new Empresa(nomeEmpresa);
		new EmpresaDAO().adiciona(empresa);

		req.setAttribute("nomeNovaEmpresa", nomeEmpresa);
		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/pages/novaEmpresa.jsp");
		dispatcher.forward(req, resp);
	}
}
