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
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class UpdateCaseLoad extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JComboBox comboBox;
	private JComboBox comboBox_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCaseLoad frame = new UpdateCaseLoad();
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
	public UpdateCaseLoad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 450, 340);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChooseAttorney = new JLabel("Choose Attorney:");
		lblChooseAttorney.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblChooseAttorney.setForeground(Color.WHITE);
		lblChooseAttorney.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChooseAttorney.setBounds(98, 78, 86, 14);
		contentPane.add(lblChooseAttorney);
		
		JLabel lblModifyWorkLoad = new JLabel("Modify Work Load");
		lblModifyWorkLoad.setForeground(Color.WHITE);
		lblModifyWorkLoad.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifyWorkLoad.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblModifyWorkLoad.setBounds(120, 11, 203, 25);
		contentPane.add(lblModifyWorkLoad);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"[Select An Attorney]", "Abbas Ravjani", "Catherine Peters", "Eddie Cohen", "Elizabeth Donnelly", "Jeremy Weinberg", "Judith Osborn", "Julianna Bentes", "Mahvish Madad", "Matthew Hackell", "Natalya Scimeca", "Nina Schou", "Semra Mesulam", "Stephen Kerr", "Steven Fabry"}));
		comboBox.setBounds(216, 75, 136, 20);
		contentPane.add(comboBox);
		
		JLabel lblCases = new JLabel("Case(s):");
		lblCases.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCases.setForeground(Color.WHITE);
		lblCases.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCases.setBounds(120, 120, 64, 14);
		contentPane.add(lblCases);
		
		textField = new JTextField();
		textField.setBounds(216, 117, 136, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String lcaAttorney = (String) comboBox.getSelectedItem();
				String caseName = textField.getText();
				String month = (String)comboBox_1.getSelectedItem();
				try{
					Connect c = new Connect();
					Connection con = c.start();
					
					Statement st = con.createStatement();
					String sql = "update attorneys set "+month+"='"+caseName+"' where name='"+lcaAttorney+"'";
					
					int x =0; 
					x = st.executeUpdate(sql);
					if(x!=0)
					JOptionPane.showMessageDialog(contentPane, "Selection Updated Succefully!");
					
					con.close();
				}	catch(ClassNotFoundException  | SQLException e)
					{
					System.out.println(e);
					
					}
				dispose();
				
			}
		});
		btnNewButton.setBounds(98, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setBounds(234, 227, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel lblMonth = new JLabel("Month:");
		lblMonth.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMonth.setForeground(Color.WHITE);
		lblMonth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMonth.setBounds(138, 172, 46, 14);
		contentPane.add(lblMonth);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"[Select Month]", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox_1.setBounds(216, 169, 136, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\RCooper\\Desktop\\Case Tracker Backgrounds\\Main Back for Add Frame.png"));
		lblNewLabel.setBounds(0, 0, 434, 301);
		contentPane.add(lblNewLabel);
	}

}
