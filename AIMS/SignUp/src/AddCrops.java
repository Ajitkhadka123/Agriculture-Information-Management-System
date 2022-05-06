

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class AddCrops extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField name;
	private JTextField FarmerR;
	private JTextField MarketB;
	private JTextField Back;
	DefaultTableModel model;
	private JTable table;
	private JTextField crop;
	private JTextField Quantity;
	private JTextField id;
	private JTextField noofbox;
	String ID;
	String Name;
	String Noofbox;
	String Crop;
	String quantity;
	String production;
	String farmerRate;
	String marketRate;
	long first4;
	long first;
	
	private Image logo = new ImageIcon(Login.class.getResource("/img/corpslogo.png")).getImage().getScaledInstance(50,50, Image.SCALE_SMOOTH);
	
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
		Random();
		
		//creating methods for lables and textfields
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 1406, 818);
		//setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(85, 107, 47));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel QuantityL = new JLabel("Quantity");
		QuantityL.setFont(new Font("Calibri", Font.PLAIN, 20));
		QuantityL.setForeground(Color.WHITE);
		QuantityL.setBounds(253, 311, 144, 25);
		contentPane.add(QuantityL);
		
		JLabel lblMarketRate = new JLabel("Market Rate");
		lblMarketRate.setForeground(Color.WHITE);
		lblMarketRate.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblMarketRate.setBounds(688, 311, 110, 25);
		contentPane.add(lblMarketRate);
		
		JLabel lblFarmersRate = new JLabel("Farmers Rate");
		lblFarmersRate.setForeground(Color.WHITE);
		lblFarmersRate.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblFarmersRate.setBounds(688, 180, 144, 25);
		contentPane.add(lblFarmersRate);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Arial", Font.PLAIN, 16));
		textPane.setBounds(892, 199, 469, 572);
		contentPane.add(textPane);
		
		
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
				 try {
                     textPane.print();
                    
                     JOptionPane.showMessageDialog(null, "Successfully Printed!!!");
                 } catch (Exception e2) {
                     JOptionPane.showMessageDialog(null, e2);
                 }
			
			}
		});
		PrintButton.setBounds(1272, 158, 89, 31);
		contentPane.add(PrintButton);
		
		JLabel label = new JLabel("New label");
		label.setBounds(111, 35, 89, -4);
		contentPane.add(label);
		
		JLabel lblCrops_1 = new JLabel("Crops");
		lblCrops_1.setForeground(Color.WHITE);
		lblCrops_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblCrops_1.setBounds(38, 311, 71, 25);
		contentPane.add(lblCrops_1);
		
		FarmerR = new JTextField();
		FarmerR.setFont(new Font("Arial", Font.PLAIN, 16));
		FarmerR.setColumns(10);
		FarmerR.setBounds(688, 217, 175, 31);
		contentPane.add(FarmerR);
		
		MarketB = new JTextField();
		MarketB.setFont(new Font("Arial", Font.PLAIN, 16));
		MarketB.setColumns(10);
		MarketB.setBounds(688, 345, 175, 31);
		contentPane.add(MarketB);
		
		JComboBox comboBoxP = new JComboBox();
		comboBoxP.setModel(new DefaultComboBoxModel(new String[] {"Kilogram ", "Gram", "Miligram", "Pound", "Ton"}));
		comboBoxP.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBoxP.setBounds(473, 346, 177, 29);
		contentPane.add(comboBoxP);
		
		JLabel lblAddCropSection = new JLabel("Add Crop Section");
		lblAddCropSection.setForeground(Color.WHITE);
		lblAddCropSection.setFont(new Font("Arial", Font.BOLD, 28));
		lblAddCropSection.setBounds(533, 17, 247, 58);
		contentPane.add(lblAddCropSection);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new LineBorder(new Color(255, 215, 0), 9));
		verticalBox.setBackground(new Color(255, 215, 0));
		verticalBox.setBounds(0, 85, 1386, 3);
		contentPane.add(verticalBox);

		
		name = new JTextField();
		name.setFont(new Font("Arial", Font.PLAIN, 16));
		name.setBounds(253, 218, 175, 29);
		contentPane.add(name);
		name.setColumns(10);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 453, 825, 318);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				id.setText(model.getValueAt(i, 0).toString());
				name.setText(model.getValueAt(i, 1).toString());
				noofbox.setText(model.getValueAt(i, 2).toString());
				crop.setText(model.getValueAt(i, 3).toString());
				Quantity.setText(model.getValueAt(i, 4).toString());
    			comboBoxP.setSelectedItem(model.getValueAt(i, 5).toString());
				FarmerR.setText(model.getValueAt(i, 6).toString());
				MarketB.setText(model.getValueAt(i, 7).toString());
				
				
			}
		});
		model = new DefaultTableModel();
		Object[] column = {"ID","Name","No. of Family","Crops","Quantity","Production","Farmers Rate","Market rate"};
		final Object[] row = new Object[8];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		//add
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				
				
			    ID = id.getText();
			    Name = name.getText();
			    Noofbox = noofbox.getText();
			    Crop = crop.getText();
			    quantity = Quantity.getText();
			    production = (String) comboBoxP.getSelectedItem();
			    farmerRate = FarmerR.getText();
			    marketRate = MarketB.getText();
					
					
				row[0]= id.getText();
				row[1]= name.getText();
				row[2]= noofbox.getText();
				row[3]= crop.getText();
				row[4]= Quantity.getText();
				row[5]= comboBoxP.getSelectedItem();
				row[6]= FarmerR.getText();
				row[7]= MarketB.getText();
				model.addRow(row);
				
			    textPane.setText("------------------------------------------------------------------------------------------------------------\n");
	            textPane.setText(textPane.getText()+"                        Agricultural record of Municipality\n");
	            textPane.setText(textPane.getText()+"-------------------------------------------------------------------------------------------------\n");
	            textPane.setText(textPane.getText()+"Farmer Name : " +Name+"\n");
	            textPane.setText(textPane.getText()+"ID                  : " +ID+"\n");
                textPane.setText(textPane.getText()+"No. of family   : " +Noofbox+"\n");
	            textPane.setText(textPane.getText()+"Crop              : " +Crop+"\n");
	            textPane.setText(textPane.getText()+"Quantity         : "+quantity+"\n");
                textPane.setText(textPane.getText()+"Production      : "+production+"\n");
	            textPane.setText(textPane.getText()+"Farmer Price  : " +farmerRate+"\n");
                textPane.setText(textPane.getText()+"Market Price  : " +marketRate+"\n");
                textPane.setText(textPane.getText()+"Date              : "+"2079/ /"+"\n");
//              textPane.setText(textPane.getText()+"Issued By          : "+ +" Municipality"+"\n");
	                
	                
	       
	            textPane.setText(textPane.getText()+"\nSignature       :                   \n");
				 
				
 				id.setText("");
				name.setText("");
				noofbox.setText("");
				crop.setText("");
				Quantity.setText("");
				comboBoxP.setSelectedItem("");
				FarmerR.setText("");
				MarketB.setText("");
				JOptionPane.showMessageDialog(null,"Added");
				}catch(Exception E) {
					System.out.println(E);
				}
				Random();
				
				
				
			}
		});
		btnNewButton.setBounds(38, 398, 89, 31);
		contentPane.add(btnNewButton);
		
      //Update 	
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Arial", Font.BOLD, 14));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				
				model.setValueAt(id.getText(), i ,0);
				model.setValueAt(name.getText(), i ,1);
				model.setValueAt(noofbox.getText(), i ,2);
				model.setValueAt(crop.getText(), i ,3);
				model.setValueAt(Quantity.getText(), i ,4);
				model.setValueAt(comboBoxP.getSelectedItem(), i ,5);
				model.setValueAt(FarmerR.getText(), i ,6);
				model.setValueAt(MarketB.getText(), i ,7);
				JOptionPane.showMessageDialog(null,"Updated");		
				
			}
		});
		btnUpdate.setBounds(151, 398, 89, 31);
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
		btnDelete.setBounds(771, 397, 89, 32);
		contentPane.add(btnDelete);
		
		
		// clear
		
		JButton clearb = new JButton("Clear");
		clearb.setFont(new Font("Arial", Font.BOLD, 14));
		clearb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setText("");
				name.setText("");
				noofbox.setText("");
				crop.setText("");
				Quantity.setText("");
				comboBoxP.setSelectedItem("");
				FarmerR.setText("");
				MarketB.setText("");
				JOptionPane.showMessageDialog(null,"Cleared");		
			}
		});
		clearb.setBounds(672, 398, 89, 31);
		contentPane.add(clearb);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("Fill up details in below boxes and press add to add details and for deleting crops select crop name from the list and press delete.");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(195, 98, 1041, 31);
		contentPane.add(lblNewLabel_1);
		
		
		JLabel lblNewLabel = new JLabel("Farmer Details");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(38, 139, 175, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblPrintData = new JLabel("Print data");
		lblPrintData.setForeground(Color.WHITE);
		lblPrintData.setFont(new Font("Arial", Font.BOLD, 18));
		lblPrintData.setBounds(892, 139, 128, 31);
		contentPane.add(lblPrintData);
		
		crop = new JTextField();
		crop.setFont(new Font("Arial", Font.PLAIN, 16));
		crop.setColumns(10);
		crop.setBounds(38, 346, 175, 29);
		contentPane.add(crop);
		
		JLabel lblNewLabel_2 = new JLabel("Add crops");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2.setBounds(38, 270, 128, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblCrops_1_1 = new JLabel("Name");
		lblCrops_1_1.setForeground(Color.WHITE);
		lblCrops_1_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblCrops_1_1.setBounds(253, 180, 71, 25);
		contentPane.add(lblCrops_1_1);
		
		Quantity = new JTextField();
		Quantity.setFont(new Font("Arial", Font.PLAIN, 16));
		Quantity.setColumns(10);
		Quantity.setBounds(253, 345, 175, 31);
		contentPane.add(Quantity);
		
		JLabel lblCrops_2 = new JLabel("Production");
		lblCrops_2.setForeground(Color.WHITE);
		lblCrops_2.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblCrops_2.setBounds(473, 311, 144, 25);
		contentPane.add(lblCrops_2);
		
		id = new JTextField();
		id.setFont(new Font("Arial", Font.PLAIN, 16));
		id.setColumns(10);
		id.setBounds(38, 219, 175, 29);
//		id.setText("1533"+first);
		contentPane.add(id);
		
		JLabel lblCrops_1_1_1 = new JLabel("ID");
		lblCrops_1_1_1.setForeground(Color.WHITE);
		lblCrops_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblCrops_1_1_1.setBounds(38, 185, 71, 25);
		contentPane.add(lblCrops_1_1_1);
		
		noofbox = new JTextField();
		noofbox.setFont(new Font("Arial", Font.PLAIN, 16));
		noofbox.setColumns(10);
		noofbox.setBounds(475, 217, 175, 31);
		contentPane.add(noofbox);
		
		JLabel lblNoOfFamily = new JLabel("No. of Family");
		lblNoOfFamily.setForeground(Color.WHITE);
		lblNoOfFamily.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNoOfFamily.setBounds(473, 180, 144, 25);
		contentPane.add(lblNoOfFamily);
		
		JLabel mainlogo = new JLabel("");
		mainlogo.setHorizontalAlignment(SwingConstants.CENTER);
		mainlogo.setBounds(62, 17, 65, 58);
		contentPane.add(mainlogo);
		mainlogo.setIcon(new ImageIcon(logo));
		
		
		
//		JList list = new JList();
//		list.setBounds(38, 349, 706, 284);
//		contentPane.add(list);
		
		
	}
}
