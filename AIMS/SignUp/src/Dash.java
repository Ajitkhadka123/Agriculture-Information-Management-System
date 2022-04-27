import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Box;
import javax.swing.border.LineBorder;


public class Dash extends JFrame {
     //inserting image
	private Image img_logo = new ImageIcon(Login.class.getResource("/img/AgricultureOutlook.png")).getImage().getScaledInstance(300,300, Image.SCALE_SMOOTH);
    
	private JPanel contentPane;
	private JTextField Fname;
	private JTextField Lname;
	private JTextField Municipality;
	private JLabel lblMunicipality;          //initiating textfields and lables
	private JLabel lblNumberOfFamily;
	private JTextField NumofFamilyMembers;
	private JLabel lblidNumber;
	private JTextField textField;
	private JTextField Back;
	
	//generating random numbers
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    long first = Math.abs(first4); // abs for on positive numbers

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dash frame = new Dash();
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
	public Dash() {
		setResizable(false);
		setMaximumSize(new Dimension(0, 0));
		setBounds(new Rectangle(2, 2, 793, 5960));
		
	// creating an object for all lables and textfields 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		//setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.setMinimumSize(new Dimension(6, 6));
		contentPane.setMaximumSize(new Dimension(1000, 1000));
		contentPane.setBackground(new Color(85, 107, 47));
		contentPane.setBorder(new EmptyBorder(3, 3, 3, 3));    
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//image
		JLabel IbllconLogo = new JLabel("");
		IbllconLogo.setBounds(565, 202, 287, 323);
		IbllconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(IbllconLogo);
		IbllconLogo.setIcon(new ImageIcon(img_logo));
		
		JLabel Labelfname = new JLabel("First Name");
		Labelfname.setFont(new Font("Calibri", Font.PLAIN, 20));
		Labelfname.setForeground(Color.WHITE);
		Labelfname.setBounds(56, 309, 117, 25);
		contentPane.add(Labelfname);
		
		Fname = new JTextField();
		Fname.setFont(new Font("Arial", Font.PLAIN, 16));
		Fname.setBounds(56, 344, 200, 31);
		contentPane.add(Fname);
		Fname.setColumns(10);
		
		Lname = new JTextField();
		Lname.setFont(new Font("Arial", Font.PLAIN, 16));
		Lname.setColumns(10);
		Lname.setBounds(332, 344, 200, 31);
		contentPane.add(Lname);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblLastName.setBounds(332, 309, 117, 25);
		contentPane.add(lblLastName);
		
		JLabel lblProvince = new JLabel("Province");
		lblProvince.setForeground(Color.WHITE);
		lblProvince.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblProvince.setBounds(56, 192, 117, 25);
		contentPane.add(lblProvince);
		
		Municipality = new JTextField();
		Municipality.setFont(new Font("Arial", Font.PLAIN, 16));
		Municipality.setColumns(10);
		Municipality.setBounds(56, 457, 200, 31);
		contentPane.add(Municipality);
		
		lblMunicipality = new JLabel("Municipality");
		lblMunicipality.setForeground(Color.WHITE);
		lblMunicipality.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblMunicipality.setBounds(332, 192, 117, 25);
		contentPane.add(lblMunicipality);
		
		lblNumberOfFamily = new JLabel("No of Family Members");
		lblNumberOfFamily.setForeground(Color.WHITE);
		lblNumberOfFamily.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNumberOfFamily.setBounds(58, 422, 247, 25);
		contentPane.add(lblNumberOfFamily);
		
		NumofFamilyMembers = new JTextField();
		NumofFamilyMembers.setFont(new Font("Arial", Font.PLAIN, 16));
		NumofFamilyMembers.setColumns(10);
		NumofFamilyMembers.setBounds(332, 227, 200, 31);
		contentPane.add(NumofFamilyMembers);
		
		lblidNumber = new JLabel("Id Number");
		lblidNumber.setForeground(Color.WHITE);
		lblidNumber.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblidNumber.setBounds(332, 422, 247, 25);
		contentPane.add(lblidNumber);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(332, 457, 200, 31);
		textField.setText("1533"+first);
		contentPane.add(textField);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 10, 51, 45);
	    panel.setBackground(new Color(85, 107, 47));
		contentPane.add(panel);
		panel.setLayout(null);
		
		Back = new JTextField();
		Back.setBackground(new Color(85, 107, 47));
		Back.setEditable(false);
		Back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Dash.this.dispose();
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
		Back.setBounds(0, 16, 42, 19);
		panel.add(Back);
		Back.setColumns(10);
		
		
		JButton btnAddCrops = new JButton("Add Crops");
		btnAddCrops.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnAddCrops.setForeground(Color.RED);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnAddCrops.setForeground(Color.BLACK);
			}
		});
		btnAddCrops.setBackground(Color.WHITE);                    // adding button of add crops
		btnAddCrops.setFont(new Font("Arial", Font.BOLD, 14));
		btnAddCrops.setForeground(Color.BLACK);
		btnAddCrops.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==btnAddCrops){
					try {
						new AddCrops().setVisible(true);
						Dash.this.dispose();
					}catch(Exception E){
						System.out.print("Can't add");
					}
				}
			}
			
		});
		btnAddCrops.setBounds(182, 559, 123, 31);
		contentPane.add(btnAddCrops);
		
		
		JButton btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSave.setForeground(Color.RED);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnSave.setForeground(Color.BLACK);
			}
		});
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnSave) {
					if(JOptionPane.showConfirmDialog(null, "Do you want Save Details?", "Confirmation", JOptionPane.YES_NO_OPTION) ==0) {
						
					}
				}
			}
		});
		btnSave.setForeground(Color.BLACK);
		btnSave.setFont(new Font("Arial", Font.BOLD, 14));
		btnSave.setBackground(Color.WHITE);
		btnSave.setBounds(56, 559, 93, 31);
		contentPane.add(btnSave);
	    
	    JComboBox comboBox = new JComboBox();
	    comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
	    comboBox.setModel(new DefaultComboBoxModel(new String[] {"Koshi ", "Madhesh ", "Bagmati ", "Gandaki", "Lumbini", "Karnali", "Sudur Paschim"}));
	    comboBox.setBounds(56, 227, 200, 31);
	    contentPane.add(comboBox);
	    
	    JLabel lblNewLabel = new JLabel("Agriculture Information Management System");
	    lblNewLabel.setForeground(Color.WHITE);
	    lblNewLabel.setFont(new Font("Arial", Font.BOLD, 28));
	    lblNewLabel.setBounds(133, 22, 672, 58);
	    contentPane.add(lblNewLabel);
	    
	    JLabel lblNewLabel_1 = new JLabel("Fill up farmer details in below boxes and press add crops button for \r\n");
	    lblNewLabel_1.setForeground(Color.WHITE);
	    lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
	    lblNewLabel_1.setBounds(56, 97, 600, 31);
	    contentPane.add(lblNewLabel_1);
	    
	    JLabel lblNewLabel_1_1 = new JLabel("adding crops with market and farmer price.");
	    lblNewLabel_1_1.setForeground(Color.WHITE);
	    lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
	    lblNewLabel_1_1.setBounds(56, 127, 372, 25);
	    contentPane.add(lblNewLabel_1_1);
	    
	    Box verticalBox = Box.createVerticalBox();
	    verticalBox.setBorder(new LineBorder(new Color(255, 215, 0), 9));
	    verticalBox.setBackground(new Color(255, 215, 0));
	    verticalBox.setBounds(0, 84, 886, 3);
	    contentPane.add(verticalBox);
	    
	  
	    
	    
	 
		
		
	}
}
