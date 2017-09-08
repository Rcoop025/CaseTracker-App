

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;


import net.proteanit.sql.DbUtils;

import javax.swing.JOptionPane;

public abstract class CaseFuncs {
	
	protected String tempcaseName;
	protected String tempCourt;
	protected String tempCaseNo; 
	protected String tempLcaAttorney; 
	protected String tempPPT_OSC_Attorney;
	protected String tempDOJ_OIL_AUSA_E; 
	protected String tempDOS_srvd_recd; 
	protected String tempAnswer_MTO_Date; 
	protected String tempDiscovery_Cut_Date; 
	protected String temptrialDate;
	protected String tempEvent_Filing;
	protected boolean isValid;
	
	public abstract void display();
	public abstract void display2();
	
	

	
	public boolean validEntry()
	{
		
		
		if(!tempcaseName.equals("") && !tempcaseName.equals(" ") && (((int)tempcaseName.charAt(0) >= 65 && (int)tempcaseName.charAt(0) <= 90) ||  ((int)tempcaseName.charAt(0) >= 97 && (int)tempcaseName.charAt(0) <= 122)))
		{
		return true;
		} 
		
		
		return false;
	}
	
	public void addCase(JFrame frame)
	{
		isValid = validEntry();
		if(isValid)
		try{
			Connect c = new Connect();
			Connection con = c.start();
			PreparedStatement ps = con.prepareStatement("insert into pchart values(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, tempcaseName);
			ps.setString(2, tempCourt);
			ps.setString(3, tempCaseNo);
			ps.setString(4, tempLcaAttorney);
			ps.setString(5, tempPPT_OSC_Attorney);
			ps.setString(6, tempDOJ_OIL_AUSA_E);
			ps.setString(7, tempDOS_srvd_recd);
			ps.setString(8, tempAnswer_MTO_Date);
			ps.setString(9, tempDiscovery_Cut_Date);
			ps.setString(10, temptrialDate);
			ps.setString(11, tempEvent_Filing);
			
			int x =0; 
			x = ps.executeUpdate();
			if(x!=0)
			JOptionPane.showMessageDialog(frame.getContentPane(),  "Data Inserted!");
			
			con.close();
		}	catch(ClassNotFoundException  | SQLException e)
			{
			System.out.println(e);
			
			}
		else
		{
			JOptionPane.showMessageDialog(frame.getContentPane(), "Please check your entry for Case Name to make sure\n that there is no space or special characters");
			}
		
		
		
		}

	public void saveChanges(JFrame frame, String name)
	{
		
		isValid = validEntry();
		if(isValid)
		try{
			Connect c = new Connect();
			Connection con = c.start();
			PreparedStatement ps = con.prepareStatement("update pchart set Case_Name=?,Court=?,Case_Number=?,"
					+ "LCA_Attorney=?, PPTL_OSCL_Attorney=?, DOJ_OIL_AUSA_Attorney_Email=?,DOS_Srvd_Recd=?,"
					+ "Answer_MTO_Due_Date=?,Discovery_Cut_Off_Date=?,Trial_Date=?,Event_or_Filing=? where  Case_Name = '"+name+"'");
			ps.setString(1, tempcaseName);
			ps.setString(2, tempCourt);
			ps.setString(3, tempCaseNo);
			ps.setString(4, tempLcaAttorney);
			ps.setString(5, tempPPT_OSC_Attorney);
			ps.setString(6, tempDOJ_OIL_AUSA_E);
			ps.setString(7, tempDOS_srvd_recd);
			ps.setString(8, tempAnswer_MTO_Date);
			ps.setString(9, tempDiscovery_Cut_Date);
			ps.setString(10,temptrialDate);
			ps.setString(11, tempEvent_Filing);
			
			int x =0; 
			x = ps.executeUpdate();
			if(x!=0)
			JOptionPane.showMessageDialog(frame.getContentPane(), "Selection Updated Succefully!");
			
			con.close();
			}	
			catch(ClassNotFoundException  | SQLException e)
			{
			System.out.println(e);
			
			}
			
			else
			{
			JOptionPane.showMessageDialog(frame.getContentPane(), "Please check your entry for Case Name to make sure\n that there is no space or special characters");
			}
		
		
		frame.dispose();
		}
		
		
	
		
		


	

		
	
	
	
	public void retrieveCase(JFrame frameObj, String caseName)
	{
		
		
		try{
			Connect c = new Connect();
			Connection con = c.start();
			PreparedStatement ps = con.prepareStatement("select * from pchart where Case_Name =?");
			
			
			ps.setString(1, caseName);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				
				
				 tempcaseName = rs.getString("Case_Name");
				 tempCourt = rs.getString("Court");
				 tempCaseNo = rs.getString("Case_Number");
				 tempLcaAttorney = rs.getString("LCA_Attorney");
				 tempPPT_OSC_Attorney  = rs.getString("PPTL_OSCL_Attorney");
				 tempDOJ_OIL_AUSA_E = rs.getString("DOJ_OIL_AUSA_Attorney_Email");
				 tempDOS_srvd_recd = rs.getString("DOS_Srvd_Recd");
				 tempAnswer_MTO_Date = rs.getString("Answer_MTO_Due_Date");
				 tempDiscovery_Cut_Date = rs.getString("Discovery_Cut_Off_Date");
				 temptrialDate = rs.getString("Trial_Date");
				 tempEvent_Filing = rs.getString("Event_or_Filing");
				
			}
			c.stop();
			
			}catch(ClassNotFoundException| SQLException e)
			{
			JOptionPane.showMessageDialog(frameObj.getContentPane(), e); 
			
			
			}
		
	}
	public void inactiveRetrieveCase(JFrame frameObj, String caseName)
	{
		
		
		try{
			Connect c = new Connect();
			Connection con = c.start();
			PreparedStatement ps = con.prepareStatement("select * from pass_inactive where Case_Name =?");
			
			
			ps.setString(1, caseName);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				
				
				 tempcaseName = rs.getString("Case_Name");
				 tempCourt = rs.getString("Court");
				 tempCaseNo = rs.getString("Case_Number");
				 tempLcaAttorney = rs.getString("LCA_Attorney");
				 tempPPT_OSC_Attorney  = rs.getString("PPTL_OSCL_Attorney");
				 tempDOJ_OIL_AUSA_E = rs.getString("DOJ_OIL_Attorney_Email");
				 tempDOS_srvd_recd = rs.getString("DOS_Srvd_Recd");
				 tempAnswer_MTO_Date = rs.getString("Answer_MTO_Due_Date");
				 tempDiscovery_Cut_Date = rs.getString("Discovery_Cut_Off_Date");
				 temptrialDate = rs.getString("Trial_Date");
				 tempEvent_Filing = rs.getString("Event_or_Filing");
				
			}
			c.stop();
			
			}catch(ClassNotFoundException| SQLException e)
			{
			JOptionPane.showMessageDialog(frameObj.getContentPane(), e); 
			
			
			}
		
	}
	public void inactiveAddCase(JFrame frame)
	{
		isValid = validEntry();
		if(isValid)
			try{
				Connect c = new Connect();
				Connection con = c.start();
				
				PreparedStatement ps = con.prepareStatement("insert into pass_inactive values(?,?,?,?,?,?,?,?,?,?,?)");
				Statement st = con.createStatement();
				ps.setString(1, tempcaseName);
				ps.setString(2, tempCourt);
				ps.setString(3, tempCaseNo);
				ps.setString(4, tempLcaAttorney);
				ps.setString(5, tempPPT_OSC_Attorney);
				ps.setString(6, tempDOJ_OIL_AUSA_E);
				ps.setString(7, tempDOS_srvd_recd);
				ps.setString(8, tempAnswer_MTO_Date);
				ps.setString(9, tempDiscovery_Cut_Date);
				ps.setString(10,temptrialDate);
				ps.setString(11, tempEvent_Filing);
				
				int x =0; 
				x = ps.executeUpdate();
				if(x!=0)
					JOptionPane.showMessageDialog(frame.getContentPane(), "Data Transferred!");
				
				
				String sql = "delete from pchart where Case_Name='"+tempcaseName+"'";
				st.executeUpdate(sql);
				int a =0;
				
				con.close();
			}	catch(ClassNotFoundException  | SQLException e)
				{
				System.out.println(e);
				
				}
		else
		{
			JOptionPane.showMessageDialog(frame.getContentPane(), "Please check your entry for Case Name to make sure\n that there is no space or special characters");
			}
		
		
		
		}
	
	
	public void reactivateCase(JFrame frame)
	{
		isValid = validEntry();
		if(isValid)
			try{
				Connect c = new Connect();
				Connection con = c.start();
				
				PreparedStatement ps = con.prepareStatement("insert into pchart values(?,?,?,?,?,?,?,?,?,?,?)");
				Statement st = con.createStatement();
				ps.setString(1, tempcaseName);
				ps.setString(2, tempCourt);
				ps.setString(3, tempCaseNo);
				ps.setString(4, tempLcaAttorney);
				ps.setString(5, tempPPT_OSC_Attorney);
				ps.setString(6, tempDOJ_OIL_AUSA_E);
				ps.setString(7, tempDOS_srvd_recd);
				ps.setString(8, tempAnswer_MTO_Date);
				ps.setString(9, tempDiscovery_Cut_Date);
				ps.setString(10,temptrialDate);
				ps.setString(11, tempEvent_Filing);
				
				int x =0; 
				x = ps.executeUpdate();
				if(x!=0)
					JOptionPane.showMessageDialog(frame.getContentPane(), "Data Transferred!");
				
				
				String sql = "delete from pass_inactive where Case_Name='"+tempcaseName+"'";
				st.executeUpdate(sql);
				int a =0;
			
				con.close();
			}	catch(ClassNotFoundException  | SQLException e)
				{
				System.out.println(e);
				
				}
		else
		{
			JOptionPane.showMessageDialog(frame.getContentPane(), "Please check your entry for Case Name to make sure\n that there is no space or special characters");
			}
		
		
		
		}
	

	public void deleteCase(JFrame frame)
	{
		try{
			Connect c = new Connect();
			Connection con = c.start();
			Statement st = con.createStatement();
		
			
			int a =1;
			String sql = "delete from pass_inactive where Case_Name='"+tempcaseName+"'";
			a = st.executeUpdate(sql);
			
		
			
			
			if(a != 0)
				JOptionPane.showMessageDialog(frame.getContentPane(), "Case Deleted!");
			
			
			con.close();
		}	catch(ClassNotFoundException  | SQLException e)
			{
			System.out.println(e);
			
			}
		
	}
	
}


