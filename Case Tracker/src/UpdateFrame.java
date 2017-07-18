import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

public class UpdateFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateFrame frame = new UpdateFrame();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdateFrame() {
		setTitle("Edit Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 20, 600, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAction = new JMenu("Action");
		menuBar.add(mnAction);
		
		JMenuItem mntmGoBack = new JMenuItem("Go Back");
		mntmGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		mnAction.add(mntmGoBack);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUpdateForm = new JLabel("Update Form");
		lblUpdateForm.setForeground(Color.WHITE);
		lblUpdateForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateForm.setFont(new Font("Verdana", Font.BOLD, 24));
		lblUpdateForm.setBounds(141, 31, 353, 35);
		contentPane.add(lblUpdateForm);
		
		JLabel label_1 = new JLabel("Case Name:");
		label_1.setForeground(Color.WHITE);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(151, 90, 89, 14);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
		});
		textField.setColumns(10);
		textField.setBounds(268, 87, 166, 20);
		contentPane.add(textField);
		
		JLabel label_2 = new JLabel("Court:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setForeground(Color.WHITE);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(194, 126, 46, 14);
		contentPane.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(268, 122, 165, 20);
		contentPane.add(textField_1);
		
		JLabel label_3 = new JLabel("Case No.:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setForeground(Color.WHITE);
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(177, 161, 62, 14);
		contentPane.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(268, 158, 166, 20);
		contentPane.add(textField_2);
		
		JLabel label_4 = new JLabel("L/CA Attorney:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setForeground(Color.WHITE);
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(116, 197, 123, 14);
		contentPane.add(label_4);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"[Select An Attorney]", "Abbas Ravjani", "Catherine Peters", "Eddie Cohen", "Elizabeth Donnelly", "Jeremy Weinberg", "Judith Osborn", "Julianna Bentes", "Mahvish Madad", "Matthew Hackell", "Natalya Scimeca", "Nina Schou", "Semra Mesulam", "Stephen Kerr", "Steven Fabry"}));
		comboBox.setBounds(268, 194, 166, 20);
		contentPane.add(comboBox);
		
		JLabel label_5 = new JLabel("PPT/L or OCS/L Lead:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setForeground(Color.WHITE);
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(116, 237, 123, 14);
		contentPane.add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(268, 234, 166, 20);
		contentPane.add(textField_3);
		
		JLabel label_6 = new JLabel("DOJ-OIL or AUSA (Email):");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_6.setForeground(Color.WHITE);
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(82, 279, 157, 14);
		contentPane.add(label_6);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(268, 276, 166, 20);
		contentPane.add(textField_4);
		
		JLabel label_7 = new JLabel("DOS Srv'd/Rec'd:");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_7.setForeground(Color.WHITE);
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setBounds(116, 325, 123, 14);
		contentPane.add(label_7);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(268, 322, 166, 20);
		contentPane.add(textField_5);
		
		JLabel label_8 = new JLabel("Answer/MTO Due Date (filed):");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_8.setForeground(Color.WHITE);
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setBounds(71, 366, 168, 14);
		contentPane.add(label_8);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(268, 363, 166, 20);
		contentPane.add(textField_6);
		
		JLabel label_9 = new JLabel("Discovery cut-off date:");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_9.setForeground(Color.WHITE);
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setBounds(105, 404, 134, 14);
		contentPane.add(label_9);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(268, 401, 166, 20);
		contentPane.add(textField_7);
		
		JLabel label_10 = new JLabel("Trial Date:");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_10.setForeground(Color.WHITE);
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setBounds(116, 435, 123, 14);
		contentPane.add(label_10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(268, 432, 166, 20);
		contentPane.add(textField_8);
		
		JLabel label_11 = new JLabel("Event of Filing:");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_11.setForeground(Color.WHITE);
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setBounds(107, 470, 131, 14);
		contentPane.add(label_11);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(268, 467, 166, 20);
		contentPane.add(textField_9);
		
		JButton btnSubmitChanges = new JButton("Submit Changes");
		btnSubmitChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String caseName = textField.getText();
				String court = textField_1.getText();
				String caseNo = textField_2.getText();
				String lcaAttorney = (String)comboBox.getSelectedItem();
				String PPT_OSC_Attorney  = textField_3.getText();
				String DOJ_OIL_AUSA_E = textField_4.getText();
				String DOS_srvd_recd = textField_5.getText();
				String Answer_MTO_Date = textField_6.getText();
				String Discovery_Cut_Date = textField_7.getText();
				String trialDate = textField_8.getText();
				String Event_Filing = textField_9.getText();
				
				
				System.out.println(caseName);
				System.out.println(court);
				try{
					Connect c = new Connect();
					Connection con = c.start();
					PreparedStatement ps = con.prepareStatement("update pchart set Case_Name=?,Court=?,Case_Number=?,"
							+ "LCA_Attorney=?, PPTL_OSCL_Attorney=?, DOJ_OIL_AUSA_Attorney_Email=?,DOS_Srvd_Recd=?,"
							+ "Answer_MTO_Due_Date=?,Discovery_Cut_Off_Date=?,Trial_Date=?,Event_or_Filing=? where  Case_Name = '"+caseName+"'");
					ps.setString(1, caseName);
					ps.setString(2, court);
					ps.setString(3, caseNo);
					ps.setString(4, lcaAttorney);
					ps.setString(5, PPT_OSC_Attorney);
					ps.setString(6, DOJ_OIL_AUSA_E);
					ps.setString(7, DOS_srvd_recd);
					ps.setString(8, Answer_MTO_Date);
					ps.setString(9, Discovery_Cut_Date);
					ps.setString(10, trialDate);
					ps.setString(11, Event_Filing);
					
					int x =0; 
					x = ps.executeUpdate();
					if(x!=0)
					JOptionPane.showMessageDialog(contentPane, "Selection Updated Succefully!");
					
					con.close();
				}	catch(ClassNotFoundException  | SQLException e)
					{
					System.out.println(e);
					
					}
				
				
				//The Following statements will clear all of the fields in the Add Form
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_6.setText("");
				textField_5.setText("");
				textField_7.setText("");
				textField_8.setText("");
				textField_9.setText("");
				comboBox.setSelectedIndex(0);
				
				
				dispose();
			}
		});
		btnSubmitChanges.setBounds(151, 506, 134, 23);
		contentPane.add(btnSubmitChanges);
		
		JButton btnRetrieve = new JButton("Retrieve");
		btnRetrieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditFrame fm = new EditFrame();
				String name = textField.getText();
				String ComboBoxStr;
				try{
					Connect c = new Connect();
					Connection con = c.start();
					PreparedStatement ps = con.prepareStatement("select * from pchart where Case_Name =?");
					//String sql = "select * from pchart where Case_Name like '%"+name+"%'";
					
					ps.setString(1, name);
					
					ResultSet rs = ps.executeQuery();
					while(rs.next())
					{
						
						textField.setText(rs.getString("Case_Name"));
						textField_1.setText(rs.getString("Court"));
						textField_2.setText(rs.getString("Case_Number"));
						
							switch(rs.getString("LCA_Attorney"))
								{
										
							case "Abbas Ravjani":
								comboBox.setSelectedIndex(1);
								break;
							case "Catherine Peters":
								comboBox.setSelectedIndex(2);
								break;
							case "Eddie Cohen":
								comboBox.setSelectedIndex(3);
								break;
							case "Elizabeth Donnelly":
								comboBox.setSelectedIndex(4);
								break;
							case "Jeremy Weinberg":
								comboBox.setSelectedIndex(5);
								break;
							case "Judith Osborn":
								comboBox.setSelectedIndex(6);
								break;
							case "Julianna Bentes":
								comboBox.setSelectedIndex(7);
								break;
							case "Mahvish Madad":
								comboBox.setSelectedIndex(8);
								break;
							case "Matthew Hackell":
								comboBox.setSelectedIndex(9);
								break;
							case "Natalya Scimeca":
								comboBox.setSelectedIndex(10);
								break;
							case "Nina Schou":
								comboBox.setSelectedIndex(11);
								break;
							case "Semra Mesulam":
								comboBox.setSelectedIndex(12);
								break;
							case "Stephen Kerr":
								comboBox.setSelectedIndex(13);
								break;
								default: 
									comboBox.setSelectedItem(0);
							case "Steven Fabry":
								comboBox.setSelectedItem(1);
								break;
					
								}
						

						textField_3.setText(rs.getString("PPTL_OSCL_Attorney"));
						textField_4.setText(rs.getString("DOJ_OIL_AUSA_Attorney_Email"));
						textField_5.setText(rs.getString("DOS_Srvd_Recd"));
						textField_6.setText(rs.getString("Answer_MTO_Due_Date"));
						textField_7.setText(rs.getString("Discovery_Cut_Off_Date"));
						textField_8.setText(rs.getString("Trial_Date"));
						textField_9.setText(rs.getString("Event_or_Filing"));
						
					}
					c.stop();
					
					}catch(ClassNotFoundException| SQLException e)
					{
					JOptionPane.showMessageDialog(contentPane, e);
					}
			}
		});
		btnRetrieve.setBounds(329, 506, 123, 23);
		contentPane.add(btnRetrieve);
		
		JLabel lblNewLabel = new JLabel("New label");
		Image imgback =  new ImageIcon(this.getClass().getResource("/Main Back for Add Frame.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(imgback));
		lblNewLabel.setBounds(0, 0, 584, 537);
		contentPane.add(lblNewLabel);
	}
}
