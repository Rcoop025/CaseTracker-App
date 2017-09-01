import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PassportChoice extends JFrame {

	private JPanel contentPane;
	private JLabel editLabel;
	private JLabel addCaseLabel;
	JMenuBar menuBar;
	JMenu  optMenu, chartsMenu, attorneyRotation, helpMenu;
	JMenuItem viewChart, addCase, editCase, CheckAttorneys, editAttorneys;

	/**
	 * Launch the application.
	 */
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PassportChoice frame = new PassportChoice();
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
	public PassportChoice() {
		setTitle("Passport Litigation Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 600, 600);
		
		JMenuBar menuBar_1 = new JMenuBar();
		setJMenuBar(menuBar_1);
		
		JMenu mnAction = new JMenu("Action");
		menuBar_1.add(mnAction);
		
		JMenuItem mntmLitigationPage = new JMenuItem("Litigation Page");
		mntmLitigationPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LitigationChoice lc = new LitigationChoice();
				lc.setVisible(true);
				dispose();
			}
		});
		
		mnAction.add(mntmLitigationPage);
		
		JMenuItem mntmVisaLitigationMenu = new JMenuItem("Visa Litigation Menu");
		mntmVisaLitigationMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisaChoice vc =  new VisaChoice();
				vc.setVisible(true);
				dispose();
				
			}
		});
		mnAction.add(mntmVisaLitigationMenu);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel viewLabel = new JLabel("");
		viewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewFrame vf = new ViewFrame();
				vf.setVisible(true);
				dispose();
				
				
			}
		});
		Image img =  new ImageIcon(this.getClass().getResource("/presentation.png")).getImage();
		viewLabel.setIcon(new ImageIcon(img));
		viewLabel.setBounds(156, 228, 60, 75);
		contentPane.add(viewLabel);
		
		addCaseLabel = new JLabel("");
		addCaseLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddFrame af = new AddFrame();
				af.setVisible(true);
				addCaseLabel.setVisible(false);
				dispose();
				
				
			}
		});
		Image img2 =  new ImageIcon(this.getClass().getResource("/folder.png")).getImage();
		addCaseLabel.setIcon(new ImageIcon(img2));
		addCaseLabel.setBounds(156, 407, 60, 58);
		contentPane.add(addCaseLabel);
		
		 editLabel = new JLabel("");
		 editLabel.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent arg0) {
		 		
		 		EditFrame ef = new EditFrame();
		 		ef.setVisible(true);
		 		dispose();
		 	}
		 });
		Image img3 =  new ImageIcon(this.getClass().getResource("/content.png")).getImage();
		editLabel.setIcon(new ImageIcon(img3));
		editLabel.setBounds(367, 228, 73, 75);
		contentPane.add(editLabel);
		
		JLabel ARotationLabel = new JLabel("");
		ARotationLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AttorneyChart ac = new AttorneyChart();
				ac.setVisible(true);
				
				/*PassInactiveCase pic = new PassInactiveCase();
				pic.setVisible(true);*/
				dispose();
			}
		});
		Image img4 =  new ImageIcon(this.getClass().getResource("/team.png")).getImage();
		ARotationLabel.setIcon(new ImageIcon(img4));
		ARotationLabel.setBounds(367, 402, 73, 75);
		contentPane.add(ARotationLabel);
		
		JLabel lblNewLabel = new JLabel("New label");
		Image imgback =  new ImageIcon(this.getClass().getResource("/Passport Background (update 3).png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(imgback));
		lblNewLabel.setBounds(0, 0, 584, 540);
		contentPane.add(lblNewLabel);
	}
}
