import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class VisaEdit extends JFrame {

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
					VisaEdit frame = new VisaEdit();
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
	public VisaEdit() {
		setTitle("Visa Edit Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAction = new JMenu("Action");
		menuBar.add(mnAction);
		
		JMenuItem mntmInactiveCases = new JMenuItem("Inactive Cases");
		mntmInactiveCases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VisaInactive vi = new VisaInactive();
				vi.setVisible(true);
				dispose();
			}
		});
		mnAction.add(mntmInactiveCases);
		
		JMenuItem mntmGoBack = new JMenuItem("Go Back");
		mntmGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VisaChoice vc = new VisaChoice();
				vc.setVisible(true);
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
		label.setBounds(84, 385, 46, 14);
		label.setFont(new Font("Dialog", Font.BOLD, 12));
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
				String sql = "select * from vchart where Case_Name like '%"+name+"%'";
				ResultSet rs = st.executeQuery(sql);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				c.stop();
				
				}catch(ClassNotFoundException| SQLException e)
				{
				JOptionPane.showMessageDialog(contentPane, e);
				}
			}
		});
		textField.setBounds(140, 382, 149, 20);
		textField.setColumns(10);
		contentPane.add(textField);
		
		JButton button = new JButton("Load Cases");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Connect c = new Connect();
					Connection con = c.start();
					PreparedStatement ps=con.prepareStatement("select * from vchart");
					ResultSet rs =	ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					c.stop();
					
				}catch(Exception e){JOptionPane.showMessageDialog(contentPane, e);}
				
			}
		});
		button.setBounds(657, 385, 124, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Edit Case");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VUpdateFrame vuf = new VUpdateFrame();
				vuf.setVisible(true);
				
			}
		});
		button_1.setBounds(805, 385, 110, 23);
		contentPane.add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(66, 26, 850, 338);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\RCooper\\Desktop\\Case Tracker Backgrounds\\View Frame Size Background.jpg"));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel.setBounds(0, 0, 984, 440);
		contentPane.add(lblNewLabel);
	}

}
