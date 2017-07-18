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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class EditFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	 String searchValue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditFrame frame = new EditFrame();
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
	public EditFrame() {
		setTitle("Edit Process");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Action");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Inactive Cases");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PassInactiveCase pic = new PassInactiveCase();
				pic.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Go Back");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PassportChoice pc = new PassportChoice();
				pc.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 11, 831, 345);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Load Cases");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					Connect c = new Connect();
					Connection con = c.start();
					PreparedStatement ps=con.prepareStatement("select * from pchart");
					ResultSet rs =	ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					c.stop();
					
				}catch(Exception e){JOptionPane.showMessageDialog(contentPane, e);}
				
			}
		});
		btnNewButton.setBounds(666, 394, 124, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Edit Case");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateFrame uf = new UpdateFrame();
				uf.setVisible(true);
					
				
				
			}
		});
		btnNewButton_1.setBounds(814, 394, 110, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setForeground(Color.WHITE);
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSearch.setBounds(93, 394, 46, 14);
		contentPane.add(lblSearch);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
	String name = textField.getText();
				
				try{
				Connect c = new Connect();
				Connection con = c.start();
				Statement st = con.createStatement();
				String sql = "select * from pchart where Case_Name like '%"+name+"%'";
				ResultSet rs = st.executeQuery(sql);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				c.stop();
				searchValue = name;
				
				}catch(ClassNotFoundException| SQLException e)
				{
				JOptionPane.showMessageDialog(contentPane, e);
				}
			}
		});
		textField.setBounds(149, 391, 149, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		Image imgback =  new ImageIcon(this.getClass().getResource("/View Frame Size Background.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(imgback));
		
		lblNewLabel.setBounds(0, 0, 984, 440);
		contentPane.add(lblNewLabel);
	}
}
