
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
import javax.swing.border.LineBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Rectangle;

public class Dash extends JFrame {
     //inserting image
	private Image img_logo = new ImageIcon(UserLogin.class.getResource("img/corpslogo.png")).getImage().getScaledInstance(90,90, Image.SCALE_SMOOTH);
    
	private JPanel contentPane;
	private JTextField Fname;
	private JTextField Lname;
	private JTextField Province;
	private JTextField Municipality;
	private JLabel lblMunicipality;          //initiating textfields and lables
	private JLabel lblNumberOfFamily;
	private JTextField NumofFamilyMembers;
	private JLabel lblidNumber;
	private JTextField textField;
	private JButton btnCancel;
	private JTextField Back;
	

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
		setBounds(new Rectangle(2, 2, 796, 5960));
		
	// creating an object for all lables and textfields 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		//setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.setMinimumSize(new Dimension(6, 6));
		contentPane.setMaximumSize(new Dimension(1000, 1000));
		contentPane.setBackground(new Color(205, 92, 92));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));    
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Labelfname = new JLabel("First Name");
		Labelfname.setFont(new Font("Calibri", Font.PLAIN, 20));
		Labelfname.setForeground(Color.WHITE);
		Labelfname.setBounds(173, 154, 117, 25);
		contentPane.add(Labelfname);
		
		Fname = new JTextField();
		Fname.setBounds(173, 178, 200, 31);
		contentPane.add(Fname);
		Fname.setColumns(10);
		
		Lname = new JTextField();
		Lname.setColumns(10);
		Lname.setBounds(487, 178, 200, 31);
		contentPane.add(Lname);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblLastName.setBounds(487, 154, 117, 25);
		contentPane.add(lblLastName);
		
		JLabel lblProvince = new JLabel("Province");
		lblProvince.setForeground(Color.WHITE);
		lblProvince.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblProvince.setBounds(173, 243, 117, 25);
		contentPane.add(lblProvince);
		
		Province = new JTextField();
		Province.setColumns(10);
		Province.setBounds(173, 267, 200, 31);
		contentPane.add(Province);
		
		Municipality = new JTextField();
		Municipality.setColumns(10);
		Municipality.setBounds(487, 267, 200, 31);
		contentPane.add(Municipality);
		
		lblMunicipality = new JLabel("Municipality");
		lblMunicipality.setForeground(Color.WHITE);
		lblMunicipality.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblMunicipality.setBounds(488, 243, 117, 25);
		contentPane.add(lblMunicipality);
		
		lblNumberOfFamily = new JLabel("No of Family Members");
		lblNumberOfFamily.setForeground(Color.WHITE);
		lblNumberOfFamily.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNumberOfFamily.setBounds(173, 327, 247, 25);
		contentPane.add(lblNumberOfFamily);
		
		NumofFamilyMembers = new JTextField();
		NumofFamilyMembers.setColumns(10);
		NumofFamilyMembers.setBounds(173, 354, 200, 31);
		contentPane.add(NumofFamilyMembers);
		
		lblidNumber = new JLabel("Id Number");
		lblidNumber.setForeground(Color.WHITE);
		lblidNumber.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblidNumber.setBounds(487, 327, 247, 25);
		contentPane.add(lblidNumber);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(487, 354, 200, 31);
		contentPane.add(textField);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 10, 51, 45);
	    panel.setBackground(new Color(205, 92, 92));
		contentPane.add(panel);
		panel.setLayout(null);
		
		Back = new JTextField();
		Back.setBackground(new Color(205,92,92));
		Back.setEditable(false);
		Back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Dash.this.dispose();
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
		Back.setForeground(Color.ORANGE);
		Back.setText("\u2190");
		Back.setBounds(10, 10, 42, 19);
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
		btnAddCrops.setFont(new Font("Calibri", Font.BOLD, 14));
		btnAddCrops.setForeground(Color.BLACK);
		btnAddCrops.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==btnAddCrops){
					try {
						new AddCrops().setVisible(true);
					}catch(Exception E){
						System.out.print("Can't add");
					}
				}
			}
			
		});
		btnAddCrops.setBounds(593, 446, 107, 31);
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
		btnSave.setFont(new Font("Calibri", Font.BOLD, 14));
		btnSave.setBackground(Color.WHITE);
		btnSave.setBounds(477, 446, 93, 31);
		contentPane.add(btnSave);
		
		JLabel IbllconLogo = new JLabel("");
		IbllconLogo.setBounds(304, 0, 249, 148);
		contentPane.add(IbllconLogo);
		IbllconLogo.addMouseListener(new MouseAdapter() {
			
		});
		IbllconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		IbllconLogo.setIcon(new ImageIcon(img_logo));
		
		
	}
}
