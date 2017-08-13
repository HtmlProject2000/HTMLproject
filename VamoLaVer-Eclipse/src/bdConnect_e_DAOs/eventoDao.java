package bdConnect_e_DAOs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class eventoDao
 */
@WebServlet("/eventoDao")
public class eventoDao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	ResultSet rs;
	PreparedStatement pstmt;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public eventoDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws SQLException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	public void inserirEvento(Evento e) throws SQLException {
		con = new BDConnect().setDbLink();
		String sql = "insert into evento (evNome, evDescricao, evCategoria, evElaboradorEmail, evLocal, evPontuacao, evDataDeOcorrencia,   evQndPrevistaDePessoas) values(?,?,?,?,?,?,?,?);";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, e.getNome());
		pstmt.setString(2, e.getDescricao());
		pstmt.setString(3, e.getCategoria());
		pstmt.setString(4, e.getElaborador());
		pstmt.setString(5, e.getLocal());
		pstmt.setInt(6, e.getPontuacao());
		pstmt.setString(7, e.getData());
		pstmt.setInt(8, e.getQtPessoas());
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nome = (String) request.getAttribute("evNome");
			String local = (String) request.getAttribute("evLocal");
			String categoria = (String) request.getAttribute("evCategoria");
			String descricao = (String) request.getAttribute("evDescricao");
			int qndPessoas = (int) request.getAttribute("evQtPessoas");
			String data = (String) request.getAttribute("evData");
			int pontuacao = (int) request.getAttribute("evPontuacao");
			String elaborador = (String) request.getAttribute("evElaborador");

			Evento e = new Evento(nome, descricao, categoria, elaborador, local, pontuacao, data, qndPessoas);

			inserirEvento(e);

			request.getRequestDispatcher("/publicacaoDao").forward(request, response);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
