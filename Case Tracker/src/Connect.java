import java.sql.*;


public class Connect {

	Connection con =null;
	
	public Connection start() throws ClassNotFoundException, SQLException
	{	
		
		Class.forName("com.mysql.jdbc.Driver");
		 con=DriverManager.getConnection("jdbc:mysql://localhost/passport_chart", "root", "");
		
		return con;
	}
	
	
	public void stop() throws SQLException
	{
		con.close();
		
	}
}
