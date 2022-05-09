package agriculture;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
//import com.opencsv.CSVWriter;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextPane;
import javax.swing.Box;
import javax.swing.border.LineBorder;

public class AdminSection {

	private Image img_logo = new ImageIcon(AdminSection.class.getResource("/corpslogo.png")).getImage()
			.getScaledInstance(50,50 , Image.SCALE_SMOOTH);

	private JFrame frame;
	private JTextField munifield;
	private JTextField provfield;
	private JTextField cropfield;
	private JTextField marketratefield;
	private JTextField fmratefield;
	private JTable table;
	DefaultTableModel model;
	private JTextField familyfield;
	private JTextField namefield;

	private JTextPane textPane;
	Connection connect = null;
	private JTextField datefield;
	private JTextField idfield;
	private JTextField quantityfield;
	private JTextField productionfield;
	int ID, farmerRate, marketRate, Noofbox, quantity;
	String Name, Crop, prov, muni, production, date;
	private JTextField Back;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSection window = new AdminSection();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminSection() {
		initialize();
		load();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void load() {
		try {
			String query = "Select * from crops";
			PreparedStatement state = connect.prepareStatement(query);
			ResultSet result = state.executeQuery();

			table.setModel(DbUtils.resultSetToTableModel(result));
			// JOptionPane.showMessageDialog(frame, "Data Loaded Successfully");
			result.close();
			state.close();

		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(frame, e2);

		}

	}

	private void initialize() {
		connect = mysqlconnection.dbConnector();
		setFrame(new JFrame());
		getFrame().setResizable(false);
		getFrame().setBounds(100, 100, 950, 720);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(85, 107, 47));
		panel.setBounds(0, 0, 957, 683);
		getFrame().getContentPane().add(panel);
		panel.setLayout(null);

		JLabel province = new JLabel("Province");
		province.setBounds(17, 288, 102, 27);
		province.setFont(new Font("Tahoma", Font.PLAIN, 18));
		province.setForeground(new Color(255, 255, 255));
		panel.add(province);

		JLabel municipality = new JLabel("Municipality");
		municipality.setBounds(17, 333, 102, 27);
		municipality.setForeground(Color.WHITE);
		municipality.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(municipality);

		JLabel crops = new JLabel("Crop");
		crops.setBounds(17, 370, 102, 33);
		crops.setForeground(Color.WHITE);
		crops.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(crops);

		JLabel marketrate = new JLabel("Market's Rate");
		marketrate.setBounds(17, 480, 113, 27);
		marketrate.setForeground(Color.WHITE);
		marketrate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(marketrate);

		JLabel Farmersrate = new JLabel("Farmer's Rate");
		Farmersrate.setBounds(17, 251, 132, 27);
		Farmersrate.setForeground(Color.WHITE);
		Farmersrate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(Farmersrate);

		munifield = new JTextField();
		munifield.setBounds(140, 328, 137, 27);
		panel.add(munifield);
		munifield.setColumns(10);

		provfield = new JTextField();
		provfield.setBounds(140, 291, 137, 27);
		provfield.setColumns(10);
		panel.add(provfield);

		cropfield = new JTextField();
		cropfield.setBounds(140, 370, 137, 27);
		cropfield.setColumns(10);
		panel.add(cropfield);

		marketratefield = new JTextField();
		marketratefield.setBounds(140, 483, 137, 27);
		marketratefield.setColumns(10);
		panel.add(marketratefield);

		fmratefield = new JTextField();
		fmratefield.setBounds(140, 254, 137, 27);
		fmratefield.setColumns(10);
		panel.add(fmratefield);

		JLabel marketrate_1 = new JLabel("Date");
		marketrate_1.setBounds(17, 517, 102, 27);
		marketrate_1.setForeground(Color.WHITE);
		marketrate_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(marketrate_1);

		JLabel lblId = new JLabel("Id");
		lblId.setBounds(17, 140, 132, 27);
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblId);

		datefield = new JTextField();
		datefield.setBounds(140, 520, 137, 27);
		datefield.setColumns(10);
		panel.add(datefield);

		idfield = new JTextField();
		idfield.setBounds(140, 143, 137, 27);
		idfield.setColumns(10);
		panel.add(idfield);

		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(17, 408, 102, 27);
		lblQuantity.setForeground(Color.WHITE);
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblQuantity);

		quantityfield = new JTextField();
		quantityfield.setBounds(140, 408, 137, 27);
		quantityfield.setColumns(10);
		panel.add(quantityfield);

		JLabel lblProduction = new JLabel("Production");
		lblProduction.setBounds(17, 443, 102, 27);
		lblProduction.setForeground(Color.WHITE);
		lblProduction.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblProduction);

		productionfield = new JTextField();
		productionfield.setBounds(140, 446, 137, 27);
		productionfield.setColumns(10);
		panel.add(productionfield);

		JLabel AIMS = new JLabel("Agriculture Information Management System");
		AIMS.setBounds(155, 27, 587, 46);
		AIMS.setFont(new Font("Serif", Font.BOLD, 27));
		AIMS.setForeground(new Color(255, 255, 0));
		panel.add(AIMS);

		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setBounds(17, 177, 102, 27);
		lblFullName.setForeground(Color.WHITE);
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblFullName);

		JLabel noofFamily = new JLabel("No. of Family");
		noofFamily.setBounds(17, 214, 119, 27);
		noofFamily.setForeground(Color.WHITE);
		noofFamily.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(noofFamily);

		familyfield = new JTextField();
		familyfield.setBounds(140, 217, 137, 27);
		familyfield.setColumns(10);
		panel.add(familyfield);

		namefield = new JTextField();
		namefield.setBounds(140, 180, 137, 27);
		namefield.setColumns(10);
		panel.add(namefield);

		JLabel IbllconLogo = new JLabel("");
		IbllconLogo.setBounds(40, 15, 109, 82);
		IbllconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(IbllconLogo);
		IbllconLogo.setIcon(new ImageIcon(img_logo));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(287, 143, 637, 445);
		panel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				idfield.setText(table.getValueAt(i, 0).toString());
				namefield.setText(table.getValueAt(i, 1).toString());
				familyfield.setText(table.getValueAt(i, 2).toString());
				fmratefield.setText(table.getValueAt(i, 3).toString());
				provfield.setText(table.getValueAt(i, 4).toString());
				munifield.setText(table.getValueAt(i, 5).toString());
				cropfield.setText(table.getValueAt(i, 6).toString());
				quantityfield.setText(table.getValueAt(i, 7).toString());
				productionfield.setText(table.getValueAt(i, 8).toString());
				marketratefield.setText(table.getValueAt(i, 9).toString());
				datefield.setText(table.getValueAt(i, 10).toString());

			}
		});
		model = new DefaultTableModel();
		Object[] column = { "Id", "Name", "Family", "FarmersRate", "Province", "Municipality", "Crops", "Quantity",
				"Production", "Market Rate", "Date" };
		final Object[] row = new Object[11];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(37, 572, 83, 38);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					ID = Integer.parseInt(idfield.getText());
					Name = namefield.getText();
					Noofbox = Integer.parseInt(familyfield.getText());
					farmerRate = Integer.parseInt(fmratefield.getText());
					prov = provfield.getText();
					muni = munifield.getText();
					Crop = cropfield.getText();
					quantity = Integer.parseInt(quantityfield.getText());
					production = productionfield.getText();
					marketRate = Integer.parseInt(marketratefield.getText());
					date = datefield.getText();

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
					
		

				} catch (NumberFormatException E) {
					JOptionPane.showMessageDialog(null, "Please fill up all the details");
					
				}catch (SQLIntegrityConstraintViolationException E) {
					JOptionPane.showMessageDialog(null, "Id already exists");
				}
                 catch (Exception E) {
					JOptionPane.showMessageDialog(null, E);
				}
				
				load();
			}
		});
		panel.add(btnNewButton);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(152, 572, 83, 38);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ID = Integer.parseInt(idfield.getText());
					Name = namefield.getText();
					Noofbox = Integer.parseInt(familyfield.getText());
					farmerRate = Integer.parseInt(fmratefield.getText());
					prov = provfield.getText();
					muni = munifield.getText();
					Crop = cropfield.getText();
					quantity = Integer.parseInt(quantityfield.getText());
					production = productionfield.getText();
					marketRate = Integer.parseInt(marketratefield.getText());
					date = datefield.getText();
					String query = "Update crops set Name='" + Name + "',Family='" + Noofbox + "',FarmersRate='"
							+ farmerRate + "',Province='" + prov + "',Municipality='" + muni + "',Crops='" + Crop
							+ "',Quantity='" + quantity + "',Production='" + production + "',MarketRate='" + marketRate
							+ "',Date='" + date + "' where Id='" + ID + "'";
					PreparedStatement state = connect.prepareStatement(query);
					state.execute();
					JOptionPane.showMessageDialog(null, "Updated");

					state.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
				load();
			}
		});
		panel.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(37, 627, 83, 38);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ID = Integer.parseInt(idfield.getText());
				Name = namefield.getText();
				try {
					String query = "Delete from crops where Id='" + ID + "' and Name='" + Name + "'";
					PreparedStatement state = connect.prepareStatement(query);
					state.execute();
					state.close();
					idfield.setText("");
					namefield.setText("");
					familyfield.setText("");
					fmratefield.setText("");
					provfield.setText("");
					munifield.setText("");
					cropfield.setText("");
					quantityfield.setText("");
					productionfield.setText("");
					marketratefield.setText("");
					datefield.setText("");
					JOptionPane.showMessageDialog(null, "Deleted");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
				load();
			}
		});
		panel.add(btnDelete);

		JButton btnClearl = new JButton("Clear");
		btnClearl.setBounds(152, 627, 83, 38);
		btnClearl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idfield.setText("");
				namefield.setText("");
				familyfield.setText("");
				fmratefield.setText("");
				provfield.setText("");
				munifield.setText("");
				cropfield.setText("");
				quantityfield.setText("");
				productionfield.setText("");
				marketratefield.setText("");
				datefield.setText("");
				JOptionPane.showMessageDialog(null, "Cleared");
			}
		});
		panel.add(btnClearl);

		JButton btnNewButton_1 = new JButton("Create an Account");
		btnNewButton_1.setBounds(760, 40, 156, 33);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				CreateAccount account = new CreateAccount();
				account.getFrame().setVisible(true);
			}
		});
		panel.add(btnNewButton_1);

		JButton btnExport = new JButton("Export");
		btnExport.setBounds(841, 604, 83, 38);
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String csvFilePath = "C:\\csv\\test.csv";

				try {
					String sql = "SELECT * FROM crops";
		             
		            Statement statement = connect.createStatement();
		             
		            ResultSet result = statement.executeQuery(sql);
		             
		            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(csvFilePath));
		             
		            // write header line containing column names       
		            
		            fileWriter.write("Id, Name, Family, FarmersRate, Province, Municipality, Crops, Quantity, Production, MarketRate, Date");
		             
		            while (result.next()) {
		                int Id = result.getInt("Id");
		                String Name = result.getString("Name");
		                int Family = result.getInt("Family");
		                int FramersRate = result.getInt("FarmersRate");
		                String Province = result.getString("Province");
		                String Municipality = result.getString("Municipality");
		                String Crops = result.getString("Crops");
		                int Quantity = result.getInt("Quantity");
		                String Production = result.getString("Production");
		                int MarketRate = result.getInt("MarketRate");
		                String Date = result.getString("Date");
		              
		                 
		                String line = String.format("%d,%s,%d,%d,%s,%s,%s,%d,%s,%d,%s",
		                        Id, Name, Family,FramersRate, Province, Municipality, Crops, Quantity,Production,MarketRate,Date);
		                 
		                fileWriter.newLine();
		                fileWriter.write(line);     
		                
		            }
		             
		            statement.close();
		            fileWriter.close();
		            JOptionPane.showMessageDialog(null,"File created");
		             
		        } catch (SQLException e1) {
		            System.out.println("Datababse error:");
		            e1.printStackTrace();
		        } catch (IOException e1) {
		            System.out.println("File IO error:");
		            e1.printStackTrace();
		        }
		         
		    
		 
		
			}
		});
		panel.add(btnExport);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBounds(0, 107, 936, 3);
		verticalBox.setBorder(new LineBorder(new Color(255, 215, 0), 9));
		verticalBox.setBackground(new Color(255, 215, 0));
		panel.add(verticalBox);
		
		Back = new JTextField();
		Back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				AdminLogin Login = new AdminLogin();
				Login.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Back.setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent e) {
				Back.setForeground(Color.ORANGE);
			}
			
		});
		Back.setText("\u2190");
		Back.setForeground(Color.ORANGE);
		Back.setFont(new Font("Tahoma", Font.BOLD, 33));
		Back.setEditable(false);
		Back.setColumns(10);
		Back.setBorder(null);
		Back.setBackground(new Color(85, 107, 47));
		Back.setBounds(17, 47, 42, 19);
		panel.add(Back);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				AdminLogin Login = new AdminLogin();
				Login.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogout.setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent e) {
				btnLogout.setForeground(Color.BLACK);
			}
		});
		btnLogout.setBounds(287, 604, 83, 38);
		panel.add(btnLogout);

//		 textPane = new JTextPane();
//		 textPane.setEditable(false);
//		textPane.setBounds(382, 84, 94, 20);
//		panel.add(textPane);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
