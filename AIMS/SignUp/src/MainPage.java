import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;


public class MainPage {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
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
	public MainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 153));
		frame.setBounds(100, 100, 654, 442);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(frame, "Do you want to log out", "Back To Log in Page",
						JOptionPane.YES_NO_OPTION);

				if (answer == JOptionPane.NO_OPTION) {
					// do something
				} else if (answer == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
				
			}
		});
		btnLogOut.setFont(new Font("Triumvirate Cond", Font.BOLD, 14));
		btnLogOut.setBounds(545, 10, 85, 33);
		frame.getContentPane().add(btnLogOut);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(255, 255, 51));
		panel.setBounds(127, 122, 304, 177);
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
		lblNewLabel.setBounds(79, 10, 164, 27);
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
