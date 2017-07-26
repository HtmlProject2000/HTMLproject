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
			String formName= request.getParameter("formName");
			String url = null;
			/*if (ref.equals("http://localhost:8081/VamoLaVer-Eclipse/new-event.html")) {
				if (request.getSession().getAttribute("usuarioLogado") != null) {
					url = "/newEventVerificacao.jsp";
				} else {
					url = "/loginNewEventErro.jsp";
				}
			} else {
				if (request.getSession().getAttribute("usuarioLogado") != null) {
					con = new BDConnect().setDbLink();
					st = con.createStatement();
					rs = st.executeQuery("select * form usuario");

					while (rs.next()) {
						if (rs.getString("usuEmail").equals(request.getParameter("login-campo-email"))
								&& rs.getString("usuSenha").equals(request.getParameter("login-campo-senha"))) {
							request.getSession().setAttribute("usuarioLogado", rs.getString("usuEmail"));
							url = "/logadoComSucesso.jsp";
							break;
						}
					}
					if (request.getSession().getAttribute("usuarioLogado") == null) {
						url = "/loginCampoIncorreto";
					}
				} else {
					url = "/usuarioJaLogado.jsp";
				}
			}*/
			if(formName.equals("login")){
				if (request.getSession().getAttribute("usuarioLogado") != null) {
					url = "/usuarioJaLogado.jsp";
				} else {
					
					con = new BDConnect().setDbLink();
					st = con.createStatement();
					rs = st.executeQuery("select * from usuario");

					while (rs.next()) {
						if (rs.getString("usuEmail").equals(request.getParameter("login-campo-email"))
								&& rs.getString("usuSenha").equals(request.getParameter("login-campo-senha"))) {
							request.getSession().setAttribute("usuarioLogado", rs.getString("usuEmail"));
							url = "/logadoComSucesso.jsp";
							break;
						}
					}
					if (request.getSession().getAttribute("usuarioLogado") == null) {
						url = "/loginCampoIncorreto";
					}
				}
			}else{
				if (request.getSession().getAttribute("usuarioLogado") != null) {
					url = "/newEventVerificacao";
				} else {
					url = "/loginNewEventErro.jsp";
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