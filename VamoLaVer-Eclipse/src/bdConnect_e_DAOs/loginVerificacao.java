package bdConnect_e_DAOs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class loginVerificacao
 */
@WebServlet("/loginVerificacao")
public class loginVerificacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con;
	ResultSet rs;
	Statement st;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String ref = request.getHeader("referer");
			String formName = request.getParameter("formName");
			String url = null;
			/*
			 * if (ref.equals(
			 * "http://localhost:8081/VamoLaVer-Eclipse/new-event.html")) { if
			 * (request.getSession().getAttribute("usuarioLogado") != null) {
			 * url = "/newEventVerificacao.jsp"; } else { url =
			 * "/loginNewEventErro.jsp"; } } else { if
			 * (request.getSession().getAttribute("usuarioLogado") != null) {
			 * con = new BDConnect().setDbLink(); st = con.createStatement(); rs
			 * = st.executeQuery("select * form usuario");
			 * 
			 * while (rs.next()) { if
			 * (rs.getString("usuEmail").equals(request.getParameter(
			 * "login-campo-email")) &&
			 * rs.getString("usuSenha").equals(request.getParameter(
			 * "login-campo-senha"))) {
			 * request.getSession().setAttribute("usuarioLogado",
			 * rs.getString("usuEmail")); url = "/logadoComSucesso.jsp"; break;
			 * } } if (request.getSession().getAttribute("usuarioLogado") ==
			 * null) { url = "/loginCampoIncorreto"; } } else { url =
			 * "/usuarioJaLogado.jsp"; } }
			 */

											// ESQUEMA PARA "RECARREGAR AS PÃ�GINAS" E EXIBIR AS NOTIFICAÃ‡OES
			// String lhp = "loginHomePage";
			// String lcu = "loginContactUs";
			// String lne = "loginNewEvent";
			// if (formName.equals(lhp))
			// url = "/home-page.html";
			//
			// if (formName.equals(lcu))
			// url = "/contac-us.html";
			//
			// if (formName.equals(lne))
			// url = "/new-event.html";

			// switch (formName) {//NÃƒO SEI POR QUÃŠ NÃƒO DA CERTO
			// case "loginHomePage":
			// url = "/home-page.html";
			// break;
			// case "loginContactUs":
			// url = "/contact-us.html";
			// break;
			// case "loginNewEvent":
			// url = "/new-event.html";
			// break;
			// }

			if (formName.equals("login")) {
				if (request.getSession().getAttribute("usuarioLogado") != null) {
					url = "/usuarioJaLogado.jsp";
					// CONCATENA COM O PARAMETRO QUE SERÃ� LIDO NO SCRIPT APÃ“S O
					// CARREGAMENTO DA PÃ�GINA
				} else {

					con = new BDConnect().setDbLink();
					st = con.createStatement();
					rs = st.executeQuery("select * from usuario");

					while (rs.next()) {
						if (rs.getString("usuEmail").equals(request.getParameter("login-campo-email"))
								&& rs.getString("usuSenha").equals(request.getParameter("login-campo-senha"))) {
							request.getSession().setAttribute("usuarioLogado", rs.getString("usuEmail"));
							url = "/logadoComSucesso.jsp";
							// AQUI TAMBÃ‰M CONCATENA O NOME DO USUÃ�RIO PARA SER
							// EXIBIDO EM UMA MENSAGEM DE BEM VINDO
							break;
						}
					}
					if (request.getSession().getAttribute("usuarioLogado") == null) {
						url = "/loginCampoIncorreto.jsp";// "/loginCampoIncorreto";
					}
				}
			} else {
				if (request.getSession().getAttribute("usuarioLogado") != null) {
					url = "/newEventVerificacao";
				} else {
					url = "/loginNewEventErro.jsp";// "/loginNewEventErro.jsp";
				}
			}
			request.setAttribute("voltarPara", ref);
			request.getRequestDispatcher(url).forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
