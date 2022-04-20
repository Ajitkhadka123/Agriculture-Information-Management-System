

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

public class Dash extends JFrame {
     //inserting image
	private Image img_logo = new ImageIcon(Login.class.getResource("img/corpslogo.png")).getImage().getScaledInstance(90,90, Image.SCALE_SMOOTH);
    
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
		
	// creating an object for all lables and textfields 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		//setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(205, 92, 92));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));    
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel IbllconLogo = new JLabel("");
		IbllconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		IbllconLogo.setBounds(-45, 0, 238, 143);
		contentPane.add(IbllconLogo);
		IbllconLogo.setIcon(new ImageIcon(img_logo));
		
		JLabel Labelfname = new JLabel("First Name");
		Labelfname.setFont(new Font("Calibri", Font.PLAIN, 20));
		Labelfname.setForeground(Color.WHITE);
		Labelfname.setBounds(173, 139, 117, 25);
		contentPane.add(Labelfname);
		
		Fname = new JTextField();
		Fname.setBounds(173, 165, 200, 31);
		contentPane.add(Fname);
		Fname.setColumns(10);
		
		Lname = new JTextField();
		Lname.setColumns(10);
		Lname.setBounds(464, 165, 200, 31);
		contentPane.add(Lname);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblLastName.setBounds(464, 139, 117, 25);
		contentPane.add(lblLastName);
		
		JLabel lblProvince = new JLabel("Province");
		lblProvince.setForeground(Color.WHITE);
		lblProvince.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblProvince.setBounds(173, 219, 117, 25);
		contentPane.add(lblProvince);
		
		Province = new JTextField();
		Province.setColumns(10);
		Province.setBounds(173, 243, 200, 31);
		contentPane.add(Province);
		
		Municipality = new JTextField();
		Municipality.setColumns(10);
		Municipality.setBounds(464, 243, 200, 31);
		contentPane.add(Municipality);
		
		lblMunicipality = new JLabel("Municipality");
		lblMunicipality.setForeground(Color.WHITE);
		lblMunicipality.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblMunicipality.setBounds(464, 219, 117, 25);
		contentPane.add(lblMunicipality);
		
		lblNumberOfFamily = new JLabel("Number of Family Members");
		lblNumberOfFamily.setForeground(Color.WHITE);
		lblNumberOfFamily.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNumberOfFamily.setBounds(173, 297, 247, 25);
		contentPane.add(lblNumberOfFamily);
		
		NumofFamilyMembers = new JTextField();
		NumofFamilyMembers.setColumns(10);
		NumofFamilyMembers.setBounds(173, 321, 200, 31);
		contentPane.add(NumofFamilyMembers);
		
		lblidNumber = new JLabel("Id Number");
		lblidNumber.setForeground(Color.WHITE);
		lblidNumber.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblidNumber.setBounds(464, 297, 247, 25);
		contentPane.add(lblidNumber);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(464, 321, 200, 31);
		contentPane.add(textField);
		
		JButton btnAddCrops = new JButton("Add Crops");
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
		btnAddCrops.setBounds(376, 433, 107, 31);
		contentPane.add(btnAddCrops);
		
		btnCancel = new JButton("Cancel");                       //creating cancel button
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnCancel) {
					System.exit(0);
				}
			}
		});
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setFont(new Font("Calibri", Font.BOLD, 14));
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(571, 433, 93, 31);                     // creating a save button 
		contentPane.add(btnCancel);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnSave) {
					if(JOptionPane.showConfirmDialog(null, "Do you want to Save detail")==0) {
						Dash.this.dispose();
					}
				}
			}
		});
		btnSave.setForeground(Color.BLACK);
		btnSave.setFont(new Font("Calibri", Font.BOLD, 14));
		btnSave.setBackground(Color.WHITE);
		btnSave.setBounds(173, 433, 93, 31);
		contentPane.add(btnSave);
		
		
	}
}
