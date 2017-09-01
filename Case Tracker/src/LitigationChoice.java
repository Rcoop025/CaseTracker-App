

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class LitigationChoice extends JFrame {

	private JPanel contentPane;
	
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LitigationChoice frame = new LitigationChoice();
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
	public LitigationChoice() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				
			int a =	JOptionPane.showConfirmDialog(contentPane, "Do you want to close the application");
			if(a ==0)
				System.exit(0);
			
				
			}
		});
		setTitle("Litigation Menu");
		
		
		
		//Creates the first item in the menu.
		
		
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(400, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Click");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisaChoice vc = new VisaChoice();
				vc.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setBounds(149, 424, 67, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Click");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PassportChoice pc = new PassportChoice();
				pc.setVisible(true);
				dispose();
			
				
			}
		});
		btnNewButton_1.setBounds(351, 424, 67, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		Image imgback =  new ImageIcon(this.getClass().getResource("Litigation Background (Final Update).png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(imgback));
		lblNewLabel.setBounds(0, 0, 584, 561);
		contentPane.add(lblNewLabel);
	}
	

	
}
