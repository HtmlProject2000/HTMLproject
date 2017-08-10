package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bdConnect_e_DAOs.BDConnect;

/**
 * Servlet implementation class PesquisarSimples
 */
@WebServlet("/PesquisarSimples")
public class PesquisarSimples extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection con;
	ResultSet rs;
	Statement st;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PesquisarSimples() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/result-search.jsp";
		String nome = request.getParameter("campo-search");
		ArrayList<String> informacoes = new ArrayList<String>();//criar um array
		String infor = null;
		
		try {
			con = new BDConnect().setDbLink();
			st = con.createStatement();
			rs = st.executeQuery("select * from evento");
			
			while (rs.next()) {
				if(rs.getString("evNome").contains(nome)){
					infor = rs.getString("evNome");
					//adicionar as informações dos eventos encontrados no array
					informacoes.add(infor);
					//fazer um método para desconcatenar as informações do array
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
