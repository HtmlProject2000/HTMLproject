package bdConnect_e_DAOs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class usuarioDao
 */
@WebServlet("/usuarioDao")
public class usuarioDao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    Connection con;
    ResultSet rs;
    Statement stmt;
    PreparedStatement pstmt;
    public usuarioDao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws SQLException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void inserirUsuario(usuario u) throws SQLException{
    	con = new BDConnect().setDbLink();
    	String sql= "insert into usuario (usuNome,usuEmail,usuSenha) values (?,?,?)";
    	pstmt = con.prepareStatement(sql);
    	pstmt.setString(1,u.getNome());
    	pstmt.setString(2,u.getEmail());
    	pstmt.setString(3,u.getSenha());
    	pstmt.executeUpdate(sql);
    	pstmt.close();
    	con.close();
    	return;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset= 'UTF-8'");
		PrintWriter out = response.getWriter();
		out.println("<h1>CHEGAMOS AO USUARIODAO</h1>");
		
		try {
			
			String usuNome = (String) request.getAttribute("usuNome");
			String usuSenha = (String) request.getAttribute("usuSenha");
			String usuEmail = (String) request.getAttribute("usuEmail");
			usuario user = new usuario(usuEmail,usuNome,usuSenha);
			inserirUsuario(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.println("<h1>SUCESSO VIADO!</h1>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
