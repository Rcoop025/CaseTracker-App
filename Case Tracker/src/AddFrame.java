/*Parental Frame : AddFrame.java
 * DESCRIPTION : The OOD principle of inheritance will be used throughout this entire project.
 * AddFrame.java will be the parent frame that all frames pertaining to inserting, retrieving, deleting, transferring, and
 * editing will pull features/functions from.
 * 
 * 
 */

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public  class AddFrame extends JFrame {

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
	private boolean isValid;
	
	InheritCaseFuncs icf = new InheritCaseFuncs();
//Global variables to hold the data eneter into the fields
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFrame frame = new AddFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 
	
	//This method grabs all data from the textfields and comboBox
	public void connectFields()
	{
		icf.tempcaseName = textField.getText();
		 icf.tempCourt = textField_9.getText();
		 icf.tempCaseNo = textField_1.getText();
		icf.tempLcaAttorney = (String)comboBox.getSelectedItem();
		 icf.tempPPT_OSC_Attorney  = textField_2.getText();
		 icf.tempDOJ_OIL_AUSA_E = textField_3.getText();
		icf.tempDOS_srvd_recd = textField_4.getText();
		icf.tempAnswer_MTO_Date = textField_5.getText();
		icf.tempDiscovery_Cut_Date = textField_6.getText();
		icf.temptrialDate = textField_7.getText();
		 icf.tempEvent_Filing = textField_8.getText();
	}
	//This method checks the entry to see if there is a case name for the first text field.
	//This is important for future adjustments such as sorting, so that there is a way 
	//to sort the cases accurately by Case Name.
	
	
	
	
	
	
	
	
	
	/**
	 * Create the frame.
	 */
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
		icf.addCase(this);
		
	}
	public AddFrame() {
		setTitle("Add New Case");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 20, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Case");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				//This function helps to connect the components of the frame/window to variable for
				//data manipulation
				connectFields();
				
				//This display function is a principle of Object Oriented Design - Multiple Inheritance
				//upon calling, the function uses an object "icf", which inherits from an abstract class to 
				//add data to the database.
				display();
				
				//The Following statements will clear all of the fields in the Add Form
				clearFields();
				
				
				}
			
			
			
		});
		btnNewButton.setBounds(154, 502, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Go Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PassportChoice pc = new PassportChoice();
				pc.setVisible(true);
				
				dispose();
			}
		});
		btnNewButton_1.setBounds(321, 502, 89, 23);
		contentPane.add(btnNewButton_1);
		

		JLabel lblNewLabel = new JLabel("Case Name:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(128, 86, 89, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Case No.:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(154, 157, 62, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("L/CA Attorney:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(93, 193, 123, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PPT/L or OCS/L Lead:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(93, 233, 123, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("DOJ-OIL or AUSA (Email):");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(59, 275, 157, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("DOS Srv'd/Rec'd:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(93, 321, 123, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Answer/MTO Due Date (filed):");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(48, 362, 168, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New Case Form");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Verdana", Font.BOLD, 24));
		lblNewLabel_7.setBounds(115, 25, 353, 35);
		contentPane.add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char ch = arg0.getKeyChar();
				if(Character.isDigit(ch))
				{
					arg0.consume();
				}
			}
		});
		textField.setBounds(245, 83, 166, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(245, 154, 166, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char ch = e.getKeyChar();
				if(Character.isDigit(ch))
				{
					e.consume();
				}
			}
		});
		textField_2.setBounds(245, 230, 166, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(245, 272, 166, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(245, 318, 166, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(245, 359, 166, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Discovery cut-off date:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setBounds(82, 400, 134, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Trial Date:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_9.setBounds(93, 431, 123, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Event of Filing:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_10.setBounds(84, 466, 131, 14);
		contentPane.add(lblNewLabel_10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(245, 397, 166, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(245, 428, 166, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(245, 463, 166, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		 comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"[Select An Attorney]", "Abbas Ravjani", "Catherine Peters", "Eddie Cohen", "Elizabeth Donnelly", "Jeremy Weinberg", "Judith Osborn", "Julianna Bentes", "Mahvish Madad", "Matthew Hackell", "Natalya Scimeca", "Nina Schou", "Semra Mesulam", "Stephen Kerr", "Steven Fabry"}));
		comboBox.setBounds(245, 190, 166, 20);
		contentPane.add(comboBox);
		
		JLabel lblCourt = new JLabel("Court:");
		lblCourt.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCourt.setForeground(Color.WHITE);
		lblCourt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCourt.setBounds(171, 122, 46, 14);
		contentPane.add(lblCourt);
		
		textField_9 = new JTextField();
		textField_9.setBounds(245, 118, 165, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		Image imgback =  new ImageIcon(this.getClass().getResource("/Main Back for Add Frame.png")).getImage();
		lblNewLabel_11.setIcon(new ImageIcon(imgback));
	
		lblNewLabel_11.setBounds(0, 0, 594, 550);
		contentPane.add(lblNewLabel_11);
	}
	
	public void dataValidation()
	{
		
		
	}
}
