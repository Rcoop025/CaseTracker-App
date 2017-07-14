import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

public class VisaInactive extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisaInactive frame = new VisaInactive();
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
	public VisaInactive() {
		setTitle("Visa Inactive View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAction = new JMenu("Action");
		menuBar.add(mnAction);
		
		JMenuItem mntmAddInactiveCase = new JMenuItem("Add Inactive Case");
		mnAction.add(mntmAddInactiveCase);
		
		JMenuItem mntmDeleteInactiveCase = new JMenuItem("Delete Inactive Case");
		mnAction.add(mntmDeleteInactiveCase);
		
		JMenuItem mntmGoBack = new JMenuItem("Go Back");
		mntmGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VisaView vv = new VisaView();
				vv.setVisible(true);
				dispose();
			}
		});
		mnAction.add(mntmGoBack);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Search:");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(55, 403, 46, 14);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				String name = textField.getText();
				try{
					Connect c = new Connect();
					Connection con = c.start();
					Statement st = con.createStatement();
					String sql = "select * from visa_inactive where Case_Name like '%"+name+"%'";
					ResultSet rs = st.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					c.stop();
					
					}catch(ClassNotFoundException| SQLException e)
					{
					JOptionPane.showMessageDialog(contentPane, e);
					}
			}
		});
		textField.setColumns(10);
		textField.setBounds(112, 403, 143, 20);
		contentPane.add(textField);
		
		JButton button = new JButton("Load Cases");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Connect c = new Connect();
					Connection con = c.start();
					PreparedStatement ps=con.prepareStatement("select * from visa_inactive");
					ResultSet rs =	ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					c.stop();
					
				}catch(Exception e){JOptionPane.showMessageDialog(contentPane, e);}
			}
		});
		button.setBounds(689, 403, 117, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Print");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					table.print();
					
				}catch(PrinterException e)
				{
					JOptionPane.showMessageDialog(contentPane, e);
				}
			}
		});
		button_1.setBounds(826, 403, 117, 23);
		contentPane.add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 26, 900, 366);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\RCooper\\Desktop\\Case Tracker Backgrounds\\View Frame Size Background.jpg"));
		lblNewLabel.setBounds(0, 0, 984, 440);
		contentPane.add(lblNewLabel);
	}

}
