import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewPage {

	JFrame frame;
	private JTable table;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPage window = new ViewPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(205,92,92));
		frame.setBounds(100, 100, 717, 445);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AdminDashboard main = new AdminDashboard();
					main.frame.setVisible(true);
					frame.setVisible(false);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(frame, e2);
				}
			}
		});
		btnBack.setFont(new Font("Triumvirate Cond", Font.BOLD, 15));
		btnBack.setBounds(608, 10, 85, 33);
		frame.getContentPane().add(btnBack);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel(
						new Object[][] {
							{"1", "Sandeep", "sandeep", "Apple", "sandeep@gmail.com", "Male", "Sattale", "2001/01/01"},
						},
						new String[] {
							"User Id", "Name", "Username", "Password", "Email", "Gender", "Location", "Date of Birth"
						}
					));
			}
		});
		btnRefresh.setFont(new Font("Triumvirate Cond", Font.BOLD, 15));
		btnRefresh.setBounds(162, 343, 106, 33);
		frame.getContentPane().add(btnRefresh);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
			}
		});
		btnClear.setFont(new Font("Triumvirate Cond", Font.BOLD, 15));
		btnClear.setBounds(416, 343, 85, 33);
		frame.getContentPane().add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 683, 273);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Triumvirate Cond", Font.PLAIN, 12));
		table.setRowSelectionAllowed(false);
		table.setEnabled(false);
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "Sandeep", "sandeep", "Apple", "sandeep@gmail.com", "Male", "Sattale", "2001/01/01"},
			},
			new String[] {
				"User Id", "Name", "Username", "Password", "Email", "Gender", "Location", "Date of Birth"
			}
		));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(48);
		table.getColumnModel().getColumn(4).setPreferredWidth(112);
		table.getColumnModel().getColumn(5).setPreferredWidth(49);
		scrollPane.setViewportView(table);
	}
}
