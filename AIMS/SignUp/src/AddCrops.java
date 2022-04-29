

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AddCrops extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField CropTextfield;
	private JTextField FarmerR;
	private JTextField MarketB;
	private JTextField Back;
	DefaultTableModel model;
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
		PrintButton.setBounds(774, 111, 89, 31);
		contentPane.add(PrintButton);
		
		JLabel label = new JLabel("New label");
		label.setBounds(111, 35, 89, -4);
		contentPane.add(label);
		
		JLabel lblCrops_1 = new JLabel("Crops");
		lblCrops_1.setForeground(Color.WHITE);
		lblCrops_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblCrops_1.setBounds(38, 182, 71, 25);
		contentPane.add(lblCrops_1);
		
		FarmerR = new JTextField();
		FarmerR.setFont(new Font("Arial", Font.PLAIN, 16));
		FarmerR.setColumns(10);
		FarmerR.setBounds(478, 217, 175, 31);
		contentPane.add(FarmerR);
		
		MarketB = new JTextField();
		MarketB.setFont(new Font("Arial", Font.PLAIN, 16));
		MarketB.setColumns(10);
		MarketB.setBounds(688, 217, 175, 31);
		contentPane.add(MarketB);
		
		JComboBox comboBoxP = new JComboBox();
		comboBoxP.setModel(new DefaultComboBoxModel(new String[] {"Kilogram ", "Gram", "Miligram", "Pound", "Ton"}));
		comboBoxP.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBoxP.setBounds(271, 218, 177, 29);
		contentPane.add(comboBoxP);
		
		JLabel lblAddCropSection = new JLabel("Add Crop Section");
		lblAddCropSection.setForeground(Color.WHITE);
		lblAddCropSection.setFont(new Font("Arial", Font.BOLD, 28));
		lblAddCropSection.setBounds(337, 17, 247, 58);
		contentPane.add(lblAddCropSection);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new LineBorder(new Color(255, 215, 0), 9));
		verticalBox.setBackground(new Color(255, 215, 0));
		verticalBox.setBounds(0, 85, 886, 3);
		contentPane.add(verticalBox);

		
		CropTextfield = new JTextField();
		CropTextfield.setBounds(38, 220, 175, 29);
		contentPane.add(CropTextfield);
		CropTextfield.setColumns(10);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 335, 825, 318);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
//				comboBoxP.setText(model.getValueAt(i, 0).toString());
				CropTextfield.setText(model.getValueAt(i, 1).toString());
				FarmerR.setText(model.getValueAt(i, 2).toString());
				MarketB.setText(model.getValueAt(i, 3).toString());
				
				
			}
		});
		model = new DefaultTableModel();
		Object[] column = {"Province","Municipality","Crops","Market Rate","Farmers rate"};
		final Object[] row = new Object[4];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//				row[0]= comboBoxP.getText();
				row[1]= CropTextfield.getText();
				row[2]= FarmerR.getText();
				row[3]= MarketB.getText();
				model.addRow(row);
				
//				comboBoxP.setText("");
				CropTextfield.setText("");
				FarmerR.setText("");
				MarketB.setText("");
				JOptionPane.showMessageDialog(null,"Saved");
				}catch(Exception E) {
					System.out.println(E);
				}
			}
		});
		btnNewButton.setBounds(38, 282, 89, 31);
		contentPane.add(btnNewButton);
		
      //Update 	
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Arial", Font.BOLD, 14));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
//				model.setValueAt(comboBoxP.getText(), i ,0);
				model.setValueAt(CropTextfield.getText(), i ,1);
				model.setValueAt(FarmerR.getText(), i ,2);
				model.setValueAt(MarketB.getText(), i ,3);
				JOptionPane.showMessageDialog(null,"Updated");
				
				
				
			}
		});
		btnUpdate.setBounds(151, 282, 89, 31);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Arial", Font.BOLD, 14));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.removeRow(i);
				JOptionPane.showMessageDialog(null,"Deleted");
			}
		});
		btnDelete.setBounds(774, 283, 89, 32);
		contentPane.add(btnDelete);
		
		JButton btnClearl = new JButton("Clear");
		btnClearl.setFont(new Font("Arial", Font.BOLD, 14));
		btnClearl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				comboBoxP.setText("");
				CropTextfield.setText("");
				FarmerR.setText("");
				MarketB.setText("");
				JOptionPane.showMessageDialog(null,"Cleared");
			}
		});
		btnClearl.setBounds(668, 283, 89, 31);
		contentPane.add(btnClearl);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	
	

		
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
		
		
		
		JList list = new JList();
		list.setBounds(38, 349, 706, 284);
		contentPane.add(list);
		
		
	}
}
