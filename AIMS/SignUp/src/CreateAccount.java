import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

public class CreateAccount extends JFrame {

	private JPanel contentPane;
	private JTextField Back;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JPasswordField passwordField_3;
	private JPasswordField passwordField_4;
	private JPasswordField passwordField_5;
	private JTextField txtCreateFreeAccount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount frame = new CreateAccount();
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
	public CreateAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 800, 600);
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
		panel1.setBounds(2, 2, 796, 596);
		panel1.setBorder(new LineBorder(new Color(255, 192, 203), 2));
		panel1.setBackground(new Color(255, 240, 245));
		contentPane.add(panel1);
		panel1.setLayout(null);
		panel1.setLayout(null);
		
		JLabel lblX2 = new JLabel("X");
		lblX2.setBounds(758, 0, 50, 25);
		lblX2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want exit the Application?", "Confirmation", JOptionPane.YES_NO_OPTION) ==0) {
					CreateAccount.this.dispose();
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
			lblX2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
			lblX2.setBackground(Color.BLACK);
			panel1.add(lblX2);
		
		Back = new JTextField();
		Back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CreateAccount.this.dispose();
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
		Back.setBorder(null);
		Back.setEditable(false);
		Back.setBackground(new Color(255, 240, 245));
		Back.setForeground(Color.ORANGE);
		Back.setFont(new Font("Tahoma", Font.BOLD, 33));
		Back.setText("\u2190");
		Back.setBounds(10, 10, 40, 25);
		panel1.add(Back);
		Back.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("First Name");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(45, 67, 152, 22);
		panel1.add(lblNewLabel_2);
		
		//username
		textField = new JTextField();
		textField.setName("username");
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Arial", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBackground(new Color(255, 250, 250));
		textField.setBounds(45, 97, 290, 40);
		panel1.add(textField);
		
		//password
		JLabel lblNewLabel_2_1 = new JLabel("Email");
		lblNewLabel_2_1.setForeground(Color.ORANGE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(45, 149, 75, 22);
		panel1.add(lblNewLabel_2_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(255, 215, 0));
		panel_1.setBounds(45, 501, 290, 43);
		panel1.add(panel_1);
		
		// Registor button
		JLabel lblRegister = new JLabel("Register");
		lblRegister.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				lblRegister.setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent e) {
				lblRegister.setForeground(Color.WHITE);
			}
		});
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setForeground(Color.WHITE);
		lblRegister.setFont(new Font("Arial", Font.BOLD, 15));
		lblRegister.setBounds(0, 3, 290, 37);
		panel_1.add(lblRegister);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 250, 250));
		passwordField.setBounds(45, 181, 290, 40);
		panel1.add(passwordField);
		
		JLabel lblNewLabel_2_2 = new JLabel("Last Name");
		lblNewLabel_2_2.setForeground(Color.ORANGE);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(417, 67, 152, 22);
		panel1.add(lblNewLabel_2_2);
		
		textField_1 = new JTextField();
		textField_1.setName("username");
		textField_1.setForeground(Color.BLACK);
		textField_1.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(255, 250, 250));
		textField_1.setBounds(417, 97, 290, 40);
		panel1.add(textField_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBackground(new Color(255, 250, 250));
		passwordField_1.setBounds(417, 181, 290, 40);
		panel1.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBackground(new Color(255, 250, 250));
		passwordField_2.setBounds(45, 267, 290, 40);
		panel1.add(passwordField_2);
		
		passwordField_3 = new JPasswordField();
		passwordField_3.setBackground(new Color(255, 250, 250));
		passwordField_3.setBounds(417, 267, 290, 40);
		panel1.add(passwordField_3);
		
		passwordField_4 = new JPasswordField();
		passwordField_4.setBackground(new Color(255, 250, 250));
		passwordField_4.setBounds(45, 351, 290, 40);
		panel1.add(passwordField_4);
		
		passwordField_5 = new JPasswordField();
		passwordField_5.setBackground(new Color(255, 250, 250));
		passwordField_5.setBounds(45, 435, 290, 40);
		panel1.add(passwordField_5);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Password");
		lblNewLabel_2_1_1.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(45, 235, 75, 22);
		panel1.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Address");
		lblNewLabel_2_1_1_1.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1.setBounds(45, 319, 75, 22);
		panel1.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Phone Number");
		lblNewLabel_2_1_1_1_1.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1.setBounds(45, 403, 152, 22);
		panel1.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Confirim Email");
		lblNewLabel_2_2_1.setForeground(Color.ORANGE);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1.setBounds(417, 149, 152, 22);
		panel1.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Confirm Password");
		lblNewLabel_2_2_1_1.setForeground(Color.ORANGE);
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1_1.setBounds(417, 238, 152, 22);
		panel1.add(lblNewLabel_2_2_1_1);
		
		txtCreateFreeAccount = new JTextField();
		txtCreateFreeAccount.setBorder(null);
		txtCreateFreeAccount.setEditable(false);
		txtCreateFreeAccount.setForeground(Color.ORANGE);
		txtCreateFreeAccount.setBackground(new Color(255, 240, 245));
		txtCreateFreeAccount.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtCreateFreeAccount.setText("Create Free Account");
		txtCreateFreeAccount.setBounds(57, 12, 302, 34);
		panel1.add(txtCreateFreeAccount);
		txtCreateFreeAccount.setColumns(10);
		
		JLabel lblNewLabel_2_2_1_1_1 = new JLabel("Gender");
		lblNewLabel_2_2_1_1_1.setForeground(Color.ORANGE);
		lblNewLabel_2_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1_1_1.setBounds(417, 326, 152, 22);
		panel1.add(lblNewLabel_2_2_1_1_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setForeground(Color.ORANGE);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton.setBackground(new Color(255, 240, 245));
		rdbtnNewRadioButton.setBounds(417, 360, 75, 21);
		panel1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setForeground(Color.ORANGE);
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnFemale.setBackground(new Color(255, 240, 245));
		rdbtnFemale.setBounds(493, 360, 103, 21);
		panel1.add(rdbtnFemale);
		
		
	}
}
