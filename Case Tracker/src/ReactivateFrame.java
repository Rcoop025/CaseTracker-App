import java.awt.BorderLayout;
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
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ReactivateFrame extends JFrame {

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
					ReactivateFrame frame = new ReactivateFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	InheritCaseFuncs icf = new InheritCaseFuncs();
	/**
	 * Create the frame.
	 */
	
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
	private void display()
	{
		icf.reactivateCase(this);
		
	}
	private void display2()
	{
		String  name = textField.getText();
		 System.out.println("Case Name = " + name);
		icf.inactiveRetrieveCase(this, name);
		
		
	}
	
	public void passData()
	{
		
		System.out.println("INSIDE OF THE PASS DATA FUNCTION");
		
		icf.tempcaseName = textField.getText();
		System.out.println("Pass Data-Case Name = " + icf.tempcaseName);
		
		icf.tempCourt = textField_1.getText();
		System.out.println("Pass Data-Court District = " + icf.tempCourt);
		icf.tempCaseNo = textField_2.getText();
		System.out.println("Pass Data-Case Number = " + icf.tempCaseNo);
		
		icf.tempLcaAttorney = (String)comboBox.getSelectedItem();
		
		
		
		
		
			switch(icf.tempLcaAttorney)
				{
						
			case "Abbas Ravjani":
				this.comboBox.setSelectedIndex(1);
				break;
			case "Catherine Peters":
				this.comboBox.setSelectedIndex(2);
				break;
			case "Eddie Cohen":
				this.comboBox.setSelectedIndex(3);
				break;
			case "Elizabeth Donnelly":
				this.comboBox.setSelectedIndex(4);
				break;
			case "Jeremy Weinberg":
				this.comboBox.setSelectedIndex(5);
				break;
			case "Judith Osborn":
				this.comboBox.setSelectedIndex(6);
				break;
			case "Julianna Bentes":
				this.comboBox.setSelectedIndex(7);
				break;
			case "Mahvish Madad":
				this.comboBox.setSelectedIndex(8);
				break;
			case "Matthew Hackell":
				this.comboBox.setSelectedIndex(9);
				break;
			case "Natalya Scimeca":
				this.comboBox.setSelectedIndex(10);
				break;
			case "Nina Schou":
				this.comboBox.setSelectedIndex(11);
				break;
			case "Semra Mesulam":
				this.comboBox.setSelectedIndex(12);
				break;
			case "Stephen Kerr":
				this.comboBox.setSelectedIndex(13);
				break;
				default: 
					this.comboBox.setSelectedItem(0);
			case "Steven Fabry":
				this.comboBox.setSelectedItem(1);
				break;
	
				}
		

			icf.tempPPT_OSC_Attorney = textField_3.getText();
			icf.tempDOJ_OIL_AUSA_E =  textField_4.getText();
			icf.tempDOS_srvd_recd =  textField_5.getText();
			icf.tempAnswer_MTO_Date = textField_6.getText();
			icf.tempDiscovery_Cut_Date = textField_7.getText();
			icf.temptrialDate = textField_8.getText();
			icf.tempEvent_Filing = textField_9.getText();
		
	
	}
	
	
	public void passComponentData()
	{
		this.textField.setText(icf.tempcaseName);
		this.textField_1.setText(icf.tempCourt);
		this.textField_2.setText(icf.tempCaseNo);
		
		
		
		
		
			switch(icf.tempLcaAttorney)
				{
						
			case "Abbas Ravjani":
				this.comboBox.setSelectedIndex(1);
				break;
			case "Catherine Peters":
				this.comboBox.setSelectedIndex(2);
				break;
			case "Eddie Cohen":
				this.comboBox.setSelectedIndex(3);
				break;
			case "Elizabeth Donnelly":
				this.comboBox.setSelectedIndex(4);
				break;
			case "Jeremy Weinberg":
				this.comboBox.setSelectedIndex(5);
				break;
			case "Judith Osborn":
				this.comboBox.setSelectedIndex(6);
				break;
			case "Julianna Bentes":
				this.comboBox.setSelectedIndex(7);
				break;
			case "Mahvish Madad":
				this.comboBox.setSelectedIndex(8);
				break;
			case "Matthew Hackell":
				this.comboBox.setSelectedIndex(9);
				break;
			case "Natalya Scimeca":
				this.comboBox.setSelectedIndex(10);
				break;
			case "Nina Schou":
				this.comboBox.setSelectedIndex(11);
				break;
			case "Semra Mesulam":
				this.comboBox.setSelectedIndex(12);
				break;
			case "Stephen Kerr":
				this.comboBox.setSelectedIndex(13);
				break;
				default: 
					this.comboBox.setSelectedItem(0);
			case "Steven Fabry":
				this.comboBox.setSelectedItem(1);
				break;
	
				}
		

		this.textField_3.setText(icf.tempPPT_OSC_Attorney);
		this.textField_4.setText(icf.tempDOJ_OIL_AUSA_E);
		this.textField_5.setText(icf.tempDOS_srvd_recd);
		this.textField_6.setText(icf.tempAnswer_MTO_Date);
		this.textField_7.setText(icf.tempDiscovery_Cut_Date);
		this.textField_8.setText(icf.temptrialDate);
		this.textField_9.setText(icf.tempEvent_Filing);
		
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
	
	public ReactivateFrame() {
		setTitle("Passport Case Reactivation Form\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 20, 600, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAction = new JMenu("Action");
		menuBar.add(mnAction);
		
		JMenuItem mntmGoBack = new JMenuItem("Go Back");
		mntmGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PassInactiveCase pic  =  new PassInactiveCase();
				pic.setVisible(true);
				dispose();
			}
		});
		mnAction.add(mntmGoBack);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 584, 661);
		contentPane.add(panel);
		
		JLabel lblReactivateCaseForm = new JLabel("Reactivate Case Form");
		lblReactivateCaseForm.setForeground(Color.WHITE);
		lblReactivateCaseForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblReactivateCaseForm.setFont(new Font("Verdana", Font.BOLD, 24));
		lblReactivateCaseForm.setBounds(141, 11, 353, 35);
		panel.add(lblReactivateCaseForm);
		
		JLabel label_1 = new JLabel("Case Name:");
		label_1.setForeground(Color.WHITE);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(151, 70, 89, 14);
		panel.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(268, 67, 166, 20);
		panel.add(textField);
		
		JLabel label_2 = new JLabel("Court:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setForeground(Color.WHITE);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(194, 106, 46, 14);
		panel.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(268, 102, 165, 20);
		panel.add(textField_1);
		
		JLabel label_3 = new JLabel("Case No.:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setForeground(Color.WHITE);
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(177, 141, 62, 14);
		panel.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(268, 138, 166, 20);
		panel.add(textField_2);
		
		JLabel label_4 = new JLabel("L/CA Attorney:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setForeground(Color.WHITE);
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(116, 177, 123, 14);
		panel.add(label_4);
		
		 comboBox = new JComboBox();
		 comboBox.setModel(new DefaultComboBoxModel(new String[] {"[Select An Attorney]", "Abbas Ravjani", "Catherine Peters", "Eddie Cohen", "Elizabeth Donnelly", "Jeremy Weinberg", "Judith Osborn", "Julianna Bentes", "Mahvish Madad", "Matthew Hackell", "Natalya Scimeca", "Nina Schou", "Semra Mesulam", "Stephen Kerr", "Steven Fabry"}));
		comboBox.setBounds(268, 174, 166, 20);
		panel.add(comboBox);
		
		JLabel label_5 = new JLabel("PPT/L or OCS/L Lead:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setForeground(Color.WHITE);
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(116, 217, 123, 14);
		panel.add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(268, 214, 166, 20);
		panel.add(textField_3);
		
		JLabel label_6 = new JLabel("DOJ-OIL or AUSA (Email):");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_6.setForeground(Color.WHITE);
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(82, 259, 157, 14);
		panel.add(label_6);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(268, 256, 166, 20);
		panel.add(textField_4);
		
		JLabel label_7 = new JLabel("DOS Srv'd/Rec'd:");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_7.setForeground(Color.WHITE);
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setBounds(116, 305, 123, 14);
		panel.add(label_7);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(268, 302, 166, 20);
		panel.add(textField_5);
		
		JLabel label_8 = new JLabel("Answer/MTO Due Date (filed):");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_8.setForeground(Color.WHITE);
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setBounds(71, 346, 168, 14);
		panel.add(label_8);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(268, 343, 166, 20);
		panel.add(textField_6);
		
		JLabel label_9 = new JLabel("Discovery cut-off date:");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_9.setForeground(Color.WHITE);
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setBounds(105, 384, 134, 14);
		panel.add(label_9);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(268, 381, 166, 20);
		panel.add(textField_7);
		
		JLabel label_10 = new JLabel("Trial Date:");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_10.setForeground(Color.WHITE);
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setBounds(116, 415, 123, 14);
		panel.add(label_10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(268, 412, 166, 20);
		panel.add(textField_8);
		
		JLabel label_11 = new JLabel("Event of Filing:");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_11.setForeground(Color.WHITE);
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setBounds(107, 450, 131, 14);
		panel.add(label_11);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(268, 447, 166, 20);
		panel.add(textField_9);
		
		JButton button = new JButton("Transfer Case");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				
				passData();
				display();
				
				PassInactiveCase pic = new PassInactiveCase();
				pic.setVisible(true);
				dispose();
			
			}
		});
		button.setBounds(151, 486, 134, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Retrieve");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				display2();
				passComponentData();
			}
		});
		button_1.setBounds(329, 486, 123, 23);
		panel.add(button_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		Image imgback =  new ImageIcon(this.getClass().getResource("/Main Back for Add Frame.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(imgback));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 584, 559);
		panel.add(lblNewLabel);
	}

}
