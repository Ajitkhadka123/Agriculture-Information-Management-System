package agriculture;

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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
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
	private JTextField familyNo;
	int ID, farmerRate, marketRate, Noofbox, quantity;
	String Name, Crop, production,  date;

	private Image logo = new ImageIcon(Login.class.getResource("/corpslogo.png")).getImage().getScaledInstance(50, 50,
			Image.SCALE_SMOOTH);
	private JButton PrintButton;
	private JTextPane textPane;
	private JComboBox<String> comboBoxP;
	private JTextField province;
	private JTextField municipality;

	Connection connect = null;
	private JTextField Datetext;
	
	static String prov=null;
	static String muni=null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCrops frame = new AddCrops(prov,muni);
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
	public AddCrops(final String prov, final String muni) {
		AddCrops.prov=prov;
		AddCrops.muni=muni;
		setResizable(false);
		connect = mysqlconnection.dbConnector();

		// creating methods for lables and textfields

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 1406, 818);
		// setUndecorated(true);
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

		textPane = new JTextPane();
		textPane.setFont(new Font("Arial", Font.PLAIN, 16));
		textPane.setBounds(892, 453, 469, 318);
		contentPane.add(textPane);

		PrintButton = new JButton("Print"); // creating save button
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
		PrintButton.setBounds(1261, 398, 89, 31);
		contentPane.add(PrintButton);

		JLabel label = new JLabel("New label");
		label.setBounds(111, 35, 89, -4);
		contentPane.add(label);

		JLabel lblCrops_1 = new JLabel("Crop");
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

		comboBoxP = new JComboBox<String>();
		comboBoxP.setModel(
				new DefaultComboBoxModel<String>(new String[] { "Kilogram ", "Gram", "Miligram", "Pound", "Ton" }));
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
				familyNo.setText(model.getValueAt(i, 2).toString());
				FarmerR.setText(model.getValueAt(i, 3).toString());
				province.setText(model.getValueAt(i, 4).toString());
				municipality.setText(model.getValueAt(i, 5).toString());
				crop.setText(model.getValueAt(i, 6).toString());
				Quantity.setText(model.getValueAt(i, 7).toString());
				comboBoxP.setSelectedItem(model.getValueAt(i, 8).toString());
				MarketB.setText(model.getValueAt(i, 9).toString());
				Datetext.setText(model.getValueAt(i, 10).toString());

				textPane.setText(
						"------------------------------------------------------------------------------------------------------------\n");
				textPane.setText(textPane.getText() + "                        Agricultural record of Municipality\n");
				textPane.setText(textPane.getText()
						+ "-------------------------------------------------------------------------------------------------\n");
				textPane.setText(textPane.getText() + "ID                         : "
						+ table.getValueAt(i, 0).toString() + "\n");
				textPane.setText(
						textPane.getText() + "Farmer Name        : " + table.getValueAt(i, 1).toString() + "\n");
				textPane.setText(
						textPane.getText() + "No. of family          : " + table.getValueAt(i, 2).toString() + "\n");
				textPane.setText(
						textPane.getText() + "Farmer Price         : " + table.getValueAt(i, 3).toString() + "\n");
				textPane.setText(
						textPane.getText() + "Province                : " + table.getValueAt(i, 4).toString() + "\n");
				textPane.setText(
						textPane.getText() + "Municipality            : " + table.getValueAt(i, 5).toString() + "\n");
				textPane.setText(
						textPane.getText() + "Crop                      : " + table.getValueAt(i, 6).toString() + "\n");
				textPane.setText(
						textPane.getText() + "Quantity                 : " + table.getValueAt(i, 7).toString() + "\n");
				textPane.setText(
						textPane.getText() + "Production              : " + table.getValueAt(i, 8).toString() + "\n");
				textPane.setText(
						textPane.getText() + "Market Price           : " + table.getValueAt(i, 9).toString() + "\n");
				textPane.setText(textPane.getText() + "Date                       : "
						+ table.getValueAt(i, 10).toString() + "\n");
//          textPane.setText(textPane.getText()+"Issued By           : "+ +" Municipality"+"\n");
				textPane.setText(textPane.getText() + "\nSignature              :                   \n");

			}
		});
		model = new DefaultTableModel();
		Object[] column = { "ID", "Name", "No. of Family", "Farmers Rate", "Province", "Municipality", "Crops",
				"Quantity", "Production", "Market rate", "Date" };
		final Object[] row = new Object[11];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1 = new JLabel(
				"Fill up details in below boxes and press add to add details and for deleting crops select crop name from the list and press delete.");
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
		lblPrintData.setBounds(892, 397, 128, 31);
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

		familyNo = new JTextField();
		familyNo.setFont(new Font("Arial", Font.PLAIN, 16));
		familyNo.setColumns(10);
		familyNo.setBounds(475, 217, 175, 31);
		contentPane.add(familyNo);

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

		province = new JTextField();
		province.setFont(new Font("Arial", Font.PLAIN, 16));
		province.setColumns(10);
		province.setBounds(910, 217, 175, 31);
		contentPane.add(province);
		province.setText(prov);

		municipality = new JTextField();
		municipality.setFont(new Font("Arial", Font.PLAIN, 16));
		municipality.setColumns(10);
		municipality.setBounds(1132, 217, 175, 31);
		contentPane.add(municipality);
		municipality.setText(muni);

		JLabel lblProvince = new JLabel("Province");
		lblProvince.setForeground(Color.WHITE);
		lblProvince.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblProvince.setBounds(911, 180, 144, 25);
		contentPane.add(lblProvince);

		JLabel lblMunici = new JLabel("Municipality");
		lblMunici.setForeground(Color.WHITE);
		lblMunici.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblMunici.setBounds(1133, 180, 144, 25);
		contentPane.add(lblMunici);

		Datetext = new JTextField();
		Datetext.setFont(new Font("Arial", Font.PLAIN, 16));
		Datetext.setColumns(10);
		Datetext.setBounds(910, 345, 175, 31);
		contentPane.add(Datetext);

		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblDate.setBounds(910, 311, 110, 25);
		contentPane.add(lblDate);

//		JList list = new JList();
//		list.setBounds(38, 349, 706, 284);
//		contentPane.add(list);

		// add

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setForeground(Color.RED);
			}

			public void mouseExited(MouseEvent e) {
				btnNewButton.setForeground(Color.BLACK);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					ID = Integer.parseInt(id.getText());
					Name = name.getText();
					Noofbox = Integer.parseInt(familyNo.getText());
					farmerRate = Integer.parseInt(FarmerR.getText());
					Crop = crop.getText();
					quantity = Integer.parseInt(Quantity.getText());
					production = (String) comboBoxP.getSelectedItem();
					marketRate = Integer.parseInt(MarketB.getText());
					date = Datetext.getText();

					// Create table crops(Id int not null unique, Name varchar(25) not null, Family
					// int not null, FarmersRate int not null,Province varchar(20) not null,
					// Municipality varchar(30) not null, Crops varchar(20) not null, Quantity int
					// not null, Production varchar(25) not null, MarketRate int not null, Date
					// varcahr(20));

					String query = "INSERT INTO crops (Id, Name, Family, FarmersRate, Province, Municipality, Crops, Quantity, Production, MarketRate, Date) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
					// create the statement
					PreparedStatement state = connect.prepareStatement(query);
					state.setInt(1, ID);
					state.setString(2, Name);
					state.setInt(3, Noofbox);
					state.setInt(4, farmerRate);
					state.setString(5, prov);
					state.setString(6, muni);
					state.setString(7, Crop);
					state.setInt(8, quantity);
					state.setString(9, production);
					state.setInt(10, marketRate);
					state.setString(11, date);

					state.executeUpdate();
					JOptionPane.showMessageDialog(null, "Added Successfully");
					// close the statement
					state.close();

					row[0] = id.getText();
					row[1] = name.getText();
					row[2] = familyNo.getText();
					row[3] = FarmerR.getText();
					row[4] = province.getText();
					row[5] = municipality.getText();
					row[6] = crop.getText();
					row[7] = Quantity.getText();
					row[8] = comboBoxP.getSelectedItem();
					row[9] = MarketB.getText();
					row[10] = Datetext.getText();
					model.addRow(row);

					textPane.setText(
							"------------------------------------------------------------------------------------------------------------\n");
					textPane.setText(
							textPane.getText() + "                        Agricultural record of Municipality\n");
					textPane.setText(textPane.getText()
							+ "-------------------------------------------------------------------------------------------------\n");
					textPane.setText(textPane.getText() + "ID                         : " + ID + "\n");
					textPane.setText(textPane.getText() + "Farmer Name        : " + Name + "\n");
					textPane.setText(textPane.getText() + "No. of family          : " + Noofbox + "\n");
					textPane.setText(textPane.getText() + "Farmer Price         : " + farmerRate + "\n");
					textPane.setText(textPane.getText() + "Province                : " + prov + "\n");
					textPane.setText(textPane.getText() + "Municipality            : " + muni + "\n");
					textPane.setText(textPane.getText() + "Crop                      : " + Crop + "\n");
					textPane.setText(textPane.getText() + "Quantity                 : " + quantity + "\n");
					textPane.setText(textPane.getText() + "Production              : " + production + "\n");
					textPane.setText(textPane.getText() + "Market Price           : " + marketRate + "\n");
					textPane.setText(textPane.getText() + "Date                       : " + date + "\n");
					textPane.setText(textPane.getText() + "\nSignature              :                   \n");

					id.setText("");
					name.setText("");
					familyNo.setText("");
					FarmerR.setText("");
					crop.setText("");
					Quantity.setText("");
					comboBoxP.setSelectedItem("");
					MarketB.setText("");
					Datetext.setText("");

				} catch (NumberFormatException E) {
					JOptionPane.showMessageDialog(null, "Please correctly fill up all the details");
					
				}catch (SQLIntegrityConstraintViolationException E) {
					JOptionPane.showMessageDialog(null, "Id already exists");
				}catch (Exception E) {
					JOptionPane.showMessageDialog(contentPane, E);
				}
			}
		});
		btnNewButton.setBounds(38, 398, 89, 31);
		contentPane.add(btnNewButton);

		// Update
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnUpdate.setForeground(Color.RED);
			}

			public void mouseExited(MouseEvent e) {
				btnUpdate.setForeground(Color.BLACK);
			}
		});
		btnUpdate.setFont(new Font("Arial", Font.BOLD, 14));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				ID = Integer.parseInt(id.getText());
				Name = name.getText();
				Noofbox = Integer.parseInt(familyNo.getText());
				farmerRate = Integer.parseInt(FarmerR.getText());

				Crop = crop.getText();
				quantity = Integer.parseInt(Quantity.getText());
				production = (String) comboBoxP.getSelectedItem();
				marketRate = Integer.parseInt(MarketB.getText());
				date = Datetext.getText();
				
				
				

				try {
					String query = "Update crops set Name='" + Name + "',Family='" + Noofbox + "',FarmersRate='"
							+ farmerRate + "',Province='" + prov + "',Municipality='" + muni + "',Crops='" + Crop
							+ "',Quantity='" + quantity + "',Production='" + production + "',MarketRate='" + marketRate
							+ "',Date='" + date + "' where Id='" + ID + "'";
					PreparedStatement state = connect.prepareStatement(query);
					state.execute();
					
					state.close();
					
					model.setValueAt(id.getText(), i, 0);
					model.setValueAt(name.getText(), i, 1);
					model.setValueAt(familyNo.getText(), i, 2);
					model.setValueAt(FarmerR.getText(), i, 3);
					model.setValueAt(province.getText(), i, 4);
					model.setValueAt(municipality.getText(), i, 5);
					model.setValueAt(crop.getText(), i, 6);
					model.setValueAt(Quantity.getText(), i, 7);
					model.setValueAt(comboBoxP.getSelectedItem(), i, 8);
					model.setValueAt(MarketB.getText(), i, 9);
					model.setValueAt(Datetext.getText(), i, 10);
					

					textPane.setText(
							"------------------------------------------------------------------------------------------------------------\n");
					textPane.setText(textPane.getText() + "                        Agricultural record of Municipality\n");
					textPane.setText(textPane.getText()
							+ "-------------------------------------------------------------------------------------------------\n");
					textPane.setText(textPane.getText() + "ID                         : " + ID + "\n");
					textPane.setText(textPane.getText() + "Farmer Name        : " + Name + "\n");
					textPane.setText(textPane.getText() + "No. of family          : " + Noofbox + "\n");
					textPane.setText(textPane.getText() + "Farmer Price         : " + farmerRate + "\n");
					textPane.setText(textPane.getText() + "Province                : " + prov + "\n");
					textPane.setText(textPane.getText() + "Municipality            : " + muni + "\n");
					textPane.setText(textPane.getText() + "Crop                      : " + Crop + "\n");
					textPane.setText(textPane.getText() + "Quantity                 : " + quantity + "\n");
					textPane.setText(textPane.getText() + "Production              : " + production + "\n");
					textPane.setText(textPane.getText() + "Market Price           : " + marketRate + "\n");
					textPane.setText(textPane.getText() + "Date                       : " + date + "\n");
//	          textPane.setText(textPane.getText()+"Issued By           : "+ +" Municipality"+"\n");
					textPane.setText(textPane.getText() + "\nSignature              :                   \n");
					JOptionPane.showMessageDialog(null, "Data Updated Successfully");
					
					
					

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(contentPane, e1);
				}

			}
			
			
		});
		btnUpdate.setBounds(151, 398, 89, 31);
		contentPane.add(btnUpdate);

		// delete

		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDelete.setForeground(Color.RED);
			}

			public void mouseExited(MouseEvent e) {
				btnDelete.setForeground(Color.BLACK);
			}
		});
		btnDelete.setFont(new Font("Arial", Font.BOLD, 14));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ID = Integer.parseInt(id.getText());
				Name = name.getText();
				try {
					
					String query = "Delete from crops where Id='" + ID + "' and Name='" + Name + "'";
					PreparedStatement state = connect.prepareStatement(query);
					state.execute();
					state.close();
					int i = table.getSelectedRow();
					model.removeRow(i);
					JOptionPane.showMessageDialog(null, "Deleted");
					id.setText("");
					name.setText("");
					familyNo.setText("");
					FarmerR.setText("");
					crop.setText("");
					Quantity.setText("");
					comboBoxP.setSelectedItem("");
					MarketB.setText("");
					Datetext.setText("");
					textPane.setText("");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(contentPane, e2);
				}
			}
		});
		btnDelete.setBounds(771, 397, 89, 32);
		contentPane.add(btnDelete);

		// clear

		JButton clearb = new JButton("Clear");
		clearb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				clearb.setForeground(Color.RED);
			}

			public void mouseExited(MouseEvent e) {
				clearb.setForeground(Color.BLACK);
			}
		});
		clearb.setFont(new Font("Arial", Font.BOLD, 14));
		clearb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setText("");
				name.setText("");
				familyNo.setText("");
				FarmerR.setText("");
				crop.setText("");
				Quantity.setText("");
				comboBoxP.setSelectedItem("");
				MarketB.setText("");
				Datetext.setText("");
				textPane.setText("");
				JOptionPane.showMessageDialog(null, "Cleared");
			}
		});
		clearb.setBounds(672, 398, 89, 31);
		contentPane.add(clearb);

		// back button

		Back = new JTextField();
		Back.setBackground(new Color(85, 107, 47));
		Back.setEditable(false);
		Back.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				Back.setForeground(Color.RED);
			}

			public void mouseExited(MouseEvent e) {
				Back.setForeground(Color.ORANGE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = municipality.getText();
				AddCrops.this.dispose();
				Dash lol = new Dash(name);
				lol.setVisible(true);
				
			}
		});

		Back.setFont(new Font("Tahoma", Font.BOLD, 33));
		Back.setBorder(null);
		Back.setForeground(Color.ORANGE);
		Back.setText("\u2190");
		Back.setBounds(22, 32, 42, 19);
		contentPane.add(Back);
		Back.setColumns(10);

	}
}
