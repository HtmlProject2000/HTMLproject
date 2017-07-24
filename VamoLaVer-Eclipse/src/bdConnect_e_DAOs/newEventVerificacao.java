package bdConnect_e_DAOs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Servlet implementation class newEventVerificacao
 */
@WebServlet("/newEventVerificacao")
public class newEventVerificacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public newEventVerificacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/eventoDao";
		List<String> erros = new ArrayList<>();
		String evNome = request.getParameter("campo-nome");
		String evLocal = request.getParameter("campo-local");
		String evCategoria = request.getParameter("campo-categ");
		String evDescricao = request.getParameter("campo-desc");
		String evData =request.getParameter("campo-data");
		int evQtPessoas;
		int evPontuacao = 0;
		String evElaborador = "e@gmail.com";
		

		if (evData.equals("")) {
			erros.add("Data não informada.");
		} 
		
		if (request.getParameter("campo-qndPessoas").equals("")) {
			evQtPessoas = 0;
		} else {
			evQtPessoas = Integer.parseInt(request.getParameter("campo-qndPessoas"));
		}

		if (evNome.equals("")) {
			erros.add("Nome do evento não informado.");
		}

		if (evDescricao.equals("")) {
			erros.add("Descrição não Informada.");
		}

		if (evCategoria.equals("")) {
			erros.add("Categoria não Informada.");
		}

		if (erros.size() > 0) {
			request.setAttribute("erros", erros);
			url = "/newEventErros.jsp";

		} else {
			request.setAttribute("evNome", evNome);
			request.setAttribute("evLocal", evLocal);
			request.setAttribute("evCategoria", evCategoria);
			request.setAttribute("evDescricao", evDescricao);
			request.setAttribute("evQtPessoas", evQtPessoas);
			request.setAttribute("evData", evData);
			request.setAttribute("evPontuacao", evPontuacao);
			request.setAttribute("evElaborador", evElaborador);

		}

		request.getRequestDispatcher(url).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
