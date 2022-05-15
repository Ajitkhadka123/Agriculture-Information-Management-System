package agriculture;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;

public class CreateAccount {

	private JFrame frame;
	private JTextField usernametextField;
	private JTextField passwordField_1;
	Connection connect = null;
	private Image img_logo = new ImageIcon(AdminSection.class.getResource("/corpslogo.png")).getImage()
			.getScaledInstance(90,90 , Image.SCALE_SMOOTH);
	private JTextField Back;
	DefaultTableModel model;
	String Username, Password;
	private JTable table_2;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount window = new CreateAccount();
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
	
	private void load() {
		try {
			String query = "Select * from user";
			PreparedStatement state = connect.prepareStatement(query);
			ResultSet result = state.executeQuery();

			table_2.setModel(DbUtils.resultSetToTableModel(result));
			// JOptionPane.showMessageDialog(frame, "Data Loaded Successfully");
			result.close();
			state.close();

		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(frame, e2);

		}

	}
	public CreateAccount() {
		initialize();
		load();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		connect = mysqlconnection.dbConnector();
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 904, 554);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		usernametextField = new JTextField();
		usernametextField.setBounds(108, 248, 227, 34);
		getFrame().getContentPane().add(usernametextField);
		usernametextField.setColumns(10);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(108, 344, 227, 34);
		frame.getContentPane().add(passwordField_1);
		
		getFrame().getContentPane().add(passwordField_1);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel.setBounds(108, 207, 91, 22);
		getFrame().getContentPane().add(lblNewLabel);
		
		
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblPassword.setBounds(108, 312, 91, 22);
		getFrame().getContentPane().add(lblPassword);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(392, 126, 452, 311);
		getFrame().getContentPane().add(scrollPane);
		
		table_2 = new JTable();
		scrollPane.setColumnHeaderView(table_2);
		
		scrollPane.setColumnHeaderView(table_2);
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table_2.getSelectedRow();
				usernametextField.setText(table_2.getValueAt(i, 0).toString());
				passwordField_1.setText(table_2.getValueAt(i, 1).toString());
				

			}
		});
		model = new DefaultTableModel();
		Object[] column = { "Municipality", "Password" };
		final Object[] row = new Object[2];
		model.setColumnIdentifiers(column);
		table_2.setModel(model);
		scrollPane.setViewportView(table_2);
		
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				String Username , Password;
				
				try {
					
					Username = usernametextField.getText();
					Password= passwordField_1.getText();
					
					String query = "INSERT INTO user (Username, Password) VALUES(?,?)";
					// create the statement
					PreparedStatement state = connect.prepareStatement(query);
					
					state.setString(1,Username);
					state.setString(2,Password);
					state.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Added Successfully");
					// close the statement
					state.close();
				} catch (NumberFormatException E) {
					JOptionPane.showMessageDialog(null, "Please fill up all the details");
					
				}catch (SQLIntegrityConstraintViolationException E) {
					JOptionPane.showMessageDialog(null, "Username already exists");
		
				}catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "e2");
				}
				load();
			}
		});
		btnNewButton.setBounds(108, 403, 85, 34);
		getFrame().getContentPane().add(btnNewButton);
		
		JButton btnBtnupdate = new JButton("Update");
		btnBtnupdate.setBounds(108, 447, 85, 34);
		btnBtnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Username = usernametextField.getText();
					Password = passwordField_1.getText();
					
					String query = "Update user set Password='" + Password + "' where Username = '" +Username +"'" ;
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
		getFrame().getContentPane().add(btnBtnupdate);

		JButton btnDelete_1 = new JButton("Delete");
		btnDelete_1.setBounds(250, 447, 85, 34);
		getFrame().getContentPane().add(btnDelete_1);
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Username = usernametextField.getText();
				Password = passwordField_1.getText();
				try {
					String query = "Delete from user where Username = '" +Username + "'";
					PreparedStatement state = connect.prepareStatement(query);
					state.execute();
					state.close();
					usernametextField.setText("");
					passwordField_1.setText("");
				
					JOptionPane.showMessageDialog(null, "Deleted");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
				load();
			}
		});
		getFrame().getContentPane().add(btnDelete_1);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usernametextField.setText("");
				passwordField_1.setText("");
				JOptionPane.showMessageDialog(null, "Cleared");
			}
		});
		btnClear.setBounds(250, 403, 85, 34);
		getFrame().getContentPane().add(btnClear);
		
		JButton btnShort = new JButton("User Login");
		btnShort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getFrame().setVisible(false);
				MunicipalityLogin log = new MunicipalityLogin();
				log.setVisible(true);
			}
		});
		btnShort.setBounds(392, 462, 100, 34);
		getFrame().getContentPane().add(btnShort);
		
		JLabel IbllconLogo = new JLabel("");
		IbllconLogo.setBounds(165, 98, 109, 99);
		IbllconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(IbllconLogo);
		IbllconLogo.setIcon(new ImageIcon(img_logo));
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new LineBorder(new Color(255, 215, 0), 5));
		verticalBox.setBackground(new Color(255, 215, 0));
		verticalBox.setBounds(0, 70, 1074, 4);
		frame.getContentPane().add(verticalBox);
		
		JLabel lblNewLabel_1 = new JLabel("Create Municipality Account");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel_1.setBounds(218, 9, 392, 58);
		frame.getContentPane().add(lblNewLabel_1);
		
		Back = new JTextField();
		Back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Back.setForeground(Color.RED);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				getFrame().setVisible(false);
				AdminSection admin = new AdminSection();
				admin.getFrame().setVisible(true);
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
		Back.setBounds(20, 25, 42, 19);
		frame.getContentPane().add(Back);
		
		
		
		JLabel lblAccounts = new JLabel("Accounts");
		lblAccounts.setForeground(Color.WHITE);
		lblAccounts.setFont(new Font("Calibri", Font.BOLD, 20));
		lblAccounts.setBounds(392, 98, 91, 22);
		frame.getContentPane().add(lblAccounts);
		
		
		
		
		
		
	
	}
	

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(85, 107, 47));
	}
}
