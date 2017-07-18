import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Image;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class AttorneyChart extends JFrame {

	private static JPanel contentPane;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttorneyChart frame = new AttorneyChart();
					frame.setVisible(true);
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(contentPane, e);
				}
				init();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AttorneyChart() {
		setTitle("Attorney Rotation Chart");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAction = new JMenu("Action");
		menuBar.add(mnAction);
		
		JMenuItem mntmGoBack = new JMenuItem("Go Back");
		mntmGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PassportChoice pc = new PassportChoice();
				pc.setVisible(true);
				dispose();
				
			}
		});
	
		mnAction.add(mntmGoBack);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(81, 33, 819, 318);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Load Attorneys");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
			}
		});
		btnNewButton.setBounds(600, 389, 141, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Assign Case");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateCaseLoad  ucl = new UpdateCaseLoad();
				ucl.setVisible(true);
				

			}
		});
		btnNewButton_1.setBounds(770, 389, 130, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		Image imgback =  new ImageIcon(this.getClass().getResource("/View Frame Size Background.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(imgback));
		
		lblNewLabel.setBounds(0, 0, 984, 440);
		contentPane.add(lblNewLabel);
		
	}
	
	public static void init()
	{
		
		try {
			Connect c = new Connect();
			Connection con = c.start();
			String sql = "select * from attorneys";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs =	ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			c.stop();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, e);
		}
	}
}
