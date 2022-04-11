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

public class Delete {

	JFrame frame;
	private JTextField nametextField;
	private JTextField IdtextField;
	private JTextField usertextField;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete window = new Delete();
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
	public Delete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 153));
		frame.setBounds(100, 100, 626, 397);
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
		btnBack.setBounds(517, 10, 85, 33);
		frame.getContentPane().add(btnBack);
		
		nametextField = new JTextField();
		nametextField.setColumns(10);
		nametextField.setBounds(203, 146, 183, 25);
		frame.getContentPane().add(nametextField);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Triumvirate Cond", Font.BOLD, 15));
		lblNewLabel.setBounds(203, 126, 45, 13);
		frame.getContentPane().add(lblNewLabel);
		
		IdtextField = new JTextField();
		IdtextField.setColumns(10);
		IdtextField.setBounds(203, 91, 183, 25);
		frame.getContentPane().add(IdtextField);
		
		JLabel lblUserId = new JLabel("User Id");
		lblUserId.setFont(new Font("Triumvirate Cond", Font.BOLD, 15));
		lblUserId.setBounds(203, 71, 45, 13);
		frame.getContentPane().add(lblUserId);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Triumvirate Cond", Font.BOLD, 15));
		lblUsername.setBounds(203, 185, 85, 13);
		frame.getContentPane().add(lblUsername);
		
		usertextField = new JTextField();
		usertextField.setColumns(10);
		usertextField.setBounds(203, 205, 183, 25);
		frame.getContentPane().add(usertextField);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int UserId = Integer.parseInt(IdtextField.getText());
					String Name = nametextField.getText();
					String Username = usertextField.getText();
					System.out.println("Deleting user with: \nUserId: "+ UserId + "\nName: " + Name + "\nUsername: " + Username);
					JOptionPane.showMessageDialog(frame,"User Deleted");
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
		});
		btnDelete.setFont(new Font("Triumvirate Cond", Font.BOLD, 15));
		btnDelete.setBounds(203, 269, 85, 33);
		frame.getContentPane().add(btnDelete);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IdtextField.setText("");
				nametextField.setText("");
				usertextField.setText("");
			}
		});
		btnClear.setFont(new Font("Triumvirate Cond", Font.BOLD, 15));
		btnClear.setBounds(325, 269, 85, 33);
		frame.getContentPane().add(btnClear);
	}

}
