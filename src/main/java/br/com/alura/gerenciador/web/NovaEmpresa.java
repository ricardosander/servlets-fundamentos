package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

public class NovaEmpresa implements Model {

	public String executa(HttpServletRequest request, HttpServletResponse response) {

		String nomeEmpresa = request.getParameter("nome");

		Empresa empresa = new Empresa(nomeEmpresa);
		new EmpresaDAO().adiciona(empresa);

		request.setAttribute("nomeNovaEmpresa", nomeEmpresa);
		return "/WEB-INF/pages/novaEmpresa.jsp";
	}
}
