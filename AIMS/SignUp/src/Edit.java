import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Edit {

	JFrame frame;
	private JTextField usertextField;
	private JTextField IdtextField;
	private JTextField passtextField;

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit window = new Edit();
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
	public Edit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(205,92,92));
		frame.setBounds(100, 100, 626, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AdminDashboard main = new AdminDashboard();
					main.frame.setVisible(true);
					frame.setVisible(false);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(frame, e2);
				}
			}
		});
		btnBack.setFont(new Font("Triumvirate Cond", Font.BOLD, 15));
		btnBack.setBounds(517, 10, 85, 33);
		frame.getContentPane().add(btnBack);
		
		usertextField = new JTextField();
		usertextField.setFont(new Font("Triumvirate Cond", Font.PLAIN, 13));
		usertextField.setColumns(10);
		usertextField.setBounds(203, 168, 183, 25);
		frame.getContentPane().add(usertextField);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Triumvirate Cond", Font.BOLD, 15));
		lblUsername.setBounds(203, 145, 126, 13);
		frame.getContentPane().add(lblUsername);
		
		IdtextField = new JTextField();
		IdtextField.setFont(new Font("Triumvirate Cond", Font.PLAIN, 13));
		IdtextField.setColumns(10);
		IdtextField.setBounds(203, 110, 183, 25);
		frame.getContentPane().add(IdtextField);
		
		JLabel lblUserId = new JLabel("User Id");
		lblUserId.setForeground(Color.WHITE);
		lblUserId.setFont(new Font("Triumvirate Cond", Font.BOLD, 15));
		lblUserId.setBounds(203, 87, 96, 13);
		frame.getContentPane().add(lblUserId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Triumvirate Cond", Font.BOLD, 15));
		lblPassword.setBounds(203, 197, 85, 13);
		frame.getContentPane().add(lblPassword);
		
		passtextField = new JTextField();
		passtextField.setFont(new Font("Triumvirate Cond", Font.PLAIN, 13));
		passtextField.setColumns(10);
		passtextField.setBounds(203, 220, 183, 25);
		frame.getContentPane().add(passtextField);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int UserId = Integer.parseInt(IdtextField.getText());
					String Username = usertextField.getText();
					String Password = passtextField.getText();
					System.out.println("Editing user name : "+Username+" and Password: "+Password+" using User Id: "+UserId);
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
		});
		btnEdit.setFont(new Font("Triumvirate Cond", Font.BOLD, 15));
		btnEdit.setBounds(203, 282, 85, 33);
		frame.getContentPane().add(btnEdit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IdtextField.setText("");
				usertextField.setText("");
				passtextField.setText("");
			}
		});
		btnClear.setFont(new Font("Triumvirate Cond", Font.BOLD, 15));
		btnClear.setBounds(301, 282, 85, 33);
		frame.getContentPane().add(btnClear);
	}
}
