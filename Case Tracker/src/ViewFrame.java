import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class ViewFrame extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private JMenuBar menuBar;
	private JMenu mnAction;
	private JMenuItem mntmInactiveCases;
	private JButton btnNewButton_1;
	private JMenuItem mntmGoBack;
	private JTextField textField;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewFrame frame = new ViewFrame();
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
	public ViewFrame() {
		setTitle("Passport Tracking Chart [VIEW ONLY][Active Cases]");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnAction = new JMenu("Action");
		menuBar.add(mnAction);
		
		mntmInactiveCases = new JMenuItem("Inactive Cases");
		mntmInactiveCases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PassInactiveCase pic = new PassInactiveCase();
				pic.setVisible(true);
				dispose();
			}
		});
		mnAction.add(mntmInactiveCases);
		
		mntmGoBack = new JMenuItem("Go Back");
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
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.DARK_GRAY, null));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(42, 11, 900, 366);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		JButton btnNewButton = new JButton("View Cases");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					Connect c = new Connect();
					Connection con = c.start();
					PreparedStatement ps=con.prepareStatement("select * from pchart");
					ResultSet rs =	ps.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
					c.stop();
					
				}catch(Exception e){JOptionPane.showMessageDialog(contentPane, e);}
				
					
				
			}
		});
		btnNewButton.setBounds(666, 393, 129, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Print");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					table_1.print();
					
				}catch(PrinterException e)
				{
					JOptionPane.showMessageDialog(contentPane, e);
				}
			}
		});
		btnNewButton_1.setBounds(824, 393, 118, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Search:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(23, 397, 46, 14);
		contentPane.add(lblNewLabel);
		
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
				table_1.setModel(DbUtils.resultSetToTableModel(rs));
				c.stop();
				
				}catch(ClassNotFoundException| SQLException e)
				{
				JOptionPane.showMessageDialog(contentPane, e);
				}
			
			}
		});
		textField.setBounds(79, 394, 146, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\RCooper\\Desktop\\Case Tracker Backgrounds\\View Frame Size Background.jpg"));
		lblNewLabel_1.setBounds(0, 0, 984, 440);
		contentPane.add(lblNewLabel_1);
	}
}
