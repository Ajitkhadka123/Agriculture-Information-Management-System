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
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
import javax.swing.table.DefaultTableModel;


public class Dash extends JFrame {
     //inserting image
	private Image img_logo = new ImageIcon(Login.class.getResource("/img/AgricultureOutlook.png")).getImage().getScaledInstance(300,300, Image.SCALE_SMOOTH);
	private Image logo = new ImageIcon(Login.class.getResource("/img/corpslogo.png")).getImage().getScaledInstance(50,50, Image.SCALE_SMOOTH);
    
	private JPanel contentPane;
	private JLabel lblMunicipality;          //initiating textfields and lables
	private JTextField Municipalitybox;
	private JTextField Back;
	DefaultTableModel model;
	long first4;
	long first;
	
	String name;
	
	//generating random numbers

//	public void Random(){
//    Random ran = new Random();
//    first4 = (ran.nextLong() % 9000L) + 1000L;
//    first = Math.abs(first4); // abs for on positive numbers
//
//	}

	

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
		Random();
		
	// creating an object for all lables and textfields 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 0, 818, 780);
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
		IbllconLogo.setBounds(186, 151, 411, 349);
		IbllconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(IbllconLogo);
		IbllconLogo.setIcon(new ImageIcon(img_logo));
		
		
		 JLabel mainlogo = new JLabel("");
		 mainlogo.setHorizontalAlignment(SwingConstants.CENTER);
		 mainlogo.setBounds(61, 16, 65, 58);
		 contentPane.add(mainlogo);
		 mainlogo.setIcon(new ImageIcon(logo));
			
		JLabel lblProvince = new JLabel("Province");
		lblProvince.setForeground(Color.WHITE);
		lblProvince.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblProvince.setBounds(178, 556, 117, 25);
		contentPane.add(lblProvince);
		
		lblMunicipality = new JLabel("Municipality");
		lblMunicipality.setForeground(Color.WHITE);
		lblMunicipality.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblMunicipality.setBounds(416, 556, 117, 25);
		contentPane.add(lblMunicipality);
		
		Municipalitybox = new JTextField();
		Municipalitybox.setFont(new Font("Arial", Font.PLAIN, 16));
		Municipalitybox.setColumns(10);
		Municipalitybox.setBounds(416, 591, 200, 31);
		contentPane.add(Municipalitybox);
		
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
		
		
		JButton btnAddCrops = new JButton("Add crops ");
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
		btnAddCrops.setBounds(239, 661, 140, 31);
		contentPane.add(btnAddCrops);
		
		
//		JButton btnSave = new JButton("Save");
//		btnSave.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				btnSave.setForeground(Color.RED);
//				
//			}
//			
//			@Override
//			public void mouseExited(MouseEvent e) {
//				btnSave.setForeground(Color.BLACK);
//			}
//		});
//		btnSave.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if(e.getSource()==btnSave) {
//					if(JOptionPane.showConfirmDialog(null, "Do you want Save Details?", "Confirmation", JOptionPane.YES_NO_OPTION) ==0) {
//						
//					}
//				}
//			}
//		});
//		btnSave.setForeground(Color.BLACK);
//		btnSave.setFont(new Font("Arial", Font.BOLD, 14));
//		btnSave.setBackground(Color.WHITE);
//		btnSave.setBounds(80, 332, 93, 31);
//		contentPane.add(btnSave);
//	    
	    JComboBox provincebox = new JComboBox();
	    provincebox.setFont(new Font("Arial", Font.PLAIN, 16));
	    provincebox.setModel(new DefaultComboBoxModel(new String[] {"Koshi ", "Madhesh ", "Bagmati ", "Gandaki", "Lumbini", "Karnali", "Sudur Paschim"}));
	    provincebox.setBounds(174, 591, 200, 31);
	    contentPane.add(provincebox);
	    
	    JLabel lblNewLabel = new JLabel("Agriculture Information Management System");
	    lblNewLabel.setForeground(Color.WHITE);
	    lblNewLabel.setFont(new Font("Arial", Font.BOLD, 28));
	    lblNewLabel.setBounds(76, 100, 672, 58);
	    contentPane.add(lblNewLabel);
	    
	    JLabel lblNewLabel_1 = new JLabel("Please make sure you are logined in to correct municipality by checking the following details");
	    lblNewLabel_1.setForeground(Color.WHITE);
	    lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
	    lblNewLabel_1.setBounds(76, 489, 650, 45);
	    contentPane.add(lblNewLabel_1);
	    
	    Box verticalBox = Box.createVerticalBox();
	    verticalBox.setBorder(new LineBorder(new Color(255, 215, 0), 9));
	    verticalBox.setBackground(new Color(255, 215, 0));
	    verticalBox.setBounds(0, 84, 886, 3);
	    contentPane.add(verticalBox);
	    
	    JLabel lblHompage = new JLabel("Homepage");
	    lblHompage.setForeground(Color.WHITE);
	    lblHompage.setFont(new Font("Arial", Font.BOLD, 28));
	    lblHompage.setBounds(317, 16, 178, 58);
	    contentPane.add(lblHompage);
	    
	    JButton btnLogout = new JButton("Logout");
	    btnLogout.setForeground(Color.BLACK);
	    btnLogout.setFont(new Font("Arial", Font.BOLD, 14));
	    btnLogout.setBackground(Color.WHITE);
	    btnLogout.setBounds(416, 661, 140, 31);
	    contentPane.add(btnLogout);
	    
	   
	    
	    
	    
	    
	    
	  
	    
	    
	 
		
		
	}
}
