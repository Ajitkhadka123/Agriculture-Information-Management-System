

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AddCrops extends JFrame {

	private JPanel contentPane;
	private JButton btnCancel;
	private JTextField CropTextfield;
	private JTextField FarmerR;
	private JTextField textField_3;
	private JTextField Back;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCrops frame = new AddCrops();
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
	public AddCrops() {
		setResizable(false);
		
		//creating methods for lables and textfields
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		//setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(85, 107, 47));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCrops = new JLabel("Production");
		lblCrops.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblCrops.setForeground(Color.WHITE);
		lblCrops.setBounds(271, 182, 144, 25);
		contentPane.add(lblCrops);
		
		JLabel lblMarketRate = new JLabel("Market Rate");
		lblMarketRate.setForeground(Color.WHITE);
		lblMarketRate.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblMarketRate.setBounds(688, 182, 110, 25);
		contentPane.add(lblMarketRate);
		
		JLabel lblFarmersRate = new JLabel("Farmers Rate");
		lblFarmersRate.setForeground(Color.WHITE);
		lblFarmersRate.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblFarmersRate.setBounds(478, 182, 144, 25);
		contentPane.add(lblFarmersRate);
		
		JButton PrintButton = new JButton("Print");             //creating save button
		PrintButton.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseEntered(MouseEvent e) {
				PrintButton.setForeground(Color.RED);
				
			}
	
			public void mouseExited(MouseEvent e) {
				PrintButton.setForeground(Color.BLACK);
			}
		});
		PrintButton.setFont(new Font("Arial", Font.BOLD, 14));
		PrintButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		PrintButton.setBounds(548, 283, 89, 31);
		contentPane.add(PrintButton);
		
		// delete button
		btnCancel = new JButton("Delete");                      
		btnCancel.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				btnCancel.setForeground(Color.RED);
				
			}
	
			public void mouseExited(MouseEvent e) {
				btnCancel.setForeground(Color.BLACK);
			}
		
		});
		btnCancel.setFont(new Font("Arial", Font.BOLD, 14));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCancel.setBounds(774, 283, 89, 31);
		contentPane.add(btnCancel);
		
		JLabel label = new JLabel("New label");
		label.setBounds(111, 35, 89, -4);
		contentPane.add(label);
		
		JLabel lblCrops_1 = new JLabel("Crops");
		lblCrops_1.setForeground(Color.WHITE);
		lblCrops_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblCrops_1.setBounds(38, 182, 71, 25);
		contentPane.add(lblCrops_1);
		
		CropTextfield = new JTextField();
		CropTextfield.setFont(new Font("Arial", Font.PLAIN, 16));
		CropTextfield.setColumns(10);
		CropTextfield.setBounds(38, 217, 200, 31);
		contentPane.add(CropTextfield);
		
		FarmerR = new JTextField();
		FarmerR.setFont(new Font("Arial", Font.PLAIN, 16));
		FarmerR.setColumns(10);
		FarmerR.setBounds(478, 217, 175, 31);
		contentPane.add(FarmerR);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(688, 217, 175, 31);
		contentPane.add(textField_3);
		
		JComboBox comboBoxP = new JComboBox();
		comboBoxP.setModel(new DefaultComboBoxModel(new String[] {"Kilogram ", "Gram", "Miligram", "Pound", "Ton"}));
		comboBoxP.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBoxP.setBounds(271, 218, 177, 29);
		contentPane.add(comboBoxP);
		
		JLabel lblAddCropSection = new JLabel("Add Crop Section");
		lblAddCropSection.setForeground(Color.WHITE);
		lblAddCropSection.setFont(new Font("Arial", Font.BOLD, 28));
		lblAddCropSection.setBounds(342, 16, 247, 58);
		contentPane.add(lblAddCropSection);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new LineBorder(new Color(255, 215, 0), 9));
		verticalBox.setBackground(new Color(255, 215, 0));
		verticalBox.setBounds(0, 85, 886, 3);
		contentPane.add(verticalBox);
		
		// back button
		
		Back = new JTextField();
		Back.setBackground(new Color(85, 107, 47));
		Back.setEditable(false);
		Back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddCrops.this.dispose();
				Dash Dashboard = new Dash();
				Dashboard.setVisible(true);
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
		Back.setBounds(22, 32, 42, 19);
		contentPane.add(Back);
		Back.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Fill up details in below boxes and press add to add details and for deleting crops select crop name ");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(38, 98, 836, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("from the list and press delete.");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(38, 128, 760, 25);
		contentPane.add(lblNewLabel_1_1);
		
		//add button 
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAdd.setForeground(Color.RED);
				
			}
	
			public void mouseExited(MouseEvent e) {
				btnAdd.setForeground(Color.BLACK);
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			DefaultListModel model = new DefaultListModel();
			
			public void actionPerformed(ActionEvent e) {
				model.addElement(CropTextfield.getText());
				list.setModel(model);
			}
		});
		btnAdd.setFont(new Font("Arial", Font.BOLD, 14));
		btnAdd.setBounds(663, 283, 89, 31);
		contentPane.add(btnAdd);
		
		//save button
		JButton SaveButton_1 = new JButton("Save");
		SaveButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==SaveButton_1) {
					if(JOptionPane.showConfirmDialog(null, "Do you want Save Details?", "Confirmation", JOptionPane.YES_NO_OPTION) ==0) {
						
			
		}}}});
		SaveButton_1.setFont(new Font("Arial", Font.BOLD, 14));
		SaveButton_1.setBounds(431, 283, 89, 31);
		contentPane.add(SaveButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 339, 825, 301);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
	}
}
