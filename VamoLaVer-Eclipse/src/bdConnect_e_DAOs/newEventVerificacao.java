package bdConnect_e_DAOs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String evNome = request.getParameter("campo-nome");
		String evLocal = request.getParameter("campo-local");
		String evCategoria = request.getParameter("campo-categ");
		String evDescricao = request.getParameter("campo-desc");
		String evData =request.getParameter("campo-data");
		int evQtPessoas = 0;
		int evPontuacao = 0;
		String evElaborador = null;
		
		if(request.getSession().getAttribute("usuarioLogado") != null){
			evElaborador = request.getSession().getAttribute("usuarioLogado").toString();
			
			if (request.getParameter("campo-qndPessoas").equals("")) {
				evQtPessoas = 0;
			} else {
				evQtPessoas = Integer.parseInt(request.getParameter("campo-qndPessoas"));
			}
			
			request.setAttribute("evNome", evNome);
			request.setAttribute("evLocal", evLocal);
			request.setAttribute("evCategoria", evCategoria);
			request.setAttribute("evDescricao", evDescricao);
			request.setAttribute("evQtPessoas", evQtPessoas);
			request.setAttribute("evData", evData);
			request.setAttribute("evPontuacao", evPontuacao);
			request.setAttribute("evElaborador", evElaborador);
			
		}else{
			url = "/doLogin.jsp";
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
