
import java.sql.*;

public class DatabaseTest {
	
	
	public static void main(String[] args)
	{
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/passport_chart", "root", "");
		Statement st = con.createStatement();
		//String sql = "insert into pchart values('Cooper, Roosevelt v. DOS', 'N.D.TX',"
			//	+ "'v00254-3532', 'Abbas Ravjani','Shawn Michaels', 'SCrawfish@great.com', '02/12/2017', '04/12/2017',"
			//	+ "'03/02/2017', '03/15/2017','N/A')";
		
		//String sql = "update pchart set LCA_Attorney = 'Stephen Kerr' where Case_Name='Cooper, Roosevelt v. DOS'";
		//String sql = "delete from pchart where Case_Name='Cooper, Roosevelt v. DOS'";
		
		String sql = "select * from pchart";
		ResultSet rs = st.executeQuery(sql);
		while(rs.next())
		{
		System.out.println(rs.getString("Case_Name"));
		System.out.println(rs.getString("Court"));
		System.out.println(rs.getString("Case_Number"));
		System.out.println(rs.getString("LCA_Attorney"));
		System.out.println(rs.getString("PPTL_OSCL_Attorney"));
		System.out.println(rs.getString("DOJ_OIL_AUSA_Attorney_Email"));
		System.out.println(rs.getString("DOS_Srvd_Recd"));
		System.out.println(rs.getString("Answer_MTO_Due_Date"));
		System.out.println(rs.getString("Discovery_Cut_Off_Date"));
		System.out.println(rs.getString("Trial_Date"));
		System.out.println(rs.getString("Event_or_Filing"));
		System.out.println("\n\n");
		
		}
		int a = 0;
		//a = st.executeUpdate(sql);
	
		
			
		
		//if(a != 0)
			//System.out.println("Item Inserted!");
			
			con.close();
			
		}
		catch(ClassNotFoundException | SQLException e)
		{
			System.out.println(e);
		}
		
		
	}

}
