package bdConnect_e_DAOs;

import java.sql.*;

public class BDConnect {

	public String driver= "com.mysql.jdbc.Driver";
	public String url = "jdbc:mysql://localhost:3306/projeto1bim2017";
	public String user = "root";
	public String password = "t00r";
	public BDConnect(){
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public Connection setDbLink() throws SQLException{
		return DriverManager.getConnection(url,user,password);
		
	}
	
}
