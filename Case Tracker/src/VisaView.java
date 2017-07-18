import java.awt.BorderLayout;
import java.sql.*;
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
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;

public class VisaView extends JFrame {

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
					VisaView frame = new VisaView();
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
	public VisaView() {
		setTitle("Visa View");
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
				VisaChoice vc  = new VisaChoice();
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
		
		JButton button = new JButton("View Cases");
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
		button.setBounds(659, 389, 129, 23);
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
		button_1.setBounds(824, 389, 118, 23);
		contentPane.add(button_1);
		
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
		textField.setBounds(108, 390, 146, 20);
		textField.setColumns(10);
		contentPane.add(textField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 11, 900, 366);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setColumnHeaderView(scrollBar);
		
		JLabel lblNewLabel = new JLabel("Search:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(52, 393, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		Image imgback =  new ImageIcon(this.getClass().getResource("/View Frame Size Background.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(imgback));
		
		
		lblNewLabel_1.setBounds(0, 0, 984, 440);
		contentPane.add(lblNewLabel_1);
	}
}
