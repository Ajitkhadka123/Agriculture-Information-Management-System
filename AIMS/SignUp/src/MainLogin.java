import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class MainLogin extends JFrame {
	
	private Image img_logo = new ImageIcon(Login.class.getResource("img/corpslogo.png")).getImage().getScaledInstance(90,90, Image.SCALE_SMOOTH);

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainLogin frame = new MainLogin();
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
	public MainLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(475, 200, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 240, 245));
		contentPane.setBorder(new LineBorder(new Color(255, 192, 203), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 0, 0);
		panel.setBorder(new LineBorder(new Color(255, 192, 203), 2));
		panel.setBackground(new Color(255, 240, 245));
		contentPane.add(panel);
	    panel.setLayout(null);
		setUndecorated(true);
		
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(2, 2, 596, 396);
		panel1.setBorder(new LineBorder(new Color(255, 192, 203), 2));
		panel1.setBackground(new Color(255, 240, 245));
		contentPane.add(panel1);
		panel1.setLayout(null);
		panel1.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainLogin.this.dispose();
				Login secondLogin1 = new Login();
				secondLogin1.setVisible(true);
			}
		});
		panel_1.setBounds(143, 187, 290, 43);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(255, 215, 0));
		panel1.add(panel_1);
		
		JLabel IbllconLogo = new JLabel("");
		IbllconLogo.setBounds(170, -11, 238, 143);
		IbllconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(IbllconLogo);
		IbllconLogo.setIcon(new ImageIcon(img_logo));
		
		//Login as User Button
		JLabel lblNewLabel = new JLabel("LOGIN as User");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainLogin.this.dispose();
				Login secondLogin = new Login();
				secondLogin.setVisible(true);
			}
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setForeground(Color.WHITE);
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 3, 290, 37);
		panel_1.add(lblNewLabel);
		
		
		
		JLabel IbllconLogo1 = new JLabel("");
		IbllconLogo1.setBounds(180, 5, 238, 143);
		IbllconLogo1.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(IbllconLogo1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainLogin.this.dispose();
				Login secondLogin = new Login();
				secondLogin.setVisible(true);
			}
				
			
		});
		panel_1_1.setBounds(143, 250, 290, 43);
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(255, 215, 0));
		panel1.add(panel_1_1);
		
		//login as Admin button
		JLabel lblNewLabel_1 = new JLabel("LOGIN as Admin");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				MainLogin.this.dispose();
				Login secondLogin = new Login();
				secondLogin.setVisible(true);
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(0, 3, 290, 37);
		panel_1_1.add(lblNewLabel_1);
		
		
		JLabel lblX2 = new JLabel("X");
		lblX2.setBounds(562, 5, 45, 13);
		lblX2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want exit the Application?", "Confirmation", JOptionPane.YES_NO_OPTION) ==0) {
					MainLogin.this.dispose();
				}
			}
			@Override
			
			public void mouseEntered(MouseEvent e) {
					lblX2.setForeground(Color.RED);
				}
				public void mouseExited(MouseEvent e) {
					lblX2.setForeground(Color.ORANGE);
				}

			});
			lblX2.setHorizontalAlignment(SwingConstants.CENTER);
			lblX2.setForeground(new Color(255, 165, 0));
			lblX2.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
			lblX2.setBackground(Color.BLACK);
			panel1.add(lblX2);
			
			JPanel panel_1_1_1 = new JPanel();
			panel_1_1_1.setBounds(143, 314, 290, 43);
			panel_1_1_1.setLayout(null);
			panel_1_1_1.setBackground(new Color(255, 215, 0));
			panel1.add(panel_1_1_1);
				
			//create account button
			JLabel lblNewLabel_1_1 = new JLabel("Create Account");
			lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					MainLogin.this.dispose();
					CreateAccount createpage = new CreateAccount();
					createpage.setVisible(true);
				}
					public void mouseEntered(MouseEvent e) {
						lblNewLabel_1_1.setForeground(Color.RED);
					}
					public void mouseExited(MouseEvent e) {
						lblNewLabel_1_1.setForeground(Color.WHITE);
					}
				
			});
			
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1.setForeground(Color.WHITE);
			lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 15));
			lblNewLabel_1_1.setBounds(0, 3, 290, 37);
			panel_1_1_1.add(lblNewLabel_1_1);
			
			JLabel lblWelcomeToAgriculture = new JLabel("Welcome to Agriculture information Management System");
			lblWelcomeToAgriculture.setBounds(93, 128, 427, 37);
			lblWelcomeToAgriculture.setHorizontalAlignment(SwingConstants.CENTER);
			lblWelcomeToAgriculture.setForeground(Color.ORANGE);
			lblWelcomeToAgriculture.setFont(new Font("Arial", Font.BOLD, 15));
			panel1.add(lblWelcomeToAgriculture);
		
		
		
	}

}
