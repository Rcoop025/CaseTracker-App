import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class PassInactiveCase extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PassInactiveCase frame = new PassInactiveCase();
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
	public PassInactiveCase() {
		setTitle("Inactive Cases");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAction = new JMenu("Action");
		menuBar.add(mnAction);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Add Inactive Case");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PassInactiveAdd pia = new PassInactiveAdd();
				pia.setVisible(true);
				dispose();
				
			}
		});
		mnAction.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Delete Inactive Case");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteInactiveCase dic = new DeleteInactiveCase();
				dic.setVisible(true);
				
			}
		});
		mnAction.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Go Back");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewFrame vf = new ViewFrame();
				vf.setVisible(true);
				dispose();
			}
		});
		
		JMenuItem mntmReactivateCase = new JMenuItem("Reactivate Case");
		mntmReactivateCase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReactivateFrame rf = new ReactivateFrame();
				rf.setVisible(true);
				dispose();
				
				
			}
		});
		mnAction.add(mntmReactivateCase);
		mnAction.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 11, 900, 366);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Print");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					table.print();
					
				}catch(PrinterException e)
				{
					JOptionPane.showMessageDialog(contentPane, e);
				}
			}
		});
		btnNewButton.setBounds(824, 388, 117, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Load Cases");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try{
				Connect c = new Connect();
				Connection con = c.start();
				PreparedStatement ps=con.prepareStatement("select * from pass_inactive");
				ResultSet rs =	ps.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				c.stop();
				
			}catch(Exception e){JOptionPane.showMessageDialog(contentPane, e);}
			
				
			}
		
			
		});
		btnNewButton_1.setBounds(687, 388, 117, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setForeground(Color.WHITE);
		lblSearch.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSearch.setBounds(53, 388, 46, 14);
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
					String sql = "select * from pass_inactive  where Case_Name like '%"+name+"%'";
					ResultSet rs = st.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					c.stop();
					
					}catch(ClassNotFoundException| SQLException e)
					{
					JOptionPane.showMessageDialog(contentPane, e);
					}
			}
		});
		textField.setBounds(110, 388, 143, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		Image imgback =  new ImageIcon(this.getClass().getResource("/View Frame Size Background.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(imgback));
		
		lblNewLabel.setBounds(0, 0, 984, 440);
		contentPane.add(lblNewLabel);
	}
}
