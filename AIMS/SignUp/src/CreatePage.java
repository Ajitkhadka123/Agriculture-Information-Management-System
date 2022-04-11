import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreatePage {

	JFrame frame;
	private JTextField NametextField;
	private JTextField usernametextField;
	private JTextField passwordtextField;
	private JTextField mailtextField;
	private JTextField gendertextField;
	private JTextField dobtextField;
	private JTextField locationtextField;
	private JTextField IdtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreatePage window = new CreatePage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreatePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 153));
		frame.setBounds(100, 100, 587, 393);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MainPage main = new MainPage();
					main.frame.setVisible(true);
					frame.setVisible(false);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(frame, e2);
				}
			}
		});
		btnBack.setFont(new Font("Triumvirate Cond", Font.BOLD, 15));
		btnBack.setBounds(478, 10, 85, 33);
		frame.getContentPane().add(btnBack);

		JButton btnCreateUser = new JButton("Create User");
		btnCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int UserId = Integer.parseInt(IdtextField.getText());
					String Name = NametextField.getText();
					String Username = usernametextField.getText();
					String Password = passwordtextField.getText();
					String Email = mailtextField.getText();
					String Gender = gendertextField.getText();
					String Location = locationtextField.getText();
					String DoB = dobtextField.getText();
					System.out.println("User ID: " + UserId + "\nName: " + Name + "\nUsername: " + Username
							+ "\nPassword: " + Password + "\nEmail: " + Email + "\nGender: " + Gender + "\nLocation: "
							+Location+"\nDoB: "+DoB);
					JOptionPane.showMessageDialog(frame,"User created");

				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
		});
		btnCreateUser.setFont(new Font("Triumvirate Cond", Font.BOLD, 15));
		btnCreateUser.setBounds(113, 300, 107, 44);
		frame.getContentPane().add(btnCreateUser);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IdtextField.setText("");
				NametextField.setText("");
				usernametextField.setText("");
				passwordtextField.setText("");
				mailtextField.setText("");
				gendertextField.setText("");
				locationtextField.setText("");
				dobtextField.setText("");
			}
		});
		btnClear.setFont(new Font("Triumvirate Cond", Font.BOLD, 15));
		btnClear.setBounds(384, 300, 85, 44);
		frame.getContentPane().add(btnClear);

		NametextField = new JTextField();
		NametextField.setBounds(81, 132, 183, 25);
		frame.getContentPane().add(NametextField);
		NametextField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Triumvirate Cond", Font.BOLD, 15));
		lblNewLabel.setBounds(81, 112, 45, 13);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Triumvirate Cond", Font.BOLD, 15));
		lblUsername.setBounds(81, 171, 85, 13);
		frame.getContentPane().add(lblUsername);

		usernametextField = new JTextField();
		usernametextField.setColumns(10);
		usernametextField.setBounds(81, 191, 183, 25);
		frame.getContentPane().add(usernametextField);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Triumvirate Cond", Font.BOLD, 15));
		lblPassword.setBounds(81, 226, 85, 13);
		frame.getContentPane().add(lblPassword);

		passwordtextField = new JTextField();
		passwordtextField.setColumns(10);
		passwordtextField.setBounds(81, 246, 183, 25);
		frame.getContentPane().add(passwordtextField);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Triumvirate Cond", Font.BOLD, 15));
		lblEmail.setBounds(322, 57, 45, 13);
		frame.getContentPane().add(lblEmail);

		mailtextField = new JTextField();
		mailtextField.setColumns(10);
		mailtextField.setBounds(322, 77, 183, 25);
		frame.getContentPane().add(mailtextField);

		JLabel lblGedner = new JLabel("Gender");
		lblGedner.setFont(new Font("Triumvirate Cond", Font.BOLD, 15));
		lblGedner.setBounds(322, 112, 45, 13);
		frame.getContentPane().add(lblGedner);

		gendertextField = new JTextField();
		gendertextField.setColumns(10);
		gendertextField.setBounds(322, 132, 183, 25);
		frame.getContentPane().add(gendertextField);

		JLabel lblDob = new JLabel("DOB");
		lblDob.setFont(new Font("Triumvirate Cond", Font.BOLD, 15));
		lblDob.setBounds(322, 226, 45, 13);
		frame.getContentPane().add(lblDob);

		dobtextField = new JTextField();
		dobtextField.setColumns(10);
		dobtextField.setBounds(322, 246, 183, 25);
		frame.getContentPane().add(dobtextField);

		JLabel lblLocation = new JLabel("Location");
		lblLocation.setFont(new Font("Triumvirate Cond", Font.BOLD, 15));
		lblLocation.setBounds(322, 171, 67, 13);
		frame.getContentPane().add(lblLocation);

		locationtextField = new JTextField();
		locationtextField.setColumns(10);
		locationtextField.setBounds(322, 191, 183, 25);
		frame.getContentPane().add(locationtextField);

		JLabel lblUserId = new JLabel("User Id");
		lblUserId.setFont(new Font("Triumvirate Cond", Font.BOLD, 15));
		lblUserId.setBounds(81, 57, 45, 13);
		frame.getContentPane().add(lblUserId);

		IdtextField = new JTextField();
		IdtextField.setColumns(10);
		IdtextField.setBounds(81, 77, 183, 25);
		frame.getContentPane().add(IdtextField);
	}
}
