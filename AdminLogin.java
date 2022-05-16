package agriculture;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class AdminLogin extends JFrame {

	private Image img_login = new ImageIcon(Login.class.getResource("/LoginPhoto.png")).getImage().getScaledInstance(350,300, Image.SCALE_SMOOTH);
    

	private JPanel contentPane;
	private JTextField UsernametextField;
	private JTextField Back;
	private JPasswordField passwordField;
	private JButton AdminLoginB;
	private JButton AdminLoginBut;
	
	Connection connect = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setResizable(false);	
		connect = mysqlconnection.dbConnector();
		//exit
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(85, 107, 47));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//image
	    JLabel IbllconLogo = new JLabel("");
	    IbllconLogo.setBounds(330, 115, 330, 252);
		IbllconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(IbllconLogo);
		IbllconLogo.setIcon(new ImageIcon(img_login));
		
		//name 
		JLabel lblNewLabel = new JLabel("Admin Login");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(97, 89, 130, 58);
		contentPane.add(lblNewLabel);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new LineBorder(new Color(255, 215, 0), 9));
		verticalBox.setBackground(new Color(255, 215, 0));
		verticalBox.setBounds(0, 76, 686, 3);
		contentPane.add(verticalBox);
		
		JLabel lblCrops_1 = new JLabel("Username or Email");
		lblCrops_1.setForeground(Color.WHITE);
		lblCrops_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblCrops_1.setBounds(50, 157, 195, 25);
		contentPane.add(lblCrops_1);
		
		JLabel lblCrops_1_1 = new JLabel("Password");
		lblCrops_1_1.setForeground(Color.WHITE);
		lblCrops_1_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblCrops_1_1.setBounds(50, 246, 215, 25);
		contentPane.add(lblCrops_1_1);
		
		UsernametextField = new JTextField();
		UsernametextField.setFont(new Font("Arial", Font.PLAIN, 16));
		UsernametextField.setColumns(10);
		UsernametextField.setBounds(50, 192, 224, 31);
		contentPane.add(UsernametextField);
		
		JLabel lblNewLabel_1 = new JLabel("Agriculture Information Management System");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel_1.setBounds(50, 10, 672, 58);
		contentPane.add(lblNewLabel_1);
		
		//guest button
		AdminLoginB = new JButton("Login");
		AdminLoginB.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				AdminLoginB.setForeground(Color.RED);
				
			}
	
			public void mouseExited(MouseEvent e) {
				AdminLoginB.setForeground(Color.BLACK);
			}
			
			public void mouseClicked(MouseEvent e) {
				AdminLogin.this.dispose();
				AdminSection Adashboard = new AdminSection();
				Adashboard.setVisible(true);
			}
		});
		AdminLoginB.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String username, password;
				username=UsernametextField.getText();
				password=passwordField.getText();
				try {
					String query = "select * from admin where Username=? and Password=?";
					PreparedStatement state = connect.prepareStatement(query);
					state.setString(1, username);
					state.setString(2, password);
					

					ResultSet result = state.executeQuery();
					int count = 0;
					while (result.next()) {
						count++;

					}
					if (count == 1) {
						AdminLogin.this.dispose();
						AdminSection admin = new AdminSection();
						admin.getFrame().setVisible(true);
						
					} else if (count > 1) {
						JOptionPane.showMessageDialog(null, "Duplicate UserName or Password");
						passwordField.setText("");
						
					} else {
						JOptionPane.showMessageDialog(null, "Username or Password is not correct");
						UsernametextField.setText("");
						passwordField.setText("");
						
					}
					result.close();
					state.close();
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(contentPane,e2);
				}

			}
		});
		AdminLoginB.setFont(new Font("Arial", Font.BOLD, 14));
		AdminLoginB.setBounds(60, 333, 89, 31);
		contentPane.add(AdminLoginB);
		
		//reset password
		AdminLoginBut = new JButton("Reset");
		AdminLoginBut.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				AdminLoginBut.setForeground(Color.RED);
				
			}
	
			public void mouseExited(MouseEvent e) {
				AdminLoginBut.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminLogin.this.dispose();
				ForgotPassword ResetPass = new ForgotPassword();
				ResetPass.setVisible(true);
			}
		});
		AdminLoginBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		AdminLoginBut.setFont(new Font("Arial", Font.BOLD, 14));
		AdminLoginBut.setBounds(173, 333, 89, 31);
		contentPane.add(AdminLoginBut);
		
		
		
		Back = new JTextField();
		Back.setBackground(new Color(85, 107, 47));
		Back.setEditable(false);
		Back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminLogin.this.dispose();
				Login NewLogin = new Login();
				NewLogin.setVisible(true);
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
		Back.setForeground(Color.ORANGE);
		Back.setText("\u2190");
		Back.setBounds(10, 26, 42, 19);
		contentPane.add(Back);
		Back.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(50, 281, 224, 31);
		contentPane.add(passwordField);
	}
}
