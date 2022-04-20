import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AdminDashboard {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDashboard window = new AdminDashboard();
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
	public AdminDashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(205,92,92));
		frame.setBounds(100, 100, 654, 442);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			
				public void mouseEntered(MouseEvent e) {
				btnLogOut.setForeground(Color.RED);
				}
				public void mouseExited(MouseEvent e) {
					btnLogOut.setForeground(Color.BLACK);
				}
			@Override
			    public void mouseClicked(MouseEvent e) {
				
				
			}
			});
			
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(frame, "Do you want to log out?", "Back To Log in Page",
						JOptionPane.YES_NO_OPTION);

				if (answer == JOptionPane.NO_OPTION) {
					// do something
				} else if (answer == JOptionPane.YES_OPTION) {
					frame.setVisible(false);
					MainLogin Login= new MainLogin();
					Login.setVisible(true);
					
					
				}
				
			}
		});
		btnLogOut.setFont(new Font("Triumvirate Cond", Font.BOLD, 14));
		btnLogOut.setBounds(530, 10, 100, 33);
		frame.getContentPane().add(btnLogOut);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 182, 193), 2));
		panel.setBackground(new Color(205,92,92));
		panel.setBounds(168, 111, 304, 177);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnCreate = new JButton("Create");
		btnCreate.setFont(new Font("Triumvirate Cond", Font.BOLD, 14));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CreatePage create = new CreatePage();
					create.frame.setVisible(true);
					frame.setVisible(false);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(frame, e2);
				}
			}
		});
		btnCreate.setBounds(30, 47, 85, 33);
		panel.add(btnCreate);

		JLabel lblNewLabel = new JLabel("Things Admin can do");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(62, 10, 187, 27);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Triumvirate Cond", Font.BOLD, 17));

		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Triumvirate Cond", Font.BOLD, 14));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Delete delete = new Delete();
					delete.frame.setVisible(true);
					frame.setVisible(false);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(frame, e2);
				}
			}
		});
		btnDelete.setBounds(186, 47, 85, 33);
		panel.add(btnDelete);

		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Triumvirate Cond", Font.BOLD, 14));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Edit edit = new Edit();
					edit.frame.setVisible(true);
					frame.setVisible(false);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(frame, e2);
				}
			}
		});
		btnEdit.setBounds(30, 109, 85, 33);
		panel.add(btnEdit);

		JButton btnView = new JButton("View");
		btnView.setFont(new Font("Triumvirate Cond", Font.BOLD, 14));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ViewPage view = new ViewPage();
					view.frame.setVisible(true);
					frame.setVisible(false);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(frame, e2);
				}
			}
		});
		btnView.setBounds(186, 109, 85, 33);
		panel.add(btnView);
	}
}
