import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.web.Cookies;

@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Cookie usuarioLogado = new Cookies(req.getCookies()).buscaUsuarioLogado();

		String mensagem = "Usuário deslogado com sucesso.";
		if (usuarioLogado != null) {

			usuarioLogado.setMaxAge(0);
			resp.addCookie(usuarioLogado);
		} else {
			mensagem = "Usuário não estava logado.";
		}

		PrintWriter writer = resp.getWriter();
		writer.write("<html><body>" + mensagem + "</body></html>");
	}
}
