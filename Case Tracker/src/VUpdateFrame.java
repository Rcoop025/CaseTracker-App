import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class VUpdateFrame extends JFrame {

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
					VUpdateFrame frame = new VUpdateFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	InheritVisaFuncs ivf = new InheritVisaFuncs();

	/**
	 * Create the frame.
	 */
	public void passData()
	{
		
		System.out.println("INSIDE OF THE PASS DATA FUNCTION");
		
		ivf.tempcaseName = textField.getText();
		System.out.println("Pass Data-Case Name = " + ivf.tempcaseName);
		
		ivf.tempCourt = textField_1.getText();
		System.out.println("Pass Data-Court District = " + ivf.tempCourt);
		ivf.tempCaseNo = textField_2.getText();
		System.out.println("Pass Data-Case Number = " + ivf.tempCaseNo);
		
		ivf.tempLcaAttorney = (String)comboBox.getSelectedItem();
		
		
		
		
		
			switch(ivf.tempLcaAttorney)
				{
						
			
			case "Judith Osborn":
				this.comboBox.setSelectedIndex(1);
				break;
			
			case "Mahvish Madad":
				this.comboBox.setSelectedIndex(2);
				break;
			
			case "Stephen Kerr":
				this.comboBox.setSelectedIndex(3);
				break;
				default: 
					this.comboBox.setSelectedItem(0);
			
	
				}
		

			ivf.tempPPT_OSC_Attorney = textField_3.getText();
			ivf.tempDOJ_OIL_AUSA_E =  textField_4.getText();
			ivf.tempDOS_srvd_recd =  textField_5.getText();
			ivf.tempAnswer_MTO_Date = textField_6.getText();
			ivf.tempDiscovery_Cut_Date = textField_7.getText();
			ivf.temptrialDate = textField_8.getText();
			ivf.tempEvent_Filing = textField_9.getText();
		
	
	}
	
	public void passComponentData()
	{
		this.textField.setText(ivf.tempcaseName);
		this.textField_1.setText(ivf.tempCourt);
		this.textField_2.setText(ivf.tempCaseNo);
		
		
		
		
		
			switch(ivf.tempLcaAttorney)
				{
						
				case "Judith Osborn":
					this.comboBox.setSelectedIndex(1);
					break;
				
				case "Mahvish Madad":
					this.comboBox.setSelectedIndex(2);
					break;
				
				case "Stephen Kerr":
					this.comboBox.setSelectedIndex(3);
					break;
					default: 
						this.comboBox.setSelectedItem(0);
				
	
				}
		

		this.textField_3.setText(ivf.tempPPT_OSC_Attorney);
		this.textField_4.setText(ivf.tempDOJ_OIL_AUSA_E);
		this.textField_5.setText(ivf.tempDOS_srvd_recd);
		this.textField_6.setText(ivf.tempAnswer_MTO_Date);
		this.textField_7.setText(ivf.tempDiscovery_Cut_Date);
		this.textField_8.setText(ivf.temptrialDate);
		this.textField_9.setText(ivf.tempEvent_Filing);
		
	}
	
	public void clearFields()
	{
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
	}
	
	private void display()
	{
		
		ivf.saveChanges(this, ivf.tempcaseName);
		
		
	}
	private void display2()
	{
		String name = textField.getText();
		 System.out.println("Case Name = " + name);
		ivf.retrieveCase(this, name);
		
		
	}

	/**
	 * Create the frame.
	 */
	public VUpdateFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 20, 600, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAction = new JMenu("Action");
		menuBar.add(mnAction);
		
		JMenuItem mntmGoBack = new JMenuItem("Go Back");
		mntmGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VisaEdit frame = new VisaEdit();
				frame.setVisible(true);
				dispose();
				}
		});
		mnAction.add(mntmGoBack);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Update Form");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Verdana", Font.BOLD, 24));
		label.setBounds(126, 25, 353, 35);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Case Name:");
		label_1.setForeground(Color.WHITE);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(136, 84, 89, 14);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(253, 81, 166, 20);
		contentPane.add(textField);
		
		JLabel label_2 = new JLabel("Court:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setForeground(Color.WHITE);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(179, 120, 46, 14);
		contentPane.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(253, 116, 165, 20);
		contentPane.add(textField_1);
		
		JLabel label_3 = new JLabel("Case No.:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setForeground(Color.WHITE);
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(162, 155, 62, 14);
		contentPane.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(253, 152, 166, 20);
		contentPane.add(textField_2);
		
		JLabel label_4 = new JLabel("L/CA Attorney:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setForeground(Color.WHITE);
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(101, 191, 123, 14);
		contentPane.add(label_4);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"[Select An Attorney]", "Judith Osborn", "Mahvish Madad", "Stephen Kerr"}));
		comboBox.setBounds(253, 188, 166, 20);
		contentPane.add(comboBox);
		
		JLabel label_5 = new JLabel("PPT/L or OCS/L Lead:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setForeground(Color.WHITE);
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(101, 231, 123, 14);
		contentPane.add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(253, 228, 166, 20);
		contentPane.add(textField_3);
		
		JLabel label_6 = new JLabel("DOJ-OIL or AUSA (Email):");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_6.setForeground(Color.WHITE);
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(67, 273, 157, 14);
		contentPane.add(label_6);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(253, 270, 166, 20);
		contentPane.add(textField_4);
		
		JLabel label_7 = new JLabel("DOS Srv'd/Rec'd:");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_7.setForeground(Color.WHITE);
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setBounds(101, 319, 123, 14);
		contentPane.add(label_7);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(253, 316, 166, 20);
		contentPane.add(textField_5);
		
		JLabel label_8 = new JLabel("Answer/MTO Due Date (filed):");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_8.setForeground(Color.WHITE);
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setBounds(56, 360, 168, 14);
		contentPane.add(label_8);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(253, 357, 166, 20);
		contentPane.add(textField_6);
		
		JLabel label_9 = new JLabel("Discovery cut-off date:");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_9.setForeground(Color.WHITE);
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setBounds(90, 398, 134, 14);
		contentPane.add(label_9);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(253, 395, 166, 20);
		contentPane.add(textField_7);
		
		JLabel label_10 = new JLabel("Trial Date:");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_10.setForeground(Color.WHITE);
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setBounds(101, 429, 123, 14);
		contentPane.add(label_10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(253, 426, 166, 20);
		contentPane.add(textField_8);
		
		JLabel label_11 = new JLabel("Event of Filing:");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_11.setForeground(Color.WHITE);
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setBounds(92, 464, 131, 14);
		contentPane.add(label_11);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(253, 461, 166, 20);
		contentPane.add(textField_9);
		
		JButton button = new JButton("Submit Changes");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				passData();
				display();
				
				
				dispose();
			}
			
		});
		button.setBounds(136, 500, 131, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Retrieve");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				display2();
				passComponentData();
			}
		});
		button_1.setBounds(314, 500, 123, 23);
		contentPane.add(button_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(Color.WHITE);
		Image imgback =  new ImageIcon(this.getClass().getResource("/Main Back for Add Frame.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(imgback));
		
		lblNewLabel.setBounds(-12, 0, 596, 551);
		contentPane.add(lblNewLabel);
	}

}
