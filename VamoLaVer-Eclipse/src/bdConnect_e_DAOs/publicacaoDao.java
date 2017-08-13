package bdConnect_e_DAOs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
@WebServlet("/publicacaoDao")
public class publicacaoDao extends HttpServlet {
	Connection con;
	ResultSet rs;
	PreparedStatement pstmt;
	String url;
	private static final long serialVersionUID = 1L;
       
 
    public publicacaoDao() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void inserirPublicacao(publicacao p) throws SQLException{
    	
    	pstmt = con.prepareStatement("insert into publicacao values (?,?,?)");
    	pstmt.setString(1,p.getEvId());
    	pstmt.setString(2,p.getUsuEmail());
    	pstmt.setString(3,p.getData());
    	pstmt.executeUpdate();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String usuLogado = (String) request.getSession().getAttribute("usuarioLogado");
			try {
				con = new BDConnect().setDbLink();
				pstmt = con.prepareStatement("select * from evento");
				rs = pstmt.executeQuery();
				rs.last();
				Date date = new Date();
				publicacao p = new publicacao(usuLogado, rs.getString("evId"),new SimpleDateFormat("yyyy-MM-dd").format(date));
				inserirPublicacao(p);
				url = "/novoEventoAdicionado.jsp";
				
				request.getRequestDispatcher(url).forward(request,response);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
