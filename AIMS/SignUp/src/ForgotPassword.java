package agriculture;
import java.awt.BorderLayout;
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

import javax.swing.JTextField;

public class ForgotPassword extends JFrame {

	private Image img_login = new ImageIcon(Login.class.getResource("/LoginPhoto.png")).getImage().getScaledInstance(350,300, Image.SCALE_SMOOTH);
    

	private JPanel contentPane;
	private JTextField pass1field;
	private JTextField numberfield;
	private JTextField Back;
	private JTextField pass2field;


	private JButton NextButton;

	Connection connect =  null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPassword frame = new ForgotPassword();
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
	public ForgotPassword() {
		setResizable(false);	
		connect = mysqlconnection.dbConnector();
		//exit
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(85, 107, 47));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//image
	    JLabel IbllconLogo = new JLabel("");
	    IbllconLogo.setBounds(330, 115, 330, 338);
		IbllconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(IbllconLogo);
		IbllconLogo.setIcon(new ImageIcon(img_login));
		
		//name 
		JLabel lblNewLabel = new JLabel("Forgot Password ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(84, 89, 178, 58);
		contentPane.add(lblNewLabel);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new LineBorder(new Color(255, 215, 0), 9));
		verticalBox.setBackground(new Color(255, 215, 0));
		verticalBox.setBounds(0, 76, 686, 3);
		contentPane.add(verticalBox);
		
		pass1field = new JTextField();
		pass1field.setFont(new Font("Arial", Font.PLAIN, 16));
		pass1field.setColumns(10);
		pass1field.setBounds(50, 281, 224, 31);
		contentPane.add(pass1field);
		
		JLabel lblCrops_1 = new JLabel("Phone number");
		lblCrops_1.setForeground(Color.WHITE);
		lblCrops_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblCrops_1.setBounds(50, 157, 195, 25);
		contentPane.add(lblCrops_1);
		
		JLabel lblCrops_1_1 = new JLabel("New Password");
		lblCrops_1_1.setForeground(Color.WHITE);
		lblCrops_1_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblCrops_1_1.setBounds(50, 246, 215, 25);
		contentPane.add(lblCrops_1_1);
		
		numberfield = new JTextField();
		numberfield.setFont(new Font("Arial", Font.PLAIN, 16));
		numberfield.setColumns(10);
		numberfield.setBounds(50, 192, 224, 31);
		contentPane.add(numberfield);
		
		JLabel lblNewLabel_1 = new JLabel("Agriculture Information Management System");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel_1.setBounds(50, 10, 672, 58);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCrops_1_1_1 = new JLabel("Confirm Password");
		lblCrops_1_1_1.setForeground(Color.WHITE);
		lblCrops_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblCrops_1_1_1.setBounds(50, 335, 215, 25);
		contentPane.add(lblCrops_1_1_1);
		
		pass2field = new JTextField();
		pass2field.setFont(new Font("Arial", Font.PLAIN, 16));
		pass2field.setColumns(10);
		pass2field.setBounds(50, 366, 224, 31);
		contentPane.add(pass2field);
		
		//guest button
		NextButton = new JButton("Next");
		NextButton.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				NextButton.setForeground(Color.RED);
				
			}
	
			public void mouseExited(MouseEvent e) {
				NextButton.setForeground(Color.BLACK);
			}
			
			public void mouseClicked(MouseEvent e) {
				ForgotPassword.this.dispose();
				AdminLogin ALogin = new AdminLogin();
				ALogin.setVisible(true);
			}
		});
		NextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long number;
				String pass1, pass2;
				number=Long.parseLong(numberfield.getText()); 
				pass1= pass1field.getText();
				pass2= pass2field.getText();
				try {
					if(pass1.equals(pass2)) {
					String query = "update admin set Password='" + pass2 + "' where PhoneNumber='" + number
							+ "'";
					PreparedStatement state = connect.prepareStatement(query);
					state.execute();
					JOptionPane.showMessageDialog(null, "Data Updated Successfully");
					numberfield.setText("");
					pass1field.setText("");
					pass2field.setText("");

					state.close();
					}else {
						JOptionPane.showMessageDialog(null, "Password doesnot match");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		NextButton.setFont(new Font("Arial", Font.BOLD, 14));
		NextButton.setBounds(114, 411, 89, 31);
		contentPane.add(NextButton);
		
		
		
		Back = new JTextField();
		Back.setBackground(new Color(85, 107, 47));
		Back.setEditable(false);
		Back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ForgotPassword.this.dispose();
				AdminLogin Login = new AdminLogin();
				Login.setVisible(true);
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
		
		
	}
}
	
