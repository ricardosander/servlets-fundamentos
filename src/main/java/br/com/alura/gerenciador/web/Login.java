package br.com.alura.gerenciador.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

@WebServlet(urlPatterns = "/login")
public class Login implements Model {

	public String executa(HttpServletRequest request, HttpServletResponse response) {

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);

		String mensagem = "Usuário e senha não existem!";
		if (usuario != null) {

			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuario);
			mensagem = "Usuário logado " + email + " com sucesso!";
		}
		request.setAttribute("mensagem", mensagem);
		return "/WEB-INF/pages/login.jsp";
	}
}
