import java.awt.EventQueue;
import java.sql.*;
import javax.swing.event.*;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

public class Login {

	private JFrame frmLoginFrame;
	private JTextField nameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLoginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginFrame = new JFrame();
		frmLoginFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmLoginFrame.setTitle("Login");
		frmLoginFrame.setBounds(100, 100, 450, 300);
		frmLoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginFrame.getContentPane().setLayout(null);
		
		JLabel nameLabel = new JLabel("Name :");
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(141, 95, 46, 14);
		frmLoginFrame.getContentPane().add(nameLabel);
		
		JLabel passLabel = new JLabel("Password :");
		passLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		passLabel.setForeground(Color.WHITE);
		passLabel.setBounds(120, 139, 67, 14);
		frmLoginFrame.getContentPane().add(passLabel);
		
		nameField = new JTextField();
		nameField.setBounds(215, 93, 86, 20);
		frmLoginFrame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setText("");
		passwordField.setBounds(215, 136, 86, 20);
		frmLoginFrame.getContentPane().add(passwordField);
		//passwordField.
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = nameField.getText();
				char ch[] = passwordField.getPassword();
				String password = new String(ch);
				
				try{
					Connect c =  new Connect();
					Connection con = c.start();
					PreparedStatement ps = con.prepareStatement("select * from login where username=? and password=?");
					ps.setString(1, name);
					ps.setString(2, password);
					ResultSet rs = ps.executeQuery();
					int a = 0;
					if(rs.next())
						a=1;
					if(a==1)
					{
						JOptionPane.showMessageDialog(frmLoginFrame, "Successful Login!");
						LitigationChoice lc = new LitigationChoice();
						lc.setVisible(true);
						frmLoginFrame.dispose();
						
						
					}
					else
					{
						JOptionPane.showMessageDialog(frmLoginFrame, "Failed Login!");
					}
				
					
					c.stop();
				}catch(Exception ex){
					JOptionPane.showMessageDialog(frmLoginFrame, ex);
				}
				
				
				
			}
		});
		btnNewButton.setBounds(110, 194, 89, 23);
		frmLoginFrame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frmLoginFrame.dispose();
			}
		});
		btnNewButton_1.setBounds(236, 194, 89, 23);
		frmLoginFrame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		Image imgback =  new ImageIcon(this.getClass().getResource("/Main Backgroun Color.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(imgback));
		
		lblNewLabel.setBounds(0, 0, 434, 261);
		frmLoginFrame.getContentPane().add(lblNewLabel);
	}
}


