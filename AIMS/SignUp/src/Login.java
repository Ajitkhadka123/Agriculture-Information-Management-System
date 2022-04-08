import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	
	private Image img_logo = new ImageIcon(Login.class.getResource("img/corpslogo.png")).getImage().getScaledInstance(90,90, Image.SCALE_SMOOTH);

	private JPanel contentPane;
	private JTextField UserTextField;
	private JPasswordField pwdPassword;
	private JTextField Back;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 200, 200));
		contentPane.setBorder(new LineBorder(new Color(255, 192, 203), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(2, 2, 596, 396);
		panel.setBorder(new LineBorder(new Color(255, 192, 203), 2));
		panel.setBackground(new Color(255, 240, 245));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(146, 163, 290, 40);
		panel.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		//username section
		UserTextField = new JTextField();
		UserTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		UserTextField.setBackground(new Color(255, 250, 250));
		UserTextField.setName("username");
		UserTextField.setFont(new Font("Arial", Font.PLAIN, 14));
		UserTextField.setForeground(Color.BLACK);
		UserTextField.setBounds(0, 0, 290, 40);
		panel_1_1.add(UserTextField);
		UserTextField.setColumns(10);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(Color.WHITE);
		panel_1_1_1.setBounds(146, 245, 290, 40);
		panel.add(panel_1_1_1);
		panel_1_1_1.setLayout(null);
		
		//password section
		pwdPassword = new JPasswordField();
		pwdPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		pwdPassword.setBackground(new Color(255, 250, 250));
		pwdPassword.setBounds(0, 0, 290, 40);
		panel_1_1_1.add(pwdPassword);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
		});
		panel_1.setBackground(new Color(255, 215, 0));
		panel_1.setBounds(146, 317, 290, 43);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		//Login button
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setForeground(Color.WHITE);
			}
			
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 3, 290, 37);
		panel_1.add(lblNewLabel);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want exit the Application?", "Confirmation", JOptionPane.YES_NO_OPTION) ==0) {
					Login.this.dispose();
				}
			}
			@Override
			
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.ORANGE);
			}
		});
		lblX.setBackground(new Color(0, 0, 0));
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setLabelFor(this);
		lblX.setForeground(new Color(255, 165, 0));
		lblX.setBounds(562, 5, 45, 13);
		panel.add(lblX);
		
		JLabel IbllconLogo = new JLabel("");
		IbllconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		IbllconLogo.setBounds(162, 0, 238, 143);
		panel.add(IbllconLogo);
		IbllconLogo.setIcon(new ImageIcon(img_logo));
		
		JLabel lblNewLabel_2 = new JLabel("Username or Email");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(147, 129, 152, 22);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setForeground(Color.ORANGE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(146, 213, 75, 22);
		panel.add(lblNewLabel_2_1);
		
		Back = new JTextField();
		Back.setEditable(false);
		Back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login.this.dispose();
				MainLogin firstLogin = new MainLogin();
				firstLogin.setVisible(true);
			}
			public void mouseEntered(MouseEvent e) {
				Back.setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent e) {
				Back.setForeground(Color.ORANGE);
			}
		});
		Back.setFont(new Font("Tahoma", Font.BOLD, 33));
		Back.setBorder(null);
		Back.setBackground(new Color(255, 240, 245));
		Back.setForeground(Color.ORANGE);
		Back.setText("\u2190");
		Back.setBounds(10, 10, 42, 19);
		panel.add(Back);
		Back.setColumns(10);
		
		JLabel Forgotp = new JLabel("Forgot Password");
		Forgotp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login.this.dispose();
				Forgetpass newpassword = new Forgetpass();
				newpassword.setVisible(true);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Forgotp.setForeground(Color.RED);
				
			}
			
			public void mouseExited(MouseEvent e) {
				Forgotp.setForeground(Color.ORANGE);
			}
		});
		Forgotp.setForeground(Color.ORANGE);
		Forgotp.setBounds(333, 285, 121, 22);
		panel.add(Forgotp);
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
}


