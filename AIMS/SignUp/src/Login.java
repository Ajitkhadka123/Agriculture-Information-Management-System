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
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JSpinner;
import javax.swing.JPasswordField;




public class Login extends JFrame {
	private Image img_login = new ImageIcon(Login.class.getResource("/LoginPhoto.png")).getImage().getScaledInstance(350,300, Image.SCALE_SMOOTH);
    

	private JPanel contentPane;
	JButton AdminLoginBut;

	private JButton GuestLoginBut;

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
		setResizable(false);	
		
		
		
		//exit
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 700, 552);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(85, 107, 47));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//guest button
		GuestLoginBut = new JButton("Municipality");
		GuestLoginBut.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				GuestLoginBut.setForeground(Color.RED);
				
			}
	
			public void mouseExited(MouseEvent e) {
				GuestLoginBut.setForeground(Color.BLACK);
			}
			
			public void mouseClicked(MouseEvent e) {
				Login.this.dispose();
				MunicipalityLogin dashboard = new MunicipalityLogin();
				dashboard.setVisible(true);
			}
		});
		GuestLoginBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GuestLoginBut.setFont(new Font("Arial", Font.BOLD, 14));
		GuestLoginBut.setBounds(195, 437, 123, 31);
		contentPane.add(GuestLoginBut);
		
		//admin button
		AdminLoginBut = new JButton("Admin");
		AdminLoginBut.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				AdminLoginBut.setForeground(Color.RED);
				
			}
	
			public void mouseExited(MouseEvent e) {
				AdminLoginBut.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Login.this.dispose();
				AdminLogin ALogin= new AdminLogin();
				ALogin.setVisible(true);
			}
		});
		AdminLoginBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		AdminLoginBut.setFont(new Font("Arial", Font.BOLD, 14));
		AdminLoginBut.setBounds(363, 437, 89, 31);
		contentPane.add(AdminLoginBut);
		
		//image
	    JLabel IbllconLogo = new JLabel("");
	    IbllconLogo.setBounds(182, 107, 330, 252);
		IbllconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(IbllconLogo);
		IbllconLogo.setIcon(new ImageIcon(img_login));
		
		//name 
		JLabel lblNewLabel = new JLabel("Agriculture Information Management System");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel.setBounds(28, 10, 624, 58);
		contentPane.add(lblNewLabel);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new LineBorder(new Color(255, 215, 0), 9));
		verticalBox.setBackground(new Color(255, 215, 0));
		verticalBox.setBounds(0, 76, 686, 3);
		contentPane.add(verticalBox);
		
		JLabel lblLoginAs = new JLabel("Login As");
		lblLoginAs.setForeground(Color.WHITE);
		lblLoginAs.setFont(new Font("Arial", Font.BOLD, 18));
		lblLoginAs.setBounds(301, 387, 89, 58);
		contentPane.add(lblLoginAs);
		
		
//		String getRandomValue(String[] array ) {
//			String result = new Random().nextString(array.length);
//		    return array[result];
		
		 Random rand = new Random();
		    List<String> givenList = Arrays.asList("                          Intercropping can be used to increase production rate",
		    		"                            Test your soil to find the sutaible crops for harvesting.",
		    		"                           Use Grafting process for inhancing hybrid breeding",
		    		"                            Always use fresh seed for better germination rate"
		    		);

		    int numberOfElements = 1;

		    for (int i = 0; i < numberOfElements; i++) {
		        int randomIndex = rand.nextInt(givenList.size());
		        String randomElement = givenList.get(randomIndex);
		    
	
		
		//text
		JLabel lblNewLabel_1 = new JLabel(randomElement);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(42, 369, 610, 31);
		contentPane.add(lblNewLabel_1);
		
		}
		
		 
		

		
	}
}
