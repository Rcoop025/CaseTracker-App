import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VisaChoice extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisaChoice frame = new VisaChoice();
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
	public VisaChoice() {
		setTitle("Visa Litigation Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 600, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Action");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Litigations Menu");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LitigationChoice lc = new LitigationChoice();
				lc.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Passport Menu");
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
		
		

		
		JLabel ViewLabel = new JLabel("");
		ViewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				VisaView vv = new VisaView();
				vv.setVisible(true);
				dispose();
			
			}
		});
		Image img =  new ImageIcon(this.getClass().getResource("/presentation.png")).getImage();
		ViewLabel.setIcon(new ImageIcon(img));
		ViewLabel.setBounds(156, 241, 64, 62);
		contentPane.add(ViewLabel);
		
		JLabel EditLabel = new JLabel("");
		EditLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				VisaEdit ve = new VisaEdit();
				ve.setVisible(true);
				dispose();
			}
		});
		Image img2 =  new ImageIcon(this.getClass().getResource("/content.png")).getImage();
		EditLabel.setIcon(new ImageIcon(img2));
		EditLabel.setBounds(366, 241, 69, 62);
		contentPane.add(EditLabel);
		
		JLabel AddLabel = new JLabel("");
		AddLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				VisaAdd va = new VisaAdd();
				va.setVisible(true);
				dispose();
			}
		});
		Image img3 =  new ImageIcon(this.getClass().getResource("/folder.png")).getImage();
		AddLabel.setIcon(new ImageIcon(img3));
		AddLabel.setBounds(156, 412, 64, 62);
		contentPane.add(AddLabel);
		
		JLabel AttorneyLabel = new JLabel("");
		AttorneyLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				VisaAttorney va = new VisaAttorney();
				va.setVisible(true);
				dispose();
			}
		});
		Image img4 =  new ImageIcon(this.getClass().getResource("/team.png")).getImage();
		AttorneyLabel.setIcon(new ImageIcon(img4));
		AttorneyLabel.setBounds(366, 404, 64, 70);
		contentPane.add(AttorneyLabel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\RCooper\\Desktop\\Case Tracker Backgrounds\\Visa Background.jpg"));
		lblNewLabel.setBounds(0, 0, 584, 540);
		contentPane.add(lblNewLabel);
	}
}
