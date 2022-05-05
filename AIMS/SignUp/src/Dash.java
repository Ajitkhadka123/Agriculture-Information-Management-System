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
    
	private JPanel contentPane;
	private JTextField Fname;
	private JTextField Lname;
	private JTextField nofbox;
	private JLabel lblMunicipality;          //initiating textfields and lables
	private JLabel lblNumberOfFamily;
	private JTextField Municipalitybox;
	private JLabel lblidNumber;
	private JTextField idbox;
	private JTextField Back;
	DefaultTableModel model;
	private JTable table;
	long first4;
	long first;
	
	String name;
	
	//generating random numbers

	public void Random(){
    Random ran = new Random();
    first4 = (ran.nextLong() % 9000L) + 1000L;
    first = Math.abs(first4); // abs for on positive numbers

	}

	

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
		setBounds(100, 100, 901, 837);
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
		IbllconLogo.setBounds(569, 138, 287, 348);
		IbllconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(IbllconLogo);
		IbllconLogo.setIcon(new ImageIcon(img_logo));
		
		JLabel Labelfname = new JLabel("First Name");
		Labelfname.setFont(new Font("Calibri", Font.PLAIN, 20));
		Labelfname.setForeground(Color.WHITE);
		Labelfname.setBounds(56, 321, 117, 25);
		contentPane.add(Labelfname);
		
		Fname = new JTextField();
		Fname.setFont(new Font("Arial", Font.PLAIN, 16));
		Fname.setBounds(56, 356, 200, 31);
		contentPane.add(Fname);
		Fname.setColumns(10);
		
		Lname = new JTextField();
		Lname.setFont(new Font("Arial", Font.PLAIN, 16));
		Lname.setColumns(10);
		Lname.setBounds(332, 356, 200, 31);
		contentPane.add(Lname);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblLastName.setBounds(332, 321, 117, 25);
		contentPane.add(lblLastName);
		
		JLabel lblProvince = new JLabel("Province");
		lblProvince.setForeground(Color.WHITE);
		lblProvince.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblProvince.setBounds(56, 159, 117, 25);
		contentPane.add(lblProvince);
		
		nofbox = new JTextField();
		nofbox.setFont(new Font("Arial", Font.PLAIN, 16));
		nofbox.setColumns(10);
		nofbox.setBounds(56, 457, 200, 31);
		contentPane.add(nofbox);
		
		lblMunicipality = new JLabel("Municipality");
		lblMunicipality.setForeground(Color.WHITE);
		lblMunicipality.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblMunicipality.setBounds(332, 159, 117, 25);
		contentPane.add(lblMunicipality);
		
		lblNumberOfFamily = new JLabel("No of Family Members");
		lblNumberOfFamily.setForeground(Color.WHITE);
		lblNumberOfFamily.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNumberOfFamily.setBounds(56, 422, 247, 25);
		contentPane.add(lblNumberOfFamily);
		
		Municipalitybox = new JTextField();
		Municipalitybox.setFont(new Font("Arial", Font.PLAIN, 16));
		Municipalitybox.setColumns(10);
		Municipalitybox.setBounds(332, 198, 200, 31);
		contentPane.add(Municipalitybox);
		
		lblidNumber = new JLabel("Id Number");
		lblidNumber.setForeground(Color.WHITE);
		lblidNumber.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblidNumber.setBounds(332, 422, 247, 25);
		contentPane.add(lblidNumber);
		
		idbox = new JTextField();
		idbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		idbox.setFont(new Font("Arial", Font.PLAIN, 16));
		idbox.setColumns(10);
		idbox.setBounds(332, 457, 200, 31);
		idbox.setText("1533"+first);
		contentPane.add(idbox);
		
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
		btnAddCrops.setBounds(706, 496, 123, 31);
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
		btnSave.setBounds(579, 496, 93, 31);
		contentPane.add(btnSave);
	    
	    JComboBox provincebox = new JComboBox();
	    provincebox.setFont(new Font("Arial", Font.PLAIN, 16));
	    provincebox.setModel(new DefaultComboBoxModel(new String[] {"Koshi ", "Madhesh ", "Bagmati ", "Gandaki", "Lumbini", "Karnali", "Sudur Paschim"}));
	    provincebox.setBounds(56, 198, 200, 31);
	    contentPane.add(provincebox);
	    
	    JLabel lblNewLabel = new JLabel("Agriculture Information Management System");
	    lblNewLabel.setForeground(Color.WHITE);
	    lblNewLabel.setFont(new Font("Arial", Font.BOLD, 28));
	    lblNewLabel.setBounds(133, 22, 672, 58);
	    contentPane.add(lblNewLabel);
	    
	    JLabel lblNewLabel_1 = new JLabel("Fill up farmer details in below boxes and press add crops button for adding crops with market and farmer price.\r\n");
	    lblNewLabel_1.setForeground(Color.WHITE);
	    lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
	    lblNewLabel_1.setBounds(56, 97, 817, 31);
	    contentPane.add(lblNewLabel_1);
	    
	    Box verticalBox = Box.createVerticalBox();
	    verticalBox.setBorder(new LineBorder(new Color(255, 215, 0), 9));
	    verticalBox.setBackground(new Color(255, 215, 0));
	    verticalBox.setBounds(0, 84, 886, 3);
	    contentPane.add(verticalBox);
	    
	    JLabel lblFarmerDetails = new JLabel("Farmer Details");
	    lblFarmerDetails.setForeground(Color.WHITE);
	    lblFarmerDetails.setFont(new Font("Calibri", Font.BOLD, 24));
	    lblFarmerDetails.setBounds(57, 263, 167, 31);
	    contentPane.add(lblFarmerDetails);
	    
	    
	    //for table

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(175, 541, 681, 238);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				name = Fname.getText()+" "+ Lname.getText();
				idbox.setText(model.getValueAt(i, 0).toString()); 
				provincebox.setSelectedItem(model.getValueAt(i, 1).toString());
				Municipalitybox.setText(model.getValueAt(i, 2).toString());
				Fname.setText(model.getValueAt(i, 3).toString());
				Lname.setText(model.getValueAt(i, 4).toString());
				nofbox.setText(model.getValueAt(i, 5).toString());
				
				
				
			}
		});
		model = new DefaultTableModel();
		Object[] column = {"ID","Province","Municipality","First Name","Last Name","No. of family"};
		final Object[] row = new Object[6];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		//add
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				try {
				row[0]= idbox.getText();	
				row[1]= provincebox.getSelectedItem();
				row[2]= Municipalitybox.getText();
				row[3]= Fname.getText();
				row[4]= Lname.getText();
				row[5]= nofbox.getText();
				
				model.addRow(row);
				
				provincebox.setSelectedItem("");
				Municipalitybox.setText("");
				Fname.setText("");
				Lname.setText("");
				nofbox.setText("");
				idbox.setText(model.getValueAt(i, 0).toString());
				JOptionPane.showMessageDialog(null,"Saved");
				}catch(Exception E) {
					System.out.println(E);
				}
				
				Random();
				
			}
		});
		btnNewButton.setBounds(56, 541, 89, 31);
		contentPane.add(btnNewButton);
		
      //Update 	
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Arial", Font.BOLD, 14));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.setValueAt(idbox.getText(),i ,0);
				model.setValueAt(provincebox.getSelectedItem(), i ,1);
				model.setValueAt(Municipalitybox.getText(), i ,2);
				model.setValueAt(Fname.getText(), i ,3);
				model.setValueAt(Lname.getText(), i ,4);
				model.setValueAt(nofbox.getText(),i ,5);
				
				
				JOptionPane.showMessageDialog(null,"Updated");		
				
			}
		});
		btnUpdate.setBounds(56, 604, 89, 31);
		contentPane.add(btnUpdate);
		
		//delete
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Arial", Font.BOLD, 14));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.removeRow(i);
				JOptionPane.showMessageDialog(null,"Deleted");
			}
		});
		btnDelete.setBounds(56, 666, 89, 32);
		contentPane.add(btnDelete);
		
		
		// clear
		
		JButton clearb = new JButton("Clear");
		clearb.setFont(new Font("Arial", Font.BOLD, 14));
		clearb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				provincebox.setSelectedItem("");
				Municipalitybox.setText("");
				Fname.setText("");
				Lname.setText("");
				JOptionPane.showMessageDialog(null,"Cleared");		
			}
		});
		clearb.setBounds(56, 732, 89, 31);
		contentPane.add(clearb);
	    
	    
	    
	    
	  
	    
	    
	 
		
		
	}
}
