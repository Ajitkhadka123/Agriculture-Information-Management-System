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

public class MunicipalityLogin extends JFrame {

	private Image img_login = new ImageIcon(Login.class.getResource("/LoginPhoto.png")).getImage().getScaledInstance(350,300, Image.SCALE_SMOOTH);
    

	private JPanel contentPane;
	private JTextField usernametextField;
	private JTextField Back;


	private JButton AdminLoginB;
	Connection connect = null;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MunicipalityLogin frame = new MunicipalityLogin();
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
	public MunicipalityLogin() {
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
		
		//guest button
		AdminLoginB = new JButton("Login");
		AdminLoginB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username, password;
				username=usernametextField.getText();
				password=passwordField.getText();
				try {
					String query = "select * from user where Username=? and Password=?";
					PreparedStatement state = connect.prepareStatement(query);
					state.setString(1, username);
					state.setString(2, password);
					

					ResultSet result = state.executeQuery();
					int count = 0;
					while (result.next()) {
						count++;

					}
					if (count == 1) {
						MunicipalityLogin.this.setVisible(false);
						Dash door = new Dash(username);
						door.setVisible(true);
						
					} else if (count > 1) {
						JOptionPane.showMessageDialog(null, "Duplicate UserName or Password");
						passwordField.setText("");
						
					} else {
						JOptionPane.showMessageDialog(null, "Username or Password is not correct");
						usernametextField.setText("");
						passwordField.setText("");
						
					}
					result.close();
					state.close();
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(contentPane,e2);
				}
			}
		});
		AdminLoginB.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				AdminLoginB.setForeground(Color.RED);
				
			}
	
			public void mouseExited(MouseEvent e) {
				AdminLoginB.setForeground(Color.BLACK);
			}
			
//			public void mouseClicked(MouseEvent e) {
////				AdminLogin.this.dispose();
////				AdminSection Adashboard = new AdminSection();
////				Adashboard.setVisible(true);
////				if(e.getSource()==AdminLoginB) {
////					try {
////						new AdminSection().setVisible(true);
////					}catch (Exception E) {
////						System.out.println();
////					}
////				}
////			}
			});
		
		AdminLoginB.setFont(new Font("Arial", Font.BOLD, 14));
		AdminLoginB.setBounds(120, 335, 89, 31);
		contentPane.add(AdminLoginB);
		
		//image
	    JLabel IbllconLogo = new JLabel("");
	    IbllconLogo.setBounds(330, 115, 330, 252);
		IbllconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(IbllconLogo);
		IbllconLogo.setIcon(new ImageIcon(img_login));
		
		//name 
		JLabel lblNewLabel = new JLabel("Municipality Login");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(50, 89, 195, 58);
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
		
		usernametextField = new JTextField();
		usernametextField.setFont(new Font("Arial", Font.PLAIN, 16));
		usernametextField.setColumns(10);
		usernametextField.setBounds(50, 192, 224, 31);
		contentPane.add(usernametextField);
		
		JLabel lblNewLabel_1 = new JLabel("Agriculture Information Management System");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel_1.setBounds(50, 10, 672, 58);
		contentPane.add(lblNewLabel_1);
		
		Back = new JTextField();
		Back.setBackground(new Color(85, 107, 47));
		Back.setEditable(false);
		Back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MunicipalityLogin.this.dispose();
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
